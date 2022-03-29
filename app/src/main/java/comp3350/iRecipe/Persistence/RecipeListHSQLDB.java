package comp3350.iRecipe.Persistence;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import comp3350.iRecipe.Objects.Recipe;

public class RecipeListHSQLDB implements RecipeListInterface{


    private String dbPath;

    public RecipeListHSQLDB(final String dbPath){

        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    public ArrayList<Recipe> getAllRecipes(){

        // will return all the recipes present in the database
        ArrayList<Recipe> list_from_database = new ArrayList<>();

        try(Connection con = connection()){
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Recipe");
            while(rs.next()){
                Recipe recipe = fromResultSet(rs);
                PreparedStatement st2 = con.prepareStatement("SELECT * FROM INGREDIENTS WHERE RECIPENAME=?");
                st2.setString(1,recipe.getName());

                ResultSet rs2 = st2.executeQuery();
                while(rs2.next()){
                    String ingred = rs2.getString("INGREDIENT");
                    recipe.addToIngredients(ingred);
                }
                rs2.close();
                st2.close();


                PreparedStatement st3 = con.prepareStatement("SELECT * FROM KEYINGREDIENTS WHERE RECIPENAME=?");
                st3.setString(1,recipe.getName());

                ResultSet rs3 = st3.executeQuery();
                while(rs3.next()){
                    String keyIngred = rs3.getString("KEYINGREDIENT");
                    recipe.addToKeyIngredients(keyIngred);
                }
                rs3.close();
                st3.close();

                list_from_database.add(recipe);

            }
            rs.close();
            st.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        return list_from_database;
    }

    private Recipe fromResultSet(ResultSet rs) throws  SQLException{
        String name = rs.getString("RECIPENAME");
        String category = rs.getString("CATEGORY");
        String cookingLevel = rs.getString("COOKINGLEVEL");
        int prepTime = rs.getInt("PREPTIME");
        int cookingTime = rs.getInt("COOKINGTIME");
        int serving = rs.getInt("SERVING");
        String instruction = rs.getString("INSTRUCTIONS");
        String newInstr = instruction.replace("\\n" , "\n");
        ArrayList<String> ingred = new ArrayList<>();
        ArrayList<String> keyIngred = new ArrayList<>();
        return new Recipe(name, category, cookingLevel, prepTime, cookingTime, serving, ingred, keyIngred, newInstr);
    }

    //Return false when we already have a Recipe with the same name
    public boolean addRecipe(Recipe newRecipe){
        try(Connection con = connection()){
            PreparedStatement st = con.prepareStatement("INSERT INTO Recipe VALUES(?,?,?,?,?,?,?)");
            st.setString(1,newRecipe.getName());
            st.setString(2,newRecipe.getCategory());
            st.setString(3,newRecipe.getLevel());
            st.setInt(4,newRecipe.getPrepTime());
            st.setInt(5,newRecipe.getCookTime());
            st.setInt(6,newRecipe.getServing());
            st.setString(7,newRecipe.getInstruction());

            st.executeUpdate();

        }catch(SQLException e){
            return false;
        }
        return true;
    }

    public boolean removeRecipe(Recipe toRemove){
        try(Connection con = connection()){
            PreparedStatement st1 = con.prepareStatement("DELETE FROM Ingredients WHERE RecipeName = ?");
            st1.setString(1,toRemove.getName());
            st1.executeUpdate();

            PreparedStatement st2 = con.prepareStatement("DELETE FROM KeyIngredients WHERE RecipeName = ?");
            st2.setString(1,toRemove.getName());
            st2.executeUpdate();

            PreparedStatement st3 = con.prepareStatement("DELETE FROM Recipe WHERE RecipeName = ?");
            st3.setString(1,toRemove.getName());
            st3.executeUpdate();

        }catch(SQLException e){
            return false;
        }
        return true;
    }


    public Recipe searchByName(String nameOfRecipe){
        Recipe recipe = null;
        try(Connection con = connection()){

            PreparedStatement st = con.prepareStatement("SELECT * FROM RECIPE WHERE RECIPENAME = ?");
            st.setString(1, nameOfRecipe);
            ResultSet rs = st.executeQuery();
            rs.next();
            recipe = fromResultSet(rs);
            rs.close();
            st.close();

        }catch(SQLException e){
            Log.e("ErrorHere","Error",e);
        }
        return recipe;
    }

    public ArrayList<Recipe> matchByName(String nameOfRecipe){
        ArrayList<Recipe> list = new ArrayList<>();
        try(Connection con = connection()){

            PreparedStatement st = con.prepareStatement("SELECT * FROM RECIPE WHERE UPPER(RECIPENAME) LIKE ?");
            st.setString(1, "%"+nameOfRecipe.toUpperCase()+"%");
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Recipe recipe = fromResultSet(rs);
                list.add(recipe);
            }

            rs.close();
            st.close();

        }catch(SQLException e){
            Log.e("ERROR:",e.getMessage());
        }

        return list;
    }

    public ArrayList<Recipe> getRecipesByCategory(String category){
        ArrayList<Recipe> list = new ArrayList<>();
        try(Connection con = connection()){

            PreparedStatement st = con.prepareStatement("SELECT * FROM RECIPE WHERE UPPER(CATEGORY)=?");
            st.setString(1, category.toUpperCase());
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Recipe recipe = fromResultSet(rs);
                list.add(recipe);
            }

            rs.close();
            st.close();

        }catch(SQLException e){
            Log.e("ERROR:",e.getMessage());
        }

        return list;
    }

    public ArrayList<Recipe> searchByIngredients(String ingredient){
        ArrayList<Recipe> list = new ArrayList<>();
        try(Connection con = connection()){

            PreparedStatement st = con.prepareStatement("SELECT * FROM RECIPE,KEYINGREDIENTS WHERE RECIPE.RECIPENAME=KEYINGREDIENTS.RECIPENAME AND UPPER(KEYINGREDIENT)=?");
            st.setString(1, ingredient.toUpperCase());
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Recipe recipe = fromResultSet(rs);
                list.add(recipe);
            }

            rs.close();
            st.close();

        }catch(SQLException e){
            Log.e("ERROR:",e.getMessage());
        }

        return list;
    }
}
