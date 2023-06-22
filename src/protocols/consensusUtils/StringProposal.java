package protocols.consensusUtils;

public class StringProposal extends Proposal {
    private static final long serialVersionUID = -2249937284480902746L;

    /**
     * The encapsulated string.
     */
    public String msg;

    public StringProposal(String s) {
        msg = s;
    }

    /**
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    public int compareTo(Proposal o) {
        if (!(o instanceof StringProposal))
            throw new ClassCastException("Required StringProposal");
        return msg.compareTo(((StringProposal) o).msg);
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object obj) {
        return (obj instanceof StringProposal)
                && msg.equals(((StringProposal) obj).msg);
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return msg.hashCode();
    }

    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return "[StringProposal:\"" + msg.toString() + "\"]";
    }
}

