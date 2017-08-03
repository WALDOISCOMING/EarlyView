package com.khackathon.noobnoob.earlyview.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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
리퀘스트리뷰어 루트 프래그먼트
*/


public class RequestReviewerRootFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_request_reviewer_root,container,false);
        FragmentTransaction transaction = getFragmentManager()
                .beginTransaction();

        transaction.replace(R.id.request_reviewer_root_frame, new RequestReviewerListFragment());

        transaction.commit();

        return view;
    }
}
