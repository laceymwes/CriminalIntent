package edu.cnm.deepdive.criminalintent.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import edu.cnm.deepdive.criminalintent.database.CrimeDBSchema.CrimeTable;
import edu.cnm.deepdive.criminalintent.database.CrimeDBSchema.CrimeTable.Cols;

public class CrimeBaseHelper extends SQLiteOpenHelper {

  private static final int VERSION = 1;
  private static final String DATABASE_NAME = "crimeBase.db";

  public CrimeBaseHelper(Context context){
    super(context, DATABASE_NAME, null, VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    db.execSQL("CREATE TABLE " + CrimeTable.NAME + "(" +
      " _id integer primary key autoincrement, " +
      Cols.UUID + ", " +
      Cols.TITLE + ", " +
      Cols.DATE + ", " +
      Cols.SOLVED + ")");
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

  }
}
