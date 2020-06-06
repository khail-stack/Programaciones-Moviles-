package com.example.motorizapp.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.motorizapp.MotorizApp;
import com.example.motorizapp.models.Order;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class OrderService extends Service {

    public Timer timer;
    public TimerTask timerTask;
    public final Handler handler = new Handler();

    public String[] food = {
            "Bacon Burger",
            "Cajun Club Sandwich",
            "Guacamole Spicy Burger",
            "Ranch Sandwich",
            "Taco Cheese Burger",
            "Crispy Chicken Tacos",
            "Chicken Club Tacos",
            "Baby Back Ribs",
            "Ribs & Chicken Combo",
            "Wings Over Buffalo"
    };

    public String[] adress = {
            "Av. La Marina 2650 - San Miguel",
            "Jr. Pedro Conde 445 - Lince",
            "Av. Rafael Escardó 670 - San Miguel",
            "Av. Arequipa 2322 - Lince",
            "Av. Larco 1942 - Miraflores",
            "Av. Alameda El Corregidor 748 - La Molina",
            "Av. Petit Thours 2641 - Lince",
            "Av. Parque de las Leyendas 184 - San Miguel",
            "Av. Brasil 1427 - Magdalena",
            "Av. San Felipe 2796 - Jesús María"
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("OrderService", "--- Service Start ---");

        startTimer();

        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("OrderService", "--- Service Stop ---");
        stopTimer();
    }

    public void startTimer() {
        Log.i("OrderService", "--- Timer Start ---");

        //set a new Timer
        timer = new Timer();

        //initialize the TimerTask's job
        initializeTimerTask();

        //schedule the timer, after the first 5000ms the TimerTask will run every 5000ms
        timer.schedule(timerTask, 5*1000, 5*1000); //
    }

    public void stopTimer() {
        Log.i("OrderService", "--- Timer Stop ---");

        //stop the timer, if it's not already null
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    public void initializeTimerTask() {

        timerTask = new TimerTask() {
            public void run() {

                //use a handler to run a toast that shows the current timestamp
                handler.post(new Runnable() {
                    public void run() {
                        // Obtener la hora actual para pintar en el log
                        Calendar calendar = Calendar.getInstance();
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss a dd/MM/yyyy");
                        final String strDate = simpleDateFormat.format(calendar.getTime());

                        Log.i("OrderService", "Orden Generada a las " + strDate);

                        ((MotorizApp) getApplicationContext()).addOrder(createRandomOrder());

                        Intent intent = new Intent();
                        intent.setAction("pe.edu.tecsup.motizapp.NEW_ORDER_INTENT");
                        sendBroadcast(intent);
                    }
                });
            }
        };
    }

    public Order createRandomOrder() {
        return new Order("0" + randInt(), food[randInt()], adress[randInt()]);
    }

    public static int randInt() {
        Random rand = new Random();
        return rand.nextInt((9 - 1) + 1) + 1;
    }
}
