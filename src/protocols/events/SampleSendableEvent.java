package protocols.events;

import net.sf.appia.core.AppiaEventException;
import net.sf.appia.core.Channel;
import net.sf.appia.core.Session;
import net.sf.appia.core.events.SendableEvent;

/**
 * Sendable Event used by the application.
 *
 * @author nuno
 */
public class SampleSendableEvent extends SendableEvent {

    private String command;

    /**
     * Default constructor.
     */
    public SampleSendableEvent() {
        super();
    }

    public SampleSendableEvent(Channel c, int dir, Session s)
            throws AppiaEventException{
        super(c, dir, s);
    }


    /**
     * @return Returns the command.
     */
    public String getCommand() {
        return command;
    }

    /**
     * @param command
     *          The command to set.
     */
    public void setCommand(String command) {
        this.command = command;
    }

}
