package fr.zenika.training;

public enum Direction {
    NORTH, EAST, SOUTH, WEST;

    Direction turnLeft() {
        Direction[] directions = values();
        return directions[Math.floorMod(ordinal()-1, directions.length)];
    }

    Direction turnRight() {
        Direction[] directions = values();
        return directions[Math.floorMod(ordinal()+1, directions.length)];
    }
}
