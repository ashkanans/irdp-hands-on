package protocols.events;

import net.sf.appia.core.AppiaEventException;
import net.sf.appia.core.Channel;
import net.sf.appia.core.Event;
import net.sf.appia.core.Session;

/**
 * Returns the content of one of the shared registers.
 *
 * @author Alexandre Pinto DI-FCUL
 */
public class SharedReadReturn extends Event {

    /**
     * The shared register identification.
     */
    public int reg;
    /**
     * The shared register content.
     */
    public Object value;

    public SharedReadReturn(Channel channel, int direction, Session session)
            throws AppiaEventException {
        super(channel, direction, session);
    }
}
