import javafx.animation.AnimationTimer;
import javafx.application.Application; 
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * Constructs two circles and finds the distance in pixels between them
 * <p>If clicked and dragged, the distance will change accordingly
 * @author Alex Wang and Le Do
 * 9/1/16
 */
public class Orbit extends Application{
	int m = 0;
	private final double M1 = 2000000;
	private final double M2 = 2000000;
	public void start(Stage primaryStage){

		//creates panes and circle and colors them
		Pane pane = new Pane();
		BorderPane pb = new BorderPane();
		Button but = new Button();
		Canvas canvas = new Canvas(2000, 2000);
		Planet circle1 = new Planet(M1);
		Planet circle2 = new Planet(M2);
		Interact twoPlan = new Interact(circle1,circle2);
		circle1.setFill(Color.TRANSPARENT);
		circle1.setStroke(Color.TRANSPARENT);
		circle2.setFill(Color.TRANSPARENT);
		circle2.setStroke(Color.TRANSPARENT);

		circle1.setRadius(10);
		circle2.setRadius(10);

		Scene scene = new Scene(pane,2000,2000);

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

		circlelin.setStroke(Color.TRANSPARENT);
		circlelin2.setStroke(Color.TRANSPARENT);
		circlelin.setFill(Color.TRANSPARENT);
		circlelin2.setFill(Color.TRANSPARENT);

		Line lin = new Line();
		lin.setStartX(circle1.getCenterX());
		lin.setStartY(circle1.getCenterY());
		lin.setStroke(Color.WHITE);

		Line lin2 = new Line();
		lin2.setStartX(circle2.getCenterX());
		lin2.setStartY(circle2.getCenterY());
		lin2.setStroke(Color.WHITE);
		GraphicsContext gc1 = canvas.getGraphicsContext2D();
		gc1.setFill(Color.WHITE);
		gc1.fillRect(0,0,4000,4000);
		pane.setOnMouseClicked(e->{
			if(m==1) {
				circle2.setCenterX(e.getX());
				circle2.setCenterY(e.getY());
				circle2.setPosition(new double[] {e.getX(),e.getY()});
				circle2.setStroke(Color.BLACK);
				m++;
				lin2.setStroke(Color.BLACK);
				lin2.setStartX(e.getX());
				lin2.setStartY(e.getY());
				circlelin2.setCenterX(750);
				circlelin2.setCenterY(500);
				lin2.setEndX(750);
				lin2.setEndY(500);
				circle2.setVelocity(lineVec(lin2));
				//System.out.println(Arrays.toString(circle2.pos));
				//;
			}
			if(m==0) {
				circle1.setCenterX(e.getX());
				circle1.setCenterY(e.getY());
				circle1.setPosition(new double[] {e.getX(),e.getY()});
				circle1.setStroke(Color.BLACK);
				m++;
				lin.setStroke(Color.BLACK);
				lin.setStartX(e.getX());
				lin.setStartY(e.getY());
				circlelin.setCenterX(740);
				circlelin.setCenterY(500);
				lin.setEndX(740);
				lin.setEndY(500);
				circle1.setVelocity(lineVec(lin));
				//System.out.println(Arrays.toString(circle1.pos)+" "+Arrays.toString(lineVec(lin)));
			}
		});
		but.setText("Start");
		but.setOnAction(e->{
			if(m==2) {
				twoPlan.crunchValues();
			}
			m=6;
		});
		Button reset = new Button();
		reset.setText("Reset");
		reset.setOnAction(e->{
			m=0;
			circle1.setFill(Color.TRANSPARENT);
			circle1.setStroke(Color.TRANSPARENT);
			circle2.setFill(Color.TRANSPARENT);
			circle2.setStroke(Color.TRANSPARENT);

			circle1.setRadius(10);
			circle2.setRadius(10);
			lin.setStroke(Color.TRANSPARENT);
			lin2.setStroke(Color.TRANSPARENT);
			gc1.setStroke(Color.WHITE);
			gc1.setFill(Color.WHITE);
			gc1.fillRect(0,0,4000,4000);
		});
		pb.setLeft(but);
		pb.setRight(reset);
		pane.getChildren().addAll(canvas,pb,lin,lin2,circle1,circle2,circlelin,circlelin2);

		lin.setOnMouseDragged(e->{
			lin.setEndX(e.getX());
			lin.setEndY(e.getY());
		});

		//checks for when one of the circles is dragged and updates values
		circle1.setOnMouseDragged(e->{
			circle1.setCenterX(e.getX());
			circle1.setCenterY(e.getY());
			circle1.setPosition(new double[] {e.getX(),e.getY()});
			lin.setStartX(e.getX());
			lin.setStartY(e.getY());
			circle1.setVelocity(lineVec(lin));
			//dist.setX(Math.abs(circle1.getCenterX()+(circle2.getCenterX()-circle1.getCenterX())/2));
			//dist.setY(Math.abs(circle1.getCenterY()+(circle2.getCenterY()-circle1.getCenterY())/2));
			int distanc = (int)Math.sqrt(Math.pow(circle1.getCenterX()-circle2.getCenterX(),2)+Math.pow(circle1.getCenterY()-circle2.getCenterY(),2));
			//dist.setText(distanc+"");
		});
		//checks for when the other circle is dragged and updates values
		circle2.setOnMouseDragged(e->{
			circle2.setCenterX(e.getX());
			circle2.setCenterY(e.getY());
			circle2.setPosition(new double[] {e.getX(),e.getY()});
			lin2.setStartX(e.getX());
			lin2.setStartY(e.getY());
			circle2.setVelocity(lineVec(lin2));
			
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
			circle1.setVelocity(lineVec(lin));
		});
		circlelin2.setOnMouseDragged(e->{
			circlelin2.setCenterX(e.getX());
			circlelin2.setCenterY(e.getY());
			lin2.setEndX(e.getX());
			lin2.setEndY(e.getY());
			circle2.setVelocity(lineVec(lin2));
		});


		
		
		new AnimationTimer(){
			public void handle(long currentNanoTime){
				if(m>5){

					//System.out.println(Arrays.toString(twoPlan.getA()));
					gc1.setStroke(Color.RED);
					gc1.setFill(Color.RED);	
					gc1.strokeArc(twoPlan.getA()[0], twoPlan.getA()[1], 10, 10, 0, 360, ArcType.ROUND );
					gc1.setStroke(Color.BLUE);
					gc1.setFill(Color.BLUE);	
					gc1.strokeArc(twoPlan.getB()[0], twoPlan.getB()[1], 10, 10, 0, 360, ArcType.ROUND);
					
					//System.out.println(Arrays.toString(circle1.getVelocity())+" "+Arrays.toString(circle1.getPosition()));
					//m=4;
				}
			}
		}.start();

		double magA = 1/Math.pow(Math.sqrt(Math.pow((circle1.getCenterX()-circle2.getCenterX()),2)+Math.pow((circle1.getCenterY()-circle2.getCenterY()),2)),3)*
				6.63*Math.pow(10,-11)*1000;
		double[] accelerationC1 = {magA*(circle2.getCenterX()-circle1.getCenterX()),magA*(circle2.getCenterY()-circle1.getCenterY())};

		primaryStage.setTitle("Orbit Simulator"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show();
	}
	public static double[] lineVec(Line a) {
		double[] xyVec = {a.getEndX()-a.getStartX(),a.getEndY()-a.getStartY()};
		//double magVec = Math.sqrt(Math.pow(xyVec[0], 2)+Math.pow(xyVec[1], 2));
		return xyVec;
	}
	//public static void findPlanet
	public static void main(String[] args) {
		launch(args);
	}
}
