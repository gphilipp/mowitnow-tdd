package mowitnow;

import junit.framework.Assert;
import junit.framework.TestCase;

public class MowerTest extends TestCase {

    private Mower mower;

    public void setUp() {
        mower = Mower.createMowerAtOriginFacingNorth();
    }

    /*
      * The test that we would like to pass at the end of the dojo
      */
    public void testFinalTest() {
        mower.orient(Orientation.North);
        mower.move();
        mower.orient(Orientation.East);
        mower.move();
        mower.orient(Orientation.South);
        mower.move();

        assertMowerPosition(1, 0, "Final position");
    }

    public void testMowerShouldStartAtPosition00() {
        assertMowerPosition(0, 0, "Initial position");
    }

    public void testMowerShouldMoveTo01FromInitialPosition() {
        mower.move();
        assertMowerPosition(0, 1, "Position after first execute");
    }

    public void testMowerShouldMoveTo02After2Moves() {
        mower.move();
        mower.move();
        assertMowerPosition(0, 2, "Position after 2 moves");
    }

    public void testMowerCanPivotToTheLeft() {
        mower.pivotLeft();
        Assert.assertEquals(mower.getOrientation(), Orientation.West);
    }

    public void testMowerCanPivotToTheRight() {
        mower.pivotRight();
        Assert.assertEquals(mower.getOrientation(), Orientation.East);
    }

    public void testMowerCanMoveToTheEast() {
        mower.orient(Orientation.East);
        mower.move();
        assertMowerPosition(1, 0, "Position after going to the east");
    }

    private void assertMowerPosition(int x, int y, String message) {
        assertEquals(message, new Position(x, y), mower.getPosition());
    }
}
