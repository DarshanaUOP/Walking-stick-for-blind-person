import sun.audio.AudioStream;

import java.io.File;
import java.io.FileInputStream;

import static java.lang.System.in;
import static java.lang.System.setErr;

/**
 * Created by acer on 20-Oct-17.
 */
public class AudioPlayer {

    public static void say(String word){

        FileInputStream in;

        try {
                in = new FileInputStream(new File("Audio/" + word + ".wav"));
                AudioStream audio = new AudioStream(in);
                sun.audio.AudioPlayer.player.start(audio);

        } catch (Exception e1) {
            System.out.println(e1.getMessage()+"[Error in Method say]\n"+e1.getLocalizedMessage()+"\n"+e1.getCause());
        }

    }
    public static void say(String word1,String word2){

        FileInputStream in1,in2;
        try {
            in1 = new FileInputStream(new File("Audio/" + word1 + ".wav"));
            AudioStream audio1 = new AudioStream(in1);
            sun.audio.AudioPlayer.player.start(audio1);

        } catch (Exception e1) {
            System.out.println(e1.getMessage()+"[Error in Method say]\n"+e1.getLocalizedMessage()+"\n"+e1.getCause());
        }



        try {
            in2 = new FileInputStream(new File("Audio/" + word2 + ".wav"));
            AudioStream audio2 = new AudioStream(in2);
            sun.audio.AudioPlayer.player.start(audio2);

        } catch (Exception e1) {
            System.out.println(e1.getMessage()+"[Error in Method say]\n"+e1.getLocalizedMessage()+"\n"+e1.getCause());
        }
    }

}