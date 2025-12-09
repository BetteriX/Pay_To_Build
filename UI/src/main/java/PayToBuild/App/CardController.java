package PayToBuild.App;
import PayToBuild.Data.*;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.stream.Collectors;

public class CardController {
    @FXML
    private AnchorPane cardroot;
    @FXML
    private Button addPart;
    @FXML
    private VBox carddataroot;
    @FXML
    private Label partname;

    CPU _cpu ;
    Motherboard _motherboard;
    Memory _memory;
    VideoCard _videocard;
    CPUCooler _cpucooler;
    PSU _psu;
    Storage _storage;
    Case _case;

    public void DisplayCase(Case pcCase){
        this._case = pcCase;
        partname.setText(pcCase.getName());
        carddataroot.getChildren().clear();

        Label priceLable = new Label("Price: $" + pcCase.getPrice());
        Label colorLabel = new Label("Color: " + pcCase.getColor());
        Label typeLabel = new Label("Type: " + pcCase.getType());
        Label psuInWattLabel = new Label("Built in power supply watt capacity: " + pcCase.getPsuInWatt());
        Label externalVolumeLabel = new Label("External volume:" + pcCase.getExternalVolume());
        Label sidePanelLabel = new Label("Side panel type: " + pcCase.getSidePanel());
        Label internal35bayLabel = new Label("Number of 3.5 bays: " + pcCase.getInternal35bay());

        carddataroot.getChildren().addAll(priceLable,colorLabel,typeLabel,psuInWattLabel,externalVolumeLabel,sidePanelLabel,internal35bayLabel);
    }

    public void DisplayCPU(CPU pcCPU){
        this._cpu = pcCPU;
        partname.setText(pcCPU.getName());
        carddataroot.getChildren().clear();

        Label priceLable = new Label("Price: $" + pcCPU.getPrice());
        Label coreCountLabel = new Label("Cores: " + pcCPU.getCoreCount());
        Label coreClockLabel = new Label("Core base speed in Hz: " + pcCPU.getCoreClock());
        Label coreBoostLabel = new Label("Core boost speed in Hz: " + pcCPU.getCoreBoost());
        Label microArchitectureLabel = new Label("Microarchitecture: " + pcCPU.getMicroArchitecture());
        Label TDPLabel = new Label("Maximum temperature : " + pcCPU.getTDP());
        Label graphicLabel = new Label("Built in graphic card: " + pcCPU.getGraphic());

        carddataroot.getChildren().addAll(priceLable,coreCountLabel,coreClockLabel,coreBoostLabel,microArchitectureLabel,TDPLabel,graphicLabel);
    }

    public void DisplayCPUCooler(CPUCooler pcCPUCooler){
        this._cpucooler = pcCPUCooler;
        partname.setText(pcCPUCooler.getName());
        carddataroot.getChildren().clear();

        Label priceLable = new Label("Price: $" + pcCPUCooler.getPrice());
        Label RPMLabel = new Label("Fan speed: " + pcCPUCooler.getRPM());
        Label sizeLabel = new Label("Size in mm: " + pcCPUCooler.getSize());
        String noiseText = pcCPUCooler.getNoiseLevel()
                .stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        Label noiseLevelLabel = new Label("Noise levels: " + noiseText);
        Label colorLabel = new Label("Color: " + pcCPUCooler.getColor());

        carddataroot.getChildren().addAll(priceLable,RPMLabel,sizeLabel,noiseLevelLabel,colorLabel);
    }

    public void DisplayMemory(Memory pcMemory){
        this._memory = pcMemory;
        partname.setText(pcMemory.getName());
        carddataroot.getChildren().clear();

        Label priceLable = new Label("Price: $" + pcMemory.getPrice());
        Label speedLabel = new Label("Memory speed: " + pcMemory.getSpeed());
        Label ddrLabel = new Label("DDR type: " + pcMemory.getDdr());
        Label moduleLabel = new Label("Module type: " + pcMemory.getModules());
        Label pricePRgbLabel = new Label("Price/GB: " + pcMemory.getPricePRgb());
        Label colorLabel = new Label("Color: " + String.join(",",pcMemory.getColor()));
        Label fwLatencyLabel = new Label("FW latency: " + pcMemory.getFwLatency());
        Label casLatencyLabel = new Label("CAS latency: " + pcMemory.getCasLatency());

        carddataroot.getChildren().addAll(priceLable,speedLabel,ddrLabel,moduleLabel,pricePRgbLabel,colorLabel,fwLatencyLabel,casLatencyLabel);
    }

    public void DisplayMotherboard(Motherboard pcMotherboard){
        this._motherboard = pcMotherboard;
        partname.setText(pcMotherboard.getName());
        carddataroot.getChildren().clear();

        Label priceLable = new Label("Price: $" + pcMotherboard.getPrice());
        Label socketLabel = new Label("Socket type: " + pcMotherboard.getSocket());
        Label memorySlotsLabel = new Label("Number of memory slots: " + pcMotherboard.getMemorySlots());
        Label maxSuppMemoryLabel = new Label("Maximum supported memory in GB: " + pcMotherboard.getMaxSuppMemory());
        Label formFactorLabel = new Label("Form factor: " + pcMotherboard.getFormFactor());
        Label colorLabel = new Label("Color " + String.join(",",pcMotherboard.getColor()));

        carddataroot.getChildren().addAll(priceLable,socketLabel,memorySlotsLabel,maxSuppMemoryLabel,formFactorLabel,colorLabel);
    }

    public void DisplayPSU(PSU pcPSU){
        this._psu = pcPSU;
        partname.setText(pcPSU.getName());
        carddataroot.getChildren().clear();

        Label priceLable = new Label("Price: $" + pcPSU.getPrice());
        Label wattegLabel = new Label("Watt: " + pcPSU.getWattage());
        Label modularLabel = new Label("Modular?: " + pcPSU.getModular());
        Label efficiencyRateLabel = new Label("Maximum supported memory in GB: " + pcPSU.getEfficiencyRate());
        Label colorLabel = new Label("Color: " + String.join(",",pcPSU.getColor()));

        carddataroot.getChildren().addAll(priceLable,wattegLabel,modularLabel,efficiencyRateLabel,colorLabel);
    }



}
