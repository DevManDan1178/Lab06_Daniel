package lab06_daniel;
import javafx.application.Application; 
import javafx.stage.Stage; 
import javafx.scene.Scene; 
import javafx.scene.layout.Pane; 
import javafx.scene.paint.Color; 
import javafx.scene.shape.Rectangle; 
import javafx.scene.shape.Line; 
import javafx.scene.shape.Circle;

/**
 *
 * @author 6323612
 */
public class Lab06_Daniel extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Constants for the scene size 
        final double SCENE_WIDTH = 520.0;
        final double SCENE_HEIGHT = 520.0;
        // Constants for each square's XY coordinates
        final int X1 = 10, Y1 = 10; // Square #1
        final int X2 = 60, Y2 = 60; // Square #2
        final int X3 = 110, Y3 = 110; // Square #3 
        // Constants for each square's width and height 
        final int WIDTH1 = 500, HEIGHT1 = 500; // Square #1 
        final int WIDTH2 = 400, HEIGHT2 = 400; // Square #2 
        final int WIDTH3 = 300, HEIGHT3 = 300; // Square #3 
        // Constants for the circle's geometry 
        final int CENTER_X = 260, CENTER_Y = 260, RADIUS = 150;
        // Create square #1 here. Set its stroke color to black and set its fill color to null. 
        Rectangle square1 = new Rectangle(X1, Y1, WIDTH1, HEIGHT1);
        square1.setStroke(Color.BLACK);
        square1.setFill(null);
        
        // Create square #2 here. Set its stroke color to black and set its fill color to null. 
        Rectangle square2 = new Rectangle(X2, Y2, WIDTH2, HEIGHT2);
        square2.setStroke(Color.BLACK);
        square2.setFill(null);
        // Create square #3 here. Set its stroke color to black and set its fill color to null. 
        Rectangle square3 = new Rectangle(X3, Y3, WIDTH3, HEIGHT3);
        square3.setStroke(Color.BLACK);
        square3.setFill(null);
        // Create the diagonal lines here.
        Line lineUL = new Line(X1, Y1, X3, Y3);   
        Line lineUR = new Line(X1 + WIDTH1, Y1, X3 + WIDTH3, Y3);
        Line lineBL = new Line(X1, Y1 + HEIGHT1, X3, Y3 + WIDTH3);
        Line lineBR = new Line(X1 + WIDTH1, Y1 + HEIGHT1, X3 + WIDTH3, Y3 + HEIGHT3);
        // Create the circle here. 
        Circle circle = new Circle(SCENE_WIDTH/2, SCENE_HEIGHT/2 ,WIDTH3/2);
        // Add the nodes to a Pane here. 
        Pane root = new Pane();
        root.getChildren().addAll(square1, square2, square3, lineUL, lineUR, lineBL, lineBR, circle);   
        // Create a Scene with the Pane as the root node, 
        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
        // and display it here. 
        stage.setScene(scene);
        stage.show();
    }       
}
