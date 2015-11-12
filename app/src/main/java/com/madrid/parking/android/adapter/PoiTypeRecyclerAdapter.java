package com.madrid.parking.android.adapter;
/**
 * Created by Marcin on 17/09/2015.
 */

import com.android.parking.myparking.R;
import com.madrid.parking.android.model.poisType;
import com.madrid.parking.android.util.SimpleItemTouchHelperCallback;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class PoiTypeRecyclerAdapter extends RecyclerView.Adapter<PoiTypeRecyclerAdapter.CustomViewHolder> implements SimpleItemTouchHelperCallback.ItemTouchHelperAdapter {
    private List<poisType> feedItemList;
    private Context mContext;
    private int lastPosition = -1;

    private ItemTouchHelper mIth;

    public PoiTypeRecyclerAdapter(Context context, List<poisType> feedItemList) {
        this.feedItemList = feedItemList;
        this.mContext = context;


    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_row, null);

        //View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view_district, null);

        CustomViewHolder viewHolder = new CustomViewHolder(view);

        /*
        viewHolder.itemView.setAlpha(1);
        viewHolder.itemView.setTranslationX(0);
        viewHolder.itemView.setTranslationY(0);
        handleSwiping(viewHolder.itemView, viewHolder);
        */

        return viewHolder;
    }

    public void remove(int position) {
        feedItemList.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {
        poisType feedItem = feedItemList.get(i);
        setAnimation(customViewHolder.itemView, i);
        //Download image using picasso library
       /* Picasso.with(mContext).load(feedItem.getThumbnail())
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder)
                .into(customViewHolder.imageView);*/

        //Setting text view title
        customViewHolder.textView.setText(Html.fromHtml(feedItem.category));
        final View rootView = customViewHolder.itemView;

    }


    @Override
    public int getItemCount() {
        return (null != feedItemList ? feedItemList.size() : 0);
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(feedItemList, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(feedItemList, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
        return true;

    }

    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        View itemView = viewHolder.itemView;

        Paint p = new Paint();
        p.setColor(Color.RED);

        if (dX > 0) {

            // Draw Rect with varying right side, equal to displacement dX
            c.drawRect((float) itemView.getLeft(), (float) itemView.getTop(), dX,
                    (float) itemView.getBottom(), p);
        } else {

            // Draw Rect with varying left side, equal to the item's right side plus negative displacement dX
            c.drawRect((float) itemView.getRight() + dX, (float) itemView.getTop(),
                    (float) itemView.getRight(), (float) itemView.getBottom(), p);
        }


        //getDefaultUIUtil().onDraw(c, recyclerView, ((CustomViewHolder) viewHolder).getSwipableView(), dX, dY, actionState, isCurrentlyActive);


        //onDraw(c, recyclerView, ((RemovableViewHolder) viewHolder).getSwipableView(), dX, dY,    actionState, isCurrentlyActive);
        /*
        Drawable d = ContextCompat.getDrawable(mContext, R.drawable.descarga);
        d.setBounds(itemView.getRight(), itemView.getTop(), (int) dX, itemView.getBottom());
        d.draw(c);
        */
    }

    @Override
    public void onChildDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {

        View itemView = viewHolder.itemView;


        Paint p = new Paint();
        if (dX < 0) {
            //p.setARGB(255, 255, 0, 0);
        } else {
            //p.setARGB(255, 0, 255, 0);
        }

        canvas.drawRect((float) itemView.getRight() + dX, (float) itemView.getTop() + dY, (float) itemView.getRight(), (float) itemView.getBottom(), p);

        /*
        LinearLayout linearLayout = (LinearLayout) recyclerView.findViewById(R.id.linearLayout);

        MyRecyclerAdapter.CustomViewHolder vh = (MyRecyclerAdapter.CustomViewHolder) viewHolder;
        vh.itemView.setVisibility(View.VISIBLE);
        Paint p = new Paint();
        if (dX < 0) {
            p.setARGB(255, 255, 0, 0);
        } else {
            p.setARGB(255, 0, 255, 0);
        }

        canvas.drawRect(linearLayout.getLeft() + dX, linearLayout.getTop() + dY, linearLayout.getRight(), linearLayout.getBottom(), p);
        p.setTextSize(20);
        canvas.drawText("Delete", linearLayout.getLeft(), linearLayout.getTop() / 2, p);
        */

        // onDrawOver(canvas, recyclerView, ((CustomViewHolder) viewHolder).getSwipableView(), dX, dY,    actionState, isCurrentlyActive);
    }

    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        //clearView(((CustomViewHolder) viewHolder).getSwipableView());
        //clearView(((CustomViewHolder) viewHolder).getSwipableView());
    }

    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        //onSelected((CustomViewHolder) viewHolder));
    }


    @Override
    public void onItemSwiped(final RecyclerView.ViewHolder viewHolder, int swipeDir) {
        //remove(position);
        /*
        final View undo = viewHolder.itemView.findViewById(R.id.undo);
        if (undo != null) {
            // optional: tapping the message dismisses immediately
            TextView text = (TextView) viewHolder.itemView.findViewById(R.id.undo_text);
            text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //callbacks.onDismiss(recyclerView, viewHolder, viewHolder.getAdapterPosition());
                }
            });

            TextView button = (TextView) viewHolder.itemView.findViewById(R.id.undo_button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    notifyItemChanged(viewHolder.getAdapterPosition());
                    //clearView(recyclerView, viewHolder);
                    undo.setVisibility(View.GONE);
                }
            });

            undo.setVisibility(View.VISIBLE);
            undo.postDelayed(new Runnable() {
                public void run() {
                    if (undo.isShown()){

                    }

                }
            }, 20);
        }*/


    }


    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected ImageView imageView;
        protected TextView textView;
        protected TextView state;
        private View mRemoveableView;

        public CustomViewHolder(View view) {
            super(view);

            //this.textView = (TextView) view.findViewById(R.id.item_title);
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