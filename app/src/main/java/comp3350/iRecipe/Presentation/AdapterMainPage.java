package comp3350.iRecipe.Presentation;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import comp3350.iRecipe.R;

public class AdapterMainPage extends RecyclerView.Adapter<AdapterMainPage.MyAdapter> {
    Context context;

    public AdapterMainPage(Context context) {
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
            holder.back.setBackgroundColor(Color.parseColor("#D6E53935"));

            holder.card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ListRecipeActivity.class);
                    context.startActivity(intent);
                }
            });
        }
        if(position == 1)
        {
            holder.image.setImageResource(R.drawable.backdrop_main_dishes);
            holder.image1.setImageResource(R.drawable.round_fish);
            holder.text.setText("Main dishes");
            holder.back.setBackgroundColor(Color.parseColor("#D236883A"));

            holder.card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, MainDishActivity.class);
                    context.startActivity(intent);
                }
            });
        }
        if(position == 2)
        {
            holder.image.setImageResource(R.drawable.backdrop_soups);
            holder.image1.setImageResource(R.drawable.round_spaguetti);
            holder.text.setText("Soups");
            holder.back.setBackgroundColor(Color.parseColor("#D2AF4576"));

            holder.card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, SoupActivity.class);
                    context.startActivity(intent);
                }
            });
        }
        if(position == 3)
        {
            holder.image.setImageResource(R.drawable.backdrop_desserts);
            holder.image1.setImageResource(R.drawable.round_birthday_cake);
            holder.text.setText("Desserts");
            holder.back.setBackgroundColor(Color.parseColor("#D2EEAA45"));

            holder.card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, DessertActivity.class);
                    context.startActivity(intent);
                }
            });
        }
        if(position == 4)
        {
            holder.image.setImageResource(R.drawable.backdrop_drinks);
            holder.image1.setImageResource(R.drawable.round_cocktail);
            holder.text.setText("Drinks");
            holder.back.setBackgroundColor(Color.parseColor("#D6E53935"));

            holder.card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, DrinkActivity.class);
                    context.startActivity(intent);
                }
            });
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
        RelativeLayout card;
        public MyAdapter(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            image1 = itemView.findViewById(R.id.image1);
            text = itemView.findViewById(R.id.text);
            back = itemView.findViewById(R.id.back);
            card = itemView.findViewById(R.id.card);
        }
    }
}
