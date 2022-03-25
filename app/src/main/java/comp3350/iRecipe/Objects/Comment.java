package comp3350.iRecipe.Objects;

public class Comment {
    private int rating;
    private String comment;
    private String userName;

    public Comment(int rating, String comment, String userName){
        this.rating = rating;
        this.comment = comment;
        this.userName = userName;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public String getUserName() {
        return userName;
    }
}
