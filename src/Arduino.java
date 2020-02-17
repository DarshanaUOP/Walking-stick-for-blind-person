import com.fazecast.jSerialComm.SerialPort;

import javax.swing.*;
import java.util.Scanner;

/**
 * Created by acer on 19-Oct-17.
 */
public class Arduino {

    static SerialPort choosenPort;

    public static boolean conn(String portName) {
        choosenPort = SerialPort.getCommPort(portName);
        choosenPort.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
        if (choosenPort.openPort()) {
            return true;
        } else {
            return false;
        }
    }
    public static void send() {
    }

    public static String[] recieve() {
        String line = null;
        String chooseProg[]=new String[4];
        Scanner scanner = new Scanner(choosenPort.getInputStream());
        //System.out.println(scanner.next());
        while (scanner.hasNextLine()) {
            try {
                chooseProg = scanner.nextLine().split(",");

                //System.out.println("Inside arduino class: "+chooseProg[0] + "\t" + chooseProg[1] + "\t" + chooseProg[2] + "\t" + chooseProg[3] + ".");

                /**
                 * CODE FOR GET INPUTS
                 * */
                //System.out.println(line);
                //lblColor.setText(line);
                //txtRed.setText(line);
                //return line;
                return chooseProg;
            }catch (Exception e4){
                JOptionPane.showMessageDialog(null,e4.getMessage()+"\n"+e4.getCause()+"\n"+e4.getLocalizedMessage(),"Error in Arduino Class.",JOptionPane.ERROR_MESSAGE);
                System.out.println(e4.getMessage());
            }
        }
        scanner.close();
        return chooseProg;
    }

    public static void closeArduino(){
        choosenPort.closePort();
    }
}