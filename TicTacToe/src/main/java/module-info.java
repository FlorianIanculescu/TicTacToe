module com.example.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.Fritz to javafx.fxml;
    exports com.Fritz;
}