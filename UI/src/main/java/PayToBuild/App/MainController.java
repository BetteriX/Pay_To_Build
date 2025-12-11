package PayToBuild.App;

import PayToBuild.Data.*;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
//import java.awt.*;
import java.io.IOException;

import javafx.scene.control.Label;

public class MainController {
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
    @FXML
    private Label cpulabel;
    @FXML
    private Label memorylabel;
    @FXML
    private Label storagelabel;
    @FXML
    private Label motherboardlabel;
    @FXML
    private Label powersupplylabel;
    @FXML
    private Label cpucoolerlabel;
    @FXML
    private Label caselabel;
    @FXML
    private Label videocardlabel;


        @FXML
        public void refresh() {
            // Runs automatically each time FXML is loaded
            if(SaveParts.parts!=null) {
                if (SaveParts.GetCPUName() != null) {
                    cpulabel.setText("CPU: " + SaveParts.GetCPUName());
                    cpulabel.layoutXProperty().set(-220);
                }
                else{
                    cpulabel.setText("CPU");
                }
                if (SaveParts.GetCaseName() != null) {
                    caselabel.setText("Case: " + SaveParts.GetCaseName());
                    caselabel.layoutXProperty().set(-200);
                }
                else{
                    caselabel.setText("Case");
                }
                if (SaveParts.GetGPUName() != null) {
                    videocardlabel.setText("GPU: " + SaveParts.GetGPUName());
                    videocardlabel.layoutXProperty().set(-300);
                }
                else{
                    videocardlabel.setText("GPU");
                }
                if (SaveParts.GetCPUCoolerName() != null) {
                    cpucoolerlabel.setText("CPUCooler: " + SaveParts.GetCPUCoolerName());
                    cpucoolerlabel.layoutXProperty().set(-420);
                }
                else{
                    cpucoolerlabel.setText("CPUCooler");
                }
                if (SaveParts.GetMemoryName() != null) {
                    memorylabel.setText("Memory: " + SaveParts.GetMemoryName());
                    memorylabel.layoutXProperty().set(-300);
                }
                else{
                    memorylabel.setText("Memory");
                }
                if (SaveParts.GetMotherboardName() != null) {
                    motherboardlabel.setText("MotherBoard: " + SaveParts.GetMotherboardName());
                    motherboardlabel.layoutXProperty().set(-320);
                }
                else{
                    motherboardlabel.setText("MotherBoard");
                }
                if (SaveParts.GetPSUName() != null) {
                    powersupplylabel.setText("PSU: " + SaveParts.GetPSUName());
                    powersupplylabel.layoutXProperty().set(-220);
                }
                else{
                    powersupplylabel.setText("PSU");
                }
                if (SaveParts.GetStorageName() != null) {
                    storagelabel.setText("Storage: " + SaveParts.GetStorageName());
                    storagelabel.layoutXProperty().set(-180);
                }
                else{
                    storagelabel.setText("Storage");
                }

            }
            else{
                return;
            }
        }

