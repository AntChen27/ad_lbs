package com.steam.adLBS.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * @author Antony
 * 
 *@email 1151355296@qq.com
 */
public class DBOpenHelper extends SQLiteOpenHelper
{
	private static final int VERSION = 1;
	public static final String DBNAME = "note_log.db";
	public static final String TABLENAME="note_mes";
	
	public DBOpenHelper(Context context)
	{
		super(context, DBNAME, null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db)
	{
		db.execSQL("create table "+TABLENAME+" (_id integer primary key autoincrement ,diarytitle text ,diarydata text,diarycontentfilepath text,imageid int)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		Log.i("StudentDAOTest", "UpGrade!");
		String tempTable = "temp_";
		db.execSQL("alter table "+TABLENAME +" rename to "+tempTable);
		db.execSQL("create table "+TABLENAME+" (_id integer paimary key autoincrement ,diarytitle text ,diarydata text,diarycontentfilepath text,imageid int)");

	}

}
