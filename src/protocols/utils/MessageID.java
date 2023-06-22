package protocols.utils;

import java.io.Serializable;

/**
 * Message identifier.
 *
 * @author nuno
 */
public class MessageID implements Serializable {
    private static final long serialVersionUID = -5632927438973377599L;

    public int process, seqNumber;
    public MessageID(int p, int s) {
        process = p;
        seqNumber = s;
    }
    public int hashCode() {
        return process ^ seqNumber;
    }
    public boolean equals(Object o) {
        MessageID id = (MessageID) o;
        return process == id.process && seqNumber == id.seqNumber;
    }

    public String toString() {
        return " (" + process + "," + seqNumber + ") ";
    }
}
