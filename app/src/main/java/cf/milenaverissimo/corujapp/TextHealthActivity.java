package cf.milenaverissimo.corujapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.List;

public class TextHealthActivity extends AppCompatActivity
{
    private TextView TextHealth;

    public static final String mPath = "health.txt";
    public QuoteBank mQuoteBank;
    public List<String> mLines;
    String health;
    String[] items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_health);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String c = "";

        mQuoteBank = new QuoteBank(this);
        mLines = mQuoteBank.readLine(mPath);
        for (String string : mLines) {
            c += string;
        }
        health = c;
        items = health.split("@");

        Bundle extras = getIntent().getExtras();

        String currentItem = items[extras.getInt("number")];
        setTitle(currentItem.split("#")[0]);
        String currentDescription = currentItem.split("#")[1];
        TextHealth = (TextView) findViewById(R.id.Text1);
        TextHealth.setText(currentDescription);
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


    }

