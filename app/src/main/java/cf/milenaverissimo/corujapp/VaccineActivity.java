package cf.milenaverissimo.corujapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;

public class VaccineActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    CheckBox cb1;
    CheckBox[] checkBoxes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        checkBoxes = new CheckBox[11];
        checkBoxes[1] = (CheckBox) findViewById(R.id.vaccine1);
        checkBoxes[2] = (CheckBox) findViewById(R.id.vaccine2);
        checkBoxes[3] = (CheckBox) findViewById(R.id.vaccine3);
        checkBoxes[4] = (CheckBox) findViewById(R.id.vaccine4);
        checkBoxes[5] = (CheckBox) findViewById(R.id.vaccine5);
        checkBoxes[6] = (CheckBox) findViewById(R.id.vaccine6);
        checkBoxes[7] = (CheckBox) findViewById(R.id.vaccine7);
        checkBoxes[8] = (CheckBox) findViewById(R.id.vaccine8);
        checkBoxes[9] = (CheckBox) findViewById(R.id.vaccine9);
        checkBoxes[10] = (CheckBox) findViewById(R.id.vaccine10);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        save(checkBoxes[1].isChecked(), 1);
        save(checkBoxes[2].isChecked(), 2);
        save(checkBoxes[3].isChecked(), 3);
        save(checkBoxes[4].isChecked(), 4);
        save(checkBoxes[5].isChecked(), 5);
        save(checkBoxes[6].isChecked(), 6);
        save(checkBoxes[7].isChecked(), 7);
        save(checkBoxes[8].isChecked(), 8);
        save(checkBoxes[9].isChecked(), 9);
        save(checkBoxes[10].isChecked(), 10);
    }
    @Override
    protected void onResume() {
        super.onResume();
        checkBoxes[1].setChecked(load(1));
        checkBoxes[2].setChecked(load(2));
        checkBoxes[3].setChecked(load(3));
        checkBoxes[4].setChecked(load(4));
        checkBoxes[5].setChecked(load(5));
        checkBoxes[6].setChecked(load(6));
        checkBoxes[7].setChecked(load(7));
        checkBoxes[8].setChecked(load(8));
        checkBoxes[9].setChecked(load(9));
        checkBoxes[10].setChecked(load(10));
    }

    @Override
    protected void onStop() {
        super.onStop();
        save(checkBoxes[1].isChecked(), 1);
        save(checkBoxes[2].isChecked(), 2);
        save(checkBoxes[3].isChecked(), 3);
        save(checkBoxes[4].isChecked(), 4);
        save(checkBoxes[5].isChecked(), 5);
        save(checkBoxes[6].isChecked(), 6);
        save(checkBoxes[7].isChecked(), 7);
        save(checkBoxes[8].isChecked(), 8);
        save(checkBoxes[9].isChecked(), 9);
        save(checkBoxes[10].isChecked(), 10);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            startActivity(new Intent(VaccineActivity.this, MenuActivity.class));

        } else if (id == R.id.nav_family) {
            startActivity(new Intent(VaccineActivity.this, FamilyActivity.class));

        } else if (id == R.id.nav_health) {
            startActivity(new Intent(VaccineActivity.this, HealthActivity.class));

        } else if (id == R.id.nav_fun) {
            startActivity(new Intent(VaccineActivity.this, FunActivity.class));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void save(final boolean isChecked, int id) {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("CORUJA", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("check" + id, isChecked);
        editor.commit();
    }

    private boolean load(int id) {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("CORUJA", Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("check" + id, false);
    }
}
