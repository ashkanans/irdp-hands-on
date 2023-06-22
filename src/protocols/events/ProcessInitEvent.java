package protocols.events;

import net.sf.appia.core.AppiaEventException;
import net.sf.appia.core.Channel;
import net.sf.appia.core.Event;
import net.sf.appia.core.Session;
import protocols.utils.ProcessSet;

/**
 * Distributes the process set to the interested Sessions.
 *
 * @author nuno
 */
public class ProcessInitEvent extends Event {

    private ProcessSet processSet;

    /**
     * Default constructor.
     */
    public ProcessInitEvent() {
        super();
    }

    /**
     * Constructor of the event.
     *
     * @param ps
     *          The process set.
     */
    public ProcessInitEvent(ProcessSet ps) {
        super();
        processSet = ps;
    }

    /**
     * Constructor of the event.
     *
     * @param channel
     *          The Appia Channel.
     * @param dir
     *          The direction of the event.
     * @param source
     *          the session that created the event.
     * @throws AppiaEventException
     */
    public ProcessInitEvent(Channel channel, int dir, Session source)
            throws AppiaEventException {
        super(channel, dir, source);
    }

    /**
     * Gets a copy of the process set.
     *
     * @return a copy of the process set.
     */
    public ProcessSet getProcessSet() {
        return processSet.cloneProcessSet();
    }

    /**
     * Sets the process set.
     *
     * @param set
     *          the process set.
     */
    public void setProcessSet(ProcessSet set) {
        processSet = set;
    }

}
