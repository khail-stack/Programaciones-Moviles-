package patitas.com.pe.veteriapp.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import patitas.com.pe.veteriapp.R;
import patitas.com.pe.veteriapp.VeteriApp;
import patitas.com.pe.veteriapp.adapters.PetsAdapter;
import patitas.com.pe.veteriapp.models.Pet;
import patitas.com.pe.veteriapp.utils.DividingLineDecoration;

/**
 * A simple {@link Fragment} subclass.
 */
public class PetsFragment extends Fragment {

    private RecyclerView rcvPets;
    private List<Pet> pets;

    public PetsFragment() {
        // Required empty public constructor
    }

    public static PetsFragment newInstance() {
        PetsFragment fragment = new PetsFragment();
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
        View view = inflater.inflate(R.layout.fragment_pets, container, false);

        rcvPets = (RecyclerView) view.findViewById(R.id.rcvPets);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        refresh();
    }

    @Override
    public void onResume() {
        super.onResume();

        refresh();
    }

    public void refresh() {
        pets = ((VeteriApp) getActivity().getApplicationContext()).getPetList();
        PetsAdapter materialsAdapter = new PetsAdapter(pets);

        rcvPets.setAdapter(materialsAdapter);
        rcvPets.addItemDecoration(new DividingLineDecoration(getActivity()));
        rcvPets.setLayoutManager(
                new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
    }
}


