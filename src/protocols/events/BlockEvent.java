package protocols.events;

import net.sf.appia.core.AppiaEventException;
import net.sf.appia.core.Channel;
import net.sf.appia.core.Event;
import net.sf.appia.core.Session;

/**
 * Notifies the above protocols that the process must stop sending message to
 * allow virtual synchronization in a view change.
 *
 * @author alexp
 */
public class BlockEvent extends Event {

    public BlockEvent() {
        super();
    }

    public BlockEvent(Channel channel, int dir, Session source)
            throws AppiaEventException {
        super(channel, dir, source);
    }
}

