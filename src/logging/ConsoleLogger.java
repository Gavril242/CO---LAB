package logging;

public class ConsoleLogger implements ILog {
    public void write(long value) {
        System.out.print(value);
    }

    public void write(String value) {
        System.out.print(value);
    }

    public void write(Object... values) {
        for (Object value : values) {
            System.out.print(value + " ");
        }
    }

    public void close() {
        System.out.println("The Console is now closed;");
    }
}

class ConsoleTesting{
    public static void main(String[] args) {
        ConsoleLogger logger = new ConsoleLogger();
        logger.write("Hello ");
        logger.write("World; ");
        logger.close();
    }
}