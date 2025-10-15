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
import javafx.scene.shape.Circle;
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
        final int CHIMNEY_POS_X = HOUSE_POS_X + 100, CHIMNEY_POS_Y = HOUSE_POS_Y - 75, CHIMNEY_SIZE_X = 25, CHIMNEY_SIZE_Y = 50;
        final int DOOR_POS_X = HOUSE_POS_X + 120, DOOR_POS_Y = HOUSE_POS_Y + 100, DOOR_SIZE_X = 60, DOOR_SIZE_Y = 100;
        final int ROOF_HEIGHT = 100, BASE_HEIGHT = 15;
        final int SUN_RADIUS = 75;
        
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
        //Create ground
        Rectangle groundRect = new Rectangle(0, HOUSE_POS_Y + HOUSE_SIZE_Y, SCENE_WIDTH, SCENE_HEIGHT - HOUSE_POS_Y - HOUSE_SIZE_Y);
        groundRect.setFill(Color.GREEN);
        groundRect.setStroke(Color.DARKGREEN);
        //Create base rect
        Rectangle baseRect = new Rectangle(HOUSE_POS_X, HOUSE_POS_Y + HOUSE_SIZE_Y, HOUSE_SIZE_X, BASE_HEIGHT);
        baseRect.setFill(Color.GRAY);
        baseRect.setStroke(Color.BLACK);
        //Create chimney
        Rectangle chimneyRect = new Rectangle(CHIMNEY_POS_X, CHIMNEY_POS_Y, CHIMNEY_SIZE_X, CHIMNEY_SIZE_Y);
        chimneyRect.setFill(Color.DARKRED);
        chimneyRect.setStroke(Color.BLACK);
        //Create sun
        Circle sunCircle = new Circle(SCENE_WIDTH, 0, SUN_RADIUS);
        sunCircle.setFill(Color.YELLOW);
        sunCircle.setStroke(Color.GOLD);

        //Add elements
        root.getChildren().addAll(skyRect, houseRect, roofTriangle, doorRect, groundRect, baseRect, chimneyRect, sunCircle);
       
        //Create rays
        for (int i = 1; i <= 5; i++) {
            Line ray = new Line(SCENE_WIDTH, 0, SCENE_WIDTH - i * 30, 150 - 30 * i);
            ray.setStroke(Color.YELLOW);
            root.getChildren().add(ray);
        }
        //Create and addwindows
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
