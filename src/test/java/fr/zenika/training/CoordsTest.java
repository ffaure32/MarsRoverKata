package fr.zenika.training;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CoordsTest {

    @Test
    void CoordsShouldBeStrictlyPositive() {
        // ARRANGE & ACT & ASSERT
        assertThrows(IllegalArgumentException.class, () -> new Coords(new Planet(5, 5), 0, 1));
        assertThrows(IllegalArgumentException.class, () -> new Coords(new Planet(5, 5), 1, 0));
    }
}