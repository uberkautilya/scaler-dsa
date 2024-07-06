package low_level_design_two.design_pattterns.behavioral.strategy.assignments.streaming;

public class MediumQualityStrategy implements QualityAdjustmentStrategy {

    public VideoQuality supportsType(){
        return VideoQuality.MEDIUM;
    }

    public Video adjust(Video video){
        video.setCodec(VideoCodec.H265);
        video.setBitrate(1000);
        return video;
    }
}