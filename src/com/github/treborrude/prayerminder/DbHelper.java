package com.github.treborrude.prayerminder;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

class DbHelper extends SQLiteOpenHelper
{
  private static final String PM_DATABASE_NAME = "prayer_minder.db";
  private static final int PM_DATABASE_VERSION = 1;

  static class PrayersTable implements BaseColumns
  {
    static final String NAME = "prayers";
    static final String TITLE = "title";
    static final String DESCRIPTION = "description";
    static final String CREATED = "created";
    static final String MODIFIED = "modified";
    static final String ANSWERED = "answered";
    static final String LAST_PRAYED = "last_prayed";

    static final String CREATE_TABLE =
    "CREATE TABLE " + NAME + " (" +
    _ID + " INTEGER PRIMARY KEY, " +
    TITLE + " TEXT NOT NULL, " +
    DESCRIPTION + " TEXT, " +
    CREATED + " TEXT NOT NULL DEFAULT CURRENT_DATETIME, " +
    MODIFIED + " TEXT, " +
    ANSWERED + " TEXT, " +
    LAST_PRAYED + " INTEGER);";

    private PrayersTable(){} // Prevent instantiation.
  }

  static class TagsTable implements BaseColumns
  {
    static final String NAME = "tags";
    static final String TAG = "tag";
    static final String SYSTEM = "system";

    static final String CREATE_TABLE =
    "CREATE TABLE " + NAME + " (" +
    _ID + " INTEGER PRIMARY KEY, " +
    TAG + " TEXT NOT NULL, " +
    SYSTEM + " INTEGER NOT NULL);";

    private TagsTable(){} // Prevent instantiation.
  }

  static class PrayersTagsJunctionTable // I don't think I need BaseColumns in this case.
  {
    static final String NAME = "prayerstagsjunction";
    static final String PRAYER_ID = "prayerid";
    static final String TAG_ID = "tagid";

    static final String CREATE_TABLE =
    "CREATE TABLE " + NAME + " (" +
    PRAYER_ID + " REFERENCES " + PrayersTable.NAME + " (" + PrayersTable._ID + "), " +
    TAG_ID + " REFERENCES " + TagsTable.NAME + " (" + TagsTable._ID + "), " +
    "PRIMARY KEY (" + PRAYER_ID + ", " + TAG_ID + ") )";

    private PrayersTagsJunctionTable(){} // Prevent instantiation.
  }

  DbHelper(Context context)
  {
    super(context, PM_DATABASE_NAME, null, PM_DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase db)
  {
    db.execSQL(PrayersTable.CREATE_TABLE);
    db.execSQL(TagsTable.CREATE_TABLE);
    db.execSQL(PrayersTagsJunctionTable.CREATE_TABLE);

    ContentValues tagInfo;
    tagInfo.put("system", 1);

    tagInfo.put("tag", "Answered");
    db.insert(TagsTable.NAME, null, tagInfo);

    tagInfo.put("system", 0);

    tagInfo.put("tag", "Praises");
    db.insert(TagsTable.NAME, null, tagInfo);

    tagInfo.put("tag", "Healing");
    db.insert(TagsTable.NAME, null, tagInfo);

    tagInfo.put("tag", "Confessions");
    db.insert(TagsTable.NAME, null, tagInfo);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
  {
  }
}
