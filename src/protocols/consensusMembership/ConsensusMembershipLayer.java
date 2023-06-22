package protocols.consensusMembership;

import net.sf.appia.core.Layer;
import net.sf.appia.core.Session;
import protocols.events.*;

/**
 * Layer of the Consensus-Based Membership protocol.
 *
 * @author alexp
 */
public class ConsensusMembershipLayer extends Layer {

    public ConsensusMembershipLayer() {

        evProvide = new Class[2];
        evProvide[0] = ViewEvent.class;
        evProvide[1] = ConsensusPropose.class;

        evRequire = new Class[3];
        evRequire[0] = ProcessInitEvent.class;
        evRequire[1] = Crash.class;
        evRequire[2] = ConsensusDecide.class;

        evAccept = new Class[3];
        evAccept[0] = ProcessInitEvent.class;
        evAccept[1] = Crash.class;
        evAccept[2] = ConsensusDecide.class;
    }

    public Session createSession() {
        return new ConsensusMembershipSession(this);
    }
}

