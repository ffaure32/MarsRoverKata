package fr.zenika.training;

import java.util.Set;

public class PlanetBuilder {
    private Set<Position> obstacles = Set.of();

    public static PlanetBuilder aPlanet() {
        return new PlanetBuilder();
    }

    public PlanetBuilder withObstacles(Set<Position> obstacles) {
        this.obstacles = obstacles;
        return this;
    }

    public Planet build() {
        return new Planet(5, 5, obstacles);
    }

}
