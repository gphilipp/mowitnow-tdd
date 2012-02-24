package mowitnow;

import org.apache.commons.lang3.StringUtils;

public enum Orientation {

    North {
        @Override
        public Position move(Position position) {
            return position.moveToNorth();
        }

        @Override
        public Orientation pivotLeft() {
            return West;
        }

        @Override
        public Orientation pivotRight() {
            return East;
        }
    },

    East {
        public Position move(Position position) {
            return position.moveToEast();
        }

        public Orientation pivotLeft() {
            return North;
        }

        @Override
        public Orientation pivotRight() {
            return South;
        }

    },


    South {
        public Position move(Position position) {
            return position.moveToSouth();
        }

        public Orientation pivotLeft() {
            return East;
        }

        @Override
        public Orientation pivotRight() {
            return West;
        }

    },

    West {
        public Position move(Position position) {
            return position.moveToWest();
        }

        public Orientation pivotLeft() {
            return South;
        }

        @Override
        public Orientation pivotRight() {
            return North;
        }

    };


    public abstract Position move(Position position);

    public abstract Orientation pivotLeft();

    public abstract Orientation pivotRight();

}
