package mowitnow;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;

public class StepDefs {

    private Mower mower;

    @Given("^a mower in (\\d+),(\\d+) facing (.*)$")
    public void a_mower_in_facing(int x, int y, Orientation orientation) {
        mower = new Mower(x, y, orientation);
    }

    @When("^I move the mower$")
    public void i_move_the_mower() {
        mower.move();
    }

    @Then("^the mower should be in (\\d+),(\\d+) facing (.*)$")
    public void the_mower_should_be_in_facing(int x, int y, String orientation) {
        Position expectedPosition = new Position(x, y);
        Orientation expectedOrientation = getOrientation(orientation);
        Assert.assertEquals("Mower position", expectedPosition, mower.getPosition());
        Assert.assertEquals("Mower orientation", expectedOrientation, mower.getOrientation());
    }

    @When("^I pivot the mower to the (.*)$")
    public void i_pivot_the_mower_to_the(String direction) {
        if (direction.equalsIgnoreCase("right")) {
            mower.pivotRight();
        } else if (direction.equalsIgnoreCase("left")) {
            mower.pivotLeft();
        }
    }


    private Orientation getOrientation(String orientation) {
        return Orientation.valueOf(StringUtils.capitalize(orientation.toLowerCase()));
    }


}
