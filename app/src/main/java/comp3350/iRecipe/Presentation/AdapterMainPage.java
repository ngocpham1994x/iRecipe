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

import java.util.Arrays;

import comp3350.iRecipe.R;

public class AdapterMainPage extends RecyclerView.Adapter<AdapterMainPage.MyAdapter> {
    Context context;

    int card_image[] = {
        R.drawable.backdrop_ingredients,
        R.drawable.backdrop_main_dishes,
        R.drawable.backdrop_soups,
        R.drawable.backdrop_desserts,
        R.drawable.backdrop_drinks,
    };

    int card_image1[] = {
        R.drawable.round_fork_knife,
        R.drawable.round_fish,
        R.drawable.round_spaguetti,
        R.drawable.round_birthday_cake,
        R.drawable.round_cocktail,
    };

    String card_text[] = {
            "View all recipes",
            "Main dishes",
            "Soups",
            "Desserts",
            "Drinks"
    };

    String card_back[] = {      // color
            "#D6E53935",
            "#D236883A",
            "#D2AF4576",
            "#D2EEAA45",
            "#D6E53935"
    };

    String card_type[] = {
            "All",
            "Main dishes",
            "Soup",
            "Dessert",
            "Drink"
    };


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
        for (int i = 0; i < getItemCount(); i++)
        {
            if(position == i)
            {
                holder.image.setImageResource(card_image[i]);
                holder.image1.setImageResource(card_image1[i]);
                holder.text.setText(card_text[i]);
                holder.back.setBackgroundColor(Color.parseColor(card_back[i]));

                int finalI = i;
                holder.card.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, ListRecipeActivity.class);
                        intent.putExtra("type",card_type[finalI]);
                        context.startActivity(intent);
                    }
                });
            }
        }

    }

    @Override
    public int getItemCount() {
        return card_image.length;
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
