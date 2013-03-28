package rude.trebor.apps.PrayerMinder;

import android.app.Activity;
import android.os.Bundle;
import com.actionbarsherlock.app.SherlockFragmentActivity;

public class PrayerMinderMainActivity extends SherlockFragmentActivity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.PrayerList);
    }
}
