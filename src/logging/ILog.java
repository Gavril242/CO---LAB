package logging;

public interface ILog {
    void write (long value); // print the long parameter
    void write (String value); //prints the string parameter

    void write (Object ... values); // will print all the values separated by space.

    void close(); //  used to close (if necessary) any open stream (connection) used for writing.

}
