module org.example.csc325_gp {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.csc325_gp to javafx.fxml;
    exports org.example.csc325_gp;
}