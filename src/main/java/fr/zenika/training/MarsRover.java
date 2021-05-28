package fr.zenika.training;

import java.util.HashSet;
import java.util.Set;

public class MarsRover {

    private Coords coords;
    private Direction direction;
    private final Set<Position> encounteredObstacles = new HashSet<>();

    public MarsRover(Coords startingPoint, Direction direction) {
        this.coords = startingPoint;
        this.direction = direction;
    }

    public void move(char ... movements) {
        for (char movement : movements) {
            if(!applyMovement(movement)) {
                break;
            }
        }
    }

    private boolean applyMovement(char movement) {
        var expectedCoords = coords;
        switch (movement) {
            case 'f' -> expectedCoords = coords.moveForward(direction);
            case 'b' -> expectedCoords = coords.moveBackward(direction);
            case 'l' -> direction = direction.turnLeft();
            case 'r' -> direction = direction.turnRight();
            default -> throw new IllegalArgumentException("unknown command " + movement);
        }
        var movementApplied = !expectedCoords.isOnObstacle();
        if(!movementApplied) {
            encounteredObstacles.add(expectedCoords.position());
        } else {
            coords = expectedCoords;
        }
        return movementApplied;
    }

    public Position position() {
        return coords.position();
    }

    public Direction direction() {
        return direction;
    }

    public Set<Position> encounteredObstacles() {
        return encounteredObstacles;
    }
}
