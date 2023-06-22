package protocols.consensusMembership;

import net.sf.appia.core.AppiaEventException;
import net.sf.appia.core.*;
import protocols.events.*;
import protocols.membershipUtils.View;
import protocols.utils.Debug;
import protocols.utils.ProcessSet;
import protocols.utils.SampleProcess;

/**
 * Session implementing the Consensus-Based Membership protocol.
 *
 * @author alexp
 */
public class ConsensusMembershipSession extends Session {

    public ConsensusMembershipSession(Layer layer) {
        super(layer);
    }

    public void handle(Event event) {
        if (event instanceof ProcessInitEvent) {
            handleProcessInit((ProcessInitEvent) event);
            return;
        }
        if (event instanceof Crash) {
            handleCrash((Crash) event);
            return;
        }
        if (event instanceof ConsensusDecide) {
            handleConsensusDecide((ConsensusDecide) event);
            return;
        }

        Debug.print("Unwanted event received, ignoring.");
        try {
            event.go();
        } catch (AppiaEventException ex) {
            ex.printStackTrace();
        }
    }

    private View view = null;
    private ProcessSet correct = null;
    private boolean wait;

    private void handleProcessInit(ProcessInitEvent event) {
        try {
            event.go();
        } catch (AppiaEventException ex) {
            ex.printStackTrace();
        }

        view = new View();
        view.id = 0;
        view.memb = event.getProcessSet();
        correct = event.getProcessSet();
        wait = false;

        try {
            ViewEvent ev = new ViewEvent(event.getChannel(), Direction.UP, this);
            ev.view = view;
            ev.go();
        } catch (AppiaEventException ex) {
            ex.printStackTrace();
        }
    }

    private void handleCrash(Crash crash) {
        correct.setCorrect(crash.getCrashedProcess(), false);
        try {
            crash.go();
        } catch (AppiaEventException ex) {
            ex.printStackTrace();
        }

        newMembership(crash.getChannel());
    }

    private void newMembership(Channel channel) {
        if (wait)
            return;

        boolean crashed = false;
        int i;
        for (i = 0; i < correct.getSize(); i++) {
            SampleProcess p = correct.getProcess(i);
            SampleProcess m = view.memb.getProcess(p.getSocketAddress());
            if (!p.isCorrect() && (m != null)) {
                crashed = true;
            }
        }
        if (!crashed)
            return;

        wait = true;

        int j;
        ProcessSet trimmed_memb = new ProcessSet();
        for (i = 0, j = 0; i < correct.getSize(); i++) {
            SampleProcess p = correct.getProcess(i);
            if (p.isCorrect())
                trimmed_memb.addProcess(p, j++);
        }

        View v = new View();
        v.id = view.id + 1;
        v.memb = trimmed_memb;

        try {
            ConsensusPropose ev = new ConsensusPropose(channel, Direction.DOWN, this);
            ev.value = v;
            ev.go();
        } catch (AppiaEventException ex) {
            ex.printStackTrace();
        }
    }

    private void handleConsensusDecide(ConsensusDecide event) {
        view = (View) event.decision;

        wait = false;

        try {
            ViewEvent ev = new ViewEvent(event.getChannel(), Direction.UP, this);
            ev.view = view;
            ev.go();
        } catch (AppiaEventException ex) {
            ex.printStackTrace();
        }
    }
}
