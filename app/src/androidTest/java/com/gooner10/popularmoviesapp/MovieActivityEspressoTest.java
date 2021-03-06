package com.gooner10.popularmoviesapp;

import android.content.Intent;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MovieActivityEspressoTest {

    @Rule
    public final ActivityTestRule<MovieActivity> mActivityRule = new ActivityTestRule<>(MovieActivity.class);

//    public MovieActivityEspressoTest() {
//        super(MovieActivity.class);
//    }

    MovieActivity mActivity;

    @Test
    public void customIntentToStartActivity() {
        Intent intent = new Intent();
        mActivity = mActivityRule.launchActivity(intent);
    }

//    onRecyclerItemView(R.id.item_title, withText("Test"),  withId(R.id.item_content))
//            .matches(check(withText("Test Content")));


}
