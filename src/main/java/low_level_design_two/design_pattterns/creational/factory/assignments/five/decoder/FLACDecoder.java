package low_level_design_two.design_pattterns.creational.factory.assignments.five.decoder;

import low_level_design_two.design_pattterns.creational.factory.assignments.five.MediaFormat;

public class FLACDecoder extends AudioDecoder {

    public FLACDecoder(byte[] audioData) {
        super(audioData);
    }

    @Override
    public MediaFormat supportsFormat() {
        return MediaFormat.FLAC;
    }

    @Override
    public byte[] decode() {
        // Implement FLAC decoding logic
        System.out.println("Decoding FLAC audio data...");
        // Decoding process
        return getAudioData();
    }
}