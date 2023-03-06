package timing;

public class Timer implements ITimer{

    private long totalTime, start, end ;

    /**
     * Starts the timer
     */
    @Override
    public void start() {
        totalTime = 0;
         start = System.nanoTime();


    }

    /**
     * @return the time elapsed since start and stops the timer
     */
    @Override
    public long stop() {

        end = System.nanoTime();
        totalTime += end - start;
        return totalTime;

    }

    /**
     * resumes i suppose
     */
    @Override
    public void resume() {
        start = System.nanoTime();

    }

    /**
     * @return the time elapsed since and pauses the timer
     */
    @Override
    public long pause() {
        end = System.nanoTime();
        totalTime += end - start;
        return end - start;

    }
}
