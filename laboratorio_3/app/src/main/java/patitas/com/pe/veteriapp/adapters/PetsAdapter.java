package patitas.com.pe.veteriapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import patitas.com.pe.veteriapp.R;
import patitas.com.pe.veteriapp.models.Pet;

public class PetsAdapter
        extends RecyclerView.Adapter<PetsAdapter.PetsViewHolder> {

    private List<Pet> pets;
    private Context context;

    public static class PetsViewHolder extends RecyclerView.ViewHolder {

        private TextView txtName;
        private TextView txtRace;
        private TextView txtAge;
        private TextView txtSex;

        public PetsViewHolder(View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txtName);
            txtRace = itemView.findViewById(R.id.txtRace);
            txtAge = itemView.findViewById(R.id.txtAge);
            txtSex = itemView.findViewById(R.id.txtSex);
        }

        public void bindMaterial(Pet pet) {
            txtName.setText(pet.getName());
            txtRace.setText(pet.getRace());
            txtSex.setText(pet.getSex());

            if (pet.getAge() == 1) {
                txtAge.setText(
                        String.format("%s %s", String.valueOf(pet.getAge()), "año"));
            } else {
                txtAge.setText(
                        String.format("%s %s", String.valueOf(pet.getAge()), "años"));
            }
        }

    }

    public PetsAdapter(List<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public PetsViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_pet, viewGroup, false);

        PetsViewHolder petsViewHolder = new PetsViewHolder(itemView);

        return petsViewHolder;
    }

    @Override
    public void onBindViewHolder(PetsViewHolder viewHolder, int pos) {
        Pet item = pets.get(pos);

        viewHolder.bindMaterial(item);
    }

    @Override
    public int getItemCount() {
        return pets.size();
    }

}
