package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KetNoiDB {
    public static Connection getConnectDB() throws SQLException{
        String urlSQL = "jdbc:sqlserver://localhost:1433;databaseName=PTPM_FINALLY_JAVA_MOB1024;"
                + "user=sa;password=1234;encrypt=true;"
                + "trustServerCertificate=true";
        return DriverManager.getConnection(urlSQL);
    }
}
