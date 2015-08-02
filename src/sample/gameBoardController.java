package sample;

/**
 * Created by Benjamin Cervantes on 7/24/2015.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javax.swing.JOptionPane;
import javafx.scene.image.ImageView;
import java.lang.Integer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.canvas.Canvas;
import javafx.stage.Screen;

import java.util.ArrayList;


public class gameBoardController implements Initializable {

    final int numRows = 4;
    final int numCol = 8;
    static boolean p1Turn = true;
    static boolean p2Turn = false;
    static boolean p3Turn = false;
    static boolean p4Turn = false;

    static int currentP1;
    static int currentP2;
    static int currentP3;
    static int currentP4;
    int oldP1;
    int oldP2;
    int oldP3;
    int oldP4;
    static int p1Fears;
    static int p2Fears;
    static int p3Fears;
    static int p4Fears;


    /**
     * @variable dieButton button to roll a Die
     */
    @FXML
    private Button dieButton;

    @FXML
    private Label playerLabel;

    /**
     * @variable imageView to show player local
     */
    @FXML
    private ImageView red00_;
    public static ImageView red00;
    @FXML
    private ImageView blue00_;
    public static ImageView blue00;
    @FXML
    private ImageView green00_;
    public static ImageView green00;
    @FXML
    private ImageView yellow00_;
    public static ImageView yellow00;
    @FXML
    private ImageView red10_;
    public static ImageView red10;
    @FXML
    private ImageView blue10_;
    public static ImageView blue10;
    @FXML
    private ImageView green10_;
    public static ImageView green10;
    @FXML
    private ImageView yellow10_;
    public static ImageView yellow10;
    @FXML
    private ImageView red20_;
    public static ImageView red20;
    @FXML
    private ImageView blue20_;
    public static ImageView blue20;
    @FXML
    private ImageView green20_;
    public static ImageView green20;
    @FXML
    private ImageView yellow20_;
    public static ImageView yellow20;
    @FXML
    private ImageView red30_;
    public static ImageView red30;
    @FXML
    private ImageView blue30_;
    public static ImageView blue30;
    @FXML
    private ImageView green30_;
    public static ImageView green30;
    @FXML
    private ImageView yellow30_;
    public static ImageView yellow30;
    @FXML
    private ImageView red40_;
    public static ImageView red40;
    @FXML
    private ImageView blue40_;
    public static ImageView blue40;
    @FXML
    private ImageView green40_;
    public static ImageView green40;
    @FXML
    private ImageView yellow40_;
    public static ImageView yellow40;
    @FXML
    private ImageView red50_;
    public static ImageView red50;
    @FXML
    private ImageView blue50_;
    public static ImageView blue50;
    @FXML
    private ImageView green50_;
    public static ImageView green50;
    @FXML
    private ImageView yellow50_;
    public static ImageView yellow50;
    @FXML
    private ImageView red60_;
    public static ImageView red60;
    @FXML
    private ImageView blue60_;
    public static ImageView blue60;
    @FXML
    private ImageView green60_;
    public static ImageView green60;
    @FXML
    private ImageView yellow60_;
    public static ImageView yellow60;
    @FXML
    private ImageView red70_;
    public static ImageView red70;
    @FXML
    private ImageView blue70_;
    public static ImageView blue70;
    @FXML
    private ImageView green70_;
    public static ImageView green70;
    @FXML
    private ImageView yellow70_;
    public static ImageView yellow70;
    @FXML
    private ImageView red01_;
    public static ImageView red01;
    @FXML
    private ImageView blue01_;
    public static ImageView blue01;
    @FXML
    private ImageView green01_;
    public static ImageView green01;
    @FXML
    private ImageView yellow01_;
    public static ImageView yellow01;
    @FXML
    private ImageView red11_;
    public static ImageView red11;
    @FXML
    private ImageView blue11_;
    public static ImageView blue11;
    @FXML
    private ImageView green11_;
    public static ImageView green11;
    @FXML
    private ImageView yellow11_;
    public static ImageView yellow11;
    @FXML
    private ImageView red21_;
    public static ImageView red21;
    @FXML
    private ImageView blue21_;
    public static ImageView blue21;
    @FXML
    private ImageView green21_;
    public static ImageView green21;
    @FXML
    private ImageView yellow21_;
    public static ImageView yellow21;
    @FXML
    private ImageView red31_;
    public static ImageView red31;
    @FXML
    private ImageView blue31_;
    public static ImageView blue31;
    @FXML
    private ImageView green31_;
    public static ImageView green31;
    @FXML
    private ImageView yellow31_;
    public static ImageView yellow31;
    @FXML
    private ImageView red41_;
    public static ImageView red41;
    @FXML
    private ImageView blue41_;
    public static ImageView blue41;
    @FXML
    private ImageView green41_;
    public static ImageView green41;
    @FXML
    private ImageView yellow41_;
    public static ImageView yellow41;
    @FXML
    private ImageView red51_;
    public static ImageView red51;
    @FXML
    private ImageView blue51_;
    public static ImageView blue51;
    @FXML
    private ImageView green51_;
    public static ImageView green51;
    @FXML
    private ImageView yellow51_;
    public static ImageView yellow51;
    @FXML
    private ImageView red61_;
    public static ImageView red61;
    @FXML
    private ImageView blue61_;
    public static ImageView blue61;
    @FXML
    private ImageView green61_;
    public static ImageView green61;
    @FXML
    private ImageView yellow61_;
    public static ImageView yellow61;
    @FXML
    private ImageView red71_;
    public static ImageView red71;
    @FXML
    private ImageView blue71_;
    public static ImageView blue71;
    @FXML
    private ImageView green71_;
    public static ImageView green71;
    @FXML
    private ImageView yellow71_;
    public static ImageView yellow71;
    @FXML
    private ImageView red02_;
    public static ImageView red02;
    @FXML
    private ImageView blue02_;
    public static ImageView blue02;
    @FXML
    private ImageView green02_;
    public static ImageView green02;
    @FXML
    private ImageView yellow02_;
    public static ImageView yellow02;
    @FXML
    private ImageView red12_;
    public static ImageView red12;
    @FXML
    private ImageView blue12_;
    public static ImageView blue12;
    @FXML
    private ImageView green12_;
    public static ImageView green12;
    @FXML
    private ImageView yellow12_;
    public static ImageView yellow12;
    @FXML
    private ImageView red22_;
    public static ImageView red22;
    @FXML
    private ImageView blue22_;
    public static ImageView blue22;
    @FXML
    private ImageView green22_;
    public static ImageView green22;
    @FXML
    private ImageView yellow22_;
    public static ImageView yellow22;
    @FXML
    private ImageView red32_;
    public static ImageView red32;
    @FXML
    private ImageView blue32_;
    public static ImageView blue32;
    @FXML
    private ImageView green32_;
    public static ImageView green32;
    @FXML
    private ImageView yellow32_;
    public static ImageView yellow32;
    @FXML
    private ImageView red42_;
    public static ImageView red42;
    @FXML
    private ImageView blue42_;
    public static ImageView blue42;
    @FXML
    private ImageView green42_;
    public static ImageView green42;
    @FXML
    private ImageView yellow42_;
    public static ImageView yellow42;
    @FXML
    private ImageView red52_;
    public static ImageView red52;
    @FXML
    private ImageView blue52_;
    public static ImageView blue52;
    @FXML
    private ImageView green52_;
    public static ImageView green52;
    @FXML
    private ImageView yellow52_;
    public static ImageView yellow52;
    @FXML
    private ImageView red62_;
    public static ImageView red62;
    @FXML
    private ImageView blue62_;
    public static ImageView blue62;
    @FXML
    private ImageView green62_;
    public static ImageView green62;
    @FXML
    private ImageView yellow62_;
    public static ImageView yellow62;
    @FXML
    private ImageView red72_;
    public static ImageView red72;
    @FXML
    private ImageView blue72_;
    public static ImageView blue72;
    @FXML
    private ImageView green72_;
    public static ImageView green72;
    @FXML
    private ImageView yellow72_;
    public static ImageView yellow72;
    @FXML
    private ImageView red03_;
    public static ImageView red03;
    @FXML
    private ImageView blue03_;
    public static ImageView blue03;
    @FXML
    private ImageView green03_;
    public static ImageView green03;
    @FXML
    private ImageView yellow03_;
    public static ImageView yellow03;
    @FXML
    private ImageView red13_;
    public static ImageView red13;
    @FXML
    private ImageView blue13_;
    public static ImageView blue13;
    @FXML
    private ImageView green13_;
    public static ImageView green13;
    @FXML
    private ImageView yellow13_;
    public static ImageView yellow13;
    @FXML
    private ImageView red23_;
    public static ImageView red23;
    @FXML
    private ImageView blue23_;
    public static ImageView blue23;
    @FXML
    private ImageView green23_;
    public static ImageView green23;
    @FXML
    private ImageView yellow23_;
    public static ImageView yellow23;
    @FXML
    private ImageView red33_;
    public static ImageView red33;
    @FXML
    private ImageView blue33_;
    public static ImageView blue33;
    @FXML
    private ImageView green33_;
    public static ImageView green33;
    @FXML
    private ImageView yellow33_;
    public static ImageView yellow33;
    @FXML
    private ImageView red43_;
    public static ImageView red43;
    @FXML
    private ImageView blue43_;
    public static ImageView blue43;
    @FXML
    private ImageView green43_;
    public static ImageView green43;
    @FXML
    private ImageView yellow43_;
    public static ImageView yellow43;
    @FXML
    private ImageView red53_;
    public static ImageView red53;
    @FXML
    private ImageView blue53_;
    public static ImageView blue53;
    @FXML
    private ImageView green53_;
    public static ImageView green53;
    @FXML
    private ImageView yellow53_;
    public static ImageView yellow53;
    @FXML
    private ImageView red63_;
    public static ImageView red63;
    @FXML
    private ImageView blue63_;
    public static ImageView blue63;
    @FXML
    private ImageView green63_;
    public static ImageView green63;
    @FXML
    private ImageView yellow63_;
    public static ImageView yellow63;
    @FXML
    private ImageView red73_;
    public static ImageView red73;
    @FXML
    private ImageView blue73_;
    public static ImageView blue73;
    @FXML
    private ImageView green73_;
    public static ImageView green73;
    @FXML
    private ImageView yellow73_;
    public static ImageView yellow73;

    @FXML
    private Label fear1_;

    public static Label fear1;

    @FXML
    private Label fear2_;

    public static Label fear2;

    @FXML
    private Label fear3_;

    public static Label fear3;


    @FXML
    private Label fear4_;

    public static Label fear4;

