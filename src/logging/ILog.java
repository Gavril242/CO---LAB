package logging;

/**
 * This interface provides methods for logging messages and values to a console or file.
 */
public interface ILog {

    /**
     * Writes a long value to the logging output.
     *
     * @param value the long value to write.
     */
    void write(long value);

    /**
     * Writes a string value to the logging output.
     *
     * @param value the string value to write.
     */
    void write(String value);

    /**
     * Writes an array of objects to the logging output, separated by a space.
     *
     * @param values the objects to write to the logging output.
     */
    void write(Object... values);

    /**
     * Closes any open stream used for writing to the logging output.
     */
    void close();
}