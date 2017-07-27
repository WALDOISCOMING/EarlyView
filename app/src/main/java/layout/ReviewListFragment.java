package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.khackathon.noobnoob.earlyview.R;
import com.khackathon.noobnoob.earlyview.review.Review;
import com.khackathon.noobnoob.earlyview.review.ReviewController;

import java.util.ArrayList;
import java.util.Date;

/*
생성자:길경완
생성일자:2017_07_27
수정자:x
수정일자:x
내용:
ReviewListFragment이다. 이전 내용은 모두  testFragment와 동일하지만, 이제는 제대로된 이동이 가능하다.
하지만 아직은 뒤로 돌아가기가 안된다. 또한 값을 Bundle에 저장하여 보낸다.
 */
public class ReviewListFragment extends Fragment {

    String mData[];

    ReviewController reviewController = ReviewController.getInstance();


    AdapterView.OnItemClickListener listener= new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // TODO Auto-generated method stub
            //수정 프래그먼트로 이동.
            Log.v("review","이동"+mData[position]);
            reviewToPosition(mData[position]);

        }

    };


    private void reviewToPosition(String mData)
    {

        //데[이터 저장을 위한 과정
        Fragment fragment = new ReviewContentFragment();

        Bundle bundle  = new Bundle(1);
        bundle.putString("DATA",mData);
        fragment.setArguments(bundle);


        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction trans = fragmentManager.beginTransaction();
        trans.replace(R.id.review_root_frame, fragment);

        trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        trans.addToBackStack(null);


        trans.commit();


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
        mData = new String[reviewArrayList.size()];
        for(int i=0;i<reviewArrayList.size();i++)
        {
            mData[i] = reviewArrayList.get(i).getReviewTitle();
        }
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_review_list, container, false);
        //아래 mdata를 쓰기위해 부른다.
        setReviewArrayList();
        setmData();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getActivity().getApplicationContext(), // 현재 화면의 제어권자
                R.layout.review_list_item,
                R.id.review_list_item_textview,
                //한행마다 보여줄 레이아웃을 지정
                mData); // 다량의 데이터

        ListView lv = (ListView)view.findViewById(R.id.review_lists);

        lv.setAdapter(adapter);
        lv.setOnItemClickListener(listener);//리스트를 누르면 이동.

        return view;

    }


}
