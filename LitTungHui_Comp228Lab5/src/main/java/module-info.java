module com.lab5.littunghui_comp228lab5 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires java.dotenv;

    opens com.lab5.littunghui_comp228lab5 to javafx.fxml;
    exports com.lab5.littunghui_comp228lab5;
}