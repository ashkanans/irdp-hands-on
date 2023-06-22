package protocols.events;

import net.sf.appia.core.AppiaEventException;
import net.sf.appia.core.Channel;
import net.sf.appia.core.Event;
import net.sf.appia.core.Session;

/**
 * Requests the setting of a new value in one of the shared registers.
 *
 * @author Alexandre Pinto DI - FCUL
 */
public class SharedWrite extends Event {

    /**
     * The shared register identification.
     */
    public int reg;
    /**
     * The new content to put in the shared register.
     */
    public Object value;

    public SharedWrite(Channel channel, int direction, Session src)
            throws AppiaEventException {
        super(channel, direction, src);
    }
}
