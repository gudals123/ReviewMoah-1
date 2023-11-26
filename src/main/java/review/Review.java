package review;

public class Review {
	private int reviewID;
	private String userID;
	private String reviewContent;
	private String movieName;
	private String movieIMG;
	private String reviewDATE;
	private int reviewAvailable;
	
	public int getReviewID() {
		return reviewID;
	}
	public void setReviewID(int reviewID) {
		this.reviewID = reviewID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieIMG() {
		return movieIMG;
	}
	public void setMovieIMG(String movieIMG) {
		this.movieIMG = movieIMG;
	}
	public String getReviewDATE() {
		return reviewDATE;
	}
	public void setReviewDATE(String reviewDATE) {
		this.reviewDATE = reviewDATE;
	}
	public int getReviewAvailable() {
		return reviewAvailable;
	}
	public void setReviewAvailable(int reviewAvailable) {
		this.reviewAvailable = reviewAvailable;
	}
	
}
