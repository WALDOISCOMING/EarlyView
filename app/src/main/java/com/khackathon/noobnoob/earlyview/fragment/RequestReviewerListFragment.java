package com.khackathon.noobnoob.earlyview.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.khackathon.noobnoob.earlyview.R;

/*
생성자:길경완
생성일자:2017_08_02
수정자:x
수정일자:x
내용:
리퀘스트리뷰어 아이템뷰의 내용을 채워 넣는 기능을 한다.
여기에서 onclick시 이동 기능또한 있다. 아직 작업 안함/
*/
public class RequestReviewerListFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_request_reviewer_list, container, false);
    }

}
