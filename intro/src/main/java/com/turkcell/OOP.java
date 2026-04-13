package com.turkcell;

public class OOP {
    public static void main(String[] args) {
        Car car1 = new Car(); // new Car(); 
        // yeni bir araba nesnesi örneği (instance) üret
        car1.setBrand("BMW"); // set işlemi (değer atama)
        car1.setModel("x5");
        car1.setYear(2000);
        car1.setPricePerDay(-500.0);

        System.out.println(car1.getBrand()); // get işlemi (değer okuma)
        System.out.println(car1.getPricePerDay()); // private olduğu için erişilemez
    }

}
