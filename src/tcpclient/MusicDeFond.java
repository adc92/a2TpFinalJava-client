package tcpclient;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class MusicDeFond {

    public static void playSound(double freq, long duree, SourceDataLine line) {

        AudioFormat fmt = line.getFormat();
        float sampleRate = fmt.getSampleRate();
        int bufsize = line.getBufferSize();
        int sampleSize = fmt.getSampleSizeInBits();
        int nbOctets = 0;  // nombre d'octets par échantillon
        int maxVal = 0;    // valeur maximal d'un échantillon
        if (sampleSize == 8) {
            nbOctets = 1;
            maxVal = 0x7F;
        } else if (sampleSize == 16) {
            nbOctets = 2;
            maxVal = 0x7FFF;
        } else {
            throw new Error(""+sampleSize);
        }
        boolean bigEndian = fmt.isBigEndian();
        int nbEchantillons = (int) Math.ceil((double) duree / 1000 * sampleRate);
        byte audiosamples[] = new byte[bufsize];
        int i = 0;
        while (i < nbEchantillons) {
            int j = 0;
            while ((j < bufsize) && (i < nbEchantillons)) {
                int val = (int) (maxVal * sample(i++, freq, sampleRate));
                if (nbOctets == 1) {
                    audiosamples[j++] = (byte) val;
                } else if (bigEndian) {
                    audiosamples[j++] = (byte) ((val & 0xFF00) >> 8);
                    audiosamples[j++] = (byte) (val & 0x00FF);
                } else {
                    audiosamples[j++] = (byte) (val & 0x00FF);
                    audiosamples[j++] = (byte) ((val & 0xFF00) >> 8);
                }
            }
            line.write(audiosamples, 0, j);
        }
    }

    public static double sample(int i, double freq, double rate) {
        double t = Math.IEEEremainder(i / rate, 1 / freq);
        if (t < 0) {
            t += 1 / freq;
        }
        return Math.sin(2 * Math.PI * freq * t);
    }

    public static void confirmationButton() {
        final float sampleRate = 4500;
        final int sampleSize = 8;
        final boolean bigEndian = true;
        final boolean signed = true;
        AudioFormat audiofmt = new AudioFormat(sampleRate, 
                sampleSize, 1, signed, bigEndian);
        SourceDataLine line = null;
        try {
            line = AudioSystem.getSourceDataLine(audiofmt);
            line.open(audiofmt);
        } catch (LineUnavailableException lue) {
            System.out.println("");
            System.out.println(""+audiofmt);
            System.exit(1);
        }

        line.start();
        playSound(250.0, 100, line);
        playSound(500.0, 100, line);
        playSound(800.0, 100, line);

        line.drain();
    }
}