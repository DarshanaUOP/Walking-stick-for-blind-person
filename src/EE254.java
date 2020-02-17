import com.fazecast.jSerialComm.SerialPort;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;


/**
 * Created by acer on 22-Sep-17.
 */
class Loader{
    public static void main(String[] args) {
        EE254 ee254 =new EE254();
        ee254.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ee254.setVisible(true);
        ee254.setEnabled(true);
        ee254.setSize(1200,800);
        ee254.setResizable(true);
        ee254.setTitle("EE 254 Project (EE 2.01)");


    }
}

public class EE254 extends JFrame{


    static SerialPort choosenPort;

    private JPanel panBack;
    private JPanel panUp;
    private JPanel panDown;
    private JPanel panGraph;
    private JPanel panColor;
    private JPanel panConn;
    private JPanel panDbData;
    private JPanel panArduino;
    private JPanel panDb;
    private JLabel lblColor;
    private JButton btnConArd;
    private JComboBox cmbComPort;
    private JLabel lblArdn;
    private JLabel lblComPort;
    private JLabel lblMute;
    private JTextField txtRed;
    private JTextField txtGreen;
    private JTextField txtBlue;
    private JTextField txtHex;
    private JTextField txtIntHex;
    private JTextField txtColorName;
    private JTextField txtDescription;
    private JLabel lblRed;
    private JLabel lblGreen;
    private JLabel lblBlue;
    private JLabel lblHex;
    private JLabel lblIntHex;
    private JLabel lblColorName;
    private JLabel lblDescription;
    private JButton btnSave;
    private JButton btnMute;
    private JButton btnExit;
    private JLabel lblImg;
    private JButton btnSearch;
    private JLabel lblSearchIcon;
    private JLabel lblSearch;
    private JLabel lblEE2p01;

    private ImageIcon imgDone;
    private ImageIcon imgConn;
    private ImageIcon imgMute;
    private ImageIcon imgPin;
    private ImageIcon imgSearch;
    private ImageIcon imgUnmute;
    private ImageIcon imgExit;
    private ImageIcon imgWarning;
    private ImageIcon imgReconn;
    private ImageIcon imgCoppy;



