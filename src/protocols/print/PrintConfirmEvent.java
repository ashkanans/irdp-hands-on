package protocols.print;

import net.sf.appia.core.Event;


/**
 * Print request confirmation event.
 *
 * @author alexp
 */
public class PrintConfirmEvent extends Event {
    int rqid;

    void setId(int rid) {
        rqid = rid;
    }

    int getId() {
        return rqid;
    }
}

