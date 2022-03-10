package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Flight;
import ru.netology.repo.Repository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    Flight one = new Flight(1, 6000, "SVO", "ASF", 120);
    Flight two = new Flight(2, 2000, "VKO", "ASF", 120);
    Flight three = new Flight(3, 3000, "DME", "ASF", 120);
    Flight four = new Flight(4, 5000, "SVO", "ASF", 120);

    Manager manager = new Manager(new Repository());

    @BeforeEach
    void save() {
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
    }

    @Test
    void returnTwoRelevant() {
        Flight[] expected = {four, one};
        Flight[] actual = manager.findAll("SVO", "ASF");
        Arrays.sort(actual);
        assertArrayEquals(expected,actual);
    }

    @Test
    void returnOneRelevant() {
        Flight[] expected = {two};
        Flight[] actual = manager.findAll("VKO", "ASF");
        Arrays.sort(actual);
        assertArrayEquals(expected,actual);
    }

    @Test
    void returnNothing() {
        Flight[] expected = {};
        Flight[] actual = manager.findAll("ASF", "ASF");
        Arrays.sort(actual);
        assertArrayEquals(expected,actual);
    }
}