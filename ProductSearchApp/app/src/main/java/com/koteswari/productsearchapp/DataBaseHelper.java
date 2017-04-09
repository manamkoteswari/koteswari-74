package com.koteswari.productsearchapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper
{

	Context context = null;
	private static DataBaseHelper mDBConnection;

	private DataBaseHelper(Context context)
	{
		super(context, "products.db", null, 1);
		this.context = context;

	}

	public static synchronized DataBaseHelper getDBAdapterInstance(Context context)
	{
		if (mDBConnection == null) {
			mDBConnection = new DataBaseHelper(context);
		}
	    return mDBConnection;

	}

	@Override
	public void onCreate(SQLiteDatabase db)
	{

		db.execSQL("create table products ( _id int, productname varchar(200),productprice varchar(20), productDescription varchar(2000));");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}
}
