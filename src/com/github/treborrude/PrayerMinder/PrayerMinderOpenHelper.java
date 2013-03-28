package com.github.treborrude.PrayerMinder;
import android.database.sqlite.SQLiteOpenHelper;

class PrayerMinderOpenHelper extends SQLiteOpenHelper
{
  private static final String PM_DATABASE_NAME = "prayer_minder.db";
  private static final int PM_DATABASE_VERSION = 1;
  private static final String PRAYERS_TABLE_NAME = "prayers";
  private static final String PRAYERS_ID = "_id";
  private static final String PRAYERS_TITLE = "title";
  private static final String PRAYERS_DESCRIPTION = "description";
  private static final String PRAYERS_CREATED = "created";
  private static final String PRAYERS_MODIFIED = "modified";
  private static final String PRAYERS_ANSWERED = "answered";
  private static final String PRAYERS_LAST_PRAYED = "last_prayed";
  private static final String PRAYERS_TABLE_CREATE =
    "CREATE TABLE " + PRAYERS_TABLE_NAME + " (" +
    PRAYERS_ID + " INTEGER PRIMARY KEY, " +
    PRAYERS_TITLE + " TEXT NOT NULL, " +
    PRAYERS_DESCRIPTION + " TEXT, " +
    PRAYERS_CREATED + " TEXT NOT NULL DEFAULT CURRENT_DATETIME, " +
    PRAYERS_MODIFIED + " TEXT, " +
    PRAYERS_ANSWERED + " TEXT, " +
    PRAYERS_LAST_PRAYED + " INTEGER);";

  PrayerMinderOpenHelper(Context context)
  {
    super(context, PM_DATABASE_NAME, null, PM_DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase db)
  {
    db.execSQL(PRAYERS_TABLE_CREATE);
  }
}
