package com.example.motorizapp.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.motorizapp.MotorizApp;
import com.example.motorizapp.R;
import com.example.motorizapp.adapters.OrdersAdapter;
import com.example.motorizapp.models.Order;
import com.example.motorizapp.service.OrderService;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OrdersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OrdersFragment extends Fragment {

    private RecyclerView rcvOrders;
    private List<Order> orders;
    private BroadcastReceiver ordersReceiver;
    private OrdersAdapter ordersAdapter;
    private CoordinatorLayout coordinatorLayout;

    public OrdersFragment() {
        // Required empty public constructor
    }

    public static OrdersFragment newInstance() {
        OrdersFragment fragment = new OrdersFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_orders, container, false);

        rcvOrders = (RecyclerView) view.findViewById(R.id.rcvOrders);
        coordinatorLayout = (CoordinatorLayout) view.findViewById(R.id.coordinatorLayout);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //test();
        getActivity().startService(new Intent(getActivity().getApplicationContext(), OrderService.class));

        ordersReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals("pe.edu.tecsup.motizapp.NEW_ORDER_INTENT")) {
                    ordersAdapter.notifyDataSetChanged();
                }
            }
        };

        initAdapter();
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().registerReceiver(ordersReceiver, new IntentFilter("pe.edu.tecsup.motizapp.NEW_ORDER_INTENT"));
        ordersAdapter.notifyDataSetChanged();
    }

    @Override
    public void onPause() {
        getActivity().unregisterReceiver(ordersReceiver);
        super.onPause();
    }

    public void test() {
        for (int i=0 ; i<10 ; i++) {
            String quantity;
            if (i+1 < 10) {
                quantity = "0" + String.valueOf(i+1);
            } else {
                quantity = String.valueOf(i+1);
            }
            Order order = new Order(quantity, "Bacon Cheese Burger", "Av. Siempre Viva 123");
            ((MotorizApp) getActivity().getApplicationContext()).addOrder(order);
        }
    }

    public void initAdapter() {
        orders = ((MotorizApp) getActivity().getApplicationContext()).getOrderList();
        ordersAdapter = new OrdersAdapter(getActivity(), orders, new OrdersAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String address) {
                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "Dirección: " + address, Snackbar.LENGTH_LONG);

                snackbar.show();
            }
        });

        rcvOrders.setAdapter(ordersAdapter);
        rcvOrders.setLayoutManager(
                new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
    }

}
