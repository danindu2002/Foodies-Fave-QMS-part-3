module com.example.sd2cwpart3 {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.sd2cwpart3 to javafx.fxml;
    exports com.example.sd2cwpart3;
}