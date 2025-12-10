package PayToBuild.DB;

import PayToBuild.Data.*;
import io.github.cdimascio.dotenv.Dotenv;

import java.net.MalformedURLException;
import java.sql.*;
import java.util.List;

public class Connector {
    public static void main(String[] args) {
        //cpu_test();
        //case_test();
        //cooler_test();
        //memory_test();
        //motherboard_test();
        //psu_test();
        //storage_test();
        //videocard_test();
    }

    public static void cpu_test(){
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
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void case_test() {
        Dotenv dotenv = Dotenv.load();

        String host = dotenv.get("DB_HOST");
        String port = dotenv.get("DB_PORT");
        String db = dotenv.get("DB_NAME");
        String user = dotenv.get("DB_USER");
        String password = dotenv.get("DB_PASSWORD");

        String server = "jdbc:mysql://" + host + ":" + port + "/" + db + "?useSSL=true";

        try (Connection conn = DriverManager.getConnection(server, user, password)) {
            System.out.println("Connected to MySQL successfully!");

            String tableName = "case";
            Statement statement = conn.createStatement();
            String query = "SELECT * FROM ptb." + tableName;
            ResultSet rs = statement.executeQuery(query);

            List<Case> caseList = GetData.Get_Case_Data(rs);

            System.out.println(caseList);

            rs.close();
            statement.close();

        } catch (SQLException | MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void cooler_test() {
        Dotenv dotenv = Dotenv.load();

        String host = dotenv.get("DB_HOST");
        String port = dotenv.get("DB_PORT");
        String db = dotenv.get("DB_NAME");
        String user = dotenv.get("DB_USER");
        String password = dotenv.get("DB_PASSWORD");

        String server = "jdbc:mysql://" + host + ":" + port + "/" + db + "?useSSL=true";

        try (Connection conn = DriverManager.getConnection(server, user, password)) {
            System.out.println("Connected to MySQL successfully!");

            String tableName = "`cpu-cooler`";
            Statement statement = conn.createStatement();
            String query = "SELECT * FROM ptb." + tableName;
            ResultSet rs = statement.executeQuery(query);

            List<CPUCooler> coolerList = GetData.Get_CPUCooler_Data(rs);

            System.out.println(coolerList);

            rs.close();
            statement.close();

        } catch (SQLException | MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void storage_test() {
        Dotenv dotenv = Dotenv.load();

        String host = dotenv.get("DB_HOST");
        String port = dotenv.get("DB_PORT");
        String db = dotenv.get("DB_NAME");
        String user = dotenv.get("DB_USER");
        String password = dotenv.get("DB_PASSWORD");

        String server = "jdbc:mysql://" + host + ":" + port + "/" + db + "?useSSL=true";

        try (Connection conn = DriverManager.getConnection(server, user, password)) {
            System.out.println("Connected to MySQL successfully!");

            String tableName = "`internal-hard-drive`";
            Statement statement = conn.createStatement();
            String query = "SELECT * FROM ptb." + tableName;
            ResultSet rs = statement.executeQuery(query);

            List<Storage> storageList = GetData.Get_Storage_Data(rs);

            System.out.println(storageList);

            rs.close();
            statement.close();

        } catch (SQLException | MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void memory_test() {
        Dotenv dotenv = Dotenv.load();

        String host = dotenv.get("DB_HOST");
        String port = dotenv.get("DB_PORT");
        String db = dotenv.get("DB_NAME");
        String user = dotenv.get("DB_USER");
        String password = dotenv.get("DB_PASSWORD");

        String server = "jdbc:mysql://" + host + ":" + port + "/" + db + "?useSSL=true";

        try (Connection conn = DriverManager.getConnection(server, user, password)) {
            System.out.println("Connected to MySQL successfully!");

            String tableName = "memory";
            Statement statement = conn.createStatement();
            String query = "SELECT * FROM ptb." + tableName;
            ResultSet rs = statement.executeQuery(query);

            List<Memory> memoryList = GetData.Get_Memory_Data(rs);

            System.out.println(memoryList);

            rs.close();
            statement.close();

        } catch (SQLException | MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void motherboard_test() {
        Dotenv dotenv = Dotenv.load();

        String host = dotenv.get("DB_HOST");
        String port = dotenv.get("DB_PORT");
        String db = dotenv.get("DB_NAME");
        String user = dotenv.get("DB_USER");
        String password = dotenv.get("DB_PASSWORD");

        String server = "jdbc:mysql://" + host + ":" + port + "/" + db + "?useSSL=true";

        try (Connection conn = DriverManager.getConnection(server, user, password)) {
            System.out.println("Connected to MySQL successfully!");

            String tableName = "motherboard";
            Statement statement = conn.createStatement();
            String query = "SELECT * FROM ptb." + tableName;
            ResultSet rs = statement.executeQuery(query);

            List<Motherboard> mbList = GetData.Get_Motherboard_Data(rs);

            System.out.println(mbList);

            rs.close();
            statement.close();

        } catch (SQLException | MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void psu_test() {
        Dotenv dotenv = Dotenv.load();

        String host = dotenv.get("DB_HOST");
        String port = dotenv.get("DB_PORT");
        String db = dotenv.get("DB_NAME");
        String user = dotenv.get("DB_USER");
        String password = dotenv.get("DB_PASSWORD");

        String server = "jdbc:mysql://" + host + ":" + port + "/" + db + "?useSSL=true";

        try (Connection conn = DriverManager.getConnection(server, user, password)) {
            System.out.println("Connected to MySQL successfully!");

            String tableName = "ups";
            Statement statement = conn.createStatement();
            String query = "SELECT * FROM ptb." + tableName;
            ResultSet rs = statement.executeQuery(query);

            List<PSU> psuList = GetData.Get_PSU_Data(rs);

            System.out.println(psuList);

            rs.close();
            statement.close();

        } catch (SQLException | MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void videocard_test() {
        Dotenv dotenv = Dotenv.load();

        String host = dotenv.get("DB_HOST");
        String port = dotenv.get("DB_PORT");
        String db = dotenv.get("DB_NAME");
        String user = dotenv.get("DB_USER");
        String password = dotenv.get("DB_PASSWORD");

        String server = "jdbc:mysql://" + host + ":" + port + "/" + db + "?useSSL=true";

        try (Connection conn = DriverManager.getConnection(server, user, password)) {
            System.out.println("Connected to MySQL successfully!");

            String tableName = "`video-card`";
            Statement statement = conn.createStatement();
            String query = "SELECT * FROM ptb." + tableName;
            ResultSet rs = statement.executeQuery(query);

            List<VideoCard> vcList = GetData.Get_VideoCard_Data(rs);

            System.out.println(vcList);

            rs.close();
            statement.close();

        } catch (SQLException | MalformedURLException e) {
            e.printStackTrace();
        }
    }


}

