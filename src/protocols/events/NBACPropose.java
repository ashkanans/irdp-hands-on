package protocols.events;

import net.sf.appia.core.AppiaEventException;
import net.sf.appia.core.Channel;
import net.sf.appia.core.Session;
import net.sf.appia.core.events.SendableEvent;

/**
 * Proposes a value for Non-Blocking Atomic Commit.
 *
 * @author Alexandre Pinto DI - FCUL
 */
public class NBACPropose extends SendableEvent {

    /**
     * NBAC value, should be 0 or 1
     */
    public int value;

    public NBACPropose() {
        super();
    }

    public NBACPropose(Channel c, int d, Session s)
            throws AppiaEventException{
        super(c,d,s);
    }

}
