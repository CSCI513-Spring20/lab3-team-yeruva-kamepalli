import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Flower implements Garden{

Circle circle;
boolean movable;

public Flower(Point2D point,Color color,boolean bool) {
circle = new Circle();
this.movable = bool;
circle.setCenterX(point.getX());
circle.setCenterY(point.getY());
circle.setRadius(10);
circle.setFill(color);
circle.setStroke(Color.BLACK);
circle.setStrokeWidth(1);
}

public Circle getFlower() {
return circle;
}
public void move(double dx, double dy) {
circle.setCenterX(circle.getCenterX()+dx);
circle.setCenterY(circle.getCenterY()+dy);

}
@Override
public boolean ContainsPoint(Point2D point) {
return (circle.contains(point));
}

}