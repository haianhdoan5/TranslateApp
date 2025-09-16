module com.dha.translateapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.dha.translateapp to javafx.fxml;
    exports com.dha.translateapp;
    exports com.dha.pojo;
    exports com.dha.services;
    exports com.dha.utils;
}
