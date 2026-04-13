package com.turkcell;

public class Car extends Vehicle {
    
    public Car(boolean hasSunroof, String brand) {
        super(); // Vehicle'ın constructor'ını çağırır.
        this.setHasSunroof(hasSunroof);
        super.setBrand(brand); // -> Super => Vehicle classını (kalıtım aldığım class)
    }
    public Car() {
    }

    private boolean hasSunroof;
    private String[] specs;

    // Encapsulation => Dışarıdan manipülasyona kapalı.
    public String[] getSpecs() {
        return specs.clone();
    }
    public void setSpecs(String[] specs) {
        this.specs = specs.clone();
    }
    // Değerlerini al, referansı alma.
    public boolean isHasSunroof() {
        return hasSunroof;
    }
    public void setHasSunroof(boolean hasSunroof) {
        this.hasSunroof = hasSunroof;
    }
}
