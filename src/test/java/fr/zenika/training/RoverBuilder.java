package fr.zenika.training;

public class RoverBuilder {
    static final Position DEFAULT_POSITION = new Position(1,1);

    private Direction direction = Direction.NORTH;
    private PlanetBuilder planetBuilder = new PlanetBuilder();
    private Position landingPosition = DEFAULT_POSITION;

    public static RoverBuilder aRover() {
        return new RoverBuilder();
    }

    public RoverBuilder withDirection(Direction direction) {
        this.direction = direction;
        return this;
    }

    public RoverBuilder landingOnPosition(Position landingPosition) {
        this.landingPosition = landingPosition;
        return this;
    }

    public RoverBuilder landingOnPlanet(PlanetBuilder planetBuilder) {
        this.planetBuilder = planetBuilder;
        return this;
    }

    public MarsRover build() {
        return new MarsRover(new Coords(planetBuilder.build(), landingPosition), direction);
    }

}
