package com.alexurangareyes.mysqlite.adapter;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.alexurangareyes.mysqlite.R;
import com.alexurangareyes.mysqlite.activity.MainActivity;
import com.alexurangareyes.mysqlite.model.Place;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexurangareyes on 5/31/17.
 */

public class placesAdapter extends RecyclerView.Adapter<placesAdapter.ViewHolder> {

    private String[] mDataset;

    private List<Place> citiList = null;
    private ArrayList<Place> arraylist;

    private Context mContext;

    private Intent intent;
    private int lastPosition = -1;

    private boolean animation;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nameTextView, nameTextView2;
        public ImageView imageViewCom3;
        public Button buttonView;


        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.nameEstado);
            nameTextView2 = (TextView) itemView.findViewById(R.id.nameMaravilla);
            imageViewCom3 = (ImageView) itemView.findViewById(R.id.imageViewComDetail);
            buttonView = (Button) itemView.findViewById(R.id.btn_explore);
        }

    }


    public placesAdapter(Context context, ArrayList<Place> myDataset) {
        mContext = context;
        arraylist = myDataset;
        this.mContext = context;
        this.citiList = myDataset;
        //this.animation = animation;
        //intent = new Intent(mContext, DetailActivity.class);

    }


    @Override
    public placesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {

        Context context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View maravillatView = inflater.inflate(R.layout.item_place, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(maravillatView);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(placesAdapter.ViewHolder viewHolder, int position) {

        //if (animation) {
        setAnimation(viewHolder.itemView, position);
        //}

        final Place place = arraylist.get(position);

        TextView textView = viewHolder.nameTextView;
        textView.setText(place.getName());

        TextView textView2 = viewHolder.nameTextView2;
        textView2.setText(place.getState());
        //textView2.setText(String.valueOf(position));

        Button btnExplore = viewHolder.buttonView;


        final ImageView imageViewCom = viewHolder.imageViewCom3;


        switch (place.getName()) {
            case "Palacio Municipal":
                imageViewCom.setImageResource(R.drawable.palacio_municipal);
                break;
            case "Cristo de la noas":
                imageViewCom.setImageResource(R.drawable.cristo_de_las_noas);
                break;
            case "Plaza de las culturas":
                imageViewCom.setImageResource(R.drawable.palacio_municipal);
                break;

        }


        /*Picasso.with(mContext)
                .load("http://172.17.62.59:8888/Android/SearchField/img/" + maravilla.getFoto())
                .fit()
                .into(imageViewCom);*/

        btnExplore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*intent.putExtra("urlFoto", maravilla.getFoto());
                intent.putExtra("Estado", maravilla.getEstado());
                intent.putExtra("Lugar", maravilla.getLugar());*/

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation((MainActivity) mContext,
                            imageViewCom, ViewCompat.getTransitionName(imageViewCom));

                    mContext.startActivity(intent, options.toBundle());

                } else {
                    mContext.startActivity(intent);
                }
            }
        });
    }

    /**
     * Here is the key method to apply the animation
     */
    private void setAnimation(final View viewToAnimate, int position) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(mContext, android.R.anim.slide_in_left);

            viewToAnimate.startAnimation(animation);

            lastPosition = position;
        }
    }

    @Override
    public int getItemCount() {
        return arraylist.size();
    }


}