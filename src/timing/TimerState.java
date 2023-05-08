package timing;

public class TimerState {

    private String timeunit;
    private int multiplier;

    void Milli(){
        multiplier = 1000;
        timeunit= "ms";

    }

    public String toString()
    {return timeunit;}


}
