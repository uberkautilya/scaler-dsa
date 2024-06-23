package low_level_design_two.design_pattterns.creational.factory.assignments.five.processor;

import low_level_design_two.design_pattterns.creational.factory.assignments.five.MediaFormat;

public abstract class AudioProcessor {

    private final byte[] audioData;

    public AudioProcessor(byte[] audioData) {
        this.audioData = audioData;
    }

    public byte[] getAudioData() {
        return audioData;
    }

    public abstract MediaFormat supportsFormat();

    public abstract byte[] process();
}