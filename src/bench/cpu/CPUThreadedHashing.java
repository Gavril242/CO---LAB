package bench.cpu;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import bench.IBenchmark;

public class CPUThreadedHashing implements IBenchmark {

    private String result;
    volatile boolean running = true;

    public String getResult() {
        return String.valueOf(result);
    }


    @Override
    public void initialize(Object... params) {

    }

    @Override
    public void run() {
        throw new UnsupportedOperationException(
                "Method not implemented. Use run(Object) instead");
    }

    @Override
    public void run(Object... options) {

        // maximum text length
        int maxTextLength = (Integer)options[0];
        // thread pool size
        int nThreads = (Integer)options[1];
        // hash code
        int hashCode = (Integer)options[2];

        // try to break these hash codes (in ascending order of difficulty):
        // 524381996
        // 52703576
        // 605107138

        int length = 2;

        ExecutorService executor = Executors.newFixedThreadPool(nThreads);
        HashManager hasher = new HashManager();
        String text = "aa";
        int hashe;

        while (running) {
            hashe=hasher.hash(text);
            // assign new runnable to executor
            if(hashe==hashCode) {System.out.println("Found hash "+hashCode+" at text ="+text); result = text; break;}
            // get next string (new task) OR NULL if final combination "zzz..z" reached
            text = hasher.getNextString(text);

            // stop search condition#1
            if (length > maxTextLength) {
                running = false;
            }

            // reset string to "aaa...a" with length+1
            if (text == null) {
                length++;
                text = "aa";
                for (int i = 2; i < length; ++i)
                    text += "a";
            }
        }

        // stop executor


    }

    @Override
    public void clean() {
    }

    @Override
    public void cancel() {

    }

    /**
     *
     */
    @Override
    public void warmup() {
        HashManager hash = new HashManager();
        int hashcodee= hash.hash("direct");
        System.out.println("Hash of direct is: "+ hashcodee);
        // assign new runnable to executor

    }


    class HashBreakerTask implements Runnable {

        // used to compute hashes from strings
        private final HashManager hasher;
        // the string to be hashed
        private final String text;
        // the expected hash output
        private final int expectedHash;

        public HashBreakerTask(HashManager hasher, String text, int expectedHash) {
            this.hasher = hasher;
            this.text = text;
            // 'text' is hashed and compared to 'expected hash'
            this.expectedHash = expectedHash;
        }

        @Override
        public void run() {
            // if we found the hash
            if (expectedHash == hasher.hash(text)) {
                // stop condition#2
                running = false;
                //save password text as result to be printed on screen
                result = text;
            }
        }
    }

    /**
     * Used to compute hashes from strings
     */
    class HashManager {

        // do not change alphabet
        private final String charSet = "abcdefghijklmnopqrstuvwxyz";

        // do not change function
        public int hash(String text) {
            int a = 0;
            int b = 0;
            for (char c : text.toCharArray()) {
                int index = charSet.indexOf(c);
                if (index == -1)
                    index = charSet.length() + 1;
                for (int i = 0; i < 17; i++) {
                    a = a * -6 + b + 0x74FA - index;
                    b = b / 3 + a + 0x81BE - index;
                }
            }

            return (a ^ b) % Integer.MAX_VALUE;
        }

        public String getNextString(String text) {
            String charSet = "abcdefghijklmnopqrstuvwxyz";
            int[] index = new int[text.length()];
            int end = charSet.length() - 1;

            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                index[i] = charSet.indexOf(c);
            }

            int carry = 1;
            for (int i = index.length - 1; i >= 0; i--) {
                index[i] += carry;
                carry = 0;
                if (index[i] > end) {
                    index[i] = 0;
                    carry = 1;
                } else {
                    break;
                }
            }

            if (carry == 1) {
                return null;
            }

            String result = "";
            for (int i = 0; i < index.length; i++) {
                result += charSet.charAt(index[i]);
            }

            return result.toString();
        }


        // can be used as an alternative to getNextString, but it will be infinitely slower to break longer hashes
        public String getRandomString(int length) {
            String text = "";

            for (int i = 0; i < length; i++) {
                Random rand =  new Random();
                char c = charSet.charAt(rand.nextInt(charSet.length()));
                text += c;
            }

            return text;
        }
    }

}