package protocols.events;

import net.sf.appia.core.AppiaEventException;
import net.sf.appia.core.Channel;
import net.sf.appia.core.Event;
import net.sf.appia.core.Session;
import protocols.membershipUtils.View;

/**
 * Notifies the instalation of a new view.
 *
 * @author Alexandre Pinto DI-FCUL
 */
public class ViewEvent extends Event {
    /**
     * The new view.
     */
    public View view;

    public ViewEvent(Channel channel, int direction, Session session)
            throws AppiaEventException {
        super(channel, direction, session);
    }
}
