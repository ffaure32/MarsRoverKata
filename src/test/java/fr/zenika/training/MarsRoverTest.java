package fr.zenika.training;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Set;

import static fr.zenika.training.RoverBuilder.*;
import static org.junit.jupiter.api.Assertions.*;

public class MarsRoverTest {


    @ParameterizedTest
    @CsvSource({"NORTH,1,2", "SOUTH,1,5", "EAST,5,1", "WEST,2,1"})
    void GivenARoverWithStartingPoint_ItCanMoveForward(Direction direction, int x, int y) {
        // ARRANGE
        var rover = aRover().withDirection(direction).build();

        // ACT
        rover.move('f');

        // ASSERT
        assertEquals(new Position(x, y), rover.position());
    }

    @ParameterizedTest
    @CsvSource({"NORTH,1,5", "SOUTH,1,2", "EAST,2,1", "WEST,5,1"})
    void GivenARoverWithStartingPoint_ItCanMoveBackward(Direction direction, int x, int y) {
        // ARRANGE
        var rover = aRover().withDirection(direction).build();

        // ACT
        rover.move('b');

        // ASSERT
        assertEquals(new Position(x, y), rover.position());
    }

    @Test
    void GivenARoverWithStartingPoint_ItCanMoveForwardSeveralTimes() {

        // ARRANGE
        var rover = aRover().build();

        // ACT
        rover.move('f', 'f');

        // ASSERT
        assertEquals(new Position(1, 3), rover.position());
    }

    @Test
    void GivenARoverWithStartingPoint_ItComesBackToSamePositionIfMovesForwardAndBackward() {

        // ARRANGE
        var rover = aRover().build();

        // ACT
        rover.move('f', 'b');

        // ASSERT
        assertEquals(DEFAULT_POSITION, rover.position());
    }

    @Test
    void GivenAnUnexpectedCommand_TheRoverShouldThrowAnException() {

        // ARRANGE
        var rover = aRover().build();

        // ACT & ASSERT
        assertThrows(IllegalArgumentException.class, () -> rover.move('e'));
    }

    @ParameterizedTest
    @CsvSource({"NORTH,WEST", "WEST,SOUTH", "SOUTH, EAST", "EAST,NORTH"})
    void GivenARoverWithStartingDirection_ItCanTurnLeft(Direction currentDirection, Direction newDirection) {

        // ARRANGE
        var rover = aRover().withDirection(currentDirection).build();

        // ACT
        rover.move('l');

        // ASSERT
        assertEquals(DEFAULT_POSITION, rover.position());
        assertEquals(newDirection, rover.direction());
    }

    @ParameterizedTest
    @CsvSource({"NORTH,EAST", "EAST,SOUTH", "SOUTH,WEST", "WEST,NORTH"})
    void GivenARoverWithStartingDirection_ItCanTurnRight(Direction currentDirection, Direction newDirection) {

        // ARRANGE
        var rover = aRover().withDirection(currentDirection).build();

        // ACT
        rover.move('r');

        // ASSERT
        assertEquals(DEFAULT_POSITION, rover.position());
        assertEquals(newDirection, rover.direction());
    }

    @Test
    void GivenAPlanetWithObstacles_RoverCannotMove() {

        // ARRANGE
        Position obstacle = new Position(1, 2);
        Set<Position> obstacles = Set.of(obstacle);
        var planet = PlanetBuilder.aPlanet().withObstacles(obstacles);
        var rover = aRover().landingOnPlanet(planet).build();

        // ACT
        rover.move('f');

        // ASSERT
        assertEquals(DEFAULT_POSITION, rover.position());
        assertTrue(rover.encounteredObstacles().contains(obstacle));

    }

    @Test
    void RoverCanLandSomewhereElseThanDefaultPosition() {

        // ARRANGE
        Position landingPosition = new Position(3, 2);
        var rover = aRover().landingOnPosition(landingPosition).build();

        // ACT
        rover.move('f');

        // ASSERT
        assertEquals(new Position(3, 3), rover.position());
    }

}

