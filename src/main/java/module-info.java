module com.lhaunsp.wguproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.lhaunsp.wguproject to javafx.fxml;
    exports com.lhaunsp.wguproject;
}