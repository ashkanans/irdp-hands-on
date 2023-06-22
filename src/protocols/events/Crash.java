package protocols.events;

import net.sf.appia.core.AppiaEventException;
import net.sf.appia.core.Channel;
import net.sf.appia.core.Event;
import net.sf.appia.core.Session;


/**
 * Used to notify protocols that some process crashed.
 *
 * @author nuno
 */
public class Crash extends Event {

    private int processRank;

    /**
     * Default constructor.
     */
    public Crash() {
        super();
    }

    /**
     * Constructor of this event.
     *
     * @param pr
     *          the process rank that crashed.
     */
    public Crash(int pr) {
        super();
        processRank = pr;
    }

    /**
     * Constructor of this event.
     *
     * @param channel
     *          Appia Channel
     * @param direction
     *          Direction of the event.
     * @param src
     *          session that created the event.
     * @param pr
     *          process rank that crashed.
     * @throws AppiaEventException
     */
    public Crash(Channel channel, int direction, Session src, int pr)
            throws AppiaEventException {
        super(channel, direction, src);
        processRank = pr;
    }

    /**
     * gets the crashed process rank.
     *
     * @return crashed process rank
     */
    public int getCrashedProcess() {
        return processRank;
    }

}

