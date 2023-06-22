package protocols.consensusUtils;

public class IntProposal extends Proposal {
    private static final long serialVersionUID = -7259051541156122676L;

    /**
     * The encapsulated integer.
     */
    public int i;

    public IntProposal(int i) {
        this.i = i;
    }

    /**
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    public int compareTo(Proposal o) {
        if (!(o instanceof IntProposal))
            throw new ClassCastException("Required IntProposal");
        return (new Integer(i)).compareTo(new Integer(((IntProposal) o).i));
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object obj) {
        return (obj instanceof IntProposal) && (i == ((IntProposal) obj).i);
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return i;
    }

    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return "[IntProposal:" + i + "]";
    }
}
