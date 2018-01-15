package com.testing.kmin.timelinetextpj;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by kmin on 2018-01-02.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private List<ItemData> itemdatas;
    private Context context;

    public MyAdapter(Context context, List<ItemData> items){
        itemdatas = items;
        this.context = context;
    }


    // onCreateViewHolder의 int viewType을 설정한다.
    @Override
    public int getItemViewType(int position) {
        return itemdatas.get(position).getColId();
    }

    // 1번 분기되어 필요한 layout을 셋한다.
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layout = -1;
        switch (viewType){
            case ItemData.TYPE_COL_ONE:
                layout = R.layout.layout_one;
                break;
            case ItemData.TYPE_COL_TWO:
                layout = R.layout.layout_two;
                break;
//            case ItemData.TYPE_COL_THREE:
////                layout = R.layout.view_red;
//                break;
        }
        View v = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        return new ViewHolder(v,viewType);

    }

    //포지션의 해당값을 셋팅한다.
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ItemData data = itemdatas.get(position);
        holder.setMessageText(data);
        //포지션의 파라미터를 이용한여 클래스의 메소드를 실행한다.
    }

    @Override
    public int getItemCount() {
        return itemdatas.size();
    }


    //viewholder 이너클래스를 생성한다.
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView messageText, titleText, dateText, todoText;
        private ImageView imageView1,imageView2,imageView3;

        public ViewHolder(View itemView, int type) {
            super(itemView);
            //type 분기
            if(type == ItemData.TYPE_COL_ONE){
                titleText =itemView.findViewById(R.id.typeOneTitle);
                dateText = itemView.findViewById(R.id.dateText);
                imageView1 = itemView.findViewById(R.id.imageView);
                imageView2 = itemView.findViewById(R.id.imageView2);
                imageView3 = itemView.findViewById(R.id.imageView3);

            }else{
                titleText =itemView.findViewById(R.id.typeTwoTitle);
                dateText = itemView.findViewById(R.id.dateText);
                messageText = itemView.findViewById(R.id.contentText);
                todoText = itemView.findViewById(R.id.todoText);
            }

        }

        public void setMessageText(ItemData data){
            if(data == null)return;
            //type 분기
            if(data.getColId() == ItemData.TYPE_COL_ONE){
                titleText.setText(data.getTitle());
                dateText.setText(data.getRegDate());

                if(data.getImgUrl1() != null && !data.getImgUrl1().equals("")){
                        Picasso.with(context)
                                .load(data.getImgUrl1())
                                .into(imageView1);
                }else{

                }
                if(data.getImgUrl2() != null && !data.getImgUrl2().equals("")){
                    Picasso.with(context)
                            .load(data.getImgUrl2())
                            .into(imageView2);
                }
                if(data.getImgUrl3() != null && !data.getImgUrl3().equals("")){
//                    imageView1,imageView2,imageView3;
                }
            }else{
                titleText.setText(data.getTitle());
                dateText.setText(data.getRegDate());
                messageText.setText(data.getMessageData());
                todoText.setText(data.getTodoType());
            }

        }
    }

}

