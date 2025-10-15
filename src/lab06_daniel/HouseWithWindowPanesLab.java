/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab06_daniel;

import javafx.application.Application;
import javafx.scene.Scene;
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
        /*
        DRAW A HOUSE
        - Base, Roof, Door
        */
        final int SCENE_WIDTH = 520, SCENE_HEIGHT = 520;
        final int HOUSE_POS_X = 110, HOUSE_POS_Y = 400;
        final int HOUSE_SIZE_X = 300, HOUSE_SIZE_Y = 200;
        final int ROOF_HEIGHT = 100;
        final int BASE_HEIGHT = 50;
        
        
        Pane root = new Pane();
        
        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
        stage.setScene(scene);
        stage.setTitle("House or something");
        stage.show();
    }
    
}
