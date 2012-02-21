package mowitnow;

import java.util.StringTokenizer;

public class Position {

    private final int x;

    private final int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position(String x, String y) {
        this.x = Integer.parseInt(x);
        this.y = Integer.parseInt(y);
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Position other = (Position) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Position [x=" + x + ", y=" + y + "]";
    }

    public Position moveToNorth() {
        return new Position(x, y + 1);
    }

    public Position moveToEast() {
        return new Position(x + 1, y);
    }

    public Position moveToWest() {
        return new Position(x - 1, y);
    }

    public Position moveToSouth() {
        return new Position(x, y - 1);
    }

    public static Position parse(String positionAsString) {
        StringTokenizer st = new StringTokenizer(positionAsString, ",");
        String x = st.nextToken();
        String y = st.nextToken();
        return new Position(Integer.parseInt(x), Integer.parseInt(y));
    }

    public static Position atOrigin() {
        return new Position(0, 0);
    }

}
