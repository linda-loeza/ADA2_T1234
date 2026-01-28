module com.ada2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires kernel;
    requires layout;
    requires io;

    opens com.ada2 to javafx.fxml;

    exports com.ada2;

}
