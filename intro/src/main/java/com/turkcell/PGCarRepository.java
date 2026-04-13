package com.turkcell;

public class PGCarRepository implements CarRepository {
    public void add(Car car){
        System.out.println("Postgre SQL ile eklendi");
    }
}
