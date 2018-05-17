/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panprinter;

import java.awt.CardLayout;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.DefaultCaret;
import jssc.*;

/**
 *
 * @author O.S.
 * @version 29/01/2016 - alpha
 */
public class CodeMaker extends javax.swing.JFrame {
    
    private static String _code;
    
    private final static String table16x16 = "16x16";
    
    private final static String table15x15 = "15x15";
    
    private final static String table18x18 = "18x18";
    
    private final static String[] tables = {table15x15, table18x18};
    /**
     * Creates new form CodeMaker
     */
    public CodeMaker() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        codeScreen = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        serialConsole = new javax.swing.JTextArea();
        tableChanger = new javax.swing.JComboBox();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        table18C = new panprinter.Table18x18();
        table15C = new panprinter.Table15x15();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        codeScreen.setText("Waiting for code");
        codeScreen.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jScrollPane1.setViewportView(codeScreen);

        serialConsole.setEditable(false);
        serialConsole.setBackground(new java.awt.Color(0, 0, 0));
        serialConsole.setColumns(20);
        serialConsole.setForeground(new java.awt.Color(51, 204, 0));
        serialConsole.setRows(5);
        DefaultCaret caret = (DefaultCaret)serialConsole.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        jScrollPane2.setViewportView(serialConsole);

        tableChanger.setModel(new javax.swing.DefaultComboBoxModel(tables));
        tableChanger.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tableChangerItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(table15C, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(table18C, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(table15C, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(table18C, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jLayeredPane1.setLayer(table18C, 1);
        jLayeredPane1.setLayer(table15C, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tableChanger, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(148, 148, 148))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(tableChanger, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
        );

        table18C.setVisible(false);
        table15C.setVisible(true);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableChangerItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tableChangerItemStateChanged
        switch ((String) (evt.getItem()))
        {
            case table15x15: table15C.setVisible(true); table18C.setVisible(false); repaint(); revalidate(); break;
            case table18x18: table18C.setVisible(true); table15C.setVisible(false); repaint(); revalidate(); break;
        }
    }//GEN-LAST:event_tableChangerItemStateChanged

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
            java.util.logging.Logger.getLogger(CodeMaker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CodeMaker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CodeMaker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CodeMaker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CodeMaker().setVisible(true);
            }
        });
    }
    
    public static void codeUpdate(String code) {
        _code = code;
        code = code.replace("\n", "<br>");
        code = "<html>" + code + "</html>";
        codeScreen.setText(code);
    }
    
    public static void printCode(String code) throws SerialPortException {
       SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
           
       @Override
       protected Void doInBackground() throws Exception {
            SerialPort serialPort = new SerialPort("COM7");
            try {
                serialConsole.setText(serialConsole.getText() + "Port opened: " + serialPort.openPort() + "\n");
                String currLine, tempCode = code;
                Scanner liner = new Scanner(tempCode);
                while ((currLine = liner.nextLine()) != null)
                {
                    serialConsole.setText(serialConsole.getText() + currLine + "\n");
                    serialPort.writeString(currLine);
                    Thread.sleep(3000);
                    String temp = serialPort.readString();
                    serialConsole.setText(serialConsole.getText() + temp + "\n");
                }
                //System.out.println("Params setted: " + serialPort.setParams(9600, 8, 1, 0));
                //System.out.println("\"Hello World!!!\" successfully writen to port: " + serialPort.writeBytes("Hello World!!!".getBytes()));

            }
            catch (SerialPortException ex){
                System.out.println(ex);
            } 
            catch (InterruptedException ex) {
                Logger.getLogger(CodeMaker.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (NoSuchElementException ex) {
                //FOff
            }
            finally {
                serialConsole.setText(serialConsole.getText() + "Port closed: " + serialPort.closePort() + "\n");
            }
            return null;
       }
      };

      worker.execute();
    }

    public static void saveCode(String code) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PanPrinter Print File", new String[] {"ppos"});
        chooser.setFileFilter(filter);
        int returnVal = chooser.showSaveDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION)
        {
            File file = chooser.getSelectedFile();
            if (!file.getName().contains(".osp"))
                file = new File(file.getPath() + ".osp");
            try (PrintWriter out = new PrintWriter(file)) {
                out.println(code);
                out.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(CodeMaker.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(file);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JLabel codeScreen;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JTextArea serialConsole;
    private panprinter.Table15x15 table15C;
    private panprinter.Table18x18 table18C;
    private javax.swing.JComboBox tableChanger;
    // End of variables declaration//GEN-END:variables
}
