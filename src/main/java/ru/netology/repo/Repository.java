package ru.netology.repo;

import ru.netology.domain.Flight;

public class Repository {
    private Flight[] flights = new Flight[0];

    public void save(Flight flight) {
        int length = flights.length + 1;
        Flight[] tmp = new Flight[length];
        System.arraycopy(flights, 0, tmp, 0, flights.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = flight;
        flights = tmp;
    }

    public Flight[] findAll() {
        return flights;
    }

    public Flight findById(int id) {

        for (Flight flight : flights) {
            if (flight.getId() == id) {
                return flight;
            }
        }
        return null;
    }

    public Flight[] removeById(int id) {
//        if (findById(id) == null) throw new NotFoundException("Element with id: " + id + " not found");
        int length = flights.length - 1;
        Flight[] tmp = new Flight[length];
        int index = 0;
        for (Flight flight : flights) {
            if (flight.getId() != id) {
                tmp[index] = flight;
                index++;
            }
        }
        flights = tmp;
        return flights;
    }
}
