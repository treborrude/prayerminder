package rude.trebor.apps.PrayerMinder;

import android.test.ActivityInstrumentationTestCase2;

/**
 * This is a simple framework for a test of an Application.  See
 * {@link android.test.ApplicationTestCase ApplicationTestCase} for more information on
 * how to write and extend Application tests.
 * <p/>
 * To run this test, you can type:
 * adb shell am instrument -w \
 * -e class rude.trebor.apps.PrayerMinder.PrayerMinderTest \
 * rude.trebor.apps.PrayerMinder.tests/android.test.InstrumentationTestRunner
 */
public class PrayerMinderTest extends ActivityInstrumentationTestCase2<PrayerMinder> {

    public PrayerMinderTest() {
        super("rude.trebor.apps.PrayerMinder", PrayerMinder.class);
    }

}
