/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualDisk;

import java.util.ArrayList;
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
        setInodeList();
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

        fileNameMenu.setForeground(new java.awt.Color(0, 0, 255));
        fileNameMenu.setText("Untitled*");
        jMenuBar1.add(fileNameMenu);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

    }//GEN-LAST:event_jMenu1ActionPerformed

    private void saveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsActionPerformed
        String filename = (String) JOptionPane.showInputDialog(
                new JFrame(),
                "Enter filename",
                "Save as...",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                "");
        String nodeString = "";

        if (file_list.isEmpty()) {
            nodeString = "Open locations: 0,1,2";
        } else {
            for (int i = 0; i < file_list.size(); i++) {
                //Build string for JOption Pane below
                nodeString += "Location full: " + file_list.get(i).getInodeNumber() + "\n";
            }
            nodeString += "Select the inode to save your file";
        }

        //Set inode number
        int inodeNumber = 0;
        if (!inode_list.isEmpty()) {
            inodeNumber = inode_list.get(0);
            inode_list.remove(0);
        }
        System.out.println(inode_list.toString() + "what is left");

        // Create file
        File file = new File(filename, inodeNumber);

        //Add to our list of files
        file_list.add(file);

        // Get the data from text area
        String data = textArea.getText();

        // Save the data!
        fileSystem.save(file, data);

        // Display filename on gui menu
        fileNameMenu.setText(filename);

        currentFile = file;

    }//GEN-LAST:event_saveAsActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_deleteActionPerformed

    private void loadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadActionPerformed
        String listOfFiles = "";
        if (file_list.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No records to load!");
        } else {
            for (int i = 0; i < file_list.size(); i++) {
                //Build string for JOption Pane below
                listOfFiles += "(" + file_list.get(i).getInodeNumber() + ") " + file_list.get(i).getName() + "\n";
            }
            listOfFiles += "Select the number of the file you wish to load";
            String fileNumber = (String) JOptionPane.showInputDialog(
                    new JFrame(),
                    listOfFiles,
                    "Load file...",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    "");

            int inodeNumber = Integer.parseInt(fileNumber);

            String dataToDisplay = fileSystem.load(file_list.get(inodeNumber));
            textArea.setText(dataToDisplay);
            fileNameMenu.setText(file_list.get(inodeNumber).getName());
            currentFile = file_list.get(inodeNumber);
            System.out.println("LOADED DATA!: " + dataToDisplay);
        }

    }//GEN-LAST:event_loadActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
        fileSystem.save(currentFile, textArea.getText());
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
