package cf.milenaverissimo.corujapp;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
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
import android.widget.ImageView;
import android.widget.TextView;


public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ImageView BttFamiy;
    ImageView BttHealth;
    ImageView BttFun;
    TextView MenuTips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ButtonClick();
    }

    public void ButtonClick(){
        BttFamiy = (ImageView)findViewById(R.id.bttFamily);
        BttFun = (ImageView) findViewById(R.id.bttFun);
        BttHealth = (ImageView) findViewById(R.id.bttHealth);

        BttFamiy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {
                startActivity(new Intent(MenuActivity.this, FamilyActivity.class));
            }
        });
        BttFun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {
                startActivity(new Intent(MenuActivity.this, FunActivity.class));
            }
        });
        BttHealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {
                startActivity(new Intent(MenuActivity.this, HealthActivity.class));
            }
        });
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            startActivity(new Intent(MenuActivity.this, MenuActivity.class));

        } else if (id == R.id.nav_family) {
            startActivity(new Intent(MenuActivity.this, FamilyActivity.class));

        } else if (id == R.id.nav_health) {
            startActivity(new Intent(MenuActivity.this, HealthActivity.class));

        } else if (id == R.id.nav_fun) {
            startActivity(new Intent(MenuActivity.this, FunActivity.class));

        } else if (id == R.id.nav_vaccine) {
            startActivity(new Intent(MenuActivity.this, VaccineActivity.class));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
