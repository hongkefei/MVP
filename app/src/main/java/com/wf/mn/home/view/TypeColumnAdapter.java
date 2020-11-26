package com.wf.mn.home.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.bumptech.glide.Glide;
import com.wf.mn.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : wf
 * @time : 2020-11-13-16:40
 */
public class TypeColumnAdapter extends DelegateAdapter.Adapter<TypeColumnAdapter.MyViewHoler> {

    private LayoutHelper helper;

    private List<String> textList = new ArrayList<String>();
    private List<Integer> image = new ArrayList<>();



    public TypeColumnAdapter(LayoutHelper helper) {
        this.helper = helper;
        textList.add("第一");
        textList.add("第二");
        textList.add("第三");
        textList.add("第四");
        textList.add("第五");


        image.add(R.mipmap.ic_launcher);
        image.add(R.mipmap.ic_launcher);
        image.add(R.mipmap.ic_launcher);
        image.add(R.mipmap.ic_launcher);
        image.add(R.mipmap.ic_launcher);

    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return helper;
    }

    @NonNull
    @Override
    public MyViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.typecolumnlayout, parent, false);

        return new MyViewHoler(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHoler holder, int position) {

        Glide.with(holder.itemView.getContext()).load("https://kqapp-ych.furongyun.cn/activity_img/2020-11-12/1605192463353_504.jpg").into(holder.tc_image);
        holder.tc_text.setText(textList.get(position));
    }

    @Override
    public int getItemCount() {
        return 5;
    }


    class MyViewHoler extends RecyclerView.ViewHolder{

        public ImageView tc_image;
        public TextView tc_text;

        public MyViewHoler(@NonNull View itemView) {
            super(itemView);
            tc_image = itemView.findViewById(R.id.type_column_image);
            tc_text = itemView.findViewById(R.id.type_column_text);
        }

    }

}
