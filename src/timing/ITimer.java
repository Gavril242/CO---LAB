package timing;

public interface ITimer {

    /**
     * Starts the timer.
     */
    public void start();

    /**
     * Stops the timer and returns the total elapsed time in nanoseconds.
     *
     * @return long - total time.
     */
    public long stop();

    /**
     * Resumes the timer from the point it was paused.
     * Resets the start timer.
     */
    public void resume();

    /**
     * Pauses the timer and returns the elapsed time in nanoseconds up to this point.
     *
     * @return long - end time -start time.
     */
    public long pause();
}