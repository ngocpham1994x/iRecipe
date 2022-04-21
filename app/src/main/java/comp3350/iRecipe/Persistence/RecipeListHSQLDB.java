package comp3350.iRecipe.Persistence;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import comp3350.iRecipe.Objects.Category;
import comp3350.iRecipe.Objects.CookingLevel;
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
                Recipe recipe = fromResultSet(rs,con);
                list_from_database.add(recipe);

            }
            rs.close();
            st.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        return list_from_database;
    }

    private Recipe fromResultSet(ResultSet rs, Connection con) throws  SQLException{
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
        PreparedStatement st2 = con.prepareStatement("SELECT * FROM INGREDIENTS WHERE RECIPENAME=?");
        st2.setString(1,name);
        Recipe recipe = new Recipe(name, Category.getCategory(category), CookingLevel.getCookingLevel(cookingLevel), prepTime, cookingTime, serving, ingred, keyIngred, newInstr);
        ResultSet rs2 = st2.executeQuery();
        while(rs2.next()){
            String ingredStr = rs2.getString("INGREDIENT");
            recipe.addToIngredients(ingredStr);
        }
        rs2.close();
        st2.close();

        PreparedStatement st3 = con.prepareStatement("SELECT * FROM KEYINGREDIENTS WHERE RECIPENAME=?");
        st3.setString(1,recipe.getName());

        ResultSet rs3 = st3.executeQuery();
        while(rs3.next()){
            String keyIngredStr = rs3.getString("KEYINGREDIENT");
            recipe.addToKeyIngredients(keyIngredStr);
        }
        rs3.close();
        st3.close();
        return recipe;
    }

    //Return false when we already have a Recipe with the same name
    public boolean addRecipe(Recipe newRecipe){

        if(searchByName(newRecipe.getName()) != null){
            return false;
        }

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

            ArrayList<String> ingres = newRecipe.getIngredients();
            for(int i=0; i<ingres.size(); i++){
                PreparedStatement st2 = con.prepareStatement("INSERT INTO INGREDIENTS VALUES(?,?)");
                st2.setString(1, newRecipe.getName());
                st2.setString(2,ingres.get(i));
                st2.executeUpdate();
                st2.close();
            }

            ArrayList<String> keyIngres = newRecipe.getKeyIngredients();
            for(int i=0; i<keyIngres.size(); i++){
                PreparedStatement st3 = con.prepareStatement("INSERT INTO KEYINGREDIENTS VALUES(?,?)");
                st3.setString(1, newRecipe.getName());
                st3.setString(2,keyIngres.get(i));
                st3.executeUpdate();
                st3.close();
            }

            st.close();

        }catch(SQLException e){
            return false;
        }
        return true;
    }

    public boolean removeRecipe(Recipe toRemove){
        try(Connection con = connection()){
            PreparedStatement st1 = con.prepareStatement("DELETE FROM INGREDIENTS WHERE UPPER(RECIPENAME)=?");
            st1.setString(1,toRemove.getName().toUpperCase());
            st1.executeUpdate();


            PreparedStatement st2 = con.prepareStatement("DELETE FROM KEYINGREDIENTS WHERE UPPER(RECIPENAME)=?");
            st2.setString(1,toRemove.getName().toUpperCase());
            st2.executeUpdate();

            PreparedStatement st4 = con.prepareStatement("DELETE FROM COMMENTS WHERE UPPER(RECIPENAME)=?");
            st4.setString(1,toRemove.getName().toUpperCase());
            st4.executeUpdate();


            PreparedStatement st3 = con.prepareStatement("DELETE FROM RECIPE WHERE UPPER(RECIPENAME)=?");
            st3.setString(1,toRemove.getName().toUpperCase());
            st3.executeUpdate();


        }catch(SQLException e){
            return false;
        }
        return true;
    }


    public Recipe searchByName(String nameOfRecipe){
        Recipe recipe = null;
        try(Connection con = connection()){

            PreparedStatement st = con.prepareStatement("SELECT * FROM RECIPE WHERE UPPER(RECIPENAME) = ?");
            st.setString(1, nameOfRecipe.toUpperCase());
            ResultSet rs = st.executeQuery();
            rs.next();
            recipe = fromResultSet(rs,con);
            rs.close();
            st.close();

        }catch(SQLException e){
            //Log.e("ErrorHere","Error",e);

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
                Recipe recipe = fromResultSet(rs,con);
                list.add(recipe);
            }

            rs.close();
            st.close();

        }catch(SQLException e){
            return list;
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
                Recipe recipe = fromResultSet(rs,con);
                list.add(recipe);
            }

            rs.close();
            st.close();

        }catch(SQLException e){
            //Log.e("ERROR:",e.getMessage());
            return list;
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
                Recipe recipe = fromResultSet(rs,con);
                list.add(recipe);
            }

            rs.close();
            st.close();

        }catch(SQLException e){
            //Log.e("ERROR:",e.getMessage());
            return list;
        }

        return list;
    }
}
