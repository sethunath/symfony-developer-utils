/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package symfonydevelopergui;

import java.awt.TrayIcon;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

/**
 *
 * @author sethunath.km
 */
public class Commands {

    private static String applicationPath;
    private JTextPane outPutTextPane;
    private JLabel statusLabel;

    public Commands(JTextPane outPutTextPane, JLabel statusLabel) {
        this.outPutTextPane = outPutTextPane;
        this.statusLabel = statusLabel;
        Commands.applicationPath = "D:\\\\wamp\\\\www\\\\spotscloud";
    }

    public static void setApplicationPath(String applicationPath) {
        Commands.applicationPath = applicationPath;
    }

    public void clearCache(boolean dev, boolean prod) {
        if (dev) {
            this.executeCommand("rm -rf --verbose app/cache/dev");
        }
        if (prod) {
            this.executeCommand("rm -rf --verbose app/cache/prod");
        }
    }

    public void dumpAssets(boolean pull, boolean ftpPush) {
        if (pull) {
            this.executeCommand("git pull");
        }
        this.executeCommand("php app/console assetic:dump");
        if (ftpPush) {
            MainWindow.trayIcon.displayMessage("Command Finished", "Confirm Upload" , TrayIcon.MessageType.WARNING);
            int confirm = JOptionPane.showConfirmDialog(null, "Do you confirm upload");
            if (JOptionPane.YES_OPTION == confirm) {
                this.executeCommand("git ftp push --verbose");
            }
        }
    }

    public void executeCommand(String command) {
        Process p;
        this.statusLabel.setText("Executing " + command);
        int c=0;
        try {
            String a[] = null;
            p = Runtime.getRuntime().exec(command, a, new File(Commands.applicationPath));
            InputStream is = p.getInputStream();
            
            BufferedInputStream bis = new BufferedInputStream(is);
            BufferedReader br = new BufferedReader(new InputStreamReader(bis));
            String line;
            while ((line = br.readLine()) != null) {
                c++;
                this.outPutTextPane.setText(this.outPutTextPane.getText() + "\n" + line);
                if(c%123==0){
                    this.outPutTextPane.setText("");
                    c=0;
                }
            }
            try {
                p.waitFor();
            } catch (InterruptedException ex) {
                Logger.getLogger(Commands.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(p.exitValue()!=0){
                MainWindow.trayIcon.displayMessage("Man! Thats an error", command+" gave an errror. Check o/p pane" , TrayIcon.MessageType.WARNING);
                is = p.getErrorStream();
            }else{
                Logger.getLogger(Commands.class.getName()).log(Level.INFO, "Done executing the command", "");
            }
            bis = new BufferedInputStream(is);
            br = new BufferedReader(new InputStreamReader(bis));
            while ((line = br.readLine()) != null) {
                c++;
                this.outPutTextPane.setText(this.outPutTextPane.getText() + "\n" + line);
                if(c%123==0){
                    this.outPutTextPane.setText("");
                    c=0;
                }
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Commands.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.statusLabel.setText("Done Executing " + command);
        MainWindow.trayIcon.displayMessage("Command Finished", command , TrayIcon.MessageType.INFO);
    }
}
