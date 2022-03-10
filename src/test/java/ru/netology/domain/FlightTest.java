package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.Manager;
import ru.netology.repo.Repository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FlightTest {
    Flight one = new Flight(1, 5000, "SVO", "ASF", 120);
    Flight two = new Flight(2, 2000, "VKO", "ASF", 120);
    Flight three = new Flight(3, 3000, "DME", "ASF", 120);

    @Test
    void sortByPrice() {
        Flight[] expected = new Flight[]{two, three, one};
        Flight[] actual = new Flight[]{one, two, three};

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);
    }

}