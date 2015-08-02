package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

public class Main extends Application {

    static Stage PrimaryStage;
    private static Scene main;
    private static Scene gameBoardScreen;
    private static Scene ruleScreen1;
    private static Scene ruleScreen2;
    private static Scene ruleScreen3;
    private static Scene questionScreen;
    private static Scene choiceScreen;
    private static String[] names;
    private static int[] lifeTiles;
    private static int[] academicTiles;
    private static int[] personalTiles;
    private static int[] summerTiles;
    public static ArrayList<ArrayList<String>> lifeQuestions;
    public static ArrayList<ArrayList<String>> academicQuestions;
    public static ArrayList<ArrayList<String>> personalQuestions;

    @Override
    public void start(Stage stage) throws Exception{
        int lifeTiles[] = {1, 4, 10, 13, 19, 22, 25, 28};
        this.lifeTiles = lifeTiles;
        int academicTiles[] = {2, 5, 11, 14, 17, 20, 26, 29};
        this.academicTiles = academicTiles;
        int personalTiles[] = {3, 6, 9, 12, 18, 21, 27, 30};
        this.personalTiles = personalTiles;
        int summerTiles[] = {7, 15, 23, 31};
        this.summerTiles = summerTiles;
        String[] names = {"Life Problems", "Academic Problems", "Personal Problems", "Summer!"};
        this.names = names;
        ArrayList<ArrayList<String>> lifeQuestions = new ArrayList<ArrayList<String>>();
        this.lifeQuestions = lifeQuestions;
        ArrayList<ArrayList<String>> academicQuestions = new ArrayList<ArrayList<String>>();
        this.academicQuestions = academicQuestions;
        ArrayList<ArrayList<String>> personalQuestions = new ArrayList<ArrayList<String>>();
        this.personalQuestions = personalQuestions;

        lifeQuestions.add(new ArrayList<String>());
        lifeQuestions.add(new ArrayList<String>());
        lifeQuestions.add(new ArrayList<String>());

        academicQuestions.add(new ArrayList<String>());
        academicQuestions.add(new ArrayList<String>());
        academicQuestions.add(new ArrayList<String>());

        personalQuestions.add(new ArrayList<String>());
        personalQuestions.add(new ArrayList<String>());
        personalQuestions.add(new ArrayList<String>());

        ArrayList<ArrayList<ArrayList<String>>> arrays = new ArrayList<ArrayList<ArrayList<String>>>();
        arrays.add(lifeQuestions);
        arrays.add(academicQuestions);
        arrays.add(personalQuestions);
        try {
            File questionsFile = new File("Questions.txt");
            Scanner questionsScanner = new Scanner(questionsFile);
            String temp;
            int whichArray = 0;
            int whichCat = 0;
            temp = questionsScanner.nextLine();
            temp.trim();
            while (true) {
                if (temp instanceof String) {
                    if (temp.equals("") || temp.equals("Life Questions:")) {
                    } else if (temp.equals("Academic Questions:") || temp.equals("Personal Questions:")) {
                        whichArray++;
                        whichCat = 0;
                    } else if (temp.equals("Response1:") || temp.equals("Response2:")) {
                        whichCat++;
                    } else {
                        arrays.get(whichArray).get(whichCat).add(temp);
                    }
                    temp = questionsScanner.nextLine();
                    temp.trim();
                } else {
                    break;
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("Came to the End of the File safely");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Something Unexpected happened");
        }

        Parent root = FXMLLoader.load(getClass().getResource("startScreen.fxml"));
        Parent gameBoard = FXMLLoader.load(getClass().getResource("gameBoard.fxml"));
        Parent rule1 = FXMLLoader.load(getClass().getResource("rulesScreen1.fxml"));
        Parent rule2 = FXMLLoader.load(getClass().getResource("rulesScreen2.fxml"));
        Parent rule3 = FXMLLoader.load(getClass().getResource("rulesScreen11.fxml"));
        Parent question = FXMLLoader.load(getClass().getResource("questionScreen.fxml"));
        Parent choice = FXMLLoader.load(getClass().getResource("choiceScreen.fxml"));

        Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
        main = new Scene(root, visualBounds.getWidth(), visualBounds.getHeight() - 30);
        gameBoardScreen = new Scene(gameBoard, visualBounds.getWidth(), visualBounds.getHeight() - 30);
        ruleScreen1 = new Scene(rule1, visualBounds.getWidth(), visualBounds.getHeight() - 30);
        ruleScreen2 = new Scene(rule2, visualBounds.getWidth(), visualBounds.getHeight() - 30);
        ruleScreen3 = new Scene(rule3, visualBounds.getWidth(), visualBounds.getHeight() - 30);
        questionScreen = new Scene(question, visualBounds.getWidth(), visualBounds.getHeight() - 30);
        choiceScreen = new Scene(choice, visualBounds.getWidth(), visualBounds.getHeight() - 30);

        PrimaryStage = stage;
        PrimaryStage.setTitle("The STEM Life");
        PrimaryStage.setScene(main);
        PrimaryStage.show();
    }


    public static String getQuestionTitle (int key) {
        for (int i : lifeTiles ) {
            if (i == key) {
                return names[0];
            }
        }
        for (int i : academicTiles ) {
            if (i == key) {
                return names[1];
            }
        }
        for (int i : personalTiles ) {
            if (i == key) {
                return names[2];
            }
        }
        for (int i : summerTiles ) {
            if (i == key) {
                return names[3];
            }
        }
        return "New School Year";
    }

    /**
     * sets the scene to the boardGame scene
     */
    public static void setBoardScene() {
        PrimaryStage.setScene(gameBoardScreen);
    }

    /**
     * sets the scene to the rule scene1
     */
    public static void setRuleScene1() {
        PrimaryStage.setScene(ruleScreen1);
    }

    /**
     * sets the scene to the rule scene2
     */
    public static void setRuleScene2() {
        PrimaryStage.setScene(ruleScreen2);
    }

    /**
     * sets the scene to the rule scene3
     */
    public static void setRuleScene3() {
        PrimaryStage.setScene(ruleScreen3);
    }

    /**
     * sets the scene to the startScreen scene
     */
    public static void setStartScreenScene() {
        PrimaryStage.setScene(main);
    }

    /**
     * sets the scene to the questionScreen scene
     */
    public static void setQuestionScreenScene() {
        PrimaryStage.setScene(questionScreen);
    }

    /**
     * sets the scene to the choiceScreen scene
     */
    public static void setChoiceScreenScene() {
        PrimaryStage.setScene(choiceScreen);
    }



    public static void main(String[] args) {
        launch(args);
    }
}
