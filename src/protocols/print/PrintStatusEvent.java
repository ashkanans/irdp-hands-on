package protocols.print;

import net.sf.appia.core.Event;

/**
 * Print status notification event.
 * @author alexp
 */
public class PrintStatusEvent extends Event {
    int rqid;
    Status status;

    void setId(int rid) {
        rqid = rid;
    }

    void setStatus(Status s) {
        status = s;
    }

    int getId() {
        return rqid;
    }

    Status getStatus() {
        return status;
    }
}

