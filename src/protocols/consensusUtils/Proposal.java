package protocols.consensusUtils;

import java.io.Serializable;

/**
 * All proposals to consensus must derive from this class, to force them to be
 * serializable and implement the "compareTo" method, allowing them to be
 * comparable and thus permitting the choice of the lowest value by consensus.
 *
 * @author Luis Sardinha and Alexandre Pinto DI - FCUL
 */
public abstract class Proposal implements Serializable, Comparable<Proposal> {
}
