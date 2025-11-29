package PayToBuild.DB;

import io.github.cdimascio.dotenv.Dotenv;

public class Connector {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();

        String host = dotenv.get("DB_HOST");
        String port = dotenv.get("DB_PORT");
        String db = dotenv.get("DB_NAME");
        String user = dotenv.get("DB_USER");
        String password = dotenv.get("DB_PASSWORD");


            System.out.println("Connected to MySQL successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}