package com.koteswari.productsearchapp;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class ProductDataStore {

	    DataBaseHelper mDatabase_helper = null;
	    SQLiteDatabase mDatabase;
	    String mTableName ="products";
		Context context;

	    public ProductDataStore(Context context)
	    {
	        mDatabase_helper = DataBaseHelper.getDBAdapterInstance(context);
			this.context = context;

	    }

	    public ArrayList<ProductDataModel> getProducts(String queryString)
	    {
	        Cursor cursor = null;
	        ArrayList<ProductDataModel> arrOfitems = new ArrayList<ProductDataModel>();
			String KEY_NAME = "productname";

	        try
	        {
	            mDatabase = mDatabase_helper.getWritableDatabase();

				String selectQuery = "SELECT  * FROM " + mTableName + " WHERE productname LIKE '"+queryString+"%'";
				cursor = mDatabase.rawQuery(selectQuery, null);

	            if (cursor != null && cursor.moveToFirst()) {
	                do{

	                	ProductDataModel productDataModel = new ProductDataModel();
						productDataModel.setProductName(cursor.getString(cursor.getColumnIndex("productname")));
						productDataModel.setProductPrice(cursor.getString(cursor.getColumnIndex("productprice")));
						productDataModel.setProductDescription(cursor.getString(cursor.getColumnIndex("productDescription")));

						arrOfitems.add(productDataModel);
	                }while(cursor.moveToNext());

	            }else{


				}

	        }catch(Exception ex)
	        {

				ex.printStackTrace();
	        }
	        finally
	        {
	            cursor.close();
	            if (mDatabase != null)
	                mDatabase.close();

	        }
	        return arrOfitems;
	    }


	    public long insertValue(String name, String price, String description)
	    {

			long i = -1;
	        try
	        {
	            mDatabase = mDatabase_helper.getWritableDatabase();

	            ContentValues contentValues = new ContentValues();
				contentValues.put("productname", name);
	            contentValues.put("productprice", price);
				contentValues.put("productDescription", description);

				i = mDatabase.insert(mTableName, null, contentValues);


			}catch (Exception e) {
	            // TODO: handle exception
	            e.printStackTrace();
	        }finally
	        {
	            if (mDatabase != null)
	                mDatabase.close();
	        }

			return i;
	    }

	    public void deleteDataStore()
	    {
	        try
	        {

	            mDatabase = mDatabase_helper.getWritableDatabase();
	            mDatabase.execSQL("delete from " + mTableName);

	        }catch (Exception e) {
	            // TODO: handle exception
	            e.printStackTrace();
	        }finally
	        {
	            if (mDatabase != null)
	                mDatabase.close();
	        }

	    }

	    public void deleteDataRecord(String itemid)
	    {
	        try
	        {

	            mDatabase = mDatabase_helper.getWritableDatabase();
	            mDatabase.execSQL("delete from " + mTableName+  " where itemid ='" +  itemid +"'");

	        }catch (Exception e) {
	            // TODO: handle exception
	            e.printStackTrace();
	        }finally
	        {
	            if (mDatabase != null)
	                mDatabase.close();
	        }

	    }


	//deleting mails from database
		public void updateDataRecord(String itemname, String itemprice, String itemid)
		{
			try
			{
				
				mDatabase = mDatabase_helper.getWritableDatabase();
				//mDatabase.execSQL("update " + mTableName+  " set itemname = '" + itemname + "' + itemprice = '" + itemprice + "' where itemid ='" +  itemid +"'");
				//mDatabase.update(table, values, whereClause, whereArgs)
				
				ContentValues contentValues = new ContentValues();

	            contentValues.put("itemname", itemname);
	            contentValues.put("itemprice", itemprice);
	            
	            mDatabase.update(mTableName, contentValues, "itemid" + " = ?",
	                    new String[] { itemid });
			 }catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			 }finally
			 {
		        if (mDatabase != null)
		        	mDatabase.close();
			 }
			
		}
		


}
