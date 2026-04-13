package com.turkcell;

public class MsCarRepository implements CarRepository {
    public void add(Car car){
        System.out.println("MS SQL ile eklendi");
    }
}
