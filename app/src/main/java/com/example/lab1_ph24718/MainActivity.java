package com.example.lab1_ph24718;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab1_ph24718.Adapter.CatAdapter;
import com.example.lab1_ph24718.DAO.CatDAO;
import com.example.lab1_ph24718.DTO.CatDTO;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn_cate , btn_pro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn_cate = findViewById(R.id.btn_category_act);
        btn_pro =  findViewById(R.id.btn_product_act);

        btn_cate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển sang màn hình CategoryActivity
                Intent intent = new Intent(MainActivity.this, Category_Activity.class);
                startActivity(intent);
            }
        });

        btn_pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển sang màn hình ProductActivity
                Intent intent = new Intent(MainActivity.this, Product_Activity.class);
                startActivity(intent);
            }
        });
    }
 }
