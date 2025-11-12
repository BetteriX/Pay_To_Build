package PayToBuild.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    private Stage stage;
    private Parent root;
    private Scene scene;
    @FXML
    private Button guidebutton;
    @FXML
    private Button loginbutton;
    @FXML
    private ScrollBar mainscroller;
    @FXML
    private TitledPane mainparts;
    @FXML
    private Button cpubutton;
    @FXML
    private Button memorybutton;
    @FXML
    private Button storagebutton;
    @FXML
    private Button motherboardbutton;
    @FXML
    private Button psubutton;
    @FXML
    private Button gpubutton;
    @FXML
    private Button cpucoolerbutton;
    @FXML
    private Button casebutton;

    public void swaptoguide(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("GuidePage.fxml"));
        stage= (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("GuidePage");
        stage.setScene(scene);
        stage.show();
    }
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
    public void expandmainparts(ActionEvent event) {
        mainparts.setExpanded(!mainparts.isExpanded());
    }

    public void swaptocpu(ActionEvent event) throws IOException {

    }

    public void swaptocase(ActionEvent event) throws IOException {

    }

    public void swaptocpucooler(ActionEvent event) throws IOException {

    }

    public void swaptomemory(ActionEvent event) throws IOException {

    }

    public void swaptomotherboard(ActionEvent event) throws IOException {

    }

    public void swaptopsu(ActionEvent event) throws IOException {

    }

    public void swaptostorage(ActionEvent event) throws IOException {

    }

    public void swaptogpu(ActionEvent event) throws IOException {

    }
}
