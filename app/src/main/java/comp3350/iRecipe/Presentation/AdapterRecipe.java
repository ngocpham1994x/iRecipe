package comp3350.iRecipe.Presentation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import comp3350.iRecipe.R;
import comp3350.iRecipe.Objects.Recipe;

public class AdapterRecipe extends RecyclerView.Adapter<AdapterRecipe.RecipeHolder> {

    ArrayList<Recipe> recipe_list;
    public AdapterRecipe(ArrayList<Recipe> recipe_list) {
        this.recipe_list = recipe_list;
    }

    @NonNull
    @Override
    public AdapterRecipe.RecipeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_recipe, parent, false);
        RecipeHolder recipeHolder = new RecipeHolder(view);
        return recipeHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecipe.RecipeHolder holder, int position) {
        holder.recipe_name.setText(recipe_list.get(position).getName());
        holder.category.setText(recipe_list.get(position).getCategory());
    }

    @Override
    public int getItemCount() {
        return recipe_list.size();
    }

    public class RecipeHolder extends RecyclerView.ViewHolder {
        TextView recipe_name;
        TextView category;
        public RecipeHolder(@NonNull View itemView) {
            super(itemView);
            recipe_name = itemView.findViewById(R.id.recipe_name);
            category = itemView.findViewById(R.id.category);
        }
    }
}
