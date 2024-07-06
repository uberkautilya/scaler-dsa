package low_level_design_two.design_pattterns.behavioral.strategy.assignments.streaming;

public class VideoStreamingManager {
    private QualityAdjustmentStrategy strategy;

    public VideoStreamingManager(QualityAdjustmentStrategy strategy) {
        this.strategy = strategy;
    }

    public Video streamVideo(Video video) {
        return this.strategy.adjust(video);
    }
}
