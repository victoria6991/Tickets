package ru.netology.manager;

import ru.netology.domain.Flight;
import ru.netology.repo.Repository;

import java.util.Arrays;

public class Manager {
    Repository repo = new Repository();

    public Manager(Repository repo) {
        this.repo = repo;
    }

    public void add(Flight flight) {
        repo.save(flight);
    }

    public Flight[] findAll(String from, String to) {
        Flight[] result = new Flight[0];
        for (Flight flight : repo.findAll()) {
            if (matches(flight, from, to)) {
                Flight[] tmp = new Flight[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = flight;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Flight flight, String from, String to) {
        if (flight.getDepartureAirport().contains(from) & flight.getArrivalAirport().contains(to)) {
            return true;
        }
            return false;
        }
    }
