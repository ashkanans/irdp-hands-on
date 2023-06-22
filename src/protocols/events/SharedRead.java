package protocols.events;

import net.sf.appia.core.AppiaEventException;
import net.sf.appia.core.Channel;
import net.sf.appia.core.Event;
import net.sf.appia.core.Session;

/**
 * Requests the value contained in one shared register.
 *
 * @author Alexandre Pinto DI - FCUL
 */
public class SharedRead extends Event {

    /**
     * The register to read.
     */
    public int reg;

    public SharedRead(Channel channel, int direction, Session src)
            throws AppiaEventException {
        super(channel, direction, src);
    }
}
