package protocols.utils;

import java.io.Serializable;
import java.net.SocketAddress;

/**
 * A set of sample processes.
 *
 * @author nuno
 */
public class ProcessSet implements Serializable {
    private static final long serialVersionUID = -8520712350015155147L;

    SampleProcess[] processes;
    private int self;

    /**
     * Constructor of the class.
     *
     * @param n
     *          number of processes.
     */
    public ProcessSet(int n) {
        processes = new SampleProcess[n];
    }

    /**
     *
     */
    public ProcessSet() {
        processes = new SampleProcess[0];
    }

    /**
     * Gets an array with all processes.
     *
     * @return Array with all processes
     */
    public SampleProcess[] getAllProcesses() {
        return processes;
    }

    /**
     * Gets the number of processes.
     *
     * @return number of processes
     */
    public int getSize() {
        return processes.length;
    }

    /**
     * Gets the rank of the specified process.
     *
     * @param addr
     *          the address of the process
     * @return the rank of the process
     */
    public int getRank(SocketAddress addr) {
        for (int i = 0; i < processes.length; i++) {
            if ((processes[i] != null) && processes[i].getSocketAddress().equals(addr))
                return i;
        }
        return -1;
    }

    /**
     * Adds a process into the process set.
     *
     * @param process
     *          the process to add.
     * @param pr
     *          the rank of the process.
     */
    public void addProcess(SampleProcess process, int pr) {
        if (pr >= processes.length) {
            SampleProcess[] temp = new SampleProcess[processes.length + 1];
            for (int i = 0; i < processes.length; i++)
                temp[i] = processes[i];
            processes = temp;
        }
        processes[pr] = process;
        if (process.isSelf())
            self = pr;
    }

    /**
     * Sets the process specified by the rank "proc" to correct or crashed.
     *
     * @param proc
     *          the process rank.
     * @param correct
     *          true if the process is correct, false if the process crashed.
     */
    public void setCorrect(int proc, boolean correct) {
        processes[proc].setCorrect(correct);
    }

    /**
     * Gets the process with rank "i"
     *
     * @param i
     *          the process rank
     * @return the process
     */
    public SampleProcess getProcess(int i) {
        return processes[i];
    }

    /**
     * Gets the process with address "addr".
     *
     * @param addr
     *          the process address
     * @return the process.
     */
    public SampleProcess getProcess(SocketAddress addr) {
        int i = getRank(addr);
        if (i == -1)
            return null;
        else
            return processes[i];
    }

    /**
     * Gets the self rank.
     *
     * @return My rank
     */
    public int getSelfRank() {
        return self;
    }

    /**
     * Gets the self process.
     *
     * @return My process
     */
    public SampleProcess getSelfProcess() {
        return processes[self];
    }

    /**
     * Clones the process set.
     *
     * @return a clone of the process set.
     */
    public ProcessSet cloneProcessSet() {
        ProcessSet set = new ProcessSet(getSize());
        SampleProcess[] procs = getAllProcesses();
        for (int i = 0; i < procs.length; i++)
            set.addProcess(procs[i].cloneProcess(), i);
        set.self = self;
        return set;
    }

}
