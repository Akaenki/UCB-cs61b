package synthesizer;

import edu.princeton.cs.algs4.StdAudio;

//Make sure this class is public
public class GuitarString {
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    /* Buffer for storing sound data. */
    private BoundedQueue<Double> buffer;

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        int capacity = (int)Math.round(SR / frequency);
        buffer = new ArrayRingBuffer(capacity);
        // Buffer should be initially filled with zeros.
        while(!buffer.isFull()){
            buffer.enqueue(0.0);
        }
    }


    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        while(!buffer.isEmpty()){
            buffer.dequeue();
        }

        while(!buffer.isFull()){
            buffer.enqueue(Math.random() - 0.5);
        }
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm. 
     */
    public void tic() {
        double a = buffer.dequeue();
        double b = buffer.peek();
        buffer.enqueue(DECAY * 0.5 * (a + b));
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        return buffer.peek();
    }

    public static void main(String[] args){
        StdAudio.play(0.333);
        StdAudio.play(-0.9);
    }
}
