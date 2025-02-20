package View;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Audio {
    private Clip clip;

    public Audio(String caminho) {
        try {
            File arquivo = new File(caminho);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(arquivo);

            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.addLineListener(event -> {

            });
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void tocar() {
        if (clip != null) {
            if (clip.isRunning()){
                clip.stop();
            } // coloquei essa condição para poder para o audio se ele estiver rodando ainda
            clip.setFramePosition(0); // Reinicia o áudio do início
            clip.start();
        }
    }
}
