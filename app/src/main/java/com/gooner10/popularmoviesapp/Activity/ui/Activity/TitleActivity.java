package com.gooner10.popularmoviesapp.Activity.ui.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RatingBar;
import android.widget.TextView;

import com.gooner10.popularmoviesapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TitleActivity extends AppCompatActivity {

    @Bind(R.id.textTitle)
    TextView mTitleText;

    @Bind(R.id.ratingBar2)
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);

        String title = this.getIntent().getStringExtra("title");
        ButterKnife.bind(this);

        mTitleText.setText(title);

        String rating = Rating.getInstance().getAverageRating();
        Float ratingAv = Float.valueOf(rating);
        ratingBar.setRating(ratingAv);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
