module com.example.fontysassignment {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;

    opens com.example.fontysassignment to javafx.fxml;
    exports com.example.fontysassignment;
    exports com.example.fontysassignment.clock;
    opens com.example.fontysassignment.clock to javafx.fxml;
}