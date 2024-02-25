package ReviewsRatings;

public class Review
{
    private int IdReview;
    private static int NbReviews=0;
    private int IdCustomer;
    private String UserName;
    private String Date;
    private String Comment;
    private int Note;

    public Review(int IdCustomer,String UserName,String Date,String Comment,int Note)
    {
        this.IdReview=NbReviews;
        NbReviews+=1;
        this.IdCustomer=IdCustomer;
        this.UserName=UserName;
        this.Date=Date;
        this.Comment=Comment;
        this.Note=Note;
    }

    public int getNote() {
        return Note;
    }

    public String getComment() {
        return Comment;
    }

    public String getUserName() {
        return UserName;
    }
}
