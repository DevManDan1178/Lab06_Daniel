/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab06_daniel;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author 6323612
 */
public class HouseWithWindowPanesLab extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        //Create root
        Pane root = new Pane();
        /*
        DRAW A HOUSE
        - Base, Roof, Door
        */
        final int SCENE_WIDTH = 520, SCENE_HEIGHT = 520;
        final int HOUSE_POS_X = 110, HOUSE_POS_Y = 200, HOUSE_SIZE_X = 300, HOUSE_SIZE_Y = 200;
        final int [][] WINDOW_COORDINATES = { //posX, posY, sizeX, sizeY
            {HOUSE_POS_X + 25, HOUSE_POS_Y + 50, 50, 75},
            {HOUSE_POS_X + 225, HOUSE_POS_Y + 50, 50, 75},
        };
        final int DOOR_POS_X = HOUSE_POS_X + 120, DOOR_POS_Y = HOUSE_POS_Y + 100, DOOR_SIZE_X = 60, DOOR_SIZE_Y = 100;
        final int ROOF_HEIGHT = 100;
        final int BASE_HEIGHT = 50;
        
        //Create background sky rect
        Rectangle skyRect = new Rectangle(0,0, SCENE_WIDTH, SCENE_HEIGHT);
        skyRect.setFill(Color.LIGHTBLUE);
        //Create house rect
        Rectangle houseRect = new Rectangle(HOUSE_POS_X, HOUSE_POS_Y, HOUSE_SIZE_X, HOUSE_SIZE_Y);
        houseRect.setStroke(Color.BLACK);
        houseRect.setFill(Color.BEIGE);
        //Create roof triangle
        Polygon roofTriangle = new Polygon(HOUSE_POS_X, HOUSE_POS_Y, HOUSE_POS_X + HOUSE_SIZE_X, HOUSE_POS_Y, HOUSE_POS_X + HOUSE_SIZE_X/2, HOUSE_POS_Y - ROOF_HEIGHT);
        roofTriangle.setFill(Color.RED);
        roofTriangle.setStroke(Color.BLACK);
        //Create door rect
        Rectangle doorRect = new Rectangle(DOOR_POS_X, DOOR_POS_Y, DOOR_SIZE_X, DOOR_SIZE_Y);
        doorRect.setFill(Color.BROWN);
        doorRect.setStroke(Color.BLACK);
        root.getChildren().addAll(skyRect, houseRect, roofTriangle, doorRect);
        //Create windows
        for (int[] windowCoordinates : WINDOW_COORDINATES) {
            root.getChildren().addAll(createWindow(windowCoordinates));
        }
        //Show scene
        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
        stage.setScene(scene);
        stage.setTitle("House or something");
        stage.show();
    }
    
    /**
     * Creates a window based on the parameters
     * @param params [posX, posY, sizeX, sizeY]
     * @return the elements of the window (nodes)
     */
    private Node[] createWindow(int[] params) {
        final int posX = params[0], posY = params[1], sizeX = params[2], sizeY = params[3];
        Rectangle windowRect = new Rectangle(posX, posY, sizeX, sizeY);
        windowRect.setStroke(Color.BLACK);
        windowRect.setFill(Color.CORAL);
        Line vertical = new Line(posX + sizeX/2, posY, posX + sizeX/2, posY + sizeY);
        Line horizontal = new Line(posX, posY + sizeY/2, posX+ sizeX, posY + sizeY/2);
        return new Node[] {windowRect, vertical, horizontal};
    }
}
