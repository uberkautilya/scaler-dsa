package low_level_design_two.design_pattterns.creational.factory.assignments.two;

public class AudioPlayerFactory {
    public static AudioPlayer createAudioPlayer(MediaFormat format, int volume, double playbackRate) {
        if(format == MediaFormat.MP3){
            return new MP3Player(volume, playbackRate);
        } else if(format == MediaFormat.WAV){
            return new WAVPlayer(volume, playbackRate);
        } else {
            return new FLACPlayer(volume, playbackRate);
        }
    }
}