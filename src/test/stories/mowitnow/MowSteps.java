package mowitnow;

import junit.framework.Assert;
import org.apache.commons.lang.StringUtils;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.embedder.Embedder;

/**
 * @author Gilles Philippart
 */
public class MowSteps extends Embedder {

    Mower mower;

    @Given("a mower in $x,$y and oriented to the $orientation")
    public void aMowerInPosition(
            @Named("x") String x,
            @Named("y") String y,
            @Named("orientation") String orientation) {
        Position initialPosition = new Position(x, y);
        mower = new Mower(initialPosition, makeOrientation(orientation));
    }

    @When("I orient the mower to the $orientation")
    public void iMoveTheMower(String orientationSpec) {
        Orientation orientation = makeOrientation(orientationSpec);
        mower.orient(orientation);
    }

    @When("I pivot the mower to the $direction")
    public void iPivotTheMower(String direction) {
        if (direction.equals("left")) {
            mower.pivotLeft();
        } else if (direction.equals("right")) {
            mower.pivotRight();
        } else {
            throw new RuntimeException("Can only pivot left or right");
        }
    }

    @When("I move the mower")
    public void iMoveTheMower() {
        mower.move();
    }

    private Orientation makeOrientation(String orientation) {
        return Orientation.valueOf(StringUtils.capitalize(orientation));
    }

    @Then("the mower should be in $x,$y facing $orientation")
    public void theMowerShouldBeAtPositionFacing(
            @Named("x") String x,
            @Named("y") String y,
            @Named("orientation") String orientation) {
        Position expectedPosition = new Position(x, y);
        Assert.assertEquals("position", mower.getPosition(), expectedPosition);
        Orientation expectedOrientation = makeOrientation(orientation);
        Assert.assertEquals("orientation", mower.getOrientation(), expectedOrientation);
    }
}
