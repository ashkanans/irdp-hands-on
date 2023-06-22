package protocols.utils;

import net.sf.appia.core.events.SendableEvent;

/**
 * This class holds some information needed by the
 * protocols. It is used as element of lists.
 *
 * @author nuno
 */
public class MessageEntry {
    // the event
    public SendableEvent event;
    // an array of acks
    public boolean[] acks;
    // a message header
    public MessageID messageID;

    public MessageEntry(SendableEvent e, MessageID id, int procSize) {
        event = e;
        messageID = id;
        acks = new boolean[procSize];
        for (int i = 0; i < procSize; i++)
            acks[i] = false;
    }
}