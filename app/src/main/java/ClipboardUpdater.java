
/**
 * Command Line Arguments:
 * -dbug<false/true> - debugs printed/not to system out during the conversion
 * -exit<ExitString> - An exit command, if found in clipboard, terminates the
 * program
 * @author Dasun T. Bamunuarachchi
 */
import java.awt.*;
import java.awt.datatransfer.*;
import javax.swing.JOptionPane;

class ClipboardUpdater implements Runnable {

    static ConfigureRTC rtcUI;
    static Object[] commandsAll = new Object[10];
    private static final String MAGIC_STRING = "6869746170616e";
    static Clipboard clipboard = null;
    static String[] args = new String[0];
    boolean isThreadRunning = false;
    private boolean enableRestoreLastText = true;

    @Override
    public void run() {

        while (true) {
            //do translation
            commandsAll[0] = true;
            for (String arg : args) {
                System.out.println("arg:" + arg);
                if (arg.startsWith("-dbug")) {//01234___
                    commandsAll[0] = Boolean.parseBoolean(arg.substring(5));
                } else if (arg.startsWith("-exit")) {
                    commandsAll[1] = arg.substring(5);//copy exit command
                }
            }
            if(clipboard==null){
                clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                System.out.println("Obtaining Clipboard");
            }
                
            RTUC_T1 rtuc1 = new RTUC_T1();
            RTUC_T2 rtuc2 = new RTUC_T2();
            rtuc1.debugEnable = (Boolean) commandsAll[0];
            String inputData = "";
            String inputDataLast = null;// to restore last data
            String convertedData = "";
            
            while (isThreadRunning) {
                try {
                    inputData = copyFromClipboard();
                    if (inputData != null) {
                        if (inputData.equals(commandsAll[1]) || MAGIC_STRING.equals(inputData)) {
                            System.out.println(System.currentTimeMillis() + ": exit command " + commandsAll[1]);
                            copyToClipboard(inputDataLast);//restore the previous data
                            break;//exit
                        }
                    }
                    if (inputData != null && !inputData.equals(convertedData)) {
                        System.out.println(System.currentTimeMillis() + " Clipboard  IN: " + inputData);
                    } else {
                        readCommands();
                        sleep_1();
                        continue;
                    }
                    inputDataLast = inputData;
                    rtuc1.setStringToConvert(inputData);
                    convertedData = rtuc1.processText();

                    copyToClipboard(convertedData);
                    System.out.println(System.currentTimeMillis() + " Clipboard OUT: " + convertedData);

                } catch (Throwable t) {
                    t.printStackTrace();
                }
            }
            if(enableRestoreLastText && inputDataLast !=null){
                copyToClipboard(inputDataLast);//this will be set to null in the beginning of while
            }
            sleep_1();//wait
        }
    }

    static String copyFromClipboard() {
        String input = null;
        Transferable trans = clipboard.getContents(null);
        if (trans.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            try {
                input = (String) trans.getTransferData(DataFlavor.stringFlavor);
            } catch (Throwable ex) {
                ex.printStackTrace();
            }
        }
        return input;
    }

    void stopThread() {
        synchronized (ClipboardUpdater.class) {
            if (isThreadRunning) {
                isThreadRunning = false;
                System.out.println("Service Stopped");
            } else {
                JOptionPane.showMessageDialog(rtcUI, "Service is stopped");
            }
        }
    }

    void startThread() {
        synchronized (ClipboardUpdater.class) {
            if (!isThreadRunning) {
                isThreadRunning = true;
                System.out.println("Service Started");
            } else {
                JOptionPane.showMessageDialog(rtcUI, "Service is already running");
            }
        }
    }

    static void copyToClipboard(String data) {
        StringSelection converted = new StringSelection(data);
        clipboard.setContents(converted, converted);
    }

    static void sleep_1() {
        try {
            Thread.sleep(250);
        } catch (Throwable t) {
        }
    }
    
    static void readCommands() {
        //read input from client 
        char[] command = new char[0];//server.read();
        String s = new String(command);
        if (s != null && !s.isEmpty()) {
            System.out.println(s);
        }
        //update the commands list 
    }

    public boolean isEnableRestoreLastText() {
        return enableRestoreLastText;
    }

    public void setEnableRestoreLastText(boolean enableRestoreLastText) {
        this.enableRestoreLastText = enableRestoreLastText;
    }

}
