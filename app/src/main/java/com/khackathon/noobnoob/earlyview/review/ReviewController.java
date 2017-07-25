package com.khackathon.noobnoob.earlyview.review;

import android.util.Log;

import java.util.ArrayList;

/**
 /*
 생성자:길경완
 생성일자:2017_07_25
 수정자:x
 수정일자:x
 내용:
리뷰를 컨트롤한다.




 */

public class ReviewController {
    //싱글톤패턴을 이용하자.
    private static ReviewController instance = new ReviewController();
    private ReviewController()
    {
    }
    private ArrayList<Review> reviewArrayList;
    public static ReviewController getInstance()
    {
        Log.v("controller","review controller singleton");
        return instance;
    }

    String category;
    Review reivew;
    //현재는 예제로만 return 함.
    public void setReview()
    {

    }

    //원래는 이런 형식이 아닌 sql문으로 날짜 기준으로 일정 갯수를 하면된다.
    public void setdumitReivew(ArrayList<Review> mreviewArrayList,String category)
    {
        reviewArrayList = new ArrayList<Review>();
        for(int i=0;i<mreviewArrayList.size();i++)
        {
            if(mreviewArrayList.get(i).equals(category))
            {
                reviewArrayList.add(mreviewArrayList.get(i));
            }
        }


    }

    public ArrayList<Review> getdumiReview()
    {
        return reviewArrayList;
    }
    /*
    카테고리를 통하여 Review를 가져온다.

    */

}
