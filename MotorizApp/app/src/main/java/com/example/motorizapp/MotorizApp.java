package com.example.motorizapp;

import android.app.Application;
import android.util.Log;

import com.example.motorizapp.models.Order;

import java.util.ArrayList;

public class MotorizApp extends Application {
    public ArrayList<Order> orderList = new ArrayList<>();

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public void addOrder(Order order) {
        orderList.add(order);
        Log.i("MotorizApp", "Ahora hay " + orderList.size() + " elementos.");
    }

}
