package low_level_design_two.design_pattterns.behavioral.strategy.assignments.streaming;

public class LowQualityStrategy implements QualityAdjustmentStrategy {

    public VideoQuality supportsType(){
        return VideoQuality.LOW;
    }

    public Video adjust(Video video){
        video.setCodec(VideoCodec.H264);
        video.setBitrate(500);
        return video;
    }
}