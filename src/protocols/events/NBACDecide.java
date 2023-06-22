package protocols.events;

import net.sf.appia.core.AppiaEventException;
import net.sf.appia.core.Channel;
import net.sf.appia.core.Event;
import net.sf.appia.core.Session;

/**
 * Notifies the result of Non-Blocking Atomic Commit.
 *
 * @author Alexandre Pinto DI-FCUL
 */
public class NBACDecide extends Event {

    /**
     * The decision is 0 or 1.
     */
    public int decision;

    public NBACDecide(Channel channel, int direction, Session session)
            throws AppiaEventException {
        super(channel, direction, session);
    }
}
