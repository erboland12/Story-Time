package com.shapesandsuch.storytime.rv;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.shapesandsuch.storytime.R;
import com.shapesandsuch.storytime.backend.Post;
import com.shapesandsuch.storytime.backend.Template;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

//Adapter that handles record items in recycler view
public class PostsAdapter extends
        RecyclerView.Adapter<PostsAdapter.ViewHolder> {



    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView titleTextView, templateTextView, dateTextView;
        private ImageView photoImageView;
        private RatingBar ratingBar;
        public View view;

        private ViewHolder(View itemView) {
            super(itemView);

            //Links front end variables to item view
            titleTextView = itemView.findViewById(R.id.rv_title);
            templateTextView = itemView.findViewById(R.id.rv_template);
            dateTextView = itemView.findViewById(R.id.rv_date);


            //Sets up firebase and auth
//            db = FirebaseFirestore.getInstance();
//            mAuth = FirebaseAuth.getInstance();
        }

        //Converts unix time to date stamp
        private String unixToDate(long unix){
            Date date = new java.util.Date(unix*1000L);
            SimpleDateFormat sdf = new java.text.SimpleDateFormat("MM-dd-yy");
            return sdf.format(date);
        }

        private String templateToText(Template t){
            if(t == Template.POEM){
                return "Poem";
            }
            else if(t == Template.STORY){
                return "Story";
            }
            else if(t == Template.MADLIB){
                return "Madlib";
            }

            return "Null";
        }
    }


    private List<Post> mPosts;
    public List<Post> mPostsCopy = new ArrayList<>();

    public PostsAdapter(ArrayList<Post> Posts) {
        mPosts = Posts;
        mPostsCopy.addAll(mPosts);
    }

    @NonNull
    @Override
    public PostsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.post_rv_item_view, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(final PostsAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        final Post buf = mPosts.get(position);

        // Set item views based on your views and data model
//        final ImageView imageView = viewHolder.photoImageView;
//        Uri uri = Uri.parse(buf.getmPhotoString());
//        Picasso.get().load(uri).fit().centerCrop().into(imageView);

        final TextView textView = viewHolder.titleTextView;
        if(buf.getTitle().length() >= 21){
            String shortened = buf.getTitle().substring(0, 18);
            shortened += "...";
            textView.setText(shortened);
        }else{
            textView.setText(buf.getTitle());
        }

        final TextView textView2 = viewHolder.templateTextView;
        textView2.setText(viewHolder.templateToText(buf.getType()));


        final TextView textView3 = viewHolder.dateTextView;
        textView3.setTypeface(null, Typeface.ITALIC);
        textView3.setText(viewHolder.unixToDate(buf.getUnixTime()));

//        db.collection("Posts").addSnapshotListener(new EventListener<QuerySnapshot>() {
//            @Override
//            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
//                for(QueryDocumentSnapshot doc: queryDocumentSnapshots){
//                    if(buf.getRecId().equals(doc.getString("recId"))){
//                        textView3.setText(doc.getString("displayName") + ", " + viewHolder.unixToDate(doc.getLong("datePostedUnix")));
//                    }
//                }
//            }
//        });


        //Item click listener for each entry in rv
        viewHolder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

//                //Stores values from item into record page fragment
//                RecordPageFragment.idTemp = buf.getId();
//                RecordPageFragment.albumTemp = buf.getTitle();
//                RecordPageFragment.artistTemp = buf.getArtist();
//                RecordPageFragment.ratingTemp = buf.getRating();
//                RecordPageFragment.genreTemp = buf.getGenre();
//
//                //Censors description text
//                if(!viewHolder.returnCensor()){
//                    Censor censor = new Censor();
//                    RecordPageFragment.descTemp = censor.censorText(buf.getDesc());
//                }else{
//                    RecordPageFragment.descTemp = buf.getDesc();
//                }
//                RecordPageFragment.photoStringTemp = buf.getmPhotoString();
//                m.moveActivity(viewHolder.itemView.getContext(), PostsPage.class);
            }
        });
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mPosts.size();
    }

}