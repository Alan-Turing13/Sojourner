package sfx;

import javax.sound.sampled.*;
import java.io.IOException;

public class PlaySound extends Sound implements LineListener, Runnable {

    public PlaySound(String filename) {
        super(filename);
    }

    private boolean finished;

    @Override
    public void update(LineEvent ev){
        if (LineEvent.Type.STOP == ev.getType()) {
            finished = true;
        }
    }

    public void run() {
        try {
            DataLine.Info info = new DataLine.Info(Clip.class, super.auFor);
            Clip auClip = (Clip) AudioSystem.getLine(info);
            auClip.addLineListener(this);
            auClip.open(auStr);
            auClip.start();

            while (!finished) {
                Thread.sleep(1000);
            }

            auClip.close();
            auStr.close();

        } catch (LineUnavailableException| IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
