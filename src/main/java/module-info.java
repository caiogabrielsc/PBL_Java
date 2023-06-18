module main {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.brocode2 to javafx.graphics, javafx.fxml, javafx.base;
    opens Modelll.Entity to javafx.graphics, javafx.fxml, java.base;
    opens Modelll to javafx.graphics, javafx.fxml, java.base;
    opens com.example.brocode2.controllerAtendente to javafx.fxml;
    opens com.example.brocode2.controllerTecnico to javafx.fxml;


    exports com.example.brocode2;
    exports com.example.brocode2.controllerAtendente;
    exports com.example.brocode2.controllerTecnico;
    exports Modelll.Entity;
    exports Modelll;

}



