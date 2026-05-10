module com.game {
    requires javafx.media;
    requires javafx.graphics;

    opens com.game to javafx.fxml;
    exports com.game;
}