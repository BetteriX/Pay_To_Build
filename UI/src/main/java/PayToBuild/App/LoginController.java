package PayToBuild.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    private Stage stage;
    private Parent root;
    private Scene scene;
    @FXML
    private Button guidebutton;
    @FXML
    private Button loginbutton;

    @FXML
    public void changecursor(MouseEvent event){
        scene = ((Node) event.getSource()).getScene();
        if(event.getEventType().equals(MouseEvent.MOUSE_ENTERED)){
            scene.setCursor(Cursor.HAND);
        } else if (!event.getEventType().equals(MouseEvent.MOUSE_ENTERED)) {
            scene.setCursor(Cursor.DEFAULT);
        }

    }

    public void swaptoguide(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("GuidePage.fxml"));
        stage= (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("GuidePage");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void backtomain(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("MainPage");
        stage.setScene(scene);
        stage.show();
    }
}
