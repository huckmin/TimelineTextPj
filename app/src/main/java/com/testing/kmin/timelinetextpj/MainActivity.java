package com.testing.kmin.timelinetextpj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private List<ItemData> itemList = new ArrayList<ItemData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setDatas();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_continer);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        mAdapter = new MyAdapter(getApplicationContext(),itemList); //list를 넘겨준다.
        recyclerView.setAdapter(mAdapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (!recyclerView.canScrollVertically(1)) {
//                    Toast.makeText(getApplicationContext(),"LAst",Toast.LENGTH_SHORT).show();
//bottom event
                    if(itemList.size() <= 9){
                        itemList.add(new ItemData( ItemData.TYPE_COL_ONE, "6번제목","2018년 1월 6일" ,"여섯번째 내용입니다.","" ));
                        itemList.add(new ItemData( ItemData.TYPE_COL_ONE, "7번제목","2018년 1월 7일" ,"일곱번째 내용입니다.","" ));
                        itemList.add(new ItemData( ItemData.TYPE_COL_ONE, "8번제목","2018년 1월 8일" ,"여덜번째 내용입니다.","" ));
                        itemList.add(new ItemData( ItemData.TYPE_COL_ONE, "9번제목","2018년 1월 9일" ,"아홉번째 내용입니다.","" ));
                        itemList.add(new ItemData( ItemData.TYPE_COL_ONE, "10번제목","2018년 1월 10일" ,"열번째 내용입니다.","" ));
                        mAdapter.notifyItemInserted(itemList.size()-1);
                    }

                }
            }
        });
    }

    private void setDatas(){

        itemList.add(new ItemData( ItemData.TYPE_COL_ONE, "1번제목","2018년 1월 1일" ,"첫번째 내용입니다.",""  ));
        itemList.add(new ItemData( ItemData.TYPE_COL_TWO, "2번제목","2018년 1월 2일" ,"두번째 내용입니다.","하고싶은"  ));
        itemList.add(new ItemData( ItemData.TYPE_COL_TWO, "3번제목","2018년 1월 3일" ,"세번째 내용입니다.","먹고싶은"  ));
        itemList.add(new ItemData( ItemData.TYPE_COL_ONE, "4번제목","2018년 1월 4일" ,"네번째 내용입니다.",""  ));
        itemList.add(new ItemData( ItemData.TYPE_COL_ONE, "5번제목","2018년 1월 5일" ,"다섯번째 내용입니다.",""  ));
    }
}
