
package com.madrid.parking.android.adapter;

/**
 * Created by Marcin on 17/09/2015.
 */

import com.android.parking.myparking.R;
import com.madrid.parking.android.controllers.ViewControllers;
import com.madrid.parking.android.model.Parking;
import com.madrid.parking.android.model.lstParking;
import com.madrid.parking.android.util.SimpleItemTouchHelperCallback;
import com.nostra13.universalimageloader.core.ImageLoader;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.location.Location;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.Collections;
import java.util.List;

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.CustomViewHolder> implements SimpleItemTouchHelperCallback.ItemTouchHelperAdapter {
    private List<Parking> feedItemList;
    private Context mContext;
    private ImageLoader imageLoader;
    private static Double latitude, longitude;
    private int lastPosition = -1;

    private ItemTouchHelper mIth;

    public HomeRecyclerAdapter(Context context, List<Parking> feedItemList,double latitude,double longitude) {
        this.feedItemList = feedItemList;
        this.mContext = context;
        imageLoader = ImageLoader.getInstance();
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public  interface MyViewHolderClick {
        public void onClick(int position,View v);
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_row, null);
        //View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view_district, null);

        CustomViewHolder viewHolder = new CustomViewHolder(view, new MyViewHolderClick() {
            @Override
            public void onClick(int position,final View v) {

                //getTag
                CustomViewHolder holder = (CustomViewHolder )(v.getTag());

                /*
                // If the originalHeight is 0 then find the height of the View being used
                // This would be the height of the cardview
                if (holder.originalHeight == 0) {
                    holder.originalHeight = v.getHeight();
                }

                // Declare a ValueAnimator object
                ValueAnimator valueAnimator;
                if (!holder.isViewExpanded) {
                    holder.ExpandedCustomView.setVisibility(View.VISIBLE);
                    holder.ExpandedCustomView.setEnabled(true);
                    holder.isViewExpanded = true;
                    valueAnimator = ValueAnimator.ofInt(holder.originalHeight, holder.originalHeight + (int) (holder.originalHeight * 1.0)); // These values in this method can be changed to expand however much you like
                } else {
                    holder.isViewExpanded = false;
                    valueAnimator = ValueAnimator.ofInt(holder.originalHeight + (int) (holder.originalHeight * 1.0), holder.originalHeight);

                    Animation a = new AlphaAnimation(1.00f, 0.00f); // Fade out

                    MyAnimationListener listenr = new MyAnimationListener();

                    listenr.setView(holder);

                    a.setDuration(200);
                    // Set a listener to the animation and configure onAnimationEnd
                    a.setAnimationListener(listenr);

                    // Set the animation on the custom view
                    holder.ExpandedCustomView.startAnimation(a);
                }
                valueAnimator.setDuration(200);
                valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());

                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator animation) {
                        Integer value = (Integer) animation.getAnimatedValue();
                        v.getLayoutParams().height = value.intValue();
                        v.requestLayout();
                    }
                });

                valueAnimator.start();
                */

                ViewControllers.goToDetailActivity(mContext,feedItemList.get(position));
            }
        });

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
        Parking feedItem = feedItemList.get(i);

        //Download image using picasso library
        imageLoader.displayImage(feedItem.icon, customViewHolder.imageView);

        //Calculate Distance between 2 points
        Location itemLoc = new Location("");
        itemLoc.setLatitude(Double.parseDouble(feedItem.latitude));
        itemLoc.setLongitude(Double.parseDouble(feedItem.longitude));

        Location loc2 = new Location("");
        loc2.setLatitude(latitude);
        loc2.setLongitude(longitude);

        float distanceInMeters = itemLoc.distanceTo(loc2);
        distanceInMeters = distanceInMeters/1000;

        //Setting text view title
        customViewHolder.textView.setText(Html.fromHtml(feedItem.address));
        customViewHolder.distance.setText("" + String.format("%.2f km", distanceInMeters));

        final View rootView = customViewHolder.itemView;

        setAnimation(customViewHolder.itemView, i);
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


    public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        protected ImageView imageView;
        protected TextView textView;
        protected TextView distance;
        protected View ExpandedCustomView;

        private int originalHeight = 0;
        private boolean isViewExpanded = false;

        private View root;
        private MyViewHolderClick mListener;


        public CustomViewHolder(View view,MyViewHolderClick listener) {
            super(view);
            // this.textView = (TextView) view.findViewById(R.id.item_title);
            //this.imageView = (ImageView) view.findViewById(R.id.item_icon);
            //state = (TextView) itemLayoutView.findViewById(R.id.item_block);
            this.root = view;
            this.mListener = listener;
            this.ExpandedCustomView = view.findViewById(R.id.row_second);
            this.imageView = (ImageView) view.findViewById(R.id.thumbnail);
            this.textView = (TextView) view.findViewById(R.id.title);
            this.distance = (TextView) view.findViewById(R.id.distance);


            // If isViewExpanded == false then set the visibility
            // of whatever will be in the expanded to GONE
            /*
            if (isViewExpanded == false) {
                // Set Views to View.GONE and .setEnabled(false)
                ExpandedCustomView.setVisibility(View.GONE);
                ExpandedCustomView.setEnabled(false);
            }*/

            this.root.setOnClickListener(this);
            this.root.setTag(this);
        }

        @Override
        public void onClick(View v) {
            mListener.onClick(getAdapterPosition(),v);
        }
    }

    private void setAnimation(View viewToAnimate, int position) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            viewToAnimate.clearAnimation();
            Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.scale);

            //MyAnimationListener listener = new MyAnimationListener();
            //listener.setView(viewToAnimate);
            //animation.setAnimationListener(listener);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }


        viewToAnimate.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {

            @Override
            public void onViewAttachedToWindow(View v) {

            }

            @Override
            public void onViewDetachedFromWindow(View v) {
                v.clearAnimation();
            }

        });
    }

    public class MyAnimationListener implements Animation.AnimationListener {
        CustomViewHolder view;
        public void setView(CustomViewHolder view) {
            this.view = view;
        }
        public void onAnimationEnd(Animation animation) {
            // Do whatever you want
            //view.clearAnimation();
            //view.requestLayout();
            view.ExpandedCustomView.setVisibility(View.INVISIBLE);
            view.ExpandedCustomView.setEnabled(false);
        }
        public void onAnimationRepeat(Animation animation) {
        }
        public void onAnimationStart(Animation animation) {
        }
    }
}