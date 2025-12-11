package PayToBuild.App;
import PayToBuild.Data.*;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.stream.Collectors;

public class CardController {
    private Parent root;
    private Stage stage;
    private Scene scene;
    @FXML
    private AnchorPane cardroot;
    @FXML
    private Button addPart;
    @FXML
    private VBox carddataroot;
    @FXML
    private Label partname;

    private Object data;
    private MainController mainController;


    public void setMainController(MainController controller){
        this.mainController = controller;
    }

    public void DisplayCase(Case pcCase){
        this.data = pcCase;
        partname.setText(pcCase.getName());
        carddataroot.getChildren().clear();

        ImageView imageView = new ImageView(new Image(pcCase.getUrl().toString()));
        imageView.setFitHeight(150);
        imageView.setPreserveRatio(true);

        Label priceLable = new Label("Price: $" + pcCase.getPrice());
        Label colorLabel = new Label("Color: " + pcCase.getColor());
        Label typeLabel = new Label("Type: " + pcCase.getType());
        Label psuInWattLabel = new Label("Built in power supply watt capacity: " + pcCase.getPsu());
        Label externalVolumeLabel = new Label("External volume:" + pcCase.getExternal_volume());
        Label sidePanelLabel = new Label("Side panel type: " + pcCase.getSide_panel());
        Label internal35bayLabel = new Label("Number of 3.5 bays: " + pcCase.getInternal_35_bays());

        carddataroot.getChildren().addAll(priceLable,colorLabel,typeLabel,psuInWattLabel,externalVolumeLabel,sidePanelLabel,internal35bayLabel,imageView);
    }

    public void DisplayCPU(CPU pcCPU){
        this.data = pcCPU;
        partname.setText(pcCPU.getName());
        carddataroot.getChildren().clear();


        ImageView imageView = new ImageView(new Image(pcCPU.getUrl().toString()));
        imageView.setFitHeight(150);
        imageView.setPreserveRatio(true);
        Label priceLable = new Label("Price: $" + pcCPU.getPrice());
        Label coreCountLabel = new Label("Cores: " + pcCPU.getCore_count());
        Label coreClockLabel = new Label("Core base speed in Hz: " + pcCPU.getCore_clock());
        Label coreBoostLabel = new Label("Core boost speed in Hz: " + pcCPU.getBoost_clock());
        Label microArchitectureLabel = new Label("Microarchitecture: " + pcCPU.getMicroarchitecture());
        Label TDPLabel = new Label("Maximum temperature : " + pcCPU.getTdp());
        Label graphicLabel = new Label("Built in graphic card: " + pcCPU.getGraphic());

        carddataroot.getChildren().addAll(priceLable,coreCountLabel,coreClockLabel,coreBoostLabel,microArchitectureLabel,TDPLabel,graphicLabel,imageView);
    }

    public void DisplayCPUCooler(CPUCooler pcCPUCooler){
        this.data = pcCPUCooler;
        partname.setText(pcCPUCooler.getName());
        carddataroot.getChildren().clear();

        ImageView imageView = new ImageView(new Image(pcCPUCooler.getUrl().toString()));
        imageView.setFitHeight(150);
        imageView.setPreserveRatio(true);

        Label priceLable = new Label("Price: $" +  pcCPUCooler.getPrice());
        Label RPMLabel = new Label("Fan speed: " + pcCPUCooler.getRpm());
        Label sizeLabel = new Label("Size in mm: " + pcCPUCooler.getSize());
        Label noiseLevelLabel = new Label("Noise levels: " + pcCPUCooler.getNoise_level());
        Label colorLabel = new Label("Color: " + pcCPUCooler.getColor());

        carddataroot.getChildren().addAll(priceLable,RPMLabel,sizeLabel,noiseLevelLabel,colorLabel,imageView);
    }

    public void DisplayMemory(Memory pcMemory){
        this.data = pcMemory;
        partname.setText(pcMemory.getName());
        carddataroot.getChildren().clear();

        ImageView imageView = new ImageView(new Image(pcMemory.getUrl().toString()));
        imageView.setFitHeight(150);
        imageView.setPreserveRatio(true);

        Label priceLable = new Label("Price: $" + pcMemory.getPrice());
        Label speedLabel = new Label("Memory speed MHz: " + pcMemory.getSpeed());
        Label moduleLabel = new Label("Module type: " + pcMemory.getModules());
        Label pricePRgbLabel = new Label("Price/GB: " + pcMemory.getPrice_per_gb());
        Label colorLabel = new Label("Color: " + String.join(",",pcMemory.getColor()));
        Label fwLatencyLabel = new Label("FW latency: " + pcMemory.getFirst_word_latency());
        Label casLatencyLabel = new Label("CAS latency: " + pcMemory.getCas_latency());

        carddataroot.getChildren().addAll(priceLable,speedLabel,moduleLabel,pricePRgbLabel,colorLabel,fwLatencyLabel,casLatencyLabel,imageView);
    }

