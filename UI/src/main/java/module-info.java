module org.example.ui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;


    exports PayToBuild.Data;
    opens PayToBuild.Data to javafx.fxml;
    exports PayToBuild.App;
    opens PayToBuild.App to javafx.fxml;
}