package logging;
import java.io.*; // for exception and printwritter

public class FileLogger implements ILog {
    private PrintWriter writer;

    public FileLogger(String fileName) throws FileNotFoundException {
        writer = new PrintWriter(new FileOutputStream(fileName, true));
    }

    public void write(long value) {
        writer.print(value);
    }

    public void write(String value) {
        writer.print(value);
    }

    public void write(Object... values) {
        for (Object value : values) {
            writer.print(value + " "); // uses tostring for each object
        }
    }

    public void close() {
        writer.close();
    }

    /**
     * @param value
     * @param unit
     */
    @Override
    public void writeTime(long value, TimeUnits unit) {

    }

    /**
     * @param string
     * @param value
     * @param unit
     */
    @Override
    public void writeTime(String string, long value,TimeUnits unit) {

    }
}

class Testing{
    public static void main(String[] args) throws FileNotFoundException {
        FileLogger fileLogger = new FileLogger("logk.txt");
        fileLogger.write(1);
        fileLogger.write(2);
        fileLogger.write(3);
        fileLogger.close();
    }
}