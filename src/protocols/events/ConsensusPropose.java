package protocols.events;

import net.sf.appia.core.AppiaEventException;
import net.sf.appia.core.Channel;
import net.sf.appia.core.Event;
import net.sf.appia.core.Session;
import protocols.consensusUtils.Proposal;

/**
 * Proposes a value for consensus.
 *
 * @author Luis Sardinha and Alexandre Pinto DI - FCUL
 */
public class ConsensusPropose extends Event {

    /**
     * The value proposed for consensus.
     */
    public Proposal value;

    public ConsensusPropose() {
        super();
    }

    public ConsensusPropose(Proposal value) {
        super();
        this.value = value;
    }

    public ConsensusPropose(Channel channel, int direction, Session src)
            throws AppiaEventException {
        super(channel, direction, src);
    }
}
