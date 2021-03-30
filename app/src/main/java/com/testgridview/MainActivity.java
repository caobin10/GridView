package com.testgridview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.testgridview.cn.R;

import java.util.ArrayList;
import java.util.List;

import com.testgridview.ui.MyGridAdapter;
import com.testgridview.ui.MyGridView;

public class MainActivity extends AppCompatActivity {
    private MyGridView gridview;
    private MyGridAdapter adapter;
    private List<Integer> imgList;
    private List<String> textList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        gridview = (MyGridView)findViewById(R.id.gridview) ;

        imgList = new ArrayList<>();
        textList = new ArrayList<>();
        for (int i = 0;i < 7;i++){
            imgList.add(R.mipmap.xxx);
            textList.add("test"+i);
        }
        adapter = new MyGridAdapter(this,imgList,textList);
        gridview.setAdapter(adapter);
        gridview.setOnItemClickListener(itemClickListener);
    }
    private GridView.OnItemClickListener itemClickListener = new GridView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(MainActivity.this, position+"", Toast.LENGTH_SHORT).show();
        }
    };
}
