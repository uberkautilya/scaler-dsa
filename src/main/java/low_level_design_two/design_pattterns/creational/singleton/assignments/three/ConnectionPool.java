package low_level_design_two.design_pattterns.creational.singleton.assignments.three;


public interface ConnectionPool {

    void initializePool();

    DatabaseConnection getConnection();

    void releaseConnection(DatabaseConnection connection);

    int getAvailableConnectionsCount();

    int getTotalConnectionsCount();

}