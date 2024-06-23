package low_level_design_two.design_pattterns.creational.factory.assignments.five;

import low_level_design_two.design_pattterns.creational.factory.assignments.five.decoder.AudioDecoder;
import low_level_design_two.design_pattterns.creational.factory.assignments.five.decoder.MP3Decoder;
import low_level_design_two.design_pattterns.creational.factory.assignments.five.player.AudioPlayer;
import low_level_design_two.design_pattterns.creational.factory.assignments.five.player.MP3Player;
import low_level_design_two.design_pattterns.creational.factory.assignments.five.processor.AudioProcessor;
import low_level_design_two.design_pattterns.creational.factory.assignments.five.processor.MP3AudioProcessor;

public class MP3AudioFactory extends AudioFactory {
    public MediaFormat supportsFormat(){
        return MediaFormat.MP3;
    }
    public AudioDecoder createDecoder(byte[] audioData){
        return new MP3Decoder(audioData);
    }
    public AudioPlayer createPlayer(int volume, double playbackRate){
        return new MP3Player(volume, playbackRate);
    }
    public AudioProcessor createProcessor(byte[] audioData){
        return new MP3AudioProcessor(audioData);
    }
}