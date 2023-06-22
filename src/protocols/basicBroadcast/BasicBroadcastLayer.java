package protocols.basicBroadcast;

import net.sf.appia.core.Layer;
import net.sf.appia.core.Session;
import net.sf.appia.core.events.SendableEvent;
import net.sf.appia.core.events.channel.ChannelClose;
import net.sf.appia.core.events.channel.ChannelInit;
import protocols.events.ProcessInitEvent;

/**
 * Layer of the Basic Broadcast protocol.
 *
 * @author nuno
 */
public class BasicBroadcastLayer extends Layer {

    public BasicBroadcastLayer() {
        /* events that the protocol will create */
        evProvide = new Class[0];

        /*
         * events that the protocol require to work. This is a subset of the
         * accepted events
         */
        evRequire = new Class[3];
        evRequire[0] = SendableEvent.class;
        evRequire[1] = ChannelInit.class;
        evRequire[2] = ProcessInitEvent.class;

        /* events that the protocol will accept */
        evAccept = new Class[4];
        evAccept[0] = SendableEvent.class;
        evAccept[1] = ChannelInit.class;
        evAccept[2] = ChannelClose.class;
        evAccept[3] = ProcessInitEvent.class;

    }

    /**
     * Creates a new session to this protocol.
     *
     *  appia.Layer#createSession()
     */
    public Session createSession() {
        return new BasicBroadcastSession(this);
    }

}
