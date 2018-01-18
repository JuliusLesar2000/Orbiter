
import javafx.application.Application; 
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * Constructs two circles and finds the distance in pixels between them
 * <p>If clicked and dragged, the distance will change accordingly
 * @author Alex Wang
 * 9/1/16
 */
public class DraggableObjects extends Application{
	int m = 0;
	public void start(Stage primaryStage){

		//creates panes and circle and colors them
		Pane pane = new Pane();
		Circle circle1 = new Circle();
		Circle circle2 = new Circle();
		circle1.setFill(Color.WHITE);
		circle1.setStroke(Color.WHITE);
		circle2.setFill(Color.WHITE);
		circle2.setStroke(Color.WHITE);

		circle1.setRadius(10);
		circle2.setRadius(10);

		//set location
		//circle1.setCenterX(40);
		//circle1.setCenterY(40);
		//circle2.setCenterX(120);
		//circle2.setCenterY(150);
		Scene scene = new Scene(pane, 1500,1500);
		primaryStage.setTitle("I like circles"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show();

		//set the distance on the pane
		/*
		 * Text dist = new Text();
		 * int distance = (int)Math.sqrt(Math.pow(circle1.getCenterX()-circle2.getCenterX(),2)+Math.pow(circle1.getCenterY()-circle2.getCenterY(),2));
	    dist.setText(distance+"");
	    dist.setX(circle1.getCenterX()+(circle2.getCenterX()-circle1.getCenterX())/2);
	    dist.setY(circle1.getCenterY()+(circle2.getCenterY()-circle1.getCenterY())/2);
		 */





		//sets the line connecting the circles
		Circle circlelin = new Circle();
		Circle circlelin2 = new Circle();
		circlelin.setRadius(10);
		circlelin2.setRadius(10);
		circlelin.setStroke(Color.WHITE);
		circlelin2.setStroke(Color.WHITE);
		circlelin.setFill(Color.WHITE);
		circlelin2.setFill(Color.WHITE);
		Line lin = new Line();
		lin.setStartX(circle1.getCenterX());
		lin.setStartY(circle1.getCenterY());
		lin.setStroke(Color.WHITE);
		Line lin2 = new Line();
		lin2.setStartX(circle2.getCenterX());
		lin2.setStartY(circle2.getCenterY());
		lin2.setStroke(Color.WHITE);
		pane.setOnMouseClicked(e->{
			if(m==1) {
				circle2.setCenterX(e.getX());
				circle2.setCenterY(e.getY());
				circle2.setStroke(Color.BLACK);
				m++;
				lin2.setStroke(Color.BLACK);
				lin2.setStartX(e.getX());
				lin2.setStartY(e.getY());
				lin2.setEndX(750);
				lin2.setEndY(500);
				circlelin2.setCenterX(750);
				circlelin2.setCenterY(500);
			}
			if(m==0) {
				circle1.setCenterX(e.getX());
				circle1.setCenterY(e.getY());
				circle1.setStroke(Color.BLACK);
				m++;
				lin.setStroke(Color.BLACK);
				lin.setStartX(e.getX());
				lin.setStartY(e.getY());
				
				lin.setEndX(740);
				lin.setEndY(500);
				circlelin.setCenterX(740);
				circlelin.setCenterY(500);
			}




		});
		

		pane.getChildren().addAll(circle1,circle2,lin,lin2,circlelin,circlelin2);
		lin.setOnMouseDragged(e->{
			lin.setEndX(e.getX());
			lin.setEndY(e.getY());
		});
		//checks for when one of the circles is dragged and updates values
		circle1.setOnMouseDragged(e->{

			circle1.setCenterX(e.getX());
			circle1.setCenterY(e.getY());
			lin.setStartX(e.getX());
			lin.setStartY(e.getY());
			//dist.setX(Math.abs(circle1.getCenterX()+(circle2.getCenterX()-circle1.getCenterX())/2));
			//dist.setY(Math.abs(circle1.getCenterY()+(circle2.getCenterY()-circle1.getCenterY())/2));
			int distanc = (int)Math.sqrt(Math.pow(circle1.getCenterX()-circle2.getCenterX(),2)+Math.pow(circle1.getCenterY()-circle2.getCenterY(),2));
			//dist.setText(distanc+"");
		});
		//checks for when the other circle is dragged and updates values
		circle2.setOnMouseDragged(e->{
			circle2.setCenterX(e.getX());
			circle2.setCenterY(e.getY());
			lin2.setStartX(e.getX());
			lin2.setStartY(e.getY());
			//dist.setX(Math.abs(circle1.getCenterX()+(circle2.getCenterX()-circle1.getCenterX())/2));
			//dist.setY(Math.abs(circle1.getCenterY()+(circle2.getCenterY()-circle1.getCenterY())/2));
			int distanc = (int)Math.sqrt(Math.pow(circle1.getCenterX()-circle2.getCenterX(),2)+Math.pow(circle1.getCenterY()-circle2.getCenterY(),2));
			// dist.setText(distanc+"");
		});
		circlelin.setOnMouseDragged(e->{
			circlelin.setCenterX(e.getX());
			circlelin.setCenterY(e.getY());
			lin.setEndX(e.getX());
			lin.setEndY(e.getY());
		});
		circlelin2.setOnMouseDragged(e->{
			circlelin2.setCenterX(e.getX());
			circlelin2.setCenterY(e.getY());
			lin2.setEndX(e.getX());
			lin2.setEndY(e.getY());
		});
		double magA = 1/Math.pow(Math.sqrt(Math.pow((circle1.getCenterX()-circle2.getCenterX()),2)+Math.pow((circle1.getCenterY()-circle2.getCenterY()),2)),3)*
				6.63*Math.pow(10,-11)*1000;
		double[] accelerationC1 = {magA*(circle2.getCenterX()-circle1.getCenterX()),magA*(circle2.getCenterY()-circle1.getCenterY())};
	}
	//public static void findPlanet
	public static void main(String[] args) {
		launch(args);
	}
}
