import javafx.geometry.Point2D;

public interface Garden {
	public void move(double dx, double dy);

	boolean ContainsPoint(Point2D point);

}