/**
 * @return the imageView
 */
    public final ImageView getImageView(int playerMove) throws Exception {
        if (p1Turn) {
            System.out.println(reds.length + " - " + blues.length + " - " + greens.length + " - " + yellows.length);
            oldP1 = currentP1;
            reds[oldP1].setVisible(false);
            currentP1 = currentP1 + playerMove;
            if (currentP1 >= 31) {
                JOptionPane.showMessageDialog(null,
                        "Congratulations to Player 1 for Winning!", "We have a Winner!",
                        JOptionPane.INFORMATION_MESSAGE);
                currentP1 = 31;
                reds[currentP1].setVisible(true);
                throw new IOException();
            } else {
                playerLabel.setText("Player 2 Turn");
                return reds[currentP1];
            }
        }
        if (p2Turn) {
            oldP2 = currentP2;
            blues[oldP2].setVisible(false);
            currentP2 = currentP2 + playerMove;
            if (currentP1 >= 31) {
                JOptionPane.showMessageDialog(null,
                        "Congratulations to Player 2 for Winning!", "We have a Winner!",
                        JOptionPane.INFORMATION_MESSAGE);
                currentP2 = 31;
                blues[currentP2].setVisible(true);
                throw new IOException();
            } else {
                playerLabel.setText("Player 3 Turn");
                return blues[currentP2];
            }
        }
        if (p3Turn) {
            oldP3 = currentP3;
            greens[oldP3].setVisible(false);
            currentP3 = currentP3 + playerMove;
            if (currentP1 >= 31) {
                JOptionPane.showMessageDialog(null,
                        "Congratulations to Player 3 for Winning!", "We have a Winner!",
                        JOptionPane.INFORMATION_MESSAGE);
                currentP3 = 31;
                greens[currentP3].setVisible(true);
                throw new IOException();
            } else {
                playerLabel.setText("Player 4 Turn");
                return greens[currentP3];
            }
        }
        else{
            oldP4 = currentP4;
            yellows[oldP4].setVisible(false);
            currentP4 = currentP4 + playerMove;
            if (currentP1 >= 31) {
                JOptionPane.showMessageDialog(null,
                        "Congratulations to Player 4 for Winning!", "We have a Winner!",
                        JOptionPane.INFORMATION_MESSAGE);
                currentP4 = 31;
                yellows[currentP4].setVisible(true);
                throw new IOException();
            } else {
                playerLabel.setText("Player 1 Turn");
                return yellows[currentP4];
            }
        }
    }

    public static int lifeQuestNum = 0;
    public static int acaQuestNum = 0;
    public static int persQuestNum = 0;
    /**
     * rolls a die to generate random number from 1-6 when the button is clicked.
     * and moves character icon to match it
     * @param event the event
     */
    @FXML
    private void handleDieButtonAction(final ActionEvent event) {
        int playerMove = (int)(Math.random() * 6) + 1;
        try {
            getImageView(playerMove).setVisible(true);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "The Game has Ended!", "We have a Winner!",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        } catch (Exception e) {
            System.out.println("Something Unexpected Happened!");
        }
        JOptionPane.showMessageDialog(null,
                "You have rolled a " + playerMove, "Player Movement",
                JOptionPane.INFORMATION_MESSAGE);
        String tempName = Main.getQuestionTitle(getPlayerLocation());
        questionScreenController.titleLabel.setText(tempName);

        String temp = "";
        if(tempName.equals("Life Problems")) {
            temp = Main.lifeQuestions.get(0).get(lifeQuestNum);
        } else if(tempName.equals("Academic Problems")) {
            temp = Main.academicQuestions.get(0).get(acaQuestNum);
        } else if(tempName.equals("Personal Problems")) {
            temp = Main.personalQuestions.get(0).get(persQuestNum);
        }

        questionScreenController.questionLabel.setText(temp);
        questionScreenController.questionLabel.setLayoutX(500);
        Main.setQuestionScreenScene();
    }

    private boolean p1InGame_;
    private boolean p2InGame_;
    private boolean p3InGame_;
    private boolean p4InGame_;

    public static boolean p1InGame;
    public static boolean p2InGame;
    public static boolean p3InGame;
    public static boolean p4InGame;


    public static void switchTurns() {
        if (p1Turn) {
            p1Turn = false;
            if (p2InGame) {
                p2Turn = true;
            } else if (p3InGame) {
                p3Turn = true;
            } else if (p4InGame) {
                p4Turn = true;
            } else {
                p1Turn = true;
            }
        } else if (p2Turn) {
            p2Turn = false;
            if (p3InGame) {
                p3Turn = true;
            } else if (p4InGame) {
                p4Turn = true;
            } else if (p1InGame) {
                p1Turn = true;
            } else {
                p2Turn = true;
            }
        } else if (p3Turn) {
            p3Turn = false;
            if (p4InGame) {
                p4Turn = true;
            } else if (p1InGame) {
                p1Turn = true;
            } else if (p2InGame) {
                p2Turn = true;
            } else {
                p3Turn = true;
            }
        } else if (p4Turn) {
            p4Turn = false;
            if (p1InGame) {
                p1Turn = true;
            } else if (p2InGame) {
                p2Turn = true;
            } else if (p3InGame) {
                p3Turn = true;
            } else {
                p4Turn = true;
            }
        } else {
            return;
        }
    }

    /**
     * get player location
     */
    public static int getPlayerLocation() {
        if (p1Turn) {
            return currentP1;
        } else if (p2Turn) {
            return currentP2;
        } else if (p3Turn) {
            return currentP3;
        } else if (p4Turn){
            return currentP4;
        } else {
            return 0;
        }
    }



    private ImageView[] reds_;
    public static ImageView[] reds;

    private ImageView[] blues_;
    public static ImageView[] blues;

    private ImageView[] greens_;
    public static ImageView[] greens;

    private ImageView[] yellows_;
    public static ImageView[] yellows;

    @FXML
    private ImageView logo;

    /**
     * Initializes.
     * @param url no idea what this does, honestly
     * @param rb the resource bundle
     */
    @Override
    public void initialize(final URL url, final ResourceBundle rb) {

        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

        logo.setFitHeight(primaryScreenBounds.getMaxY() * 3 / 24);
        logo.setFitWidth(primaryScreenBounds.getMaxX() * 1/4);

        ImageView[] reds = {red00, red10, red20, red30, red40, red50, red60, red70, red01, red11, red21, red31, red41, red51, red61, red71, red02, red12, red22, red32, red42, red52, red62, red72, red03, red13, red23, red33, red43, red53, red63, red73};
        ImageView[] blues = {blue00, blue10, blue20, blue30, blue40, blue50, blue60, blue70, blue01, blue11, blue21, blue31, blue41, blue51, blue61, blue71, blue02, blue12, blue22, blue32, blue42, blue52, blue62, blue72, blue03, blue13, blue23, blue33, blue43, blue53, blue63, blue73};
        ImageView[] greens = {green00, green10, green20, green30, green40, green50, green60, green70, green01, green11, green21, green31, green41, green51, green61, green71, green02, green12, green22, green32, green42, green52, green62, green72, green03, green13, green23, green33, green43, green53, green63, green73};
        ImageView[] yellows = {yellow00, yellow10, yellow20, yellow30, yellow40, yellow50, yellow60, yellow70, yellow01, yellow11, yellow21, yellow31, yellow41, yellow51, yellow61, yellow71, yellow02, yellow12, yellow22, yellow32, yellow42, yellow52, yellow62, yellow72, yellow03, yellow13, yellow23, yellow33, yellow43, yellow53, yellow63, yellow73};

        this.reds = reds;
        this.blues = blues;
        this.greens = greens;
        this.yellows = yellows;

        fear1_ = fear1;
        fear2_ = fear2;
        fear3_ = fear3;
        fear4_ = fear4;

        p1InGame = true;
        p2InGame = true;
        p3InGame = true;
        p4InGame = true;

        p1InGame_ = p1InGame;
        p2InGame_ = p2InGame;
        p3InGame_ = p3InGame;
        p4InGame_ = p4InGame;

        double rngP1 = Math.random();
        double rngP2 = Math.random();
        double rngP3 = Math.random();
        double rngP4 = Math.random();

        if (rngP1 < 0.6) {
            red00.setVisible(true);
            p1Fears = 8;
            currentP1 = 0;
            fear1.setText("P1 Fears: " + p1Fears);
        } else if (rngP1 < 0.85) {
            red01.setVisible(true);
            currentP1 = 8;
            p1Fears = 6;
            fear1.setText("P1 Fears: " + p1Fears);
        } else {
            red02.setVisible(true);
            currentP1 = 16;
            p1Fears = 4;
            fear1.setText("P1 Fears: " + p1Fears);
        }


        if (rngP2 < 0.60) {
            blue00.setVisible(true);
            p2Fears = 8;
            currentP2 = 0;
            fear2.setText("P2 Fears: " + p2Fears);
        } else if (rngP2 < 0.85) {
            blue01.setVisible(true);
            currentP2 = 8;
            p2Fears = 6;
            fear2.setText("P2 Fears: " + p2Fears);
        } else {
            blue02.setVisible(true);
            p2Fears = 4;
            currentP2 = 16;
            fear2.setText("P2 Fears: " + p2Fears);
        }


        if (rngP3 < 0.60) {
            green00.setVisible(true);
            p3Fears = 8;
            currentP3 = 0;
            fear3.setText("P3 Fears: " + p3Fears);
        } else if (rngP3 < 0.85) {
            green01.setVisible(true);
            p3Fears = 6;
            currentP3 = 8;
            fear3.setText("P3 Fears: " + p3Fears);
        } else {
            green02.setVisible(true);
            p3Fears = 4;
            currentP3 = 16;
            fear3.setText("P3 Fears: " + p3Fears);
        }


        if (rngP4 < 0.60) {
            yellow00.setVisible(true);
            p4Fears = 8;
            currentP4 = 0;
            fear4.setText("P4 Fears: " + p4Fears);
        } else if (rngP4 < 0.85) {
            yellow01.setVisible(true);
            p4Fears = 6;
            currentP4 = 8;
            fear4.setText("P4 Fears: " + p4Fears);
        } else {
            yellow02.setVisible(true);
            p4Fears = 4;
            currentP4 = 16;
            fear4.setText("P4 Fears: " + p4Fears);
        }
    }

    @FXML
    private void handleReset(final ActionEvent event) {

        for ( int i = 0; i < 32; i++ ) {
            reds[i].setVisible(false);
            blues[i].setVisible(false);
            greens[i].setVisible(false);
            yellows[i].setVisible(false);
        }

        p1InGame = true;
        p2InGame = true;
        p3InGame = true;
        p4InGame = true;

        double rngP1 = Math.random();
        double rngP2 = Math.random();
        double rngP3 = Math.random();
        double rngP4 = Math.random();

        if (rngP1 < 0.6) {
            red00.setVisible(true);
            p1Fears = 8;
            currentP1 = 0;
            fear1.setText("P1 Fears: " + p1Fears);
        } else if (rngP1 < 0.85) {
            red01.setVisible(true);
            currentP1 = 8;
            p1Fears = 6;
            fear1.setText("P1 Fears: " + p1Fears);
        } else {
            red02.setVisible(true);
            currentP1 = 16;
            p1Fears = 4;
            fear1.setText("P1 Fears: " + p1Fears);
        }


        if (rngP2 < 0.60) {
            blue00.setVisible(true);
            p2Fears = 8;
            currentP2 = 0;
            fear2.setText("P2 Fears: " + p2Fears);
        } else if (rngP2 < 0.85) {
            blue01.setVisible(true);
            currentP2 = 8;
            p2Fears = 6;
            fear2.setText("P2 Fears: " + p2Fears);
        } else {
            blue02.setVisible(true);
            p2Fears = 4;
            currentP2 = 16;
            fear2.setText("P2 Fears: " + p2Fears);
        }


        if (rngP3 < 0.60) {
            green00.setVisible(true);
            p3Fears = 8;
            currentP3 = 0;
            fear3.setText("P3 Fears: " + p3Fears);
        } else if (rngP3 < 0.85) {
            green01.setVisible(true);
            p3Fears = 6;
            currentP3 = 8;
            fear3.setText("P3 Fears: " + p3Fears);
        } else {
            green02.setVisible(true);
            p3Fears = 4;
            currentP3 = 16;
            fear3.setText("P3 Fears: " + p3Fears);
        }


        if (rngP4 < 0.60) {
            yellow00.setVisible(true);
            p4Fears = 8;
            currentP4 = 0;
            fear4.setText("P4 Fears: " + p4Fears);
        } else if (rngP4 < 0.85) {
            yellow01.setVisible(true);
            p4Fears = 6;
            currentP4 = 8;
            fear4.setText("P4 Fears: " + p4Fears);
        } else {
            yellow02.setVisible(true);
            p4Fears = 4;
            currentP4 = 16;
            fear4.setText("P4 Fears: " + p4Fears);
        }
        Main.setBoardScene();
    }
}

