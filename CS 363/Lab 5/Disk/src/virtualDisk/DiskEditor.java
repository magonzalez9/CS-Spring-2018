package virtualDisk;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author marco
 */
public class DiskEditor extends javax.swing.JFrame {

    FileSystem fileSystem = new FileSystem();
    ArrayList<File> file_list = new ArrayList<File>();
    ArrayList<Integer> inode_list = new ArrayList<Integer>();
    File currentFile;

    public DiskEditor() {
        initComponents();
        this.setSize(500, 500);
        // set free inode list.
        setInodeList();
        
        // disable save funtionality as there are no files to open when the program first runs!
        save.setEnabled(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        load = new javax.swing.JMenuItem();
        save = new javax.swing.JMenuItem();
        saveAs = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        delete = new javax.swing.JMenuItem();
        fileNameMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane2.setViewportView(textArea);

        getContentPane().add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jMenu1.setText("File");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        load.setText("Load ");
        load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadActionPerformed(evt);
            }
        });
        jMenu1.add(load);

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jMenu1.add(save);

        saveAs.setText("Save As...");
        saveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsActionPerformed(evt);
            }
        });
        jMenu1.add(saveAs);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        delete.setText("Delete File");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jMenu2.add(delete);

        jMenuBar1.add(jMenu2);

        fileNameMenu.setBackground(new java.awt.Color(51, 51, 255));
        fileNameMenu.setBorder(new javax.swing.border.MatteBorder(null));
        fileNameMenu.setForeground(new java.awt.Color(0, 0, 255));
        fileNameMenu.setText("Untitled*");
        jMenuBar1.add(fileNameMenu);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

    }//GEN-LAST:event_jMenu1ActionPerformed

    private void saveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsActionPerformed
        // Get text from text area
        String data = textArea.getText();

        // First check that the user has not exceeded the character limit... if so do not save and spit out a message
        if (data.length() > 168) {
            //ALERT! user has exceeded max charecters available
            JOptionPane.showMessageDialog(null, "Max character limit reached: " + data.length() + "/168");
        } else {
            // User has less than 168 characters in text area! Lets begin to save...
            // Set starting inode... (only gets set once)
            int inodeNumber = 0;

            // Check to see if the inode list is full 
            if (!inode_list.isEmpty()) { // inode list is not empty so we can still add files!
                String filename = (String) JOptionPane.showInputDialog(
                        new JFrame(),
                        "Enter filename",
                        "Save as...",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        null,
                        "");

                // Get an open INODE number!
                inodeNumber = inode_list.get(0);
                inode_list.remove(0);

                // Create file with retrieved indode number
                File file = new File(filename, inodeNumber);

                //Add to our list of files
                file_list.add(file);

                // Save the data!
                fileSystem.save(file, data);

                // Display filename on gui menu
                fileNameMenu.setText(filename);

                // keep track of the current file we are working on. 
                currentFile = file;

                save.setEnabled(true);
            } else { // Ack! The list if full, lets ask the user they would like to overite a file!
                String listOfFiles = "";
                for (int i = 0; i < file_list.size(); i++) {
                    //Lets generate the list of the files that are currently saved. 
                    listOfFiles += "(" + file_list.get(i).getInodeNumber() + ") " + file_list.get(i).getName() + "\n";
                }
                listOfFiles += "Warning: No more inodes left! Select the inode you wish to OVERWRITE!";

                // Get the inode number that the user chose to overite!
                String inodeToReplace = (String) JOptionPane.showInputDialog(
                        new JFrame(),
                        listOfFiles,
                        "Overwrite a file",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        null,
                        "");
                // Set the new file name for the file we are overwriting
                String overite_filename = (String) JOptionPane.showInputDialog(
                        new JFrame(),
                        "Enter new filename",
                        "Save as...",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        null,
                        "");

                // parse the inode string so we can get the right file!
                int inodeNumbtoReplace = Integer.parseInt(inodeToReplace);

                // Save the data
                fileSystem.save(file_list.get(inodeNumbtoReplace), data);

                // set the new file name in our file object!
                file_list.get(inodeNumbtoReplace).setName(overite_filename);

                // Display filename on gui menu
                fileNameMenu.setText(overite_filename);

                // Set the current file so we can later access it!
                currentFile = file_list.get(inodeNumbtoReplace);

            } // End of else checking for existing files

        } // End of else checking for max character length

    }//GEN-LAST:event_saveAsActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        fileSystem.delete(currentFile);
        inode_list.add(currentFile.getInodeNumber());
        Collections.sort(inode_list);
        System.out.println(inode_list.toString()); 
    }//GEN-LAST:event_deleteActionPerformed

    private void loadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadActionPerformed
        String listOfFiles = "";

        // If the list is empty (no files saved yet) let the user know!
        if (file_list.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No records to load!");
        } else {
            // There are existing file(s) lets display them!
            for (int i = 0; i < file_list.size(); i++) {
                //Build string for JOption Pane below the shows user the files that are available
                listOfFiles += "(" + file_list.get(i).getInodeNumber() + ") " + file_list.get(i).getName() + "\n";
            }
            listOfFiles += "Select the number of the file you wish to load";
            String inodeString = (String) JOptionPane.showInputDialog(
                    new JFrame(),
                    listOfFiles,
                    "Load file...",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    "");

            int inodeNumber = Integer.parseInt(inodeString);

            // Load data into text area!
            textArea.setText(fileSystem.load(file_list.get(inodeNumber)));

            // set filename on our lovely option menu
            fileNameMenu.setText(file_list.get(inodeNumber).getName());

            // Set the current file so we can later access it!
            currentFile = file_list.get(inodeNumber);
        }

    }//GEN-LAST:event_loadActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // Save current data into current file
        String data = textArea.getText();
        
        // First make sure that the data length does not exceed the max char limit
        if (data.length() > 168) {
            //Ack! Too many characters!
            JOptionPane.showMessageDialog(null, "Max character limit reached: " + data.length() + "/168");
        } else {
            // We good on characters lets save the data into current file
            fileSystem.save(currentFile, textArea.getText());
        }
    }//GEN-LAST:event_saveActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DiskEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DiskEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DiskEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiskEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DiskEditor().setVisible(true);
            }
        });
    }

    public void setInodeList() {
        // First, set the inodes that are free upon running program e.g [0,1,2]
        inode_list.add(0);
        inode_list.add(1);
        inode_list.add(2);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem delete;
    private javax.swing.JMenu fileNameMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem load;
    private javax.swing.JMenuItem save;
    private javax.swing.JMenuItem saveAs;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}
