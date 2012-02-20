package mowitnow;

public enum Orientation {
	North{
		public Position move(Position position) {
			return position.moveToNorth();
		}
	},
	East{
		public Position move(Position position) {
			return position.moveToEast();
		}
	}, South{
		public Position move(Position position) {
			return position.moveToSouth();
		}
	};

	public abstract Position move(Position position);
}
