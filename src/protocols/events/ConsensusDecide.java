package protocols.events;

import net.sf.appia.core.AppiaEventException;
import net.sf.appia.core.Channel;
import net.sf.appia.core.Event;
import net.sf.appia.core.Session;
import protocols.consensusUtils.Proposal;

/**
 * Notifies the result of a consensus.
 *
 * @author Luis Sardinha and Alexandre Pinto DI-FCUL
 */
public class ConsensusDecide extends Event {

    /**
     * The consensus decision.
     */
    public Proposal decision;

    public ConsensusDecide(Channel channel, int direction, Session session)
            throws AppiaEventException {
        super(channel, direction, session);
    }
}

