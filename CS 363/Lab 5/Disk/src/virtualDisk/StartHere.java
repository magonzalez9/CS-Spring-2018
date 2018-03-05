package virtualDisk;

/**
 *
 * @author levenick
 */
public class StartHere {

    public static void main(String[] args) {
        testToString();
//        playWithStrings();
    }

    static void playWithStrings() {
        String s = "willamette!";
        String will = s.substring(0, 4);
        String tail = s.substring(4);
        System.out.println("will = " + will);
        System.out.println("tail = " + tail);
        
    }

    private static void testToString() {
        byte[] alpha = {'a', 'b', 'c', 'd'};
        byte[] beta = {1, 2, 3, 97};
        System.out.println("alpha first");
        outputAsLetters(alpha);
        outputAsNumbers(alpha);
        System.out.println("\nbeta second");
        outputAsLetters(beta);
        outputAsNumbers(beta);
        System.exit(12345);

    }

    static void outputAsLetters(byte[] data) {
        String buffer = "as letters... ";
        for (int i = 0; i < data.length; i++) {
            buffer += (char) data[i] + ",";
        }
        System.out.println("" + buffer);
    }

    private static void outputAsNumbers(byte[] data) {
        String buffer = "without casting... ";
        for (int i = 0; i < data.length; i++) {
            buffer += data[i] + " ";
        }
        System.out.println("" + buffer);
    }
}