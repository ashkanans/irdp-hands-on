package protocols.events;

import net.sf.appia.core.AppiaEventException;
import net.sf.appia.core.Channel;
import net.sf.appia.core.Event;
import net.sf.appia.core.Session;

/**
 * Notifies the virtual synchrony algorithm that the process as stopped the
 * sending of messages.
 *
 * @author alexp
 */
public class BlockOkEvent extends Event {

    public BlockOkEvent() {
        super();
    }

    public BlockOkEvent(Channel channel, int dir, Session source)
            throws AppiaEventException {
        super(channel, dir, source);
    }
}
