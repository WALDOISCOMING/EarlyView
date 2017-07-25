package com.khackathon.noobnoob.earlyview.review;

import java.util.ArrayList;
import java.util.Date;

/*
생성자:길경완
생성일자:2017_07_25
수정자:x
수정일자:x
내용:
실제 DB에 존재하는 Reivew와 동일한 내용을 가지는 class





 */
public class Review {
    private int reviewID;
    private int userID;
    private Date reivewDate;
    private String reviewTitle;
    private String reviewContents;
    private int 후기단ID;
    private  String 후기단Name;
    private int hit;

    private int categoryID;
    private String categoryName;

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }



 //set get
    public int getReviewID() {
        return reviewID;
    }

    public void setReviewID(int reviewID) {
        this.reviewID = reviewID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Date getReivewDate() {
        return reivewDate;
    }

    public void setReivewDate(Date reivewDate) {
        this.reivewDate = reivewDate;
    }

    public String getReviewTitle() {
        return reviewTitle;
    }

    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }

    public String getReviewContents() {
        return reviewContents;
    }

    public void setReviewContents(String reviewContents) {
        this.reviewContents = reviewContents;
    }

    public int get후기단ID() {
        return 후기단ID;
    }

    public void set후기단ID(int 후기단ID) {
        this.후기단ID = 후기단ID;
    }

    public String get후기단Name() {
        return 후기단Name;
    }

    public void set후기단Name(String 후기단Name) {
        this.후기단Name = 후기단Name;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }



    public Review(int mreviewID)
    {
        reviewID = mreviewID;
        //원래라면 ID값을 통하여 나머지를 가져온다.
    }

     public Review()
     {
     }

     //카테고리가 같은것만 반환시킴.
     @Override
     public boolean equals(Object o)
     {

         final String other = (String)o;
        if(other.equals(this.categoryName))
        {
            return true;
        }

               return false;

     }
/*
 private int reviewID;
    private int userID;
    private Date reivewDate;
    private String reviewTitle;
    private String reviewContents;
    private int 후기단ID;
    private  String 후기단Name;
    private int hit;

    private int categoryID;
    private String categoryName;
 */
     @Override
     public String toString()
     {
         return reviewID+""+userID+reivewDate+reviewTitle+reviewContents+categoryName;
     }
     public void setdumiReview(int mreviewID, int muserID, Date mreivewDate, String mreivewTitle, String mreviewContents,
                               int m후기단ID, String m후기단Name, int mhit,int mcategoryID,String mcategoryName)
     {
         setReviewID(mcategoryID);
         setUserID(muserID);
         setReivewDate(mreivewDate);
         setReviewTitle(mreivewTitle);
         setReviewContents(mreviewContents);
         set후기단ID(m후기단ID);
         set후기단Name(m후기단Name);
         setHit(mhit);
         setCategoryID(mcategoryID);
         setCategoryName(mcategoryName);

     }


     public Review getdumiReview(int start,int end)
     {


         return this;
     }

     /*
     private int reviewID;
    private int userID;
    private Date reivewDate;
    private String reviewTitle;
    private String reviewContents;
    private int 후기단ID;
    private  int 후기단Name;
    private int hit;
      */




}
