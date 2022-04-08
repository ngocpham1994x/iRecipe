package comp3350.iRecipe.Presentation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import comp3350.iRecipe.Objects.Comment;
import comp3350.iRecipe.R;

public class AdapterComment extends RecyclerView.Adapter<AdapterComment.CommentHolder>{

    ArrayList<Comment> comments;
    Context context;

    public AdapterComment(ArrayList<Comment> commentList, Context context){
        comments = commentList;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterComment.CommentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_comment, parent, false);
        CommentHolder commentHolder = new CommentHolder(view);
        return commentHolder;
    }

    @Override
    public void onBindViewHolder(AdapterComment.CommentHolder holder, int position){
        holder.userName.setText(comments.get(position).getUserName());
        holder.comment.setText(comments.get(position).getComment());
        holder.rating.setText("Rating: " + comments.get(position).getRating());
    }

    @Override
    public int getItemCount() {return comments.size();}

    public class CommentHolder extends RecyclerView.ViewHolder {
        TextView userName;
        TextView comment;
        TextView rating;
        RelativeLayout card_view;
        public CommentHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.userName);
            comment = itemView.findViewById(R.id.comment);
            rating = itemView.findViewById(R.id.rating);
            card_view = itemView.findViewById(R.id.card_comment);
        }
    }
}