    public void DisplayMotherboard(Motherboard pcMotherboard){
        this.data = pcMotherboard;
        partname.setText(pcMotherboard.getName());
        carddataroot.getChildren().clear();

        ImageView imageView = new ImageView(new Image(pcMotherboard.getUrl().toString()));
        imageView.setFitHeight(150);
        imageView.setPreserveRatio(true);
        Label priceLable = new Label("Price: $" + pcMotherboard.getPrice());
        Label socketLabel = new Label("Socket type: " + pcMotherboard.getSocket());
        Label memorySlotsLabel = new Label("Number of memory slots: " + pcMotherboard.getMemory_slots());
        Label maxSuppMemoryLabel = new Label("Maximum supported memory in GB: " + pcMotherboard.getMax_memory());
        Label formFactorLabel = new Label("Form factor: " + pcMotherboard.getForm_factor());
        Label colorLabel = new Label("Color " + String.join(",",pcMotherboard.getColor()));

        carddataroot.getChildren().addAll(priceLable,socketLabel,memorySlotsLabel,maxSuppMemoryLabel,formFactorLabel,colorLabel,imageView);
    }

    public void DisplayPSU(PSU pcPSU){
        this.data = pcPSU;
        partname.setText(pcPSU.getName());
        carddataroot.getChildren().clear();

        ImageView imageView = new ImageView(new Image(pcPSU.getUrl().toString()));
        imageView.setFitHeight(150);
        imageView.setPreserveRatio(true);
        Label priceLable = new Label("Price: $" + pcPSU.getPrice());
        Label wattegLabel = new Label("Watt: " + pcPSU.getCapacity_w());
        Label voltageLabel = new Label("Volt: " + pcPSU.getCapacity_va());

        carddataroot.getChildren().addAll(priceLable,wattegLabel,voltageLabel);
    }

    public void DisplayStorage(Storage pcStorge){
        this.data = pcStorge;
        partname.setText(pcStorge.getName());
        carddataroot.getChildren().clear();

        ImageView imageView = new ImageView(new Image(pcStorge.getUrl().toString()));
        imageView.setFitHeight(150);
        imageView.setPreserveRatio(true);

        Label priceLable = new Label("Price: $" + pcStorge.getPrice());
        Label capacityLabel = new Label("Storage size in GB:"+ pcStorge.getCapacity());
        Label pricePRgbLabel = new Label("Price/GB: " + pcStorge.getPrice_per_gb());
        Label typeLabel = new Label("Type: " + pcStorge.getType());
        Label cacheLabel = new Label("Cache: " + pcStorge.getCache());
        Label formFactorLabel = new Label("Form factor: " + pcStorge.getForm_factor());
        Label interfaceLabel = new Label("Interfaces: " + pcStorge.getDriveInterface());

        carddataroot.getChildren().addAll(priceLable,capacityLabel,pricePRgbLabel,typeLabel,cacheLabel,formFactorLabel,interfaceLabel,imageView);
    }

    public void DisplayVideoCard(VideoCard pcVideoCard ){
        this.data = pcVideoCard;
        partname.setText(pcVideoCard.getName());
        carddataroot.getChildren().clear();

        ImageView imageView = new ImageView(new Image(pcVideoCard.getUrl().toString()));
        imageView.setFitHeight(150);
        imageView.setPreserveRatio(true);

        Label priceLable = new Label("Price: $" + pcVideoCard.getPrice());
        Label chipsetLabel = new Label("Chipset:"+ pcVideoCard.getChipset());
        Label memoryLabel = new Label("Memory: " + pcVideoCard.getMemory());
        Label coreClockLabel = new Label("Core clock: " + pcVideoCard.getCore_clock());
        Label boostClockLabel = new Label("Boost clock: " + pcVideoCard.getBoost_clock());
        Label colorLabel = new Label("Color: " + pcVideoCard.getColor());
        Label lengthLabel = new Label("Length in mm: " + pcVideoCard.getLength());

        carddataroot.getChildren().addAll(priceLable,chipsetLabel,memoryLabel,coreClockLabel,boostClockLabel,colorLabel,lengthLabel,imageView);
    }

    public void backtomain(javafx.event.ActionEvent e)throws IOException{
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainPage.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root,screenSize.width,screenSize.height);
        stage.setTitle("MainPage");
        MainController controller = loader.getController();

        stage.setScene(scene);
        stage.show();

        controller.refresh();
    }

    public void addElement(javafx.event.ActionEvent e) throws IOException{
        if(mainController != null){

            mainController.changeLabelToSelectedPart(data);
            backtomain(e);
            System.out.println("Info given");
        }
    }


}
