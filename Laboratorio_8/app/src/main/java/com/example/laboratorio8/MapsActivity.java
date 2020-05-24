package com.example.laboratorio8;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.example.laboratorio8.R;
import com.example.laboratorio8.models.Location;
import com.example.laboratorio8.models.Mapa;
import com.example.laboratorio8.models.Result;
import com.example.laboratorio8.services.ApiService;
import com.example.laboratorio8.services.ApiServiceGenerator;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Challenge;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final int REQUEST_CODE_ASK_PERMISSIONS = 100;

    private GoogleMap mMap;
    ArrayList<LatLng>arrayList= new ArrayList<LatLng>();
    //ArrayList<Location> latLngData = new ArrayList<Location>();
    //LatLng DonBelisario = new LatLng(-12.090602, -77.05247299999999);
    //LatLng Tito = new LatLng(-12.1280461, -76.9888581);
    //LatLng CarbonLeña = new LatLng(-12.0440349, -77.0302519);
    //LatLng William = new LatLng(-12.057357, -77.031561);
    //LatLng Carbon = new LatLng(-12.0885545, -77.0326544);
    //LatLng Pancho = new LatLng(-12.0752719, 77.0497386);
    //LatLng McDennys = new LatLng(-12.0644879, -77.0152789);
    //LatLng Corralito = new LatLng(-12.0661087, -77.0320823);
    //LatLng LaCasa = new LatLng(-12.0757403, -76.986498);
    //LatLng PollosAlaBrasaa = new LatLng(-12.0626973, -77.014528);
    //LatLng SaborPeruano = new LatLng(-12.0311301, -76.9996893);
    //LatLng Mendoza = new LatLng(-12.0283449, -76.99064849999999);
    //LatLng Okey = new LatLng(-12.0620208, -77.019489);
    //LatLng Tomi = new LatLng(-12.0794205, -77.0252608);
    //LatLng DonBayo = new LatLng(-12.0749819, -76.98255739999999);
    //LatLng CorralitosParrilladas = new LatLng(-12.0295735, -77.0356503);
    //LatLng ChickChicken = new LatLng(-12.0276854, -77.0088957);
    //LatLng Dragon = new LatLng(-12.0834588, -77.0351015);
    //LatLng Norty = new LatLng(-12.0472356, -76.9826009);
    //LatLng Chifa = new LatLng(-12.0513669, -77.042095);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


       // arrayList.add(DonBelisario);
        //arrayList.add(Tito);
        //arrayList.add(CarbonLeña);
        //arrayList.add(William);
        //arrayList.add(Carbon);
        //arrayList.add(Pancho);
        //arrayList.add(McDennys);
        ///arrayList.add(Corralito);
        ///arrayList.add(LaCasa);
        //arrayList.add(PollosAlaBrasaa);
        //*arrayList.add(SaborPeruano);
        //arrayList.add(Mendoza);
        //arrayList.add(Okey);
        //arrayList.add(Tomi);
        //arrayList.add(DonBayo);
        //arrayList.add(CorralitosParrilladas);
        //arrayList.add(ChickChicken);
        //arrayList.add(Dragon);
        //arrayList.add(Norty);
        //arrayList.add(Chifa);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        ApiService service = ApiServiceGenerator.createService(ApiService.class);
        Call<Mapa> call = service.getDataMarkers("-12.046373,-77.042755", "50000", "restaurant", "pollo%20a%20la%20brasa" , "AIzaSyAn8DpxSG8yU35XhtDeS5R_eMvBI8XXm2g");

        call.enqueue(new Callback<Mapa>() {
            @Override
            public void onResponse(Call<Mapa> call, Response<Mapa> response) {
                for (Result result : response.body().getResults()){
                    LatLng markerLocation = new LatLng(
                            result.getGeometry().getLocation().getLat(),
                            result.getGeometry().getLocation().getLng());
                    String markerTitle = result.getName();
                    mMap.addMarker(new MarkerOptions().position(markerLocation).title(markerTitle));
                }
            }

            @Override
            public void onFailure(Call<Mapa> call, Throwable t) {
                Toast.makeText(MapsActivity.this, "No pudimos recuperar el pollito a la brasa",
                        Toast.LENGTH_SHORT).show();
                Log.e(this.getClass().getName(),t.getMessage());
            }
        });
        //LatLng locationTecsup = new LatLng(-12.090602, -77.05247299999999);
        //CameraPosition cameraTecsup = new CameraPosition.Builder().target(locationTecsup).zoom(17).build();

          for(int i=0; i<arrayList.size();i++) {
            mMap.addMarker(
                    new MarkerOptions()
                            .position(arrayList.get(i))
                            .title("Marker")
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_marker)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(arrayList.get(i)));
        }



        // Muestra los botones de control de zoom de la cámara
        mMap.getUiSettings().setZoomControlsEnabled(true);

        // Permite al usuario cambiar el nivel de zoom mediante arrastre o gestura
        mMap.getUiSettings().setZoomGesturesEnabled(true);

        // Muestra la brújula en el mapa
        mMap.getUiSettings().setCompassEnabled(true);

        // Permite al usuario rotar el mapa mediante arrastre o gestura
        mMap.getUiSettings().setRotateGesturesEnabled(true);

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            int hasLocationPermission = checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION);

            if (hasLocationPermission != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        REQUEST_CODE_ASK_PERMISSIONS);

            } else if (hasLocationPermission == PackageManager.PERMISSION_GRANTED) {
                mMap.setMyLocationEnabled(true);
                mMap.getUiSettings().setMyLocationButtonEnabled(true);
            }

        } else {
            mMap.setMyLocationEnabled(true);
            mMap.getUiSettings().setMyLocationButtonEnabled(true);
        }
    }






    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if(REQUEST_CODE_ASK_PERMISSIONS == requestCode) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                mMap.setMyLocationEnabled(true);
                mMap.getUiSettings().setMyLocationButtonEnabled(true);
            } else {
                Toast.makeText(this, "No concedió los permisos :(", Toast.LENGTH_SHORT).show();
            }
        }else{
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }


}
