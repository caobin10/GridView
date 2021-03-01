package com.datab.cn;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import sqlite.DbHelper;

public class DatabActivity extends AppCompatActivity {
    private DbHelper helper = new DbHelper(this);
    private SQLiteDatabase db;
    private TextView tv ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final EditText insert_et = (EditText)findViewById(R.id.et);
        Button insert =(Button)findViewById(R.id.button1);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData(insert_et.getText().toString().trim());
            }
        });
        Button query =(Button)findViewById(R.id.button2);
        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                queryData();
            }
        });
        tv = (TextView)findViewById(R.id.textv);
//        //打开数据库输出流
//        SQLdm s = new SQLdm();
//        SQLiteDatabase db =s.openDatabase(getApplicationContext());
//
//        TextView textv = (TextView) findViewById(R.id.textv);
//        //查询数据库中testid=1的数据
//        Cursor cursor = db.rawQuery("select * from testbiao where id=?", new String[]{"1"});
//        String name = null;
//        if(cursor.moveToFirst()){
//            name = cursor.getString(cursor.getColumnIndex("name"));
//        }
//        //这是一个TextView，把得到的数据库中的name显示出来.
//        textv.setText(name);
//        cursor.close();
    }

    private void insertData(String s) {
        if (s != null){
            db = helper.getWritableDatabase();
            db.execSQL("insert into testbiao(name) values('" + s + "')");
            db.close();
        }
    }
    //模糊查询数据
    private void queryData() {
        String tempName="";
        String s = "";
        Cursor cursor = helper.getReadableDatabase().rawQuery(
                "select id as _id,name from testbiao where name like '%" + tempName + "%' order by id desc ", null);
        if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()){
            Toast.makeText(this, "读取数据成功！" + cursor.getCount(), Toast.LENGTH_SHORT).show();
//            if(cursor.moveToNext()) {
//                cursor.moveToFirst();
            do {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                if (name != null && !name.equals("")) {
                    s = s +name +"===";
                }
            } while (cursor.moveToNext());
            cursor.close();
            tv.setText(s);
        }else {
            Toast.makeText(this, "读取数据失败！", Toast.LENGTH_SHORT).show();
        }
    }
}
