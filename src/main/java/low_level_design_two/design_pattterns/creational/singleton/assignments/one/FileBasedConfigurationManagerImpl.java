package low_level_design_two.design_pattterns.creational.singleton.assignments.one;

import java.util.concurrent.locks.ReentrantLock;

public class FileBasedConfigurationManagerImpl extends FileBasedConfigurationManager {

    private static FileBasedConfigurationManager fileBasedConfigurationManager = null;
    private static final ReentrantLock lock = new ReentrantLock();
    private FileBasedConfigurationManagerImpl(){
        super();
    };

    @Override
    public String getConfiguration(String key) {
        Object value = properties.get(key);
        return (String) value;
    }

    @Override
    public <T> T getConfiguration(String key, Class<T> type) {
        Object val = properties.get(key);
        if(val == null) return null;
        return this.convert(String.valueOf(val), type);
    }

    @Override
    public void setConfiguration(String key, String value) {
        properties.put(key, value);
    }

    @Override
    public <T> void setConfiguration(String key, T value) {
        //Todo: What is the type checking we can perform here?
        properties.put(key, value);
    }

    @Override
    public void removeConfiguration(String key) {
        properties.remove(key);
    }

    @Override
    public void clear() {
        properties.clear();
    }

    public static FileBasedConfigurationManager getInstance() {
        if(fileBasedConfigurationManager == null){
            lock.lock();
            if(fileBasedConfigurationManager == null){
                fileBasedConfigurationManager = new FileBasedConfigurationManagerImpl();
            }
            lock.unlock();
        }
        return fileBasedConfigurationManager;
    }

    public static void resetInstance() {
        fileBasedConfigurationManager = null;
    }

}