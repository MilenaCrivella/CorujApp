package cf.milenaverissimo.corujapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;
import java.util.StringTokenizer;

public class TextActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
{
    private TextView TextDevelopment;

    public static final String mPath = "development.txt";
    public QuoteBank mQuoteBank;
    public List<String> mLines;
    String development;
    String[] items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_development);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        String c = "";

        mQuoteBank = new QuoteBank(this);
        mLines = mQuoteBank.readLine(mPath);
        for (String string : mLines) {
            c += string;
        }
        development = c;
        items = development.split("@");

        Bundle extras = getIntent().getExtras();

        String currentItem = items[extras.getInt("number")];
        setTitle(currentItem.split("#")[0]);
        String currentDescription = currentItem.split("#")[1];
        TextDevelopment = (TextView) findViewById(R.id.Text1);
        TextDevelopment.setText(currentDescription);
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
            startActivity(new Intent(TextActivity.this, MenuActivity.class));

        } else if (id == R.id.nav_family) {
            startActivity(new Intent(TextActivity.this, FamilyActivity.class));

        } else if (id == R.id.nav_health) {
            startActivity(new Intent(TextActivity.this, HealthActivity.class));

        } else if (id == R.id.nav_fun) {
            startActivity(new Intent(TextActivity.this, FunActivity.class));

        } else if (id == R.id.nav_vaccine) {
            startActivity(new Intent(TextActivity.this, VaccineActivity.class));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
