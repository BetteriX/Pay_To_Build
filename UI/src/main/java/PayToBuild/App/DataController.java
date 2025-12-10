package PayToBuild.App;


import PayToBuild.Data.*;
import PayToBuild.DB.GetData;

import io.github.cdimascio.dotenv.Dotenv;

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
    private Label dataname;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private HBox dy_root;
    @FXML
    private VBox dynamiccontainer;

    private MainController mainController;


    public void setMainController(MainController mainController){
        this.mainController = mainController;
    }

    public List<Object> LoadDataBase(String s){
        Dotenv dotenv = Dotenv.load();

        String host = dotenv.get("DB_HOST");
        String port = dotenv.get("DB_PORT");
        String db = dotenv.get("DB_NAME");
        String user = dotenv.get("DB_USER");
        String password = dotenv.get("DB_PASSWORD");

        String server = "jdbc:mysql://" + host + ":" + port + "/" + db + "?useSSL=true";

        try (Connection conn = DriverManager.getConnection(server, user, password)) {
            System.out.println("Connected to MySQL successfully!");

            String tableName = s;
            Statement statement = conn.createStatement();
            String query = "SELECT * FROM ptb." + tableName;
            ResultSet rs = statement.executeQuery(query);


            List<Object> return_objects;
            // Call your GetData method
            if(tableName.equals("cpu")){
                return_objects = new ArrayList<>(GetData.Get_Processor_Data(rs));
                return return_objects;
            }
            else if(tableName.equals("case")){
                return_objects = new ArrayList<>(GetData.Get_Case_Data(rs));
                return return_objects;
            }
            else if(tableName.equals("`cpu-cooler`")){
                return_objects = new ArrayList<>(GetData.Get_CPUCooler_Data(rs));
                return return_objects;
            }
            else if(tableName.equals("`internal-hard-drive`")){
                return_objects = new ArrayList<>(GetData.Get_Storage_Data(rs));
                return return_objects;
            }
            else if(tableName.equals("memory")){
                return_objects = new ArrayList<>(GetData.Get_Memory_Data(rs));
                return return_objects;
            }
            else if(tableName.equals("motherboard")){
                return_objects = new ArrayList<>(GetData.Get_Motherboard_Data(rs));
                return return_objects;
            }
            else if(tableName.equals("ups")){
                return_objects = new ArrayList<>(GetData.Get_PSU_Data(rs));
                return return_objects;
            }
            else if(tableName.equals("`video-card`")){
                return_objects = new ArrayList<>(GetData.Get_VideoCard_Data(rs));
                return return_objects;
            }

            rs.close();
            statement.close();

        } catch (SQLException | MalformedURLException e) {
            e.printStackTrace();
        }
        return List.of();
    }

    public void loadData(String s){
        dynamiccontainer.getChildren().clear();

        List<Object> objects = LoadDataBase(s);
        for(Object object:objects){
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

           }catch (IOException e){
               e.printStackTrace();
           }
       }

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
}
