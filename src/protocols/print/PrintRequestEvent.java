package protocols.print;

import net.sf.appia.core.Event;


/**
 * Print request event.
 *
 * @author alexp
 */
public class PrintRequestEvent extends Event {
    int rqid;
    String str;

    void setId(int rid) {
        rqid = rid;
    }

    void setString(String s) {
        str = s;
    }

    int getId() {
        return rqid;
    }

    String getString() {
        return str;
    }
}