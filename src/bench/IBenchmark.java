package bench;

/**
 * This interface provides methods for benchmarking a specific task or operation.
 * IThe methods are used for  initialization, running the task, cleaning up after the task, and cancelling the task if necessary.
 */
public interface IBenchmark {

    /**
     * Initializes the benchmark with any necessary parameters.
     *
     * @param params the parameters needed to initialize the benchmark.
     */
    void initialize(Object... params);


    /**
     * Runs the benchmark task.
     */
    void run();

    /**
     * Runs the benchmark task.
     */
    void run(Object... params);

    /**
     * Cleans up after the benchmark task.
     */
    void clean();

    /**
     * Cancels the benchmark task if necessary.
     */
    void cancel();

    void warmup();
}