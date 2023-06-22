package protocols.events;

import net.sf.appia.core.AppiaEventException;
import net.sf.appia.core.Channel;
import net.sf.appia.core.Event;
import net.sf.appia.core.Session;

/**
 * Notifies that a shared register was written, in response to a SharedWrite.
 *
 * @author Alexandre Pinto DI-FCUL
 */
public class SharedWriteReturn extends Event {

    /**
     * The shared register identification.
     */
    public int reg;

    public SharedWriteReturn(Channel channel, int direction, Session session)
            throws AppiaEventException {
        super(channel, direction, session);
    }
}
