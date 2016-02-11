import com.gooner10.popularmoviesapp.Activity.ui.activity.MovieActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static junit.framework.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
public class MovieActivityTest {

    private MovieActivity movieActivity;

    @Before
    public void setup() {
        // start MovieActivity, call through to onCreate()
        movieActivity = Robolectric.buildActivity(MovieActivity.class)
                .create().get();
    }

    @Test
    public void checkActivityNotNull() throws Exception {
        assertNotNull(movieActivity);
    }


    @Test
    public void clickingRecyclerViewItem_shouldStartDetailView() {

    }
}
