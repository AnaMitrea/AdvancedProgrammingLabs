module com.example.lab6 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;

    opens com.example.lab6 to javafx.fxml;
    exports com.example.lab6;
}