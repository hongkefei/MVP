package com.wf.mn.home.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.wf.mn.R;

/**
 * @author : wf
 * @time : 2020-11-13-14:46
 */
public class MyAdapter extends DelegateAdapter.Adapter {

    private LayoutHelper helper;

    public MyAdapter(LayoutHelper helper) {
        this.helper = helper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return helper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_layout, parent, false);

        return new MyViewHoler(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {




    }

    @Override
    public int getItemCount() {
        return 1;
    }


    class MyViewHoler extends RecyclerView.ViewHolder{

        public MyViewHoler(@NonNull View itemView) {
            super(itemView);
        }

    }

}
