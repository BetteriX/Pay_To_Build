package PayToBuild.App;


import PayToBuild.Data.*;
import PayToBuild.DB.GetData;

import io.github.cdimascio.dotenv.Dotenv;

import java.awt.*;
import java.net.MalformedURLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.sun.tools.javac.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.smartcardio.Card;
import java.io.IOException;
import java.security.PublicKey;
import java.util.List;
import java.util.Objects;

public class DataController {
    private Stage stage;
    private Parent root;
    private Scene scene;

    @FXML
    private AnchorPane mainroot;
    @FXML
    private Button guidebutton;
    @FXML
    private Button loginbutton;
    @FXML
    private Region right;
    @FXML
    private Region left;
    @FXML
    private Label data_name;

    @FXML
    private HBox dy_root;
    @FXML
    private VBox dynamiccontainer;

    private MainController mainController;

    private int limit = 10;
    private int offset = 0;
    private String currentTable = "";
    private boolean isLoading = false;

    public void setMainController(MainController mainController){
        this.mainController = mainController;
    }

    public List<Object> LoadDataBase(String table, int limit, int offset){
        Dotenv dotenv = Dotenv.load();

        String host = dotenv.get("DB_HOST");
        String port = dotenv.get("DB_PORT");
        String db = dotenv.get("DB_NAME");
        String user = dotenv.get("DB_USER");
        String password = dotenv.get("DB_PASSWORD");

        String server = "jdbc:mysql://" + host + ":" + port + "/" + db + "?useSSL=true";

        try (Connection conn = DriverManager.getConnection(server, user, password)) {

            String query = "SELECT * FROM ptb." + table + " LIMIT " + limit + " OFFSET " + offset;

            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);

            List<Object> return_objects;

            if(table.equals("cpu")) return_objects = new ArrayList<>(GetData.Get_Processor_Data(rs));
            else if(table.equals("case")) return_objects = new ArrayList<>(GetData.Get_Case_Data(rs));
            else if(table.equals("`cpu-cooler`")) return_objects = new ArrayList<>(GetData.Get_CPUCooler_Data(rs));
            else if(table.equals("`internal-hard-drive`")) return_objects = new ArrayList<>(GetData.Get_Storage_Data(rs));
            else if(table.equals("memory")) return_objects = new ArrayList<>(GetData.Get_Memory_Data(rs));
            else if(table.equals("motherboard")) return_objects = new ArrayList<>(GetData.Get_Motherboard_Data(rs));
            else if(table.equals("ups")) return_objects = new ArrayList<>(GetData.Get_PSU_Data(rs));
            else if(table.equals("`video-card`")) return_objects = new ArrayList<>(GetData.Get_VideoCard_Data(rs));
            else return List.of();

            rs.close();
            statement.close();
            return return_objects;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return List.of();
    }

    public void loadData(String s) {

        // only clear if new table OR the first load
        if (!s.equals(currentTable)) {
            String name_data_page = "";
            if(s.equals("cpu")) name_data_page = "CPU";
            else if(s.equals("case")) name_data_page = "Case";
            else if(s.equals("`cpu-cooler`")) name_data_page = "CPU cooler";
            else if(s.equals("`internal-hard-drive`")) name_data_page = "Internal Hard Drive";
            else if(s.equals("memory")) name_data_page = "Memory";
            else if(s.equals("motherboard")) name_data_page = "Motherboard";
            else if(s.equals("ups")) name_data_page = "PSU";
            else if(s.equals("`video-card`")) name_data_page = "Video Card";
            else name_data_page = "Unknown";
            data_name.setText(name_data_page);
            currentTable = s;
            offset = 0;
            dynamiccontainer.getChildren().clear();
        }

        isLoading = true;

        List<Object> objects = LoadDataBase(s, limit, offset);

        for(Object object : objects){
            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Card.fxml"));
                AnchorPane cardNode = loader.load();

                CardController controller = loader.getController();
                controller.setMainController(mainController);

                if(object instanceof Case c) controller.DisplayCase(c);
                else if(object instanceof CPU c) controller.DisplayCPU(c);
                else if(object instanceof CPUCooler cooler) controller.DisplayCPUCooler(cooler);
                else if(object instanceof Memory memory) controller.DisplayMemory(memory);
                else if(object instanceof Motherboard motherboard) controller.DisplayMotherboard(motherboard);
                else if(object instanceof VideoCard videoCard) controller.DisplayVideoCard(videoCard);
                else if(object instanceof Storage storage) controller.DisplayStorage(storage);

                dynamiccontainer.getChildren().add(cardNode);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // increment offset only if data arrived
        if (!objects.isEmpty()) {
            offset += limit;
        }

        isLoading = false;
    }




    @FXML
    public void swaptoguide(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("GuidePage.fxml"));
        stage= (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("GuidePage");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void swaptologin(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        stage= (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("LoginPage");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void changecursor(MouseEvent event){
        scene = ((Node) event.getSource()).getScene();
        if(event.getEventType().equals(MouseEvent.MOUSE_ENTERED)){
            scene.setCursor(Cursor.HAND);
        } else if (!event.getEventType().equals(MouseEvent.MOUSE_ENTERED)) {
            scene.setCursor(Cursor.DEFAULT);
        }
    }

    @FXML
    public void backtomain(MouseEvent event) throws IOException {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root,screenSize.width,screenSize.height);
        stage.setTitle("MainPage");
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    private ScrollPane scrollPane;
    private void enableInfiniteScroll() {
        scrollPane.vvalueProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal.doubleValue() >= 0.95) { // bottom reached
                if (!isLoading) {
                    loadData(currentTable); // load next 10
                }
            }
        });
    }

    public void initialize() {
        enableInfiniteScroll();
    }
}
