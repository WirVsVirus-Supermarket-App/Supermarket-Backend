package com.supermarket.backend.entities.reduced;

import java.time.LocalTime;

/**
 * @author Johannes Theiner
 **/
public class ReducedTimeslot {

    private LocalTime begin;
    private LocalTime end;
    private int reservations;


    public ReducedTimeslot(LocalTime begin, LocalTime end, int reservations) {
        this.begin = begin;
        this.end = end;
        this.reservations = reservations;
    }

    public LocalTime getBegin() {
        return begin;
    }

    public void setBegin(LocalTime begin) {
        this.begin = begin;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }

    public int getReservations() {
        return reservations;
    }

    public void setReservations(int reservations) {
        this.reservations = reservations;
    }
}