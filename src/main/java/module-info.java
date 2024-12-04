module org.example.csc325_gp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.csc325_gp to javafx.fxml;
    exports org.example.csc325_gp;
    exports org.example.csc325_gp.controllers;
    opens org.example.csc325_gp.controllers to javafx.fxml;
    exports org.example.csc325_gp.db;
    opens org.example.csc325_gp.db to javafx.fxml;
}