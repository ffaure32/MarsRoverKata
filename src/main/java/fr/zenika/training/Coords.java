package fr.zenika.training;

public record Coords(Planet planet, Position position) {
    public Coords(Planet planet, int x, int y) {
        this(planet, new Position(x, y));
    }

    public Coords moveForward(Direction direction) {
        return switch (direction) {
            case NORTH -> new Coords(planet, position.x(), computeNewY(position.y() + 1));
            case SOUTH -> new Coords(planet, position.x(), computeNewY(position.y() - 1));
            case EAST -> new Coords(planet, computeNewX(position.x() - 1), position.y());
            case WEST -> new Coords(planet, computeNewX(position.x() + 1), position.y());
        };
    }

    public Coords moveBackward(Direction direction) {
        return switch (direction) {
            case NORTH -> new Coords(planet, position.x(), computeNewY(position.y() - 1));
            case SOUTH -> new Coords(planet, position.x(), computeNewY(position.y() + 1));
            case EAST -> new Coords(planet, computeNewX(position.x() + 1), position.y());
            case WEST -> new Coords(planet, computeNewX(position.x() - 1), position.y());
        };
    }

    public boolean isOnObstacle() {
        return planet.obstacles().contains(position);
    }
    public int computeNewX(int newX) {
        return Math.floorMod(newX-1, planet().xSize())+1;
    }

    private int computeNewY(int newY) {
        return Math.floorMod(newY-1, planet().ySize())+1;
    }

}