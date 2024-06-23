package low_level_design_two.design_pattterns.creational.factory.assignments.five;

import low_level_design_two.design_pattterns.creational.factory.assignments.five.decoder.AudioDecoder;
import low_level_design_two.design_pattterns.creational.factory.assignments.five.decoder.FLACDecoder;
import low_level_design_two.design_pattterns.creational.factory.assignments.five.player.AudioPlayer;
import low_level_design_two.design_pattterns.creational.factory.assignments.five.player.FLACPlayer;
import low_level_design_two.design_pattterns.creational.factory.assignments.five.processor.AudioProcessor;
import low_level_design_two.design_pattterns.creational.factory.assignments.five.processor.FLACAudioProcessor;

public class FLACAudioFactory extends AudioFactory {
    public MediaFormat supportsFormat(){
        return MediaFormat.FLAC;
    }
    public AudioDecoder createDecoder(byte[] audioData){
        return new FLACDecoder(audioData);
    }
    public AudioPlayer createPlayer(int volume, double playbackRate){
        return new FLACPlayer(volume, playbackRate);
    }
    public AudioProcessor createProcessor(byte[] audioData){
        return new FLACAudioProcessor(audioData);
    }
}