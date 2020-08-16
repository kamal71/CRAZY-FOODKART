package com.crazyfoodkart.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.crazyfoodkart.Fragments.CostFragment;
import com.crazyfoodkart.Fragments.HomeFragment;
import com.crazyfoodkart.Fragments.ProfileFragment;
import com.crazyfoodkart.Fragments.SearchFragment;
import com.crazyfoodkart.R;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class MainActivity extends AppCompatActivity {

    // Widgets
    private ChipNavigationBar chipNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initializing all widgets
        initializeWidgets();

        // setting default item selected for ChipBottomNavBar
        chipNavigationBar.setItemSelected(R.id.home, true);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();

        // Setting item selection Listener for ChipBottomNavBar
        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                switch (i){
                    case R.id.home:
                        chipNavigationBar.setItemSelected(R.id.home, true);
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
                        break;
                    case R.id.search:
                        chipNavigationBar.setItemSelected(R.id.search, true);
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new SearchFragment()).commit();
                        break;
                    case R.id.cost:
                        chipNavigationBar.setItemSelected(R.id.cost, true);
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new CostFragment()).commit();
                        break;
                    case R.id.profile:
                        chipNavigationBar.setItemSelected(R.id.profile, true);
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new ProfileFragment()).commit();
                        break;
                }
            }
        });
    }

    private void initializeWidgets(){
        // We Will be Initializing our Widgets in this method.
        chipNavigationBar = findViewById(R.id.chipNavBar);
    }
}
