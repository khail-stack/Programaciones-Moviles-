package patitas.com.pe.veteriapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import patitas.com.pe.veteriapp.R;
import patitas.com.pe.veteriapp.models.Order;

public class OrdersAdapter
        extends RecyclerView.Adapter<OrdersAdapter.OrdersViewHolder> {

    private List<Order> orders;
    private Context context;

    public static class OrdersViewHolder extends RecyclerView.ViewHolder {

        private TextView txtNumber;
        private TextView txtPet;
        private TextView txtServices;
        private TextView txtDateTime;

        public OrdersViewHolder(View itemView) {
            super(itemView);

            txtNumber = itemView.findViewById(R.id.txtNumber);
            txtPet = itemView.findViewById(R.id.txtPet);
            txtServices = itemView.findViewById(R.id.txtServices);
            txtDateTime = itemView.findViewById(R.id.txtDateTime);
        }

        public void bindMaterial(Order order) {

            String services = new String();

            for (int i=0 ; i<order.getServices().size() ; i++) {
                services = services + order.getServices().get(i);
                if (!(i+1 == order.getServices().size())) {
                    services = services + " - ";
                }
            }

            txtNumber.setText(order.getNumber());
            txtPet.setText(order.getPet());
            txtServices.setText(services);
            txtDateTime.setText(order.getDateTime());
        }

    }

    public OrdersAdapter(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public OrdersViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_order, viewGroup, false);

        OrdersViewHolder ordersViewHolder = new OrdersViewHolder(itemView);

        return ordersViewHolder;
    }

    @Override
    public void onBindViewHolder(OrdersViewHolder viewHolder, int pos) {
        Order item = orders.get(pos);

        viewHolder.bindMaterial(item);
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

}

