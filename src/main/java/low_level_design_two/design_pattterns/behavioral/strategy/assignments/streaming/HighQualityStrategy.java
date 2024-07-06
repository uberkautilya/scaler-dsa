package low_level_design_two.design_pattterns.behavioral.strategy.assignments.streaming;

public class HighQualityStrategy implements QualityAdjustmentStrategy {

    public VideoQuality supportsType(){
        return VideoQuality.HIGH;
    }

    public Video adjust(Video video){
        video.setCodec(VideoCodec.VP9);
        video.setBitrate(2000);
        return video;
    }
}