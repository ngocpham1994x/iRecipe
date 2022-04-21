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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

import comp3350.iRecipe.Objects.Category;
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

    ArrayList<String> card_text;

    String card_back[] = {      // color
            "#D6E53935",
            "#D236883A",
            "#D2AF4576",
            "#D2EEAA45",
            "#D6E53935"
    };

    public AdapterMainPage(Context context) {
        this.context = context;

        card_text = new ArrayList<>();
        card_text.add("View all recipes");
        for(Category e: Category.values()){
            if(!e.equals(Category.INVALID_CATEGORY))
                card_text.add(e.toString());
        }
    }

    @NonNull
    @Override
    public MyAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false);
        return new MyAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter holder, int position) {

        holder.image.setImageResource(card_image[position]);
        holder.image1.setImageResource(card_image1[position]);
        holder.text.setText(card_text.get(position));
        holder.back.setBackgroundColor(Color.parseColor(card_back[position]));

        int finalI = position;
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ListRecipeActivity.class);
                intent.putExtra("type",card_text.get(finalI));
                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        if (card_image.length == card_image1.length && card_image1.length == card_text.size() && card_text.size() == card_back.length)
            return card_image.length;
        else {
            Toast.makeText(context, "Card Arrays have incorrect length",
                    Toast.LENGTH_LONG).show();
            return -1;
        }
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
