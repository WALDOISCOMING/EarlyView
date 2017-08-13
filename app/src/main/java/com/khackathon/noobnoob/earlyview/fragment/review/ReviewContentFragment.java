package com.khackathon.noobnoob.earlyview.fragment.review;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.Html;
import android.text.Spanned;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import com.khackathon.noobnoob.earlyview.R;
import com.khackathon.noobnoob.earlyview.review.Review;

import org.xml.sax.XMLReader;

/*
생성자:길경완
생성일자:2017_07_27
----------------------------------------------------------------------------------------------------
수정자:길경완
수정일자:2017_07802
수정내용:
생성:이전의 String이 아닌 bundle에서 객체를 받는 getArguments().getParcelable("reviewdata")를 추가.
----------------------------------------------------------------------------------------------------
내용:
글 내용을 본다. 원래라면 뒤로가기로 ReviewListFragment로 돌아가야한다. 이건 스택을 이용해야 될것이다.
Bundle값을 받아 textview로 뽑는다.
*/

public class ReviewContentFragment extends Fragment {
    Spanned imageText;

    int width=0;
    int hieght=0;

    public ReviewContentFragment() {
        // Required empty public constructor
    }

    public void setXY()
    {
        DisplayMetrics dm = getActivity().getApplicationContext().getResources().getDisplayMetrics();
        width = dm.widthPixels;


    }
    public Integer imageSet(String str)
    {

        if (str.equals("review1"))
            return R.drawable.review1;

        if (str.equals("review2"))
            return R.drawable.review2;
        if (str.equals("review3"))
            return R.drawable.review3;
        if (str.equals("review4"))
            return R.drawable.review4;
        if (str.equals("review5"))
            return R.drawable.review5;
        if (str.equals("review6"))
            return R.drawable.review6;
        if (str.equals("review7"))
            return R.drawable.review7;
        if (str.equals("review8"))
            return R.drawable.review8;
        if (str.equals("review9"))
            return R.drawable.review9;
        if (str.equals("review10"))
            return R.drawable.review10;
        if (str.equals("review11"))
            return R.drawable.review11;
        if (str.equals("review12"))
            return R.drawable.review12;
        if (str.equals("review13"))
            return R.drawable.review13;
        if (str.equals("review14"))
            return R.drawable.review14;
        if (str.equals("review15"))
            return R.drawable.review15;
        if (str.equals("review16"))
            return R.drawable.review16;
        if (str.equals("review17"))
            return R.drawable.review17;
        if (str.equals("review18"))
            return R.drawable.review18;
        if (str.equals("review19"))
            return R.drawable.review19;
        if (str.equals("review20"))
            return R.drawable.review20;
        if (str.equals("review21"))
            return R.drawable.review21;



        else
            return R.drawable.background;



    }

    public void set()
    {



        String str="미친듯이 더운 이 여름, 우리들에게 필수품이 있다." +

                "바로 핸디형 선풍기이다." +
                "<img src='review1'>"+
                "그립감도 좋고, 편리하다." +
                "<img src='review2'>"+
                "그리고 세워둘 수 있어서 나름대로 장점이 존재한다. " +
                "<img src='review3'>";


        imageText = Html.fromHtml(str,
                new Html.ImageGetter() {
                    @Override public Drawable getDrawable(String source)
                    {
                        Integer value = imageSet(source);
                        if (value!=null) {
                            Drawable draw = getResources().getDrawable(value);

                            int d;
                            d = width/draw.getIntrinsicWidth();


                            draw.setBounds(20, 20, width-20 ,draw.getIntrinsicHeight()*d-20);
                            return draw; } return null; } },
                new Html.TagHandler(){

                    @Override
                    public void handleTag(boolean opening, String tag, Editable output, XMLReader xmlReader) {

                    }
                });
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_review_content,container,false);

        Review review  =getArguments().getParcelable("reviewdata");
        String data = review.getReviewContents()+"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";

        //가로세로 크기 구하기
         TextView textView = (TextView)view.findViewById(R.id.review_content_view);

setXY();

        set();




        textView.setText(imageText);

        TextView tv = (TextView)view.findViewById(R.id.review_content_date);
        tv.setText(review.getHit()+"명이 보았습니다.");






        return view;
    }





}
