package Question3;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;




public class NotepadFrame extends javax.swing.JFrame {
    
    String fname="Untitled";
    File name;
    String text1;
    UndoManager undoManager = new UndoManager();
    
          //Default icon operation to close 
           private void Closing()
           {
               String txt = jTextArea1.getText().toString();
               if (!txt.trim().isEmpty()) 
               {
                   int dialogResult = JOptionPane.showConfirmDialog(new NotepadFrame(), "Do you want to save changes to " + fname, "Notepad", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION);
                   if (dialogResult == 0) 
                   {
                       try 
                       {
                           JFileChooser obj = new JFileChooser();
                           obj.showSaveDialog(null);
                           File name = new File(obj.getSelectedFile() + ".txt");
                           BufferedWriter writeFile = new BufferedWriter(new FileWriter(name));
                           jTextArea1.write(writeFile);

                       } 
                       catch (Exception e) 
                       {
                           e.printStackTrace();
                       }
                       System.exit(0);
                   } 
                   else if (dialogResult == 1) 
                   {
                       System.exit(0);
                   }
               } 
               else 
               {
                   System.exit(0);
               }
           }
    @Override
    public void setDefaultCloseOperation(int operation) {
        super.setDefaultCloseOperation(NotepadFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e)
            {
                Closing();
            }
        });
    }

    public NotepadFrame() 
    {
        initComponents();
        undo();
        setTitle(fname+" - Notepad"); 
        wrapOption.setText("Word Wrap");

    }
    public void undo()
    {
        jTextArea1.getDocument().addUndoableEditListener(new UndoableEditListener() 
        {
            public void undoableEditHappened(UndoableEditEvent e) 
            {
                undoManager.addEdit(e.getEdit());
                //updateButton();   
            }
        });
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        newOption = new javax.swing.JMenuItem();
        newWindowOption = new javax.swing.JMenuItem();
        openOption = new javax.swing.JMenuItem();
        saveOption = new javax.swing.JMenuItem();
        saveAsOption = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        printOption = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        exitOption = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        undoOption = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        cutOption = new javax.swing.JMenuItem();
        copyOption = new javax.swing.JMenuItem();
        pasteOption = new javax.swing.JMenuItem();
        deleteOption = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        selectAllOption = new javax.swing.JMenuItem();
        dateOption = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        wrapOption = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane1.setViewportView(jTextArea1);

        jMenu1.setText("File");

        newOption.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        newOption.setText("New");
        newOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newOptionActionPerformed(evt);
            }
        });
        jMenu1.add(newOption);

        newWindowOption.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        newWindowOption.setText("New Window");
        newWindowOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newWindowOptionActionPerformed(evt);
            }
        });
        jMenu1.add(newWindowOption);

        openOption.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        openOption.setText("Open...");
        openOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openOptionActionPerformed(evt);
            }
        });
        jMenu1.add(openOption);

        saveOption.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        saveOption.setText("Save");
        saveOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveOptionActionPerformed(evt);
            }
        });
        jMenu1.add(saveOption);

        saveAsOption.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        saveAsOption.setText("Save As...");
        saveAsOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsOptionActionPerformed(evt);
            }
        });
        jMenu1.add(saveAsOption);
        jMenu1.add(jSeparator1);

        printOption.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        printOption.setText("Print");
        printOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printOptionActionPerformed(evt);
            }
        });
        jMenu1.add(printOption);
        jMenu1.add(jSeparator2);

        exitOption.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        exitOption.setText("Exit");
        exitOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitOptionActionPerformed(evt);
            }
        });
        jMenu1.add(exitOption);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        undoOption.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        undoOption.setText("Undo");
        undoOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoOptionActionPerformed(evt);
            }
        });
        jMenu2.add(undoOption);
        jMenu2.add(jSeparator3);

        cutOption.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        cutOption.setText("Cut");
        cutOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutOptionActionPerformed(evt);
            }
        });
        jMenu2.add(cutOption);

        copyOption.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        copyOption.setText("Copy");
        copyOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyOptionActionPerformed(evt);
            }
        });
        jMenu2.add(copyOption);

        pasteOption.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        pasteOption.setText("Paste");
        pasteOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasteOptionActionPerformed(evt);
            }
        });
        jMenu2.add(pasteOption);

        deleteOption.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        deleteOption.setText("Delete");
        deleteOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteOptionActionPerformed(evt);
            }
        });
        jMenu2.add(deleteOption);
        jMenu2.add(jSeparator4);

        selectAllOption.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        selectAllOption.setText("Select All");
        selectAllOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectAllOptionActionPerformed(evt);
            }
        });
        jMenu2.add(selectAllOption);

        dateOption.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        dateOption.setText("Time/Date");
        dateOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateOptionActionPerformed(evt);
            }
        });
        jMenu2.add(dateOption);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Format");

        wrapOption.setText("Word Wrap ");
        wrapOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wrapOptionActionPerformed(evt);
            }
        });
        jMenu3.add(wrapOption);

        jMenuBar1.add(jMenu3);

        jMenu5.setText("About");

        jMenuItem2.setText("About Notepad");
        jMenu5.add(jMenuItem2);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pasteOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasteOptionActionPerformed
      jTextArea1.insert(text1, jTextArea1.getCaretPosition());
    }//GEN-LAST:event_pasteOptionActionPerformed

    private void exitOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitOptionActionPerformed
        //dispose();        => (for a particular window/frame)
        //System.exit();    => (terminate java vm completely)
        
        String txt = jTextArea1.getText().toString();
        if (!txt.trim().isEmpty()) 
        {
            int dialogResult = JOptionPane.showConfirmDialog(new NotepadFrame(), "Do you want to save changes to " + fname, "Notepad", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION);
            if (dialogResult == 0) 
            {
                try
                {
                    JFileChooser obj = new JFileChooser();
                    obj.showSaveDialog(null);
                    File name = new File(obj.getSelectedFile() + ".txt");
                    BufferedWriter writeFile = new BufferedWriter(new FileWriter(name));
                    jTextArea1.write(writeFile);
                }
                catch (Exception e) 
                {
                    e.printStackTrace();
                }
                System.exit(0);
            }
            else if (dialogResult == 1) 
            {
                System.exit(0);
            }
        } 
        else 
        {
            System.exit(0);
        }
    }//GEN-LAST:event_exitOptionActionPerformed

    private void newOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newOptionActionPerformed
        String txt = jTextArea1.getText().toString();
        if (!txt.trim().isEmpty()) 
        {
            int dialogResult = JOptionPane.showConfirmDialog(new NotepadFrame(), "Do you want to save changes to " + fname, "Notepad", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION);
            if (dialogResult == 0) 
            {
                try 
                {
                    JFileChooser obj = new JFileChooser();
                    obj.showSaveDialog(null);
                    File name = new File(obj.getSelectedFile() + ".txt");
                    BufferedWriter writeFile = new BufferedWriter(new FileWriter(name));
                    jTextArea1.write(writeFile);

                } 
                catch (Exception e) 
                {
                    e.printStackTrace();
                }
                jTextArea1.setText("");
            } 
            else if (dialogResult == 1) 
            {
                jTextArea1.setText("");
            }
        } 
        else 
        {
            jTextArea1.setText("");
        }
           
    }//GEN-LAST:event_newOptionActionPerformed

    private void saveOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveOptionActionPerformed
        JFileChooser obj = new JFileChooser();
        try 
        {
            if (fname.equals("Untitled")) 
            {
                obj.showSaveDialog(null);
                name = new File(obj.getSelectedFile() + ".txt");
                BufferedWriter writeFile = new BufferedWriter(new FileWriter(name));
                jTextArea1.write(writeFile);
                fname = name.getName();
                setTitle(fname + " - Notepad");
            } 
            else 
            {

                BufferedWriter writeFile = new BufferedWriter(new FileWriter(name));
                jTextArea1.write(writeFile);

            }

        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_saveOptionActionPerformed

    private void openOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openOptionActionPerformed
        JFileChooser obj = new JFileChooser();
        //boolean b=false;
        // obj.setAcceptAllFileFilterUsed(b);
        
        //filter to display only text files
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Documents (*.txt)", "txt");
        obj.addChoosableFileFilter(filter);
        try
        {
            obj.showOpenDialog(null);
            name = obj.getSelectedFile();
            fname = name.getName();
            setTitle(fname + " - Notepad");
            BufferedReader readFile = new BufferedReader(new FileReader(name));
            jTextArea1.read(readFile, name);
        }
        catch (Exception e) 
        {
            //e.printStackTrace();
        }
    }//GEN-LAST:event_openOptionActionPerformed

    private void saveAsOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsOptionActionPerformed
        JFileChooser obj=new JFileChooser();
        try
         {
          obj.showSaveDialog(null);
          name=new File(obj.getSelectedFile()+".txt");
          BufferedWriter writeFile=new BufferedWriter(new FileWriter(name));
          jTextArea1.write(writeFile);
          fname=name.getName(); 
          setTitle(fname+" - Notepad"); 
         }
        catch(Exception e)
         {
          e.printStackTrace();
         }
    }//GEN-LAST:event_saveAsOptionActionPerformed

    private void printOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printOptionActionPerformed
      try
      {
        jTextArea1.print();
      }
      catch(Exception e)
      {
    e.printStackTrace();
      }
    }//GEN-LAST:event_printOptionActionPerformed

    private void copyOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyOptionActionPerformed
       text1=jTextArea1.getSelectedText();
       
    }//GEN-LAST:event_copyOptionActionPerformed

    private void cutOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutOptionActionPerformed
       text1=jTextArea1.getSelectedText();
       jTextArea1.replaceRange("", jTextArea1.getSelectionStart(),jTextArea1.getSelectionEnd());
    }//GEN-LAST:event_cutOptionActionPerformed

    private void deleteOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteOptionActionPerformed

    jTextArea1.replaceSelection("");
    }//GEN-LAST:event_deleteOptionActionPerformed

    private void selectAllOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectAllOptionActionPerformed
       jTextArea1.selectAll();
    }//GEN-LAST:event_selectAllOptionActionPerformed

    private void dateOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateOptionActionPerformed
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm MM/dd/yyyy");
        LocalDateTime dt = LocalDateTime.now();
        String date = dt.format(dtf).toString();
        jTextArea1.insert(date, jTextArea1.getCaretPosition());
    }//GEN-LAST:event_dateOptionActionPerformed

    private void wrapOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wrapOptionActionPerformed
        
        String wText=wrapOption.getText();
        boolean w=true;
        if(wText=="Word Wrap")
        {
            jTextArea1.setLineWrap(w);
            wrapOption.setText("Word Wrap ✅");
        }
        else
        {
            w=false;
            jTextArea1.setLineWrap(w);
            wrapOption.setText("Word Wrap");
        }
    }//GEN-LAST:event_wrapOptionActionPerformed

    private void undoOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoOptionActionPerformed
        try 
        {
            undoManager.undo();
        } 
        catch (CannotUndoException ex) 
        {
            ex.printStackTrace();
        }    
    }//GEN-LAST:event_undoOptionActionPerformed

    private void newWindowOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newWindowOptionActionPerformed
        
       
        
        NotepadFrame frame = new NotepadFrame();
        frame.setVisible(true);
        
    }//GEN-LAST:event_newWindowOptionActionPerformed

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
            java.util.logging.Logger.getLogger(NotepadFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NotepadFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NotepadFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NotepadFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NotepadFrame().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem copyOption;
    private javax.swing.JMenuItem cutOption;
    private javax.swing.JMenuItem dateOption;
    private javax.swing.JMenuItem deleteOption;
    private javax.swing.JMenuItem exitOption;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JMenuItem newOption;
    private javax.swing.JMenuItem newWindowOption;
    private javax.swing.JMenuItem openOption;
    private javax.swing.JMenuItem pasteOption;
    private javax.swing.JMenuItem printOption;
    private javax.swing.JMenuItem saveAsOption;
    private javax.swing.JMenuItem saveOption;
    private javax.swing.JMenuItem selectAllOption;
    private javax.swing.JMenuItem undoOption;
    private javax.swing.JMenuItem wrapOption;
    // End of variables declaration//GEN-END:variables
}
