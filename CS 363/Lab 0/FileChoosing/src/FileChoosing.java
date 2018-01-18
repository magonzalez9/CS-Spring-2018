
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 * @author Marco
 */
public class FileChoosing {

    public static void main(String[] args) {

//        File f = new File("Source Packages/");
//        String currentDirectory = f.getAbsolutePath();
//        System.out.println("currentDirectory = " + currentDirectory);
        new FileChoosing().printFilesInADirectorySelectedByTheUser();
    }

    void printFilesInADirectorySelectedByTheUser() {
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        // Prompt for file selection
        int returnVal = fc.showOpenDialog(new JFrame());

        // Check for errors
        if (returnVal != JFileChooser.APPROVE_OPTION) {
            System.out.println("Error");
            return;  // give up, go home
        }

        File f = fc.getSelectedFile();
        System.out.println("You selected the directory = " + f);
        System.out.println(f);

        // Print contents
        printContentsOfDirectory(f,"  ");
    }

    void printContentsOfDirectory(File f, String tab) {
        for (File nextFile : f.listFiles()) {
            System.out.println(tab+nextFile);
            // Print recoursively
            if (nextFile.isDirectory() && nextFile.listFiles() != null) {
                tab += "    ";
                printContentsOfDirectory(nextFile,tab);
            } 
            // Print file(s)
            if (nextFile.isFile() && nextFile.listFiles() != null){
                tab ="  ";
                System.out.println(tab+nextFile);
            }
        }
    }

}
