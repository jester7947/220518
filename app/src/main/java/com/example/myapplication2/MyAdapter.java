package com.example.myapplication2;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private final List<Integer> iImages;
    private final List<String> iNames;
    private final List<String> iEmails;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    static class ViewHolder extends RecyclerView.ViewHolder {

        // each data item is just a string in this case
        ImageView imageView;
        TextView textView;
        TextView emailView;

        ViewHolder(View v) {
            super(v);
            imageView = v.findViewById(R.id.image_view);
            textView = v.findViewById(R.id.text_view);
            emailView = v.findViewById(R.id.email_view);        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    MyAdapter(List<Integer> itemImages, List<String> itemNames, List<String> itemEmails) {
        this.iImages = itemImages;
        this.iNames = itemNames;
        this.iEmails = itemEmails;
    }

    // Create new views (invoked by the layout manager)
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);

        // set the view's size, margins, paddings and layout parameters

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.imageView.setImageResource(iImages.get(position));
        holder.textView.setText(iNames.get(position));
        holder.emailView.setText(iEmails.get(position));    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return iNames.size();
    }
}