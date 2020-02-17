import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static java.lang.Integer.parseInt;
import static java.lang.Math.sqrt;

/**
 * Created by acer on 19-Oct-17.
 */
public class DataBase {
    static String[] name=new String[4];
    static Connection connection = null;
    static PreparedStatement ps;
    static ResultSet rsG,rs;
    public static boolean connectDB(){
          try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/rgb_names", "root", "");
            //JOptionPane.showMessageDialog(null, "Connection succesed to Database", "Connection status", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Connection Succeed(DB)");
            return true;
        } catch (Exception e) {
            System.out.println("Error in connection \n" + e);
            return false;
        }
    }
    public static String[] getName(String sRed,String sGreen,String sBlue){
        int rPass = 0,       gPass=0,           bPass=0;
        //System.out.println(Float.valueOf(sRed));
        int red = (int) (Float.valueOf(sRed)*255/100);
        int green = (int) ((Float.valueOf(sGreen))*255/100);
        int blue = (int) ((Float.valueOf(sBlue))*255/100);
        int r_var = 0,       g_var = 0,         b_var = 0;
        int rgbARRrray[][]=new int[100][3] ;
        String RGBname[][]=new String[100][4];
        int numOfRows=0;
        int Red=0,      Green=0,      Blue = 0;
        int redup=0,    gup,        bup;
        int iRed = 0,   iGreen = 0, iBlue=0;
        int reddown=0,  gdown,      bdown;
/**Get nearest RED value.*/
        r_var = -1;
        do {
            r_var++;
            redup = red+r_var;
            reddown = red-r_var;
            try {
                ps = connection.prepareStatement("");
                if (r_var==0){
                    rs = ps.executeQuery("select Name , Red ,Green ,Blue,intOfHex,HexVal,Description from rgb_table where Red = " + red);
                }else {
                    rs = ps.executeQuery("select Name , Red ,Green ,Blue,intOfHex,HexVal,Description from rgb_table where Red between " + reddown + " and " + redup);
                }
                while (rs.next()) {
                    //Red = Integer.valueOf(rs.getString("Red")) * 100 / 256;
                    //System.out.println("Nearest red value is :"+Red+"% color Name ["+rs.getString("Name")+"]");
                    try {
                        RGBname[numOfRows][0] = rs.getString(1);
                        rgbARRrray[numOfRows][0] = rs.getInt(2);
                        rgbARRrray[numOfRows][1] = rs.getInt(3);
                        rgbARRrray[numOfRows][2] = rs.getInt(4);
                        RGBname[numOfRows][1] = rs.getString(5);
                        RGBname[numOfRows][2]= rs.getString(6);
                        RGBname[numOfRows][3] = rs.getString(7);
                        numOfRows++;
                    }catch (Exception e1){
                        System.out.println(e1.getMessage());
                    }
                //    System.out.println(rgbARRrray[numOfRows-1][0] +"\t"+rgbARRrray[numOfRows-1][1] +"\t"+rgbARRrray[numOfRows-1][2] );
                    iRed++;/**Number of results.*/
                }
                //System.out.println("Red values :"+iRed);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error in Red", JOptionPane.ERROR_MESSAGE);
            }
        }while (iRed==0);
       /**Get nearest GREEN value.*/
        g_var = -1;
        do {
            g_var++;
            gup = green+g_var;
            gdown = green-g_var;
            try {
                ps = connection.prepareStatement("");
                if (g_var==0){
                    rsG = ps.executeQuery("select Name , Red ,Green ,Blue,intOfHex,HexVal,Description from rgb_table where Green = " + green);
                }else {
                    rsG = ps.executeQuery("select Name , Red ,Green ,Blue,intOfHex,HexVal,Description from rgb_table where Green between " + gdown + " and " + gup);
                }
                while (rsG.next()) {
                    //Green = Integer.valueOf(rs.getString("Green")) * 100 / 256;
                    //System.out.println("Nearest Green value is :"+Green+"% color Name ["+rs.getString("Name")+"]");
                    try {
                        RGBname[numOfRows][0] = rsG.getString(1);
                        rgbARRrray[numOfRows][0] = rsG.getInt(2);
                        rgbARRrray[numOfRows][1] = rsG.getInt(3);
                        rgbARRrray[numOfRows][2] = rsG.getInt(4);
                        RGBname[numOfRows][1] = rsG.getString(5);
                        RGBname[numOfRows][2]= rsG.getString(6);
                        RGBname[numOfRows][3] = rsG.getString(7);
                        numOfRows++;
                        //System.out.println(rsG.getInt(2)+"\t"+rsG.getInt(3)+"\t"+rsG.getInt(4));
                    }catch (Exception e1){
                        System.out.println(e1.getMessage());
                    }
                    iGreen++;/**Number of results.*/
                }
                //System.out.println("Green Values :"+iGreen);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error G", JOptionPane.ERROR_MESSAGE);
            }
        }while (iGreen==0);
        /**
        System.out.println("Green variance is "+g_var+" and "+iGreen+" Result(s) found.");
        System.out.println("Green up "+gup+" Green down "+gdown);
        System.out.println("\n");
         */
/**Get nearest BLUE value.*/
        b_var = -1;
        do {
            b_var++;
            bup = blue+b_var;
            bdown = blue-b_var;
            try {
                ps = connection.prepareStatement("");
                if (b_var==0){
                    rs = ps.executeQuery("select Name , Red ,Green ,Blue,intOfHex,HexVal,Description from rgb_table where Blue = " + blue);
                }else {
                    rs = ps.executeQuery("select Name , Red ,Green ,Blue,intOfHex,HexVal,Description from rgb_table where Blue between " + bdown + " and " + bup);
                }
                while (rs.next()) {
                    //Blue = Integer.valueOf(rs.getString("Blue")) * 100 / 256;
                    //System.out.println("Nearest Blue value is :"+Blue+"% color Name ["+rs.getString("Name")+"]");
                    try {
                        RGBname[numOfRows][0]=rs.getString(1);
                        rgbARRrray[numOfRows][0] = rs.getInt(2);
                        rgbARRrray[numOfRows][1] = rs.getInt(3);
                        rgbARRrray[numOfRows][2] = rs.getInt(4);
                        RGBname[numOfRows][1] = rs.getString(5);
                        RGBname[numOfRows][2]= rs.getString(6);
                        RGBname[numOfRows][3] = rs.getString(7);
                        numOfRows++;
                    }catch (Exception e1){
                        System.out.println(e1.getMessage());
                    }
                    //System.out.println(rs.getInt(2) + "\t"+rs.getInt(3) + "\t"+rs.getInt(4));
                    iBlue++;/**Number of results.*/
                }
                //System.out.println("Blue values : "+iBlue);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error B", JOptionPane.ERROR_MESSAGE);
            }
        }while (iBlue==0);

        //System.out.println(numOfRows);
        double distances[] = new double[numOfRows+1];
        double minError=255;int minOPossition=0;
        //System.out.println("Error values");
        for (int i=0;i<=numOfRows;i++){
            distances[i] = sqrt( (red-rgbARRrray[i][0])*(red-rgbARRrray[i][0]) + (green - rgbARRrray[i][1])*(green - rgbARRrray[i][1]) + (blue - rgbARRrray[i][2])*(green - rgbARRrray[i][1]));
            if (distances[i]<=minError){
                minError = distances[i];
                minOPossition=i;
            }
            //System.out.println("["+i+"] . Error "+ distances[i] +"\t Current min error :" + minError);
        }

        name = RGBname[minOPossition];
        return name;
    }
}