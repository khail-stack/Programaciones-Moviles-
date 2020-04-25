package patitas.com.pe.veteriapp.models;

import java.util.ArrayList;

public class Order {

    private String number;
    private String pet;
    private ArrayList<String> services;
    private String dateTime;

    public Order() {
    }

    public Order(String number, String pet, ArrayList<String> services, String dateTime) {
        this.number = number;
        this.pet = pet;
        this.services = services;
        this.dateTime = dateTime;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPet() {
        return pet;
    }

    public void setPet(String pet) {
        this.pet = pet;
    }

    public ArrayList<String> getServices() {
        return services;
    }

    public void setServices(ArrayList<String> services) {
        this.services = services;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}

