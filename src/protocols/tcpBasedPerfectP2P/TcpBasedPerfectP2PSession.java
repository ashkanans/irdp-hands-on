package protocols.tcpBasedPerfectP2P;

import net.sf.appia.core.Event;
import net.sf.appia.core.Layer;
import net.sf.appia.protocols.tcpcomplete.TcpCompleteSession;

/**
 * Session implementing the
 * TCP-Based Perfect Point-to-Point Links protocol.
 *
 * @author Nuno Carvalho
 *
 */
public class TcpBasedPerfectP2PSession extends TcpCompleteSession {


    /**
     * Constructor for NewTcpSession.
     *
     * @param layer
     */
    public TcpBasedPerfectP2PSession(Layer layer) {
        super(layer);
    }

    public void handle(Event e) {
        super.handle(e);
    }

}
