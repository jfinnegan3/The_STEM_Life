package sample;

/**
 * Created by Benjamin Cervantes on 7/23/2015.
 */

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.scene.text.Font;


public class startScreenController implements Initializable {

    /**
     * @variable title game title
     */
    @FXML
    private Label title;

    /**
     * @variable newGameButton button to start new game
     */
    @FXML
    private Button beginButton;

    /**
     * sets the boardGame scene as the main scene when the button is clicked.
     *
     * @param event the event
     */
    @FXML
    private void handleButtonAction(final ActionEvent event) {
        Main.setRuleScene1();
    }

    @FXML
    private AnchorPane aPane;

    @FXML
    private StackPane sPane;

    @FXML
    private ImageView logo;

    @FXML
    /**
     * Initializes.
     * @param url no idea what this does, honestly
     * @param rb the resource bundle
     */
    @Override
    public void initialize(final URL url, final ResourceBundle rb) {
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        aPane.setTopAnchor(sPane, primaryScreenBounds.getMaxY() / 5);
        aPane.setBottomAnchor(sPane, primaryScreenBounds.getMaxY() / 5);
        aPane.setLeftAnchor(sPane, primaryScreenBounds.getMaxX() / 4);
        aPane.setRightAnchor(sPane, primaryScreenBounds.getMaxX() / 4);

        logo.setFitHeight(primaryScreenBounds.getMaxY() * 3 / 5);
        logo.setFitWidth(primaryScreenBounds.getMaxX() * 4 / 5);

        beginButton.setPrefSize(primaryScreenBounds.getMaxX() / 10, primaryScreenBounds.getMaxY() / 10);
        beginButton.setFont(Font.font("Century Gothic Bold", FontWeight.BOLD, 22));
    }

}
