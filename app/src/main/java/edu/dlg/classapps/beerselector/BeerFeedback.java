package edu.dlg.classapps.beerselector;

public class BeerFeedback {

    private String name;
    private String comment;
    private int rating;

    public BeerFeedback(String newName) {
        this.name = newName;
        this.comment = new String();
        this.rating = 0;
    }

    public void setRating(String newComment, int newRating) {
        this.comment = newComment;
        this.rating = newRating;
    }

    public String getName() {
        return name;
    }

    public String getComment() {
        return comment;
    }

    public int getRating() {
        return rating;
    }
}
