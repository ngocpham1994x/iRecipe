package comp3350.iRecipe.Persistence;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import comp3350.iRecipe.Objects.Comment;
import comp3350.iRecipe.Objects.Recipe;

public class CommentHSQLDB implements RecipeCommentInterface{

    private String dbPath;

    public CommentHSQLDB(final String dbPath){
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    public ArrayList<Comment> getComments(String recipeName){

        ArrayList<Comment> comments = new ArrayList<>();
        try(Connection con = connection()){
            PreparedStatement st = con.prepareStatement("SELECT * FROM COMMENTS WHERE RECIPENAME=?");
            st.setString(1,recipeName);
            ResultSet rs = st.executeQuery();

            while(rs.next()){
                Comment comment = fromResultSet(rs);
                comments.add(comment);
            }
            rs.close();
            st.close();

        }catch(SQLException e){
            e.printStackTrace();
        }
        return comments;
    }

    public boolean addComments(String recipeName, Comment comment){


        try(Connection con = connection()){
            PreparedStatement st = con.prepareStatement("INSERT INTO COMMENTS VALUES(?,?,?,?)");
            st.setString(1,recipeName);
            st.setString(2,comment.getUserName());
            st.setString(3, comment.getComment());
            st.setInt(4,comment.getRating());

            st.executeUpdate();
            st.close();

        }catch(SQLException e){
            return false;
        }
        return true;
    }

    private Comment fromResultSet(ResultSet rs) throws SQLException{
        int rating = rs.getInt("RATING");
        String comment = rs.getString("COMMENT");
        String user = rs.getString("USERNAME");
        return new Comment(rating, comment, user);
    }

}
