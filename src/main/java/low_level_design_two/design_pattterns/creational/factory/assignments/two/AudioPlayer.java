package low_level_design_two.design_pattterns.creational.factory.assignments.two;

public abstract class AudioPlayer {
    protected int volume;
    protected double playBackRate;
    
    abstract public void play();
    abstract public void pause();
    abstract public void stop();
    abstract public void setVolume(int volume);
    abstract public int getVolume();
    abstract public double getPlayBackRate();
    abstract public MediaFormat supportsType();
}