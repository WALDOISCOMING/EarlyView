package com.khackathon.noobnoob.earlyview.fragment.requestreviewer;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.khackathon.noobnoob.earlyview.R;
import com.khackathon.noobnoob.earlyview.requestreviewer.RequestReviewer;

/*
생성자:길경완
생성일자:2017_08_05
수정자:x
수정일자:x
후기단 컨텐츠 프래그먼트 아마도 여기에서 지원을 하는것을 넣어야할 것이다.
*/
public class RequestReviewerContentFragment extends Fragment {

    public RequestReviewerContentFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_request_reviewer_content,container,false);

        RequestReviewer requestReviewer = getArguments().getParcelable("requestreviewerdata");
        String data = requestReviewer.getRequestReviewerTitle();


        TextView title = (TextView)view.findViewById(R.id.request_reviewer_content_title);
        title.setText(data);
        return view;
    }

}
