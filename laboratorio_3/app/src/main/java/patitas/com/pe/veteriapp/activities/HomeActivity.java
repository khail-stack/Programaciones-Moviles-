package patitas.com.pe.veteriapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;

import patitas.com.pe.veteriapp.R;
import patitas.com.pe.veteriapp.activities.NewOrderActivity;
import patitas.com.pe.veteriapp.activities.NewPetActivity;
import patitas.com.pe.veteriapp.adapters.TabsPagerAdapter;


public class HomeActivity extends AppCompatActivity {

    private TabsPagerAdapter tabsPagerAdapter;
    private ViewPager container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        MaterialToolbar toolbar = findViewById(R.id.tlbMain);
        setSupportActionBar(toolbar);

        tabsPagerAdapter = new TabsPagerAdapter(
                getSupportFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,
                getApplicationContext());

        container = findViewById(R.id.vwpMain);
        container.setAdapter(tabsPagerAdapter);

        TabLayout tabs = findViewById(R.id.tblMain);
        tabs.setupWithViewPager(container);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_new_pet) {
            Intent intent = new Intent(HomeActivity.this, NewPetActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_new_order) {
            Intent intent = new Intent(HomeActivity.this, NewOrderActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
