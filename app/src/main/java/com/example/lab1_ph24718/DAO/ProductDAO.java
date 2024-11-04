package com.example.lab1_ph24718.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.lab1_ph24718.DBHelper.MyDBHelper;
import com.example.lab1_ph24718.DTO.CatDTO;
import com.example.lab1_ph24718.DTO.ProductDTO;

import java.util.ArrayList;

public class ProductDAO {
    MyDBHelper dbHelper;
    SQLiteDatabase db;

    public ProductDAO(Context context){
        dbHelper = new MyDBHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    // ham them du lieu
    public int AddProduct(ProductDTO objProduct){
        ContentValues v = new ContentValues();
        v.put("name" , objProduct.getName());
        v.put("price",objProduct.getPrice());
        v.put("id_cat",objProduct.getId_cat());
        int kq = (int) db.insert("tb_product" , null , v);

        return kq;
    }

    // ham lay danh sach
    public ArrayList<ProductDTO> getList(){
        ArrayList<ProductDTO> listProduct = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT * FROM tb_product ORDER BY id ASC" , null);
        if (c != null && c.getCount()>0){
            c.moveToFirst();
            //duyet vong lap
            //thu tu id 0 , name 1
            do {
                ProductDTO objProduct = new ProductDTO();
                objProduct.setId(c.getInt(0));
                objProduct.setName(c.getString(1));
                objProduct.setPrice(c.getDouble(2));
                objProduct.setId_cat(c.getInt(3));
                listProduct.add(objProduct);
            }while (c.moveToNext());
        }else {
            Log.d("zzzzzz", "ProductDAO::getList: Khong lay duoc du lieu ");
        }
        return listProduct;
    }
}
