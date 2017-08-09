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
        else
            return R.drawable.background;



    }

    public void set()
    {

        String ss="\n" +
                "\n" +
                "\n" +
                "<div class=\"se_component se_paragraph default\">\n" +
                "    <div class=\"se_sectionArea\">\n" +
                "        <div class=\"se_editArea\">\n" +
                "            <div class=\"se_viewArea se_ff_nanumgothic se_fs_T3 se_align-center\" >\n" +
                "                <div class=\"se_editView\">\n" +
                "                    <div class=\"se_textView\">\n" +
                "                        <p class=\"se_textarea\"><!-- SE3-TEXT { --><span>음? 실수로 반대로 열어버린것 같네요<br></span><span><br></span><span><strike>상관없으니 그대로 진행합니다</strike></span><!-- } SE3-TEXT --></p>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "    \n" +
                "\n" +
                "\n" +
                "\t\t<div class=\"se_component se_image default\">\n" +
                "\t\t\t<div class=\"se_sectionArea se_align-justify\">\n" +
                "\t\t\t\t<div class=\"se_editArea\">\n" +
                "\t\t\t\t\t<div class=\"se_viewArea\" >\n" +
                "\t\t\t\t\t\t<a href=\"#\" onclick=\"return false;\" class=\"se_mediaArea __se_image_link __se_link\" data-linktype=\"img\" data-linkdata='{\"imgId\" : \"SEDOC-1487042410221-694079435_image_3_img\", \"src\" : \"http://postfiles9.naver.net/MjAxNzAyMTNfMTc4/MDAxNDg2OTk2NDAxMTE3.OYkUptt5KLcgra7os4tOvbK4VsuAvpUJpud4fZ3jso8g.mfWVud0PdwnjidFK1CPsu9-e1q4NPzbHfsF9Cp2KaEsg.JPEG.elaha00/KakaoTalk_Moim_311GK6wlDybVtbQPAihbUBj3doKpot.jpg\", \"linkUse\" : \"false\",\"link\" : \"\"}'>\n" +
                "\t\t\t\t\t\t\t<img src=\"http://postfiles9.naver.net/MjAxNzAyMTNfMTc4/MDAxNDg2OTk2NDAxMTE3.OYkUptt5KLcgra7os4tOvbK4VsuAvpUJpud4fZ3jso8g.mfWVud0PdwnjidFK1CPsu9-e1q4NPzbHfsF9Cp2KaEsg.JPEG.elaha00/KakaoTalk_Moim_311GK6wlDybVtbQPAihbUBj3doKpot.jpg?type=w773\" width=\"1440\" height=\"810\" data-attachment-id=\"IM0aSvqVF54cSA_wVbFMOy1MXP7k\" alt=\"\" class=\"se_mediaImage __se_img_el\" id=\"SEDOC-1487042410221-694079435_image_3_img\">\n" +
                "\t\t\t\t\t\t</a>\n" +
                "\t\t\t\t\t\t\t<div class=\"se_editView\">\n" +
                "\t\t\t\t\t\t\t\t<div class=\"se_textView se_mediaCaption\">\n" +
                "\t\t\t\t\t\t\t\t\t<span class=\"se_textarea\">모니터의 생명, 전면부!</span>\n" +
                "\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "    \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "<div class=\"se_component se_paragraph default\">\n" +
                "    <div class=\"se_sectionArea\">\n" +
                "        <div class=\"se_editArea\">\n" +
                "            <div class=\"se_viewArea se_ff_nanumgothic se_fs_T3 se_align-center\" >\n" +
                "                <div class=\"se_editView\">\n" +
                "                    <div class=\"se_textView\">\n" +
                "                        <p class=\"se_textarea\"><!-- SE3-TEXT { --><span>뽀샤시하게 보이는 모니터의 전면부가 절 두근두근하게 만드네요<br></span><span><br></span><span>해체를 계속 진행해볼까요!</span><span><br></span><span></span><!-- } SE3-TEXT --></p>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "    \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "<div class=\"se_component se_sticker default \">\n" +
                "\t<div class=\"se_sectionArea se_align-center\">\n" +
                "\t\t<div class=\"se_editArea\">\n" +
                "\t\t\t<div class=\"se_viewArea\">\n" +
                "\t\t\t\t<div id=\"SEDOC-1487042410221-694079435_sticker_2\" class=\"se_sticker_area\">\n" +
                "\t\t\t\t \t<a href=\"#\" onclick=\"return false;\" class=\"se_mediaArea __se_sticker_link __se_link\" data-linktype=\"sticker\" data-linkdata='{\"src\" : \"http://gfmarket.phinf.naver.net/moon_and_james/original_4.png\", \"packCode\" : \"moon_and_james\", \"seq\" : \"4\", \"width\" : \"110\", \"height\" : \"115\"}'>\n" +
                "\t\t\t\t\t\t<img src=\"http://gfmarket.phinf.naver.net/moon_and_james/original_4.png?type=p50_50\" class=\"__se_img_el\" alt=\"스티커 이미지\" width=110 height=115>\n" +
                "\t\t\t\t\t</a>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "</div>\n";


        String str="미친듯이 더운 이 여름, 우리들에게 필수품이 있다." +

                "바로 핸디형 선풍기이다." +
                "<img src='review1'>"+
                "그립감도 좋고, 편리하다." +
                "<img src='review2'>"+
                "그리고 세워둘 수 있어서 나름대로 장점이 존재한다. " +
                "<img src='review3'>";
        str=ss;

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
