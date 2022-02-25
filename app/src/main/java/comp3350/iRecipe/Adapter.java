package comp3350.iRecipe;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.MyAdapter> {
    Context context;

    public Adapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false);
        return new MyAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter holder, int position) {
        if(position == 0)
        {
            holder.image.setImageResource(R.drawable.backdrop_ingredients);
            holder.image1.setImageResource(R.drawable.round_fork_knife);
            holder.text.setText("View all recipes");
            holder.back.setBackgroundColor(Color.parseColor("#E6E53935"));
        }
        if(position == 1)
        {
            holder.image.setImageResource(R.drawable.backdrop_main_dishes);
            holder.image1.setImageResource(R.drawable.round_fish);
            holder.text.setText("Main dishes");
            holder.back.setBackgroundColor(Color.parseColor("#F236883A"));
        }
        if(position == 2)
        {
            holder.image.setImageResource(R.drawable.backdrop_soups);
            holder.image1.setImageResource(R.drawable.round_spaguetti);
            holder.text.setText("Soups");
            holder.back.setBackgroundColor(Color.parseColor("#F2AF4576"));
        }
        if(position == 3)
        {
            holder.image.setImageResource(R.drawable.backdrop_desserts);
            holder.image1.setImageResource(R.drawable.round_birthday_cake);
            holder.text.setText("Desserts");
            holder.back.setBackgroundColor(Color.parseColor("#F2EEAA45"));
        }
        if(position == 4)
        {
            holder.image.setImageResource(R.drawable.backdrop_drinks);
            holder.image1.setImageResource(R.drawable.round_cocktail);
            holder.text.setText("Drinks");
            holder.back.setBackgroundColor(Color.parseColor("#E6E53935"));
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class MyAdapter extends RecyclerView.ViewHolder {
        ImageView image, image1;
        TextView text;
        RelativeLayout back;
        public MyAdapter(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            image1 = itemView.findViewById(R.id.image1);
            text = itemView.findViewById(R.id.text);
            back = itemView.findViewById(R.id.back);
        }
    }
}
