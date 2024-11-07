package com.example.lab1_ph24718.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.lab1_ph24718.DBHelper.MyDBHelper;
import com.example.lab1_ph24718.DTO.CatDTO;

import java.util.ArrayList;

public class CatDAO {
    MyDBHelper dbHelper;
    SQLiteDatabase db;

    public CatDAO(Context context){
        dbHelper = new MyDBHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    // ham them du lieu
    public int AddRow(CatDTO objCat){
        ContentValues v = new ContentValues();
        v.put("name" , objCat.getName());
        int kq = (int) db.insert("tb_cat" , null , v);

        return kq;
    }

    public boolean updateRow(CatDTO objCat) {
        ContentValues values = new ContentValues();
        values.put("name", objCat.getName());

        int result = db.update("tb_cat", values, "id = ?", new String[]{String.valueOf(objCat.getId())});
        if (result > 0) {
            Log.d("CatDAO", "updateRow: Cập nhật thành công, id = " + objCat.getId());
            return true;
        } else {
            Log.d("CatDAO", "updateRow: Không tìm thấy dòng có id = " + objCat.getId());
            return false;
        }
    }

    public boolean deleteRow(CatDTO objCat) {
        int result = db.delete("tb_cat", "id = ?", new String[]{String.valueOf(objCat.getId())});
        if (result > 0) {
            Log.d("CatDAO", "deleteRow: Đã xóa dòng có id = " + objCat.getId());
            return true;
        } else {
            Log.d("CatDAO", "deleteRow: Không tìm thấy dòng có id = " + objCat.getId());
            return false;
        }
    }



    // ham lay danh sach
    public ArrayList<CatDTO> getList(){
        ArrayList<CatDTO> listCat = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT * FROM tb_cat ORDER BY id ASC" , null);
        if (c != null && c.getCount()>0){
            c.moveToFirst();
            //duyet vong lap
            //thu tu id 0 , name 1
            do {
                CatDTO objCat = new CatDTO();
                objCat.setId(c.getInt(0));
                objCat.setName(c.getString(1));
                listCat.add(objCat);
            }while (c.moveToNext());
        }else {
            Log.d("zzzzzz", "CatDAO::getList: Khong lay duoc du lieu ");
        }
        return listCat;
    }
}