    public void changeLabelToSelectedPart(Object data){
        //Function that returns name & type (string)

            if (data instanceof Case c) {
                SaveParts.SaveCase(c);
            } else if (data instanceof CPU c) {
                SaveParts.SaveCpu(c);
            } else if (data instanceof CPUCooler cooler) {
                SaveParts.SaveCPUCooler(cooler);
            } else if (data instanceof Memory memory) {
                SaveParts.SaveMemory(memory);
            } else if (data instanceof Motherboard motherboard) {
                SaveParts.SaveMotherboard(motherboard);
            } else if (data instanceof VideoCard videoCard) {
                SaveParts.SaveGPU(videoCard);
            } else if (data instanceof Storage storage) {
                SaveParts.SaveStorage(storage);
            }
            else if (data instanceof PSU psu) {
                SaveParts.SavePSU(psu);
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

    @FXML
    public void swaptocpu(ActionEvent event) throws IOException {
        // 1. Create FXMLLoader instance
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DataPage.fxml"));

        // 2. Load the FXML (returns root node)
        Parent root = loader.load();

        // 3. Get the controller instance
        DataController controller = loader.getController();

        // 4. Pass MainController and any other data
        controller.setMainController(this);
        controller.loadData("cpu"); // e.g., "cpu", "memory", etc.

        // 5. Get current stage
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // 6. Create scene and set stage
        Scene scene = new Scene(root);
        stage.setTitle("DataPage");
        stage.setScene(scene);
        stage.show();
    }

    public void swaptocase(ActionEvent event) throws IOException {
        //PassData("case");
        // 1. Create FXMLLoader instance
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DataPage.fxml"));

        // 2. Load the FXML (returns root node)
        Parent root = loader.load();

        // 3. Get the controller instance
        DataController controller = loader.getController();

        // 4. Pass MainController and any other data
        controller.setMainController(this);
        controller.loadData("case"); // e.g., "cpu", "memory", etc.

        // 5. Get current stage
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // 6. Create scene and set stage
        Scene scene = new Scene(root);
        stage.setTitle("DataPage");
        stage.setScene(scene);
        stage.show();
    }

    public void swaptocpucooler(ActionEvent event) throws IOException {
        //PassData("`cpu-cooler`");
        // 1. Create FXMLLoader instance
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DataPage.fxml"));

        // 2. Load the FXML (returns root node)
        Parent root = loader.load();

        // 3. Get the controller instance
        DataController controller = loader.getController();

        // 4. Pass MainController and any other data
        controller.setMainController(this);
        controller.loadData("`cpu-cooler`"); // e.g., "cpu", "memory", etc.

        // 5. Get current stage
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // 6. Create scene and set stage
        Scene scene = new Scene(root);
        stage.setTitle("DataPage");
        stage.setScene(scene);
        stage.show();
    }

    public void swaptomemory(ActionEvent event) throws IOException {
        //PassData("memory");
        // 1. Create FXMLLoader instance
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DataPage.fxml"));

        // 2. Load the FXML (returns root node)
        Parent root = loader.load();

        // 3. Get the controller instance
        DataController controller = loader.getController();

        // 4. Pass MainController and any other data
        controller.setMainController(this);
        controller.loadData("memory"); // e.g., "cpu", "memory", etc.

        // 5. Get current stage
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // 6. Create scene and set stage
        Scene scene = new Scene(root);
        stage.setTitle("DataPage");
        stage.setScene(scene);
        stage.show();
    }

    public void swaptomotherboard(ActionEvent event) throws IOException {
        //PassData("motherboard");
        // 1. Create FXMLLoader instance
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DataPage.fxml"));

        // 2. Load the FXML (returns root node)
        Parent root = loader.load();

        // 3. Get the controller instance
        DataController controller = loader.getController();

        // 4. Pass MainController and any other data
        controller.setMainController(this);
        controller.loadData("motherboard"); // e.g., "cpu", "memory", etc.

        // 5. Get current stage
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // 6. Create scene and set stage
        Scene scene = new Scene(root);
        stage.setTitle("DataPage");
        stage.setScene(scene);
        stage.show();
    }

    public void swaptopsu(ActionEvent event) throws IOException {
        //PassData("ups");
        // 1. Create FXMLLoader instance
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DataPage.fxml"));

        // 2. Load the FXML (returns root node)
        Parent root = loader.load();

        // 3. Get the controller instance
        DataController controller = loader.getController();

        // 4. Pass MainController and any other data
        controller.setMainController(this);
        controller.loadData("ups"); // e.g., "cpu", "memory", etc.

        // 5. Get current stage
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // 6. Create scene and set stage
        Scene scene = new Scene(root);
        stage.setTitle("DataPage");
        stage.setScene(scene);
        stage.show();
    }

    public void swaptostorage(ActionEvent event) throws IOException {
        //PassData("`internal-hard-drive`");
        // 1. Create FXMLLoader instance
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DataPage.fxml"));

        // 2. Load the FXML (returns root node)
        Parent root = loader.load();

        // 3. Get the controller instance
        DataController controller = loader.getController();

        // 4. Pass MainController and any other data
        controller.setMainController(this);
        controller.loadData("`internal-hard-drive`"); // e.g., "cpu", "memory", etc.

        // 5. Get current stage
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // 6. Create scene and set stage
        Scene scene = new Scene(root);
        stage.setTitle("DataPage");
        stage.setScene(scene);
        stage.show();
    }

    public void swaptogpu(ActionEvent event) throws IOException {
        //PassData("`video-card`");
        //PassData("`video-card`");
        // 1. Create FXMLLoader instance
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DataPage.fxml"));

        // 2. Load the FXML (returns root node)
        Parent root = loader.load();

        // 3. Get the controller instance
        DataController controller = loader.getController();

        // 4. Pass MainController and any other data
        controller.setMainController(this);
        controller.loadData("`video-card`"); // e.g., "cpu", "memory", etc.

        // 5. Get current stage
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // 6. Create scene and set stage
        Scene scene = new Scene(root);
        stage.setTitle("DataPage");
        stage.setScene(scene);
        stage.show();
    }






}
