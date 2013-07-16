/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package symfonydevelopergui;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
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
            int confirm = JOptionPane.showConfirmDialog(null, "Do you confirm upload");
            if (JOptionPane.YES_OPTION == confirm) {
                this.executeCommand("git ftp push --verbose");
            }
        }
    }

    public void executeCommand(String command) {
        Process p;
        this.statusLabel.setText("Executing " + command);
        try {
            String a[] = null;
            p = Runtime.getRuntime().exec(command, a, new File(Commands.applicationPath));
            BufferedInputStream bis = new BufferedInputStream(p.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(bis));
            String line;
            while ((line = br.readLine()) != null) {
                this.outPutTextPane.setText(this.outPutTextPane.getText() + "\n" + line);
            }
            Logger.getLogger(Commands.class.getName()).log(Level.INFO, "Done executing the command", "");
        } catch (IOException ex) {
            Logger.getLogger(Commands.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.statusLabel.setText("Done Executing " + command);
    }
}
