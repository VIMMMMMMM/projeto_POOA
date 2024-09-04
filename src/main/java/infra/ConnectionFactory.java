package infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private ConnectionFactory(){}
    public static Connection getConnection(){
        try {

            return DriverManager.getConnection("jdbc:hsqldb:mem:POOA","sa","");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}
