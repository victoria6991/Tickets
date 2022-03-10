package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Flight implements Comparable<Flight> {
    int id;
    int price;
    String departureAirport;
    String arrivalAirport;
    int time;

    @Override
    public int compareTo(Flight o) {
        return this.price - o.price;
    }
}
