package com.wf.mn.home.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.LayoutManagerHelper;
import com.bumptech.glide.Glide;
import com.wf.mn.R;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : wf
 * @time : 2020-11-13-15:26
 */
public class BannerAdapter extends DelegateAdapter.Adapter<BannerAdapter.BannerHolder> {


    List<String> list = new ArrayList<>();

    private LayoutHelper helper;

    public BannerAdapter(LayoutHelper helper) {
        this.helper = helper;

        list.add("http://ww1.sinaimg.cn/large/610dc034jw1f7ef7i5m1zj20u011hdjm.jpg");
        list.add("http://ww3.sinaimg.cn/large/610dc034jw1f7d97id9mbj20u00u0q4g.jpg");
        list.add("https://ww1.sinaimg.cn/large/0065oQSqly1fu7xueh1gbj30hs0uwtgb.jpg");
        list.add("https://ww1.sinaimg.cn/large/0065oQSqgy1fu39hosiwoj30j60qyq96.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1605262799312&di=d6881f4d6d00b17580871899eedb5736&imgtype=0&src=http%3A%2F%2Fa1.att.hudong.com%2F24%2F78%2F20300000291746133783784887147.jpg");
        list.add("https://ww1.sinaimg.cn/large/0065oQSqly1ftu6gl83ewj30k80tites.jpg");


    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return helper;
    }

    @NonNull
    @Override
    public BannerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_banner, parent, false);

        return new BannerHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull final BannerHolder holder, int position) {

        holder.banner.setImages(list).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load(path).into(imageView);
            }
        }).start();


    }

    @Override
    public int getItemCount() {
        return 1;
    }


    class BannerHolder extends RecyclerView.ViewHolder {

        public Banner banner;

        public BannerHolder(@NonNull View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.home_banner);
        }
    }

}
