package edu.neaga.superrecycler;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SuperAdapter extends RecyclerView.Adapter<SuperAdapter.ViewHolder> {
    public List<Secret> localDataSet;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        View view;

        public ViewHolder(View view) {
            super(view);

            this.view = view;
        }

        public TextView getTextViewById(int id) {
            return view.findViewById(id);
        }
    }

    public SuperAdapter() {
        localDataSet = new ArrayList<>();
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        TextView nom = viewHolder.getTextViewById(R.id.nom);
        TextView date = viewHolder.getTextViewById(R.id.date);
        TextView nbGrand = viewHolder.getTextViewById(R.id.nbGrand);

        nom.setText(localDataSet.get(position).nom);
        date.setText(localDataSet.get(position).date.toString());
        nbGrand.setText(""+localDataSet.get(position).nbGrand);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}
