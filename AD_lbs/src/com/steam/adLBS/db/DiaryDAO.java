//package com.steam.adLBS.db;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.util.Log;
//
//public class DiaryDAO {
//	private DBOpenHelper helper;
//	private SQLiteDatabase db;
//	private String tag="DiaryDAO";
//
//	public DiaryDAO(Context context) {
//		helper = new DBOpenHelper(context);
//	}
//
//	/**
//	 * 添加新的日记记录
//	 * 
//	 * @param
//	 */
//	public void insert(Diary diary) {
//		db = helper.getWritableDatabase();
//		String sql = "insert into "
//				+ DBOpenHelper.TABLENAME
//				+ " (_id,diarytitle,diarydata,diarycontentfilepath,imageid) values(?,?,?,?,?)";
//
//		// db.execSQL("insert into t_student (sid,name,age) values (?,?,?)", new
//		// Object[]
//		// { student.getSid(), student.getName(), student.getAge() });
//		db.execSQL(sql, new Object[] { diary._id, diary.diarytitle,
//				diary.diarydata, diary.diarycontentfilepath, diary.imageId });
//	}
//
//	/**
//	 * 更新日记记录
//	 * 
//	 * @param student
//	 */
//	public void update(Diary diary) {
//		db = helper.getWritableDatabase();
//		db.execSQL(
//				"update "
//						+ DBOpenHelper.TABLENAME
//						+ " set diarytitle=?,diarydata=?,diarycontentfilepath=?,imageid=? where _id=?",
//				new Object[] { diary.diarytitle, diary.diarydata,
//						diary.diarycontentfilepath, diary.imageId, diary._id });
//	}
//
//	/**
//	 * 查找日记记录
//	 * 
//	 * @param _id
//	 * @return
//	 */
//	public Diary find(int _id) {
//		Diary diary = null;
//		db = helper.getWritableDatabase();
//		Cursor cursor = db.rawQuery("select * from " + DBOpenHelper.TABLENAME
//				+ " where _id = ?", new String[] { String.valueOf(_id) });
//		if (cursor.moveToNext()) {
//			diary = new Diary();
//			diary._id = cursor.getInt(cursor.getColumnIndex("_id"));
//			diary.diarytitle = cursor.getString(cursor
//					.getColumnIndex("diarytitle"));
//			diary.diarydata = cursor.getString(cursor
//					.getColumnIndex("diarydata"));
//			diary.diarycontentfilepath = cursor.getString(cursor
//					.getColumnIndex("diarycontentfilepath"));
//			diary.imageId = cursor.getInt(cursor.getColumnIndex("imageid"));
//		}
//		return diary;
//	}
//
//	/**
//	 * 刪除日记记录
//	 * 
//	 * @param _ids
//	 */
//	public void detele(Integer... _ids) {
//		if (_ids.length > 0) {
//			StringBuffer sb = new StringBuffer();
//			for (int i = 0; i < _ids.length; i++) {
//				sb.append('?').append(',');
//			}
//			sb.deleteCharAt(sb.length() - 1);
//			SQLiteDatabase database = helper.getWritableDatabase();
//			database.execSQL("delete from " + DBOpenHelper.TABLENAME
//					+ " where _id in (" + sb + ")", (Object[]) _ids);
//		}
//	}
//
//	/**
//	 * 获取日记记录
//	 * 
//	 * @param start
//	 *            起始位置
//	 * @param count
//	 *            数量
//	 * @return
//	 */
//	public List<Diary> getScrollData(int start, int count)
//	{
//		List<Diary> diaris = new ArrayList<Diary>();
//		db = helper.getWritableDatabase();
//		Cursor cursor = db.rawQuery("select * from "+DBOpenHelper.TABLENAME+" Account limit ?,?", new String[]{ String.valueOf(start), String.valueOf(count) });
//	
//		while (cursor.moveToNext())
//		{
//			diaris.add(new Diary(
//					cursor.getInt(cursor.getColumnIndex("_id")), 
//					cursor.getString(cursor.getColumnIndex("diarytitle")), 
//					cursor.getString(cursor.getColumnIndex("diarydata")),
//					cursor.getString(cursor.getColumnIndex("diarycontentfilepath")),
//					cursor.getInt(cursor.getColumnIndex("imageid")) ));
//		}
//		return diaris;
//	}
//	/**
//	 * 获取日记记录
//	 * 
//	 * @return
//	 */
//	public List<Diary> getAllData()
//	{
//		List<Diary> diaris = new ArrayList<Diary>();
//		db = helper.getWritableDatabase();
//
//		Cursor cursor=null;
//		String[] columns={"_id","diarytitle","diarydata","diarycontentfilepath","imageid"};
//		cursor=db.query(DBOpenHelper.TABLENAME, columns, null, null, null, null, null);
//		while (cursor.moveToNext())
//		{
////			HashMap item=new HashMap();
//			Diary diary = new Diary(
//					cursor.getInt(cursor.getColumnIndex("_id")), 
//					cursor.getString(cursor.getColumnIndex("diarytitle")), 
//					cursor.getString(cursor.getColumnIndex("diarydata")),
//					cursor.getString(cursor.getColumnIndex("diarycontentfilepath")),
//					cursor.getInt(cursor.getColumnIndex("imageid")));
//			Log.i(tag,"getAllData"+diary.toString() );
//			diaris.add( diary);
//		}
//		return diaris;
//	}
//	/**
//	 * 获取日记记录数量
//	 * 
//	 * @return
//	 */
//	public long getCount() {
//		db = helper.getWritableDatabase();
//		Cursor cursor = db.rawQuery("select count(_id) from "
//				+ DBOpenHelper.TABLENAME, null);
//		if (cursor.moveToNext()) {
//			return cursor.getLong(0);
//		}
//		return 0;
//	}
//}
