package fr.zenika.training;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlanetTest {
    @Test
    void planetShouldBeStrictlyPositive() {
        // ARRANGE & ACT & ASSERT
        assertThrows(IllegalArgumentException.class, () -> new Planet(0, 5));
        assertThrows(IllegalArgumentException.class, () -> new Planet(5, 0));
    }

}