package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static Connection connection = null;

    public static Connection getConexao(){
        if (connection == null) {
            String url = "jdbc:postgresql://localhost:5432/appmusica";
            String username = "postgres";
            String password = "postgres";
            try{
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(url,username,password);
            }
            catch (SQLException e){
                e.printStackTrace();
            }
            catch (ClassNotFoundException e1){
                e1.printStackTrace();
            }
        }
        return connection;
    }

}
