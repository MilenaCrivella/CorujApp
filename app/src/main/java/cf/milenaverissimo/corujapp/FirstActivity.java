package cf.milenaverissimo.corujapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

public class FirstActivity extends AppCompatActivity {

    private final static int SPLASH_TIME_OUT = 2500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(FirstActivity.this, MenuActivity.class);
                startActivity(i);

                finish();
            }
        }, SPLASH_TIME_OUT);

        ImageView logotype = (ImageView)findViewById(R.id.logo);
        scaleView(logotype);
    }
    public void scaleView(ImageView l) {

        /*Animation anim = new ScaleAnimation(
                1f, 1f, 0f, 0.6f,
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 1f);
        anim.setFillAfter(true);
        l.startAnimation(anim);*/
    }

}
