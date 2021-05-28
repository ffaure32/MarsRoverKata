package fr.zenika.training;

import java.util.Set;

public record Planet(int xSize, int ySize, Set<Position> obstacles) {
    public Planet {
        if (xSize <= 0 || ySize <= 0) throw new IllegalArgumentException("planet size should be strictly positive");
    }

    public Planet(int xSize, int ySize) {
        this(xSize, ySize, Set.of());
    }
}
