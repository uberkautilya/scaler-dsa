package low_level_design_two.design_pattterns.behavioral.strategy.assignments.streaming;

public interface QualityAdjustmentStrategy {
    VideoQuality supportsType();
    Video adjust(Video video);
}