package mowitnow;

public class Mower {

	private Position position = new Position(0, 0);
	private Orientation orientation = Orientation.North;

	Position getPosition() {
		return position;
	}

	public void orient(Orientation orientation) {
		this.orientation = orientation;
	}

	public void move() {
		this.position = orientation.move(position);
	}
}
