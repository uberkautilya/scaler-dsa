package low_level_design_two.design_pattterns.creational.singleton.assignments.three;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Map;
import java.util.HashMap;


public class ConnectionPoolImpl implements ConnectionPool {
    private static final Lock lock = new ReentrantLock();
    private static ConnectionPool connectionPool;

    private final int maxConnections;
    private final Map<DatabaseConnection, Boolean> connectionMap;

    private ConnectionPoolImpl(int maxConnections){
        this.maxConnections = maxConnections;
        this.connectionMap = new HashMap<>();
    };

    public static ConnectionPool getInstance(int maxConnections) {

        if(connectionPool == null){

            lock.lock();
            if(connectionPool == null){
                connectionPool = new ConnectionPoolImpl(maxConnections);
                connectionPool.initializePool();
            }
            lock.unlock();
        }
        return connectionPool;
    }

    public static void resetInstance() {
        connectionPool = null;
    }

    @Override
    public void initializePool() {
        if(!connectionMap.isEmpty()) return;
        for(int i = 1; i<= maxConnections; i++){
            this.connectionMap.put(new DatabaseConnection(), false);
        }
    }

    @Override
    public DatabaseConnection getConnection() {
        DatabaseConnection dC = this.connectionMap.entrySet().stream()
                .filter(e -> e.getValue() == false)
                .map(Map.Entry::getKey)
                .findAny().orElse(null);
        this.connectionMap.put(dC, true);
        return dC;
    }

    @Override
    public void releaseConnection(DatabaseConnection connection) {
        this.connectionMap.put(connection, false);
    }

    @Override
    public int getAvailableConnectionsCount() {
        return (int) this.connectionMap.entrySet().stream().filter(e -> e.getValue() == false).count();
    }

    @Override
    public int getTotalConnectionsCount() {
        return this.connectionMap.entrySet().size();
    }
}