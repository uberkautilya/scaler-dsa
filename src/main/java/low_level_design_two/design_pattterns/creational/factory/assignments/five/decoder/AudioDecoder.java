package low_level_design_two.design_pattterns.creational.factory.assignments.five.decoder;

import low_level_design_two.design_pattterns.creational.factory.assignments.five.MediaFormat;

public abstract class AudioDecoder {

    private final byte[] audioData;

    public AudioDecoder(byte[] audioData) {
        this.audioData = audioData;
    }

    public byte[] getAudioData() {
        return audioData;
    }

    public abstract MediaFormat supportsFormat();

    public abstract byte[] decode();
}