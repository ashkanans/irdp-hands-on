package protocols.utils;

import java.io.Serializable;
import java.net.SocketAddress;

/**
 * Represents a process in the system.
 *
 * @author nuno
 */
public class SampleProcess implements Serializable {
    private static final long serialVersionUID = 3677871909022936117L;

    private SocketAddress address;
    private int processNumber;
    private boolean self, correct, initialized;

    public SampleProcess(SocketAddress addr, int proc, boolean self) {
        this.address = addr;
        this.processNumber = proc;
        this.self = self;
        correct = true;
        initialized = false;
    }

    /**
     * Gets the address of the process.
     *
     * @return the address of the process
     */
    public SocketAddress getSocketAddress() {
        return address;
    }

    /**
     * Gets the process number.
     *
     * @return the process number
     */
    public int getProcessNumber() {
        return processNumber;
    }

    /**
     * Is it my own process.
     *
     * @return true if the process is my self.
     */
    public boolean isSelf() {
        return self;
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object test) {
        if (!(test instanceof SampleProcess))
            return false;
        SampleProcess proc = (SampleProcess) test;
        return address.equals(proc.address)
                && (processNumber == proc.processNumber) && (self == proc.self);
    }

    /**
     * Is the process correct. Gets the correctness value.
     *
     * @return true if correct, false otherwise
     */
    public boolean isCorrect() {
        return correct;
    }

    /**
     * Sets the correctness of the process.
     *
     * @param b
     *          the correct value
     */
    public void setCorrect(boolean b) {
        correct = b;
    }

    /**
     * Is the process initialized. Gets the initialized value.
     *
     * @return true if initialized, false otherwise
     */
    public boolean isInitialized() {
        return initialized;
    }

    /**
     * Sets if the process has initiated.
     *
     * @param initialized
     *          the initialized value
     */
    public void setInitialized(boolean initialized) {
        this.initialized = initialized;
    }

    /**
     * Creates a clone of the process.
     *
     * @return the process clone
     */
    public SampleProcess cloneProcess() {
        SampleProcess p = new SampleProcess(address, processNumber, self);
        p.correct = correct;
        p.initialized = initialized;
        return p;
    }

}
