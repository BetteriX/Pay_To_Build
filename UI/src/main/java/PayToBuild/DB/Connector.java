package PayToBuild.DB;

import PayToBuild.Data.*;
import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;
import java.util.List;

public class Connector {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();

        String host = dotenv.get("DB_HOST");
        String port = dotenv.get("DB_PORT");
        String db = dotenv.get("DB_NAME");
        String user = dotenv.get("DB_USER");
        String password = dotenv.get("DB_PASSWORD");

        String server = "jdbc:mysql://" + host + ":" + port + "/" + db + "?useSSL=true";

        try (Connection conn = DriverManager.getConnection(server, user, password)) {
            System.out.println("Connected to MySQL successfully!");

            String tableName = "cpu";
            Statement statement = conn.createStatement();
            String query = "SELECT * FROM ptb." + tableName;
            ResultSet rs = statement.executeQuery(query);

            // Call your GetData method
            List<CPU> cpuList = GetData.Get_Processor_Data(rs);

            // Print CPUs
            System.out.println(cpuList);

            rs.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

