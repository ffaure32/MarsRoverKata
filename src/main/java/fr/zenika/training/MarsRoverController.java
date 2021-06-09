package fr.zenika.training;

import java.util.HashSet;
import java.util.Set;

public class MarsRoverController {

    private final MarsRover marsRover;
    private final Set<Position> encounteredObstacles = new HashSet<>();

    public MarsRoverController(Coords startingPoint, Direction direction) {
        this.marsRover = new MarsRover(startingPoint, direction);
    }

    public void move(char ... movements) {
        for (char movement : movements) {
            if(!applyMovement(movement)) {
                break;
            }
        }
    }

    private boolean applyMovement(char movement) {
        var movementApplied = true;
        switch (movement) {
            case 'f' -> movementApplied = tryToMoveForward();
            case 'b' -> movementApplied = tryToMoveBackward();
            case 'l' -> marsRover.turnLeft();
            case 'r' -> marsRover.turnRight();
            default -> throw new IllegalArgumentException("unknown command " + movement);
        }
        return movementApplied;
    }

    private boolean tryToMoveForward() {
        var coords = marsRover.coordsOnMoveForward();
        if(coords.isOnObstacle()) {
            encounteredObstacles.add(coords.position());
        } else {
            marsRover.moveForward();
        }
        return !coords.isOnObstacle();
    }

    private boolean tryToMoveBackward() {
        var coords = marsRover.coordsOnMoveBackward();
        if(coords.isOnObstacle()) {
            encounteredObstacles.add(coords.position());
        } else {
            marsRover.moveBackward();
        }
        return !coords.isOnObstacle();
    }

    public Position position() {
        return marsRover.position();
    }

    public Direction direction() {
        return marsRover.direction();
    }

    public Set<Position> encounteredObstacles() {
        return encounteredObstacles;
    }
}
