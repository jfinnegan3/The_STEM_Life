package sample;

import com.sun.org.apache.xpath.internal.operations.And;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.scene.image.ImageView;

import javafx.geometry.Rectangle2D;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

/**
 * Created by Benjamin Cervantes on 7/24/2015.
 */
public class questionScreenController implements Initializable {
    /**
     * @variable the title label
     */

    @FXML
    private Label titleLabel_;

    public static Label titleLabel;

    final int lifeTiles[] = {1, 4, 10, 13, 19, 22, 25, 28};
    final int academicTiles[] = {2, 5, 11, 14, 17, 20, 26, 29};
    final int personalTiles[] = {3, 6, 9, 12, 18, 21, 27, 30};
    final int summerTiles[] = {7, 15, 23, 31};
    final String[] names = {"Life Problems", "Academic Problems", "Personal Problems"};

    /**
     * @variable the question label
     */
    @FXML
    private Label questionLabel_;

    public static Label questionLabel;

    /**
     * @variable button to choose choice 1
     */
    @FXML
    private Button choice1Button;

    /**
     * @variable button to choose choice 2
     */
    @FXML
    private Button choice2Button;

    /**
     * sets the choiceScreen scene as the main scene when the button is clicked.
     *
     * @param event the event
     */
    @FXML
    private void handleChoice1ButtonAction(final ActionEvent event) {
        String tempName = Main.getQuestionTitle(gameBoardController.getPlayerLocation());
        questionScreenController.titleLabel.setText(tempName);
        String temp = "";
        if(tempName.equals("Life Problems")) {
            temp = Main.lifeQuestions.get(1).get(gameBoardController.lifeQuestNum);
            gameBoardController.lifeQuestNum++;
            if (gameBoardController.lifeQuestNum == Main.lifeQuestions.get(0).size()) {
                gameBoardController.lifeQuestNum = 0;
            }
        } else if(tempName.equals("Academic Problems")) {
            temp = Main.academicQuestions.get(1).get(gameBoardController.acaQuestNum);
            gameBoardController.acaQuestNum++;
            if (gameBoardController.acaQuestNum == Main.academicQuestions.get(0).size()) {
                gameBoardController.acaQuestNum = 0;
            }
        } else if(tempName.equals("Personal Problems")) {
            temp = Main.personalQuestions.get(1).get(gameBoardController.persQuestNum);
            gameBoardController.persQuestNum++;
            if (gameBoardController.persQuestNum == Main.personalQuestions.get(0).size()) {
                gameBoardController.persQuestNum = 0;
            }
        }
        String lastPhrase = "";
        lastPhrase = temp.substring(temp.lastIndexOf("\n")+1);
        if (lastPhrase == "") {
            if (gameBoardController.p1Turn) {
                gameBoardController.p1Fears-=2;
            } else if (gameBoardController.p2Turn) {
                gameBoardController.p2Fears-=2;
            } else if (gameBoardController.p3Turn) {
                gameBoardController.p3Fears-=2;
            } else if (gameBoardController.p4Turn) {
                gameBoardController.p4Fears-=2;
            } else {
                return;
            }
        } else if (lastPhrase.substring(0,4).equals("Gain")) {
            if (gameBoardController.p1Turn) {
                gameBoardController.p1Fears++;
                if (gameBoardController.p1Fears > 12) {
                    gameBoardController.p1InGame = false;
                    for (ImageView image : gameBoardController.reds) {
                        image.setVisible(true);
                    }
                    JOptionPane.showMessageDialog(null,
                            "Eliminated", "P1 Has Been Eliminated due to Fear!",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } else if (gameBoardController.p2Turn) {
                gameBoardController.p2Fears++;
                if (gameBoardController.p2Fears > 12) {
                    gameBoardController.p2InGame = false;
                    for (ImageView image : gameBoardController.blues) {
                        image.setVisible(true);
                    }
                    JOptionPane.showMessageDialog(null,
                            "Eliminated", "P2 Has Been Eliminated due to Fear!",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } else if (gameBoardController.p3Turn) {
                gameBoardController.p3Fears++;
                if (gameBoardController.p3Fears > 12) {
                    gameBoardController.p3InGame = false;
                    for (ImageView image : gameBoardController.greens) {
                        image.setVisible(true);
                    }
                    JOptionPane.showMessageDialog(null,
                            "Eliminated", "P3 Has Been Eliminated due to Fear!",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } else if (gameBoardController.p4Turn) {
                gameBoardController.p4Fears++;
                if (gameBoardController.p3Fears > 12) {
                    gameBoardController.p3InGame = false;
                    for (ImageView image : gameBoardController.yellows) {
                        image.setVisible(true);
                    }
                    JOptionPane.showMessageDialog(null,
                            "Eliminated", "P4 Has Been Eliminated due to Fear!",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                return;
            }
        } else {
            if (gameBoardController.p1Turn) {
                gameBoardController.p1Fears--;
            } else if (gameBoardController.p2Turn) {
                gameBoardController.p2Fears--;
            } else if (gameBoardController.p3Turn) {
                gameBoardController.p3Fears--;
            } else if (gameBoardController.p4Turn) {
                gameBoardController.p4Fears--;
            } else {
                return;
            }
        }

        gameBoardController.fear1.setText("P1 Fears: " + gameBoardController.p1Fears);
        gameBoardController.fear2.setText("P2 Fears: " + gameBoardController.p2Fears);
        gameBoardController.fear3.setText("P3 Fears: " + gameBoardController.p3Fears);
        gameBoardController.fear4.setText("P4 Fears: " + gameBoardController.p4Fears);

        gameBoardController.switchTurns();
        String newLine = System.getProperty("line.separator");
        temp = temp.replaceAll("\\*", newLine);
        choiceScreenController.choiceLabel.setText(temp);
        Main.setChoiceScreenScene();
    }

    @FXML
    private void handleChoice2ButtonAction(final ActionEvent event) {
        String tempName = Main.getQuestionTitle(gameBoardController.getPlayerLocation());
        questionScreenController.titleLabel.setText(tempName);
        String temp = "";
        if(tempName.equals("Life Problems")) {
            temp = Main.lifeQuestions.get(1).get(gameBoardController.lifeQuestNum);
            gameBoardController.lifeQuestNum++;
            if (gameBoardController.lifeQuestNum == Main.lifeQuestions.get(0).size()) {
                gameBoardController.lifeQuestNum = 0;
            }
        } else if(tempName.equals("Academic Problems")) {
            temp = Main.academicQuestions.get(1).get(gameBoardController.acaQuestNum);
            gameBoardController.acaQuestNum++;
            if (gameBoardController.acaQuestNum == Main.academicQuestions.get(0).size()) {
                gameBoardController.acaQuestNum = 0;
            }
        } else if(tempName.equals("Personal Problems")) {
            temp = Main.personalQuestions.get(1).get(gameBoardController.persQuestNum);
            gameBoardController.persQuestNum++;
            if (gameBoardController.persQuestNum == Main.personalQuestions.get(0).size()) {
                gameBoardController.persQuestNum = 0;
            }
        }
        String lastPhrase = "";
        lastPhrase = temp.substring(temp.lastIndexOf("\n")+1);

        if (lastPhrase == "") {
            if (gameBoardController.p1Turn) {
                gameBoardController.p1Fears-=2;
            } else if (gameBoardController.p2Turn) {
                gameBoardController.p2Fears-=2;
            } else if (gameBoardController.p3Turn) {
                gameBoardController.p3Fears-=2;
            } else if (gameBoardController.p4Turn) {
                gameBoardController.p4Fears-=2;
            } else {
                return;
            }
        }else if (lastPhrase.substring(0,4).equals("Gain")) {
            if (gameBoardController.p1Turn) {
                gameBoardController.p1Fears++;
                if (gameBoardController.p1Fears > 12) {
                    gameBoardController.p1InGame = false;
                    for (ImageView image : gameBoardController.reds) {
                        image.setVisible(true);
                    }
                    JOptionPane.showMessageDialog(null,
                            "Eliminated", "P1 Has Been Eliminated due to Fear!",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } else if (gameBoardController.p2Turn) {
                gameBoardController.p2Fears++;
                if (gameBoardController.p2Fears > 12) {
                    gameBoardController.p2InGame = false;
                    for (ImageView image : gameBoardController.blues) {
                        image.setVisible(true);
                    }
                    JOptionPane.showMessageDialog(null,
                            "Eliminated", "P2 Has Been Eliminated due to Fear!",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } else if (gameBoardController.p3Turn) {
                gameBoardController.p3Fears++;
                if (gameBoardController.p3Fears > 12) {
                    gameBoardController.p3InGame = false;
                    for (ImageView image : gameBoardController.greens) {
                        image.setVisible(true);
                    }
                    JOptionPane.showMessageDialog(null,
                            "Eliminated", "P3 Has Been Eliminated due to Fear!",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } else if (gameBoardController.p4Turn) {
                gameBoardController.p4Fears++;
                if (gameBoardController.p3Fears > 12) {
                    gameBoardController.p3InGame = false;
                    for (ImageView image : gameBoardController.yellows) {
                        image.setVisible(true);
                    }
                    JOptionPane.showMessageDialog(null,
                            "Eliminated", "P4 Has Been Eliminated due to Fear!",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }  else {
                if (gameBoardController.p1Turn) {
                    gameBoardController.p1Fears--;
                } else if (gameBoardController.p2Turn) {
                    gameBoardController.p2Fears--;
                } else if (gameBoardController.p3Turn) {
                    gameBoardController.p3Fears--;
                } else if (gameBoardController.p4Turn) {
                    gameBoardController.p4Fears--;
                } else {
                    return;
                }
            }
        }

        gameBoardController.fear1.setText("P1 Fears: " + gameBoardController.p1Fears);
        gameBoardController.fear2.setText("P2 Fears: " + gameBoardController.p2Fears);
        gameBoardController.fear3.setText("P3 Fears: " + gameBoardController.p3Fears);
        gameBoardController.fear4.setText("P4 Fears: " + gameBoardController.p4Fears);


        gameBoardController.switchTurns();
        String newLine = System.getProperty("line.separator");
        temp = temp.replaceAll("\\*", newLine);
        choiceScreenController.choiceLabel.setText(temp);
        Main.setChoiceScreenScene();
    }

    @FXML
    private AnchorPane aPane;

    @FXML
    private StackPane sPane;
    /**
     * Initializes.
     * @param url no idea what this does, honestly
     * @param rb the resource bundle
     */
    @Override
    public void initialize(final URL url, final ResourceBundle rb) {
        titleLabel_ = titleLabel;
        questionLabel_ = questionLabel;

        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        aPane.setTopAnchor(sPane, primaryScreenBounds.getMaxY() * 1 / 5);
        aPane.setBottomAnchor(sPane, primaryScreenBounds.getMaxY() * 1 / 5);
        aPane.setLeftAnchor(sPane, primaryScreenBounds.getMaxX() / 4);
        aPane.setRightAnchor(sPane, primaryScreenBounds.getMaxX() / 4);

        titleLabel_.setLayoutX(primaryScreenBounds.getMaxY() / 3);
        questionLabel_.setLayoutX(0);
    }
}
