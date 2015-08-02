package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Benjamin Cervantes on 7/24/2015.
 */
public class choiceScreenController implements Initializable {

    /**
     * @variable the choice label
     */
    @FXML
    private Label choiceLabel_;

    public static Label choiceLabel;

    /**
     * @variable the button to return to gameBoard
     */
    @FXML
    private Button returnButton;

    /**
     * sets the boardGame scene as the main scene when the button is clicked.
     *
     * @param event the event
     */
    @FXML
    private void handleReturnButtonAction(final ActionEvent event) {
        Main.setBoardScene();
    }

    @FXML
    private AnchorPane aPane;

    @FXML
    private StackPane sPane;

    @FXML
    private Label fearUpdateLabel_;

    public static Label fearUpdateLabel;

    /**
     * Initializes.
     * @param url no idea what this does, honestly
     * @param rb the resource bundle
     */
    @Override
    public void initialize(final URL url, final ResourceBundle rb) {
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        aPane.setTopAnchor(sPane, primaryScreenBounds.getMaxY()/5);
        aPane.setBottomAnchor(sPane, primaryScreenBounds.getMaxY()/5);
        aPane.setLeftAnchor(sPane, primaryScreenBounds.getMaxX()/4);
        aPane.setRightAnchor(sPane, primaryScreenBounds.getMaxX()/4);

        choiceLabel_ = choiceLabel;
        fearUpdateLabel_ = fearUpdateLabel;
    }
}
