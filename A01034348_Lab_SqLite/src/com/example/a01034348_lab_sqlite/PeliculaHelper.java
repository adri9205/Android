package com.example.a01034348_lab_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class PeliculaHelper extends SQLiteOpenHelper {
	private static final int DATABASE_VERSION=1;
	private static final String DATABASE_NAME="peliculaDB.db";
	public static final String TABLE_PELICULAS="peliculas";
	public static final String COLUMN_ID="_id";
	public static final String COLUMN_NAME="name";
	public static final String COLUMN_RANKING="ranking";
	
	
	public PeliculaHelper(Context context) {
		super(context,"DATABASE_NAME",null,DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		// TODO Auto-generated method stub
		String CREATE_PELICULAS_TABLE="CREATE TABLE " +
		TABLE_PELICULAS+ "("+ COLUMN_ID+ " INTEGER PRIMARY KEY,"+
				COLUMN_NAME +" TEXT,"+
		COLUMN_RANKING +" INTEGER"+");";
		db.execSQL(CREATE_PELICULAS_TABLE);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		Log.w(PeliculaHelper.class.getName(),"Upgrading database from version "+ oldVersion+"to"+newVersion+", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS" + TABLE_PELICULAS);
		onCreate(db);

	}

}


