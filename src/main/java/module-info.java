module com.numbermatch.numbermatch {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.numbermatch.numbermatch to javafx.fxml;
    exports com.numbermatch.numbermatch;
}