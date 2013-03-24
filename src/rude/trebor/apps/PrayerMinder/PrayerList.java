package rude.trebor.apps.PrayerMinder;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class PrayerMinder extends FragmentActivity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}
