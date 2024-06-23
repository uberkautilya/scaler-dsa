package low_level_design_two.design_pattterns.creational.factory.assignments.five;

import low_level_design_two.design_pattterns.creational.factory.assignments.five.decoder.AudioDecoder;
import low_level_design_two.design_pattterns.creational.factory.assignments.five.player.AudioPlayer;
import low_level_design_two.design_pattterns.creational.factory.assignments.five.processor.AudioProcessor;

public abstract class AudioFactory {
    public abstract MediaFormat supportsFormat();
    public abstract AudioDecoder createDecoder(byte[] audioData);
    public abstract AudioPlayer createPlayer(int volume, double playbackRate);
    public abstract AudioProcessor createProcessor(byte[] audioData);
}