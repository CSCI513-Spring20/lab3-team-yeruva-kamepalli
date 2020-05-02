import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


public class Main extends Application {
Pane root;
Point2D clickpoint;
Scene scene;
Point2D lastPosition =null;
Flower f1,f2,f3,f4,f5;
FlowerBed fb1;
Garden component;
boolean inDragMode = false;
List<Garden> components = new ArrayList<Garden>();



@Override
public void start(Stage primaryStage) {

// Creating Flower
f1 = new Flower(new Point2D(20,20),Color.YELLOW,true);
components.add(f1);
//Creating FlowerBeds
fb1 = new FlowerBed(new Point2D(12,80),Color.GREEN,true);
components.add(fb1);


root = new Pane();
   
   root.getChildren().addAll(fb1.getFlowerBed(),f1.getFlower());
   
   
   scene =new Scene(root,600,600);
   scene.setFill(Color.BLUE);
   
   scene.setOnMouseDragged(mouseHandler);
   scene.setOnMousePressed(mouseHandler);
   scene.setOnMouseReleased(mouseHandler);
   
   primaryStage.setTitle("Garden Layout");
   primaryStage.setScene(scene);
   primaryStage.show();
 
   




}

EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>() {

public void handle(MouseEvent mouseEvent) {

clickpoint = new Point2D(mouseEvent.getX(),mouseEvent.getY());
String eventName = mouseEvent.getEventType().getName();
if(!inDragMode) {
component = getComponent();
}
switch(eventName) {

case("MOUSE_DRAGGED"):
if(components!=null&&lastPosition != null&&component!=null) {
inDragMode = true;
double xCells =clickpoint.getX()-lastPosition.getX();
double yCells =clickpoint.getY()-lastPosition.getY();
component.move(xCells,yCells);
}

break;
case("MOUSE_RELEASED"):
if(components!=null&&component instanceof Flower) {
for(Garden shape: components){
if(shape instanceof FlowerBed && shape.ContainsPoint(clickpoint)) {
((FlowerBed) shape).addchild(component);
break;
}
}
}
inDragMode = false;
}
lastPosition = clickpoint;
}
};

private Garden getComponent(){
    Garden selectedComponent = null;
for(Garden shape: components){
if (shape.ContainsPoint(clickpoint)){
selectedComponent = shape;
break;
}
}
return selectedComponent;
    }
public static void main(String[] args) {
launch(args);
}
}