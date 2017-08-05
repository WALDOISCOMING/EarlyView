package com.khackathon.noobnoob.earlyview.fragment.requestreviewer;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.khackathon.noobnoob.earlyview.Adapter.RequestReviewerListAdapter;
import com.khackathon.noobnoob.earlyview.R;
import com.khackathon.noobnoob.earlyview.requestreviewer.RequestReviewer;
import com.khackathon.noobnoob.earlyview.requestreviewer.RequestReviewerController;

import java.util.ArrayList;

/*
생성자:길경완
생성일자:2017_08_03
----------------------------------------------------------------------------------------------------
수정자:길경완
수정일자:2017_08_05
내용:기초적 더미 데이터 입력과 아이템뷰를 보이게함.
----------------------------------------------------------------------------------------------------
후기단 리스트 프래그먼트
*/
public class RequestReviewerListFragment extends Fragment {
    RequestReviewerController reviewController = RequestReviewerController.getInstance();


    ArrayList<RequestReviewer> requestReviewerArrayList;

    //카드뷰!
    private RecyclerView recyclerView;
    private LinearLayoutManager mLinearLayoutManager;

    private void setReviewArrayList()
    {
        RequestReviewer[] requestReviewer = new RequestReviewer[10];


        for(int i=0;i<10;i++)
            requestReviewer[i] = new RequestReviewer();
        requestReviewer[0].setdumiRequestReviewer("회사1","제목1",234);
        requestReviewer[1].setdumiRequestReviewer("회사2","제목2",234);
        requestReviewer[2].setdumiRequestReviewer("회사3","제목3",234);
        requestReviewer[3].setdumiRequestReviewer("회사4","제목4",234);
        requestReviewer[4].setdumiRequestReviewer("회사5","제목5",234);
        requestReviewer[5].setdumiRequestReviewer("회사6","제목6",234);
        requestReviewer[6].setdumiRequestReviewer("회사7","제목7",234);
        requestReviewer[7].setdumiRequestReviewer("회사8","제목8",234);
        requestReviewer[8].setdumiRequestReviewer("회사9","제목9",234);
        requestReviewer[9].setdumiRequestReviewer("회사10","제목10",234);



        requestReviewerArrayList= new ArrayList<RequestReviewer>();
        for(int i=0;i<10;i++) {
            requestReviewerArrayList.add(requestReviewer[i]);
        }

    }



    private void setReviewList()
    {
        RequestReviewerListAdapter adapter =
                new RequestReviewerListAdapter(getActivity(),requestReviewerArrayList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_request_reviewer_list, container, false);



        mLinearLayoutManager=new LinearLayoutManager(getActivity());
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView = (RecyclerView) view.findViewById(R.id.request_reviewer_lists);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(mLinearLayoutManager);
        //어댑터와 연결



        setReviewArrayList();
        setReviewList();

        return view;
    }

}