    public  EE254(){


        /**_Load_Images____*/
        imgDone=new ImageIcon(getClass().getResource("done.png"));
        imgConn=new ImageIcon(getClass().getResource("Connect.png"));
        imgMute=new ImageIcon(getClass().getResource("Mute.png"));
        imgPin=new ImageIcon(getClass().getResource("pin.png"));
        imgSearch = new ImageIcon(getClass().getResource("Search.png"));
        imgUnmute=new ImageIcon(getClass().getResource("Unmute.png"));
        imgExit = new ImageIcon(getClass().getResource("Exit.png"));
        imgWarning = new ImageIcon(getClass().getResource("werning.png"));
        imgReconn = new ImageIcon(getClass().getResource("Reconnect.png"));
        imgCoppy = new ImageIcon(getClass().getResource("coppy.png"));

        /**_Load_Jpanels___*/
        panBack = new JPanel();
            panBack.setEnabled(true);
            panBack.setVisible(true);
            GridLayout panBackgridLayout = new GridLayout(2,1);
            panBack.setLayout(panBackgridLayout);

        panUp = new JPanel();
            panUp.setVisible(true);
            panUp.setEnabled(true);
            panUp.setLayout(new GridLayout(1,2));

        panDown = new JPanel();
            panDown.setEnabled(true);
            panDown.setVisible(true);
            panDown.setLayout(new GridLayout(2,2));

        panColor = new JPanel();
            panColor.setEnabled(true);
            panColor.setVisible(true);
            panColor.setLayout(new GridLayout(1,1));

        panGraph = new JPanel();
            panGraph.setEnabled(true);
            panGraph.setVisible(true);
            panGraph.setLayout(new GridLayout(1,3));

        panConn = new JPanel();
            panConn.setEnabled(true);
            panConn.setVisible(true);
            panConn.setLayout(new GridLayout(1,2));

        panDbData = new JPanel();
            panDbData.setEnabled(true);
            panDbData.setVisible(true);
            panDbData.setLayout(new GridLayout(10,3));

        panArduino = new JPanel();
            panArduino.setEnabled(true);
            panArduino.setVisible(true);
            panArduino.setLayout(new GridBagLayout());

        panDb = new JPanel();
            panDb.setEnabled(true);
            panDb.setVisible(true);
            panDb.setLayout(new FlowLayout());

        lblColor = new JLabel("COLOR");
        lblColor.setEnabled(true);
        lblColor.setVisible(true);
        lblColor.setForeground(new Color(0,0,0));
        lblColor.setSize(panColor.getSize());
        lblColor.setFont(new Font(null,Font.PLAIN,70));
        lblColor.setBackground(new Color(255,0,200));

        lblArdn = new JLabel("\tArduino Connection");
        lblArdn.setEnabled(true);
        lblArdn.setVisible(true);
        lblArdn.setFont(new Font(null,Font.BOLD,25));
        lblArdn.setBackground(Color.blue);
            GridBagConstraints ardn = new GridBagConstraints();
                ardn.gridx = 0;
                ardn.gridy = 0;
                ardn.gridheight =2;
                ardn.gridwidth = GridBagConstraints.REMAINDER;
                ardn.weightx = 1;
                ardn.weighty = 1.0;
                ardn.fill = GridBagConstraints.BOTH;
                ardn.ipadx= 2;
                ardn.ipady =2;


        lblImg = new JLabel("\tCreate Connection");
        lblImg.setIcon(imgConn);
        lblImg.setVisible(true);
        lblImg.setEnabled(true);
        lblImg.setFont(new Font(null,Font.PLAIN,20));
            GridBagConstraints Limg =new GridBagConstraints();
                Limg.gridx = 2;
                Limg.gridy = 2;
                Limg.gridheight =2;
                Limg.gridwidth = GridBagConstraints.REMAINDER;
                Limg.weightx = 1;
                Limg.weighty = 1.0;
                Limg.fill = GridBagConstraints.BOTH;
                Limg.ipadx= 2;
                Limg.ipady =2;

        lblComPort = new JLabel("COM Port:");
        lblComPort.setEnabled(true);
        lblComPort.setVisible(true);
        lblComPort.setFont(new Font(null,Font.PLAIN,20));
            GridBagConstraints comPort = new GridBagConstraints();
                comPort.gridx =  GridBagConstraints.RELATIVE;
                comPort.gridy =  GridBagConstraints.RELATIVE;
                comPort.gridheight =2;
                comPort.gridwidth = 100;
                comPort.weightx = 1;
                comPort.weighty = 1.0;
                comPort.fill =GridBagConstraints.BOTH;

        btnConArd = new JButton("Connect");
        btnConArd.setSize(75,10);
        btnConArd.setEnabled(true);
        btnConArd.setVisible(true);
        btnConArd.setFont(new Font(null,Font.PLAIN,20));
            GridBagConstraints conArd = new GridBagConstraints();
                conArd.gridx =  GridBagConstraints.RELATIVE;
                conArd.gridy =  GridBagConstraints.RELATIVE;
                conArd.gridheight =2;
                conArd.gridwidth = 75;
                conArd.weightx = 1;
                conArd.weighty = 1.0;
                conArd.fill= GridBagConstraints.HORIZONTAL;


        cmbComPort = new JComboBox();
        cmbComPort.setEnabled(true);
        cmbComPort.setVisible(true);
        cmbComPort.setSize(75,10);
        cmbComPort.setFont(new Font(null,Font.PLAIN,20));
            GridBagConstraints coPort = new GridBagConstraints();
                coPort.gridx = GridBagConstraints.RELATIVE;
                coPort.gridy = GridBagConstraints.RELATIVE;
                coPort.gridheight =2;
                coPort.gridwidth = 200;
                coPort.weightx = 1;
                coPort.weighty = 1.0;
                coPort.fill = GridBagConstraints.HORIZONTAL;
                coPort.ipadx= 40;
                coPort.ipady =GridBagConstraints.NONE;
        lblEE2p01= new JLabel("EE 2.01");
        lblEE2p01.setEnabled(true);
        lblEE2p01.setIcon(imgCoppy);
        lblEE2p01.setFont(new Font(null,Font.ROMAN_BASELINE,20));

        lblMute = new JLabel();
        lblMute.setIcon(imgUnmute);
        lblMute.setText("Sound on");
        lblMute.setFont(new Font(null,Font.PLAIN,20));
        lblMute.setEnabled(true);
        lblMute.setVisible(true);

        btnMute = new JButton("Mute");
        btnMute.setEnabled(true);
        btnMute.setVisible(true);
        btnMute.setFont((new Font(null,Font.PLAIN,20)));

        /**________________*/

        lblRed = new JLabel("Red ");
        lblRed.setEnabled(true);
        lblRed.setVisible(true);
        lblRed.setFont((new Font(null,Font.PLAIN,20)));

        lblGreen = new JLabel("Green");
        lblGreen.setEnabled(true);
        lblGreen.setVisible(true);
        lblGreen.setFont((new Font(null,Font.PLAIN,20)));

        lblBlue = new JLabel("Blue");
        lblBlue.setEnabled(true);
        lblBlue.setVisible(true);
        lblBlue.setFont((new Font(null,Font.PLAIN,20)));

        lblHex = new JLabel("Hex");
        lblHex.setEnabled(true);
        lblHex.setVisible(true);
        lblHex.setFont((new Font(null,Font.PLAIN,20)));

        lblIntHex = new JLabel("Int of HEX ");
        lblIntHex.setEnabled(true);
        lblIntHex.setVisible(true);
        lblIntHex.setFont((new Font(null,Font.PLAIN,20)));

        lblColorName = new JLabel("Name of Color ");
        lblColorName.setEnabled(true);
        lblColorName.setVisible(true);
        lblColorName.setFont((new Font(null,Font.PLAIN,20)));

        lblDescription = new JLabel("Description ");
        lblDescription.setEnabled(true);
        lblDescription.setVisible(true);
        lblDescription.setFont((new Font(null,Font.PLAIN,20)));

        lblSearch = new JLabel("");
        lblSearch.setEnabled(true);
        lblSearch.setVisible(true);
        lblSearch.setFont((new Font(null,Font.PLAIN,20)));

        lblSearchIcon = new JLabel("Search ");
        lblSearchIcon.setEnabled(false);
        lblSearchIcon.setVisible(true);
        lblSearchIcon.setIcon(imgSearch);
        lblSearchIcon.setFont((new Font(null,Font.PLAIN,20)));

        /**Text Fields*/

        txtRed = new JTextField("%");
        txtRed.setEnabled(true);
        txtRed.setVisible(true);
        txtRed.setFont((new Font(null,Font.PLAIN,20)));

        txtGreen = new JTextField("%");
        txtGreen.setEnabled(true);
        txtGreen.setVisible(true);
        txtGreen.setFont((new Font(null,Font.PLAIN,20)));

        txtBlue = new JTextField("%");
        txtBlue.setEnabled(true);
        txtBlue.setVisible(true);
        txtBlue.setFont((new Font(null,Font.PLAIN,20)));

        txtHex = new JTextField("000000");
        txtHex.setEnabled(false);
        txtHex.setVisible(true);
        txtHex.setFont((new Font(null,Font.PLAIN,20)));

        txtIntHex = new JTextField("000000");
        txtIntHex.setEnabled(false);
        txtIntHex.setVisible(true);
        txtIntHex.setFont((new Font(null,Font.PLAIN,20)));


        txtColorName = new JTextField("Name");
        txtColorName.setEnabled(true);
        txtColorName.setVisible(true);
        txtColorName.setFont((new Font(null,Font.PLAIN,20)));

        txtDescription = new JTextField("Description");
        txtDescription.setEnabled(true);
        txtDescription.setVisible(true);
        txtDescription.setFont((new Font(null,Font.PLAIN,20)));

        btnSave = new JButton("Save");
        btnSave.setEnabled(false);
        btnSave.setVisible(true);
        btnSave.setIcon(imgPin);
        btnSave.setFont((new Font(null,Font.PLAIN,20)));
        btnSave.setSize(100,imgPin.getIconHeight());

        btnExit = new JButton("Exit");
        btnExit.setEnabled(true);
        btnExit.setVisible(true);
        btnExit.setFont((new Font(null,Font.PLAIN,20)));
        btnExit.setIcon(imgExit);

        btnSearch =new JButton("Search");
        btnSearch.setEnabled(false);
        btnSearch.setVisible(true);
        btnSearch.setFont((new Font(null,Font.PLAIN,20)));


        /**_______ADD_ITEMS_________
         * *______COMPONENT TREE___________*/
        add(panBack);
            panBack.add(panUp);
                panUp.add(panColor);
                    panColor.add(lblColor);
                panUp.add(panColor);

            panBack.add(panDown);
                panBack.add(panConn);
                    panConn.add(panArduino);
                        panArduino.add(lblArdn,ardn);
                        panArduino.add(lblImg,Limg);
                        panArduino.add(lblComPort,comPort);
                        panArduino.add(cmbComPort,coPort);
                        panArduino.add(btnConArd,conArd);
                    panConn.add(panDb);
                        panDb.add(lblMute);
                        panDb.add(btnMute);
                panBack.add(panDbData);
                        panDbData.add(lblRed);
                        panDbData.add(txtRed);
                        panDbData.add(lblGreen);
                        panDbData.add(txtGreen);
                        panDbData.add(lblBlue);
                        panDbData.add(txtBlue);
                        panDbData.add(lblHex);
                        panDbData.add(txtHex);
                        panDbData.add(lblIntHex);
                        panDbData.add(txtIntHex);
                        panDbData.add(lblColorName);
                        panDbData.add(txtColorName);
                        panDbData.add(lblDescription);
                        panDbData.add(txtDescription);
                        panDbData.add(lblSearchIcon);
                        panDbData.add(btnSearch);
                        panDbData.add(btnSave);
                        panDbData.add(btnExit);
                        panDbData.add(lblEE2p01);

        //JOptionPane.showMessageDialog(null,"Interface Created ","Done",JOptionPane.INFORMATION_MESSAGE);
        /**_get_COM_ports_*/
        try {
            SerialPort[] portNames = SerialPort.getCommPorts();
            for (int i = 0; i < portNames.length; i++)
                cmbComPort.addItem(portNames[i].getSystemPortName());
        }catch (Exception e2){
            JOptionPane.showMessageDialog(null,e2.getMessage(),"Error",JOptionPane.WARNING_MESSAGE);
        }
        /**
         * VARIABLES
         */

        /**_Action_Listeners__*/
        btnMute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(btnMute.getText()=="Mute"){
                    btnMute.setText("Unmute");
                    lblMute.setIcon(imgMute);
                    lblMute.setText("Sound off");
                }else {
                    btnMute.setText("Mute");
                    lblMute.setIcon(imgUnmute);
                    lblMute.setText("Sound on");
                }
            }
        });
        Arduino arduinoClass=new Arduino();
        DataBase dataBase=new DataBase();
        AudioPlayer audioPlayer = new AudioPlayer();
        //boolean dBconn=false;
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (btnConArd.getText().equals("Disconnect")) {
                        //JOptionPane.showMessageDialog(null,"Please disconnect Arduino from "+choosenPort.getSystemPortName()+".","Error on EXIT",JOptionPane.ERROR_MESSAGE);
                        JOptionPane.showMessageDialog(null, "Please Disconnect Arduino from " + cmbComPort.getSelectedItem() + ".", "Error on exit", JOptionPane.ERROR_MESSAGE);
                    } else {
                        System.exit(0);
                    }
                }catch (Exception e7){

                }
            }
        });
        btnConArd.addActionListener(new ActionListener() {
            public boolean dBconn;
            public String[] colorName =new String[4];
            public int R=0,G=0,B =0;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dBconn==false){
                    DataBase.connectDB();
                    this.dBconn=true;
                }
                if(btnConArd.getText().equals("Connect")){
                    try {
                        //Code For connect Arduino..
                        /**
                         * Start new cord with arduino class
                         * */
                        boolean connState=arduinoClass.conn(cmbComPort.getSelectedItem().toString());
                        try {
                            if (connState = true) {
                                lblImg.setIcon(imgDone);
                                lblImg.setText("Arduino Succesfully Connected");
                                btnConArd.setText("Disconnect");
                                cmbComPort.setEnabled(false);
                                AudioPlayer.say("SensorCircuitConnected");
                            }
                        }catch (Exception e2){
                            JOptionPane.showMessageDialog(null,e2.getMessage(),"Error in Arduino Connection",JOptionPane.INFORMATION_MESSAGE);
                        }
                       /**
                        * end
                        * */


                        Thread thread =new Thread(){
                            @Override public void run() {
                                //Scanner scanner = new Scanner(choosenPort.getInputStream());
                                    //while (scanner.hasNextLine()) {
                                     //   String line = scanner.nextLine();
                                        /**
                                         * CODE FOR GET INPUTS
                                         * */
                                    //String line  = arduinoClass.recieve();
                                    String line[];
                                    line = Arduino.recieve();
                                    System.out.println(line[0]);
                                    String proccese = null;
                                    //System.out.println(R+"\t"+G+"\t"+B);
                                    while (true) {
                                        try{
                                        //System.out.println("Raw data " + line);
                                        //System.out.println("A");
                                        line = Arduino.recieve();
                                        //System.out.println("B");
                                             proccese = line[0];
                                          //  System.out.println(proccese);
                                             R = parseInt( line[1]);
                                           // System.out.println(R);
                                             G = parseInt(line[2]);
                                            //System.out.println(G);
                                             B = parseInt(line[3]);
                                            //System.out.println(B);
                                            //System.out.println("C");
                                            //System.out.println("Raw Data " + line[0] + "\t" + line[1] + "\t" + line[2] + "\t" + line[3] + "\nInt: " + Integer.valueOf(proccese));
                                            //System.out.println("D");
                                        }catch (Exception e5){
                                            System.out.println(e5.getMessage()+"\tCause:"+e5.getCause());
                                        }
                                        //proccese = arduinoClass.recieve()[0];
                                         //R = arduinoClass.recieve()[1];
                                         //G = arduinoClass.recieve()[2];
                                         //B = arduinoClass.recieve()[3];
                                        /**
                                         * * Create ranges of input stream and according to first char
                                         * change the option.
                                         */
                                        //System.out.println("E");
                                        try{
                                            //to Get RGB Readings.
                                        if (Float.valueOf(line[0])<30 && Float.valueOf(line[0])>10) {
                                            lblColor.setText(String.valueOf(R));
                                            txtRed.setText(String.valueOf(G));
                                            //System.out.println(line);
                                            lblColor.setText(line[0]+"%");
                                            txtRed.setText(line[1]+"%");
                                            txtGreen.setText(line[2]+"%");
                                            txtBlue.setText(line[3]+"%");
                                            //System.out.println(R+"\t"+G+"\t"+B);

                                            colorName= DataBase.getName(line[1],line[2],line[3]);
                                            txtColorName.setText(colorName[0]);
                                            txtIntHex.setText(colorName[1]);
                                            txtHex.setText(colorName[2]);
                                            txtDescription.setText(colorName[3]);
                                            lblColor.setText(colorName[0]);
                                            lblColor.setBackground(new Color(R,G,B));
                                            String mute=btnMute.getText();

                                            if (mute=="Mute") {
                                                AudioPlayer.say(colorName[0]);
                                                Thread.sleep(1000);

                                                AudioPlayer.say("R");
                                                Thread.sleep(500);
                                                AudioPlayer.say(line[1]);
                                                Thread.sleep(500);
                                                AudioPlayer.say("Percent");
                                                Thread.sleep(1000);

                                                AudioPlayer.say("G");
                                                Thread.sleep(1000);
                                                AudioPlayer.say(line[2]);
                                                Thread.sleep(1000);
                                                AudioPlayer.say("Percent");
                                                Thread.sleep(500);

                                                AudioPlayer.say("B");
                                                Thread.sleep(1000);
                                                AudioPlayer.say(line[3]);
                                                Thread.sleep(1000);
                                                AudioPlayer.say("Percent");


                                            }
                                        }else if (Float.valueOf(line[0])<40 && Float.valueOf(line[0])>30){
                                            //to unmute
                                            if (btnMute.getText().equals("Mute")){
                                                //Say Mute:
                                                AudioPlayer.say("soundDeactivated");
                                                //set Mute:
                                                btnMute.setText("Unmute");
                                                lblMute.setIcon(imgMute);
                                                lblMute.setText("Sound off");
                                            }else {
                                                //Say Unmute:
                                                AudioPlayer.say("SoundActivated");
                                                btnMute.setText("Mute");
                                                lblMute.setIcon(imgUnmute);
                                                lblMute.setText("Sound on");
                                            }
                                        }
                                        }catch(Exception e6){
                                        }
                                    }
                                // }
                                //scanner.close();
                            }
                        };
                        thread.start();


                    }catch (Exception e1){
                        JOptionPane.showMessageDialog(null,e1.getMessage()+"\nArduino not Connected","Arduino not Connected",JOptionPane.WARNING_MESSAGE);
                        lblImg.setIcon(imgWarning);
                        lblImg.setText("Arduino not Connected");
                        btnConArd.setText("Reconnect");
                        btnConArd.setIcon(imgReconn);
                        AudioPlayer.say("SensorCircuitDisConnected");
                    }
                }else {


                    //choosenPort.closePort();
                    Arduino.closeArduino();

                    btnConArd.setText("Connect");
                    lblImg.setIcon(imgConn);
                    lblImg.setText("Create Connection");
                    cmbComPort.setEnabled(true);
                    AudioPlayer.say("SensorCircuitDisConnected");
                }
                //System.out.println(lblImg.getText());
            }
        });
    }

}