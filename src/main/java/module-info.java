module com.tums {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.tums to javafx.fxml;
    exports com.tums;
}