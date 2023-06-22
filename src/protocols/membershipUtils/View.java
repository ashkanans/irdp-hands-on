package protocols.membershipUtils;

import protocols.consensusUtils.Proposal;
import protocols.utils.ProcessSet;
import protocols.utils.SampleProcess;

/**
 * Defines a view used in membership. Extends Proposal so it can be used in
 * consensus.
 *
 * @author alexp
 */
public class View extends Proposal {
    private static final long serialVersionUID = 357435326121352256L;

    /**
     * The view identifier.
     */
    public int id;
    /**
     * The view members.
     */
    public ProcessSet memb;

    /**
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    public int compareTo(Proposal o) {
        if (!(o instanceof View))
            throw new ClassCastException("Required View");
        View v = (View) o;
        if (id > v.id)
            return -1;
        if (id < v.id)
            return 1;
        if (memb.getSize() < v.memb.getSize())
            return -1;
        if (memb.getSize() > v.memb.getSize())
            return 1;
        return 0;
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof View))
            return false;
        View v = (View) obj;
        if (id != v.id)
            return false;
        if (memb.getSize() != v.memb.getSize())
            return false;
        int i;
        for (i = 0; i < memb.getSize(); i++) {
            if (v.memb.getProcess(memb.getProcess(i).getSocketAddress()) == null)
                return false;
        }
        return true;
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        int c = id;
        int i;
        for (i = 0; i < memb.getSize(); i++)
            c += memb.getProcess(i).getSocketAddress().hashCode();
        return c;
    }

    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        String s = "[View:" + id + ";{";
        int i;
        for (i = 0; i < memb.getSize(); i++) {
            SampleProcess p = memb.getProcess(i);
            s += "(" + p.getProcessNumber() + ";" + p.getSocketAddress() + ";"
                    + p.isCorrect() + "),";
        }
        s += "}]";
        return s;
    }
}
