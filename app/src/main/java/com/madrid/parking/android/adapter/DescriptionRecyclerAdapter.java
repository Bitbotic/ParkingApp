package com.madrid.parking.android.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.parking.myparking.R;
import com.madrid.parking.android.model.iconsDescription;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Marcin on 30/09/2015.
 */

public class DescriptionRecyclerAdapter extends RecyclerView.Adapter<DescriptionRecyclerAdapter.CustomViewHolder> {
    private List<iconsDescription> feedItemList;
    private Context mContext;
    private int lastPosition = -1;
    private ImageLoader imageLoader;


    public DescriptionRecyclerAdapter(Context context, List<iconsDescription> feedItemList) {
        this.feedItemList = feedItemList;
        this.mContext = context;
        imageLoader = ImageLoader.getInstance();
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_row_description, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {
        iconsDescription feedItem = feedItemList.get(i);
        setAnimation(customViewHolder.itemView, i);

        //Setting text view title
        customViewHolder.textView.setText(Html.fromHtml(feedItem.iconName));
        imageLoader.displayImage(feedItem.urlIcon, customViewHolder.imageView);
        final View rootView = customViewHolder.itemView;

    }


    @Override
    public int getItemCount() {
        return (null != feedItemList ? feedItemList.size() : 0);
    }


    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected ImageView imageView;
        protected TextView textView;
        protected TextView state;

        public CustomViewHolder(View view) {
            super(view);

            // this.textView = (TextView) view.findViewById(R.id.item_title);
            //this.imageView = (ImageView) view.findViewById(R.id.item_icon);
            //state = (TextView) itemLayoutView.findViewById(R.id.item_block);

            this.imageView = (ImageView) view.findViewById(R.id.thumbnail);
            this.textView = (TextView) view.findViewById(R.id.title);

        }

    }

    private void setAnimation(View viewToAnimate, int position) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.scale);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }
}