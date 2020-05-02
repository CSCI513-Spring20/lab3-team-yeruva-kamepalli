import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class FlowerBed implements Garden{
	Rectangle flowerBed;
	boolean movable;
	List<Garden> flowers = new ArrayList<Garden>();
	
	public FlowerBed(Point2D point,Color color,boolean bool) {
		this.movable = true;
		flowerBed = new Rectangle();
		flowerBed.setX(point.getX());
		flowerBed.setY(point.getY());
		flowerBed.setHeight(250);
		flowerBed.setWidth(150);
		flowerBed.setFill(Color.ALICEBLUE);
		flowerBed.setStroke(Color.BLACK);
		flowerBed.setStrokeWidth(1);
		
	}
	
	public Rectangle getFlowerBed() {
		return flowerBed;
	}

	public void move(double dx, double dy) {
		flowerBed.setX(flowerBed.getX()+dx);
		flowerBed.setY(flowerBed.getY()+dy);
			for (Garden flower : flowers) {
				flower.move(dx, dy);
			}
		
	}
	@Override
	public boolean ContainsPoint(Point2D point) {
		boolean inRectangle = (point.getX() >= flowerBed.getX() && point.getX() <= flowerBed.getX()+flowerBed.getWidth()
		&& point.getY()>= flowerBed.getY() && point.getY() <= flowerBed.getY()+flowerBed.getHeight());
		return inRectangle;
	}

	public void addchild(Garden component) {
		// TODO Auto-generated method stub
		flowers.add(component);
	}
	

}