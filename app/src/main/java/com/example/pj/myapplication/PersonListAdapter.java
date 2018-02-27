package com.example.pj.myapplication;

/**
 * Created by Pj on 26/02/2018.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.ArrayList;
import java.util.List;

public class PersonListAdapter  extends ArrayAdapter<PersonData> {

    private static final String TAG = "CustomListAdapter";

    private Context mContext;
    private int mResource;
    private int lastPosition = -1;

    private static class ViewHolder {
        TextView fullName;
        TextView email;
        TextView username;
        ImageView thumbnailUrl;
        ProgressBar mProgressBar;
    }

    public PersonListAdapter(Context context, int resource, ArrayList<PersonData> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;

        //sets up the image loader library
        setupImageLoader();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //get the persons information
        String nameText = getItem(position).getTitleName() + " " + getItem(position).getFirstName() + " " + getItem(position).getLastName();
        String thumbnailUrlText = getItem(position).getThumbnailUrl();
        String emailText = getItem(position).getEmail();
        String usernameText = getItem(position).getUsername();

        try{

            //finak ViewHolder object
            final ViewHolder holder;

            if(convertView == null){
                LayoutInflater inflater = LayoutInflater.from(mContext);
                convertView = inflater.inflate(mResource, parent, false);
                holder= new ViewHolder();
                holder.fullName = convertView.findViewById(R.id.nameText);
                holder.email = convertView.findViewById(R.id.emailText);
                holder.username = convertView.findViewById(R.id.usernameText);
                holder.thumbnailUrl = convertView.findViewById(R.id.personThumbnail);
                holder.mProgressBar = convertView.findViewById(R.id.progressBar);

                convertView.setTag(holder);
            }
            else{
                holder = (ViewHolder) convertView.getTag();
            }

            lastPosition = position;

            holder.fullName.setText(nameText);
            holder.email.setText(emailText);
            holder.username.setText(usernameText);

            //create the Imageloader object
            ImageLoader imageLoader = ImageLoader.getInstance();

            int defaultImage = mContext.getResources().getIdentifier("@drawable/download_failed",null,mContext.getPackageName());

            //display options for rounded thumbnails of source img's
            DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                    .cacheOnDisc(true).resetViewBeforeLoading(true)
                    .displayer(new RoundedBitmapDisplayer(300))
                    .showImageForEmptyUri(defaultImage)
                    .showImageOnFail(defaultImage)
                    .showImageOnLoading(defaultImage).build();

            //images loading options used for progress bar
            imageLoader.displayImage(thumbnailUrlText, holder.thumbnailUrl, options, new ImageLoadingListener() {
                @Override
                public void onLoadingStarted(String imageUri, View view) {
                    holder.mProgressBar.setVisibility(View.VISIBLE);

                }
                @Override
                public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                    holder.mProgressBar.setVisibility(View.GONE);

                }
                @Override
                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                    holder.mProgressBar.setVisibility(View.GONE);

                }
                @Override
                public void onLoadingCancelled(String imageUri, View view) {
                    holder.mProgressBar.setVisibility(View.GONE);

                }

            });

            return convertView;
        }catch (IllegalArgumentException e){
            Log.e(TAG, "getView: IllegalArgumentException: " + e.getMessage() );
            return convertView;
        }

    }

    private void setupImageLoader(){
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheOnDisc(true).cacheInMemory(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new FadeInBitmapDisplayer(300)).build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                mContext)
                .defaultDisplayImageOptions(defaultOptions)
                .memoryCache(new WeakMemoryCache())
                .discCacheSize(100 * 1024 * 1024).build();

        ImageLoader.getInstance().init(config);
    }
}
