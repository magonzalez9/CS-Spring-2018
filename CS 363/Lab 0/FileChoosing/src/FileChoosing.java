
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 * @author levenick Jan 8, 2018 12:47:02 PM
 */
public class FileChoosing {
    
    public static void main(String[] args) {
        
//        File f= new File("src");
//        String currentDirectory = f.getAbsolutePath();
//        System.out.println("currentDirectory = " + currentDirectory);
        
        new FileChoosing().printFilesInADirectorySelectedByTheUser();
    }
    
    void printFilesInADirectorySelectedByTheUser() {        
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = fc.showOpenDialog(new JFrame());
        
        if (returnVal != JFileChooser.APPROVE_OPTION) {  // make sure it worked
            System.out.println("so sad...");
            return;  // give up, go home
        }
        
        File f = fc.getSelectedFile();

        System.out.println("You selected the directory = " + f);
        printContentsOfDirectory(f);
    }
    
    void printContentsOfDirectory(File f) {
        for (File nextFile : f.listFiles()) {
            System.out.println("\tnextFile = " + nextFile);
        }
    }
    
}