package bench;

public interface IBenchmark {
    public void run();
     void initialize(Object ...params);

    public void clean();
    public void cancel();

}
