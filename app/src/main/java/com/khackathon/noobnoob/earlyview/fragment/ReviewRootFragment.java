package com.khackathon.noobnoob.earlyview.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.khackathon.noobnoob.earlyview.R;


/*
생성자:길경완
생성일자:2017_07_27
수정자:x
수정일자:x
내용:
리뷰 전체의 껍대기라고 생각하면 된다. 이 프레그먼트는 ReviewList와 ReviewContent를 둘다 보여줘야 하는 상황이므로
필요하다. 이것이 없다면 List에서 제목을 눌러 Content로 갔을 경우 다른 Tab이 사라진다.
이것의 하는 행동은 오직 view를 자신으로 잡은 뒤에 바로 트랜잭션을 list로 보내준다.

 */
public class ReviewRootFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_review_root,container,false);
        FragmentTransaction transaction = getFragmentManager()
                .beginTransaction();

        transaction.replace(R.id.review_root_frame, new ReviewListFragment());

        transaction.commit();

        return view;
    }

}
