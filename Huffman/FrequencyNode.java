import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.lang.Comparable;

public class FrequencyNode implements Comparable {
    
    private char value;
    private int freq;
    private FrequencyNode parent;
    private FrequencyNode child1;
    private FrequencyNode child2;
    private int binary;

    public FrequencyNode(char givenValue, int givenFreq) {
        this.value = givenValue;
        this.freq = givenFreq;
        this.parent = null;
        this.child1 = null;
        this.child2 = null;
        binary = -1;
    }

    public FrequencyNode(int givenFreq) {
        this.value = (char) 0;
        this.freq = givenFreq;
        this.parent = null;
        this.child1 = null;
        this.child2 = null;
        binary = -1;
    }

    

    /**
     * @return the parent
     */
    public FrequencyNode getParent() {
        return parent;
    }



    /**
     * @param parent the parent to set
     */
    public void setParent(FrequencyNode parent) {
        this.parent = parent;
    }



    /**
     * @return the child1
     */
    public FrequencyNode getChild1() {
        return child1;
    }



    /**
     * @param child1 the child1 to set
     */
    public void setChild1(FrequencyNode child1) {
        this.child1 = child1;
    }



    /**
     * @return the child2
     */
    public FrequencyNode getChild2() {
        return child2;
    }



    /**
     * @param child2 the child2 to set
     */
    public void setChild2(FrequencyNode child2) {
        this.child2 = child2;
    }



    /**
     * @return the binary
     */
    public int getBinary() {
        return binary;
    }



    /**
     * @param binary the binary to set
     */
    public void setBinary(int binary) {
        this.binary = binary;
    }



    /**
     * @return the value
     */
    public char getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(char value) {
        this.value = value;
    }

    /**
     * @return the freq
     */
    public int getFreq() {
        return freq;
    }

    /**
     * @param freq the freq to set
     */
    public void setFreq(int freq) {
        this.freq = freq;
    }


    public int compareTo(Object n) {

        FrequencyNode newNode = (FrequencyNode) n;

        if (this.freq > newNode.getFreq()) {
            return -1;
        } else if (this.freq < newNode.getFreq()) {
            return 1;
        } else {
            return 0;
        }
    }

}
