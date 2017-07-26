package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.khackathon.noobnoob.earlyview.R;
import com.khackathon.noobnoob.earlyview.review.Review;
import com.khackathon.noobnoob.earlyview.review.ReviewController;


import java.util.ArrayList;
import java.util.Date;

/*
생성자:길경완
생성일자:2017_07_24
수정자:x
수정일자:x

내용:
테스트용 프래그먼트1이다.
리스트 뷰를 이용하는 예이다. 이것을 통하여 후에 나올 두개 리뷰와 후기단지원리스트를 만들면된다.
이것은 어느정도 만들어지면 제거되고 다른것으로 변경시키면 된다.
 */
public class testFragment extends Fragment {

    ArrayList<String> mData = new ArrayList<String>();

    ReviewController reviewController = ReviewController.getInstance();




    private TabLayout tabLayout;


    public testFragment() {
    }

    private void setReviewArrayList()
    {
        Review[] reivews = new Review[10];
        Date date =new Date();
            for(int i=0;i<10;i++)
                reivews[i] = new Review();
            reivews[0].setdumiReview(1, 1, date, "제목1", "내용1", 1, "삼성", 10, 1, "핸드폰부문");
            reivews[1].setdumiReview(2, 1, date, "제목2", "내용2", 2, "현대", 10, 1, "자동차부문");
            reivews[2].setdumiReview(3, 1, date, "제목3", "내용3", 3, "LG", 10, 1, "핸드폰부문");
            reivews[3].setdumiReview(4, 1, date, "제목4", "내용4", 4, "HP", 10, 1, "컴퓨터부문");
            reivews[4].setdumiReview(5, 1, date, "제목5", "내용5", 5, "애플", 10, 1, "핸드폰부문");
            reivews[5].setdumiReview(6, 1, date, "제목6", "내용6", 1, "삼성", 10, 1, "핸드폰부문");
            reivews[6].setdumiReview(7, 1, date, "제목7", "내용7", 2, "현대", 10, 1, "자동차부문");
            reivews[7].setdumiReview(8, 1, date, "제목8", "내용8", 3, "LG", 10, 1, "가전기기");
            reivews[8].setdumiReview(9, 1, date, "제목9", "내용9", 4, "HP", 10, 1, "컴퓨터부문");
            reivews[9].setdumiReview(10, 1, date, "제목10", "내용10", 5, "애플", 10, 1, "컴퓨터부문");
            ArrayList<Review> reviewArrayList = new ArrayList<Review>();


            for(int i=0;i<reivews.length;i++)
            {
                reviewArrayList.add(reivews[i]);
            }

            reviewController.setdumitReivew(reviewArrayList,"컴퓨터부문");


    }

    private void setmData()
    {
        ArrayList<Review> reviewArrayList = new ArrayList<Review>();
        reviewArrayList = reviewController.getdumiReview();
        for(int i=0;i<reviewArrayList.size();i++)
        {
            mData.add(i,reviewArrayList.get(i).toString());
        }


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        //더미데이터 어레이리스트를 세팅한다.
        setReviewArrayList();

        //return으로 보여줄 view이다.
        View view = inflater.inflate(R.layout.fragment_test,container,false);
        //아래 mdata를 쓰기위해 부른다.
        setmData();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getActivity().getApplicationContext(), // 현재 화면의 제어권자
                R.layout.fragment_test_item,
                R.id.testList_textView,
                //한행마다 보여줄 레이아웃을 지정
                mData); // 다량의 데이터

        ListView lv = (ListView)view.findViewById(R.id.testListView);
        lv.setAdapter(adapter);


       // lv.setOnItemClickListener(listener);누를수 있는 기능. 이건 후에 쓸것이다.






        return view;
    }







}
