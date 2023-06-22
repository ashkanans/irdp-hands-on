package protocols.events;

import net.sf.appia.core.AppiaEventException;
import net.sf.appia.core.Channel;
import net.sf.appia.core.Event;
import net.sf.appia.core.Session;

/**
 * Notifies that the virtual synchrony algorithm as terminated and the process
 * can resume the sending of messages.
 *
 * @author alexp
 */
public class ReleaseEvent extends Event {

    public ReleaseEvent() {
        super();
    }

    public ReleaseEvent(Channel channel, int dir, Session source)
            throws AppiaEventException {
        super(channel, dir, source);
    }
}
