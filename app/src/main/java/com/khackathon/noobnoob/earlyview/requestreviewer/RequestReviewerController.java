package com.khackathon.noobnoob.earlyview.requestreviewer;

import android.util.Log;

import java.util.ArrayList;

/*
생성자:길경완
생성일자:2017_08_03
내용:
UMl 기준으로 만듬 수정 가능.
____________________________________________________________________________________________________



 */
public class RequestReviewerController {


    private static RequestReviewerController instance = new RequestReviewerController();
    private RequestReviewerController()
    {
    }
    private ArrayList<RequestReviewer> requestReviewersArrayList;
    public static RequestReviewerController getInstance()
    {
        Log.v("controller","review controller singleton");
        return instance;
    }

    String category;
    RequestReviewer reivew;
    //현재는 예제로만 return 함.
    public void setReview()
    {

    }

    //원래는 이런 형식이 아닌 sql문으로 날짜 기준으로 일정 갯수를 하면된다.
    public void setdumitReivew(ArrayList<RequestReviewer> mreviewArrayList)
    {
        requestReviewersArrayList = new ArrayList<RequestReviewer>();
        for(int i=0;i<mreviewArrayList.size();i++)
        {

            requestReviewersArrayList.add(mreviewArrayList.get(i));

        }


    }


}
