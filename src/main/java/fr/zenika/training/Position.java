package fr.zenika.training;

public record Position(int x, int y) {
    public Position {
        if (x <= 0 || y <= 0) throw new IllegalArgumentException("coords should be strictly positive");
    }
}
