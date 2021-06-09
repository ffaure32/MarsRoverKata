package fr.zenika.training;

public class MarsRover {
    private Coords coords;
    private Direction direction;

    public MarsRover(Coords startingPoint, Direction direction) {
        this.coords = startingPoint;
        this.direction = direction;
    }

    public Coords coordsOnMoveForward() {
        return coords.moveForward(direction);
    }

    public Coords coordsOnMoveBackward() {
        return coords.moveBackward(direction);
    }

    public void moveForward() {
        this.coords = coordsOnMoveForward();
    }

    public void moveBackward() {
        this.coords = coordsOnMoveBackward();
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public Position position() {
        return coords.position();
    }

    public Direction direction() {
        return direction;
    }
}
