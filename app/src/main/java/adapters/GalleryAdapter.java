package adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.quantum.rerevise.R;
import com.quantum.rerevise.activities.ImageDetailActivity;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> {


    private final List<String> imagepathlist;

    private static final String TAG="MainGalleryAdapter";

    public GalleryAdapter(List<String> imagepathlist) {
        this.imagepathlist = imagepathlist;
    }

    @NonNull
    @Override
    public GalleryAdapter.GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_item,parent,false);
        return new GalleryViewHolder(view);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull GalleryAdapter.GalleryViewHolder holder, int position) {

        holder.imageView.setImageURI(Uri.parse(imagepathlist.get(position)));
        /*// on below line we are getting th file from the
        // path which we have stored in our list.
        File imgFile = new File(imagepathlist.get(position));
        Log.d(TAG, "onBindViewHolder: "+imgFile);


        // on below line we are checking if tje file exists or not.
        if (imgFile.exists()) {

            // if the file exists then we are displaying that file in our image view using picasso library.
            Picasso.get().load(imgFile).placeholder(R.drawable.ic_launcher_background).into(holder.imageView);

            // on below line we are adding click listener to our item of recycler view.
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    // inside on click listener we are creating a new intent
                    Intent i = new Intent(context, ImageDetailActivity.class);

                    // on below line we are passing the image path to our new activity.
                    i.putExtra("imgPath", imagepathlist.get(position));

                    // at last we are starting our activity.
                    context.startActivity(i);
                }
            });
        }*/

    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: "+imagepathlist.size());
        return imagepathlist.size();
    }

    public class GalleryViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;

        public GalleryViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image_view);
        }
    }
}
