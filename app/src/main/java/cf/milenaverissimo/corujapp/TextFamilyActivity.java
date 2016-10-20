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
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class TextFamilyActivity extends AppCompatActivity
{
    private TextView TextFamily;

    public static final String mPath = "family.txt";
    public QuoteBank mQuoteBank;
    public List<String> mLines;
    String family;
    String[] items;
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_family);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String c = "";

        mQuoteBank = new QuoteBank(this);
        mLines = mQuoteBank.readLine(mPath);
        for (String string : mLines) {
            c += string;
        }
        family = c;
        items = family.split("@");

        Bundle extras = getIntent().getExtras();

        String currentItem = items[extras.getInt("number")];
        setTitle(currentItem.split("#")[0]);
        String currentDescription = currentItem.split("#")[1];
        TextFamily = (TextView) findViewById(R.id.TextFamily);
        TextFamily.setText(currentDescription);
    }
}
