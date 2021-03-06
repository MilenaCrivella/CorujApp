package cf.milenaverissimo.corujapp;

import android.content.Intent;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class FamilyActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
{
    String[] items;
    int number;
    String[] Tips;
    public QuoteBank mQuoteBank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        SendTitle();
        MyListView();
    }

    private void SendTitle(){
        final String mPath = "family.txt";
        mQuoteBank = new QuoteBank(this);
        List<String> mLines;
        String family;
        String c = "";

        mQuoteBank = new QuoteBank(this);
        mLines = mQuoteBank.readLine(mPath);
        for (String string : mLines) {
            c += string;
        }
        family = c;
        items = family.split("@");
        number = items.length;
    }

    private void MyListView(){
        SendTitle();
        Tips = new String[number];
        for(int i = 0; i < number; i++){
            Tips[i] = items[i].split("#")[0];
        }

        ListView List = (ListView) findViewById(R.id.ListFamily);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, R.layout.listview_style, R.id.textView2, Tips);
        List.setAdapter(myAdapter);

        List.getLayoutParams().height = 100 * number;
        List.requestLayout();
        List.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent SendText = new Intent(FamilyActivity.this, TextFamilyActivity.class);
                SendText.putExtra("number", position);
                startActivity(SendText);
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
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_home) {
            startActivity(new Intent(FamilyActivity.this, MenuActivity.class));

        } else if (id == R.id.nav_family) {
            startActivity(new Intent(FamilyActivity.this, FamilyActivity.class));

        } else if (id == R.id.nav_health) {
            startActivity(new Intent(FamilyActivity.this, HealthActivity.class));

        } else if (id == R.id.nav_fun) {
            startActivity(new Intent(FamilyActivity.this, FunActivity.class));

        }else if (id == R.id.nav_vaccine) {
            startActivity(new Intent(FamilyActivity.this, VaccineActivity.class));

        }

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
