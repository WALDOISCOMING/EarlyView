package com.khackathon.noobnoob.earlyview.Adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.khackathon.noobnoob.earlyview.R;
import com.khackathon.noobnoob.earlyview.fragment.requestreviewer.RequestReviewerContentFragment;
import com.khackathon.noobnoob.earlyview.requestreviewer.RequestReviewer;

import java.util.ArrayList;

/*
생성자:길경완
생성일자:2017_08_05
수정자:x
수정일자:x
내용:
후기단 아이템뷰의 내용을 채워 넣는 기능을 한다.
여기에서 onclick시 이동 기능또한 있다.
*/

public class RequestReviewerListAdapter extends   RecyclerView.Adapter<RequestReviewerListAdapter.ViewHolder> {
    Context context;
    //내용을 가진다.
    ArrayList<RequestReviewer> reviewList;


    public RequestReviewerListAdapter(Context context, ArrayList<RequestReviewer> reviewList)
    {
        this.context = context;
        this.reviewList= reviewList;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fragment_request_reviewer_list_cardview,null);
        return new ViewHolder(view);
    }


    @TargetApi(23)
    /** 정보 및 이벤트 처리는 이 메소드에서 구현 **/
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        RequestReviewer nowrequestReviewer = reviewList.get(position);


      holder.request_reviewer_list_cardview_titleTextView.setText(nowrequestReviewer.getRequestReviewerTitle());
       holder.request_reviewer_list_cardview_writerTextView.setText(nowrequestReviewer.getCompanyName());
        holder.request_reviewer_list_cardview_hitTextView.setText(nowrequestReviewer.getHit()+"");


        holder.cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {



                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Fragment fragment = new RequestReviewerContentFragment();
                Bundle bundle  = new Bundle(1);
                bundle.putParcelable("requestreviewerdata",reviewList.get(position));
                fragment.setArguments(bundle);

                activity.getSupportFragmentManager().beginTransaction().replace(R.id.request_reviewer_root_frame,fragment).addToBackStack(null).commit();



            }
        });

    }




    @Override
    public int getItemCount() {
        return reviewList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {


        ImageView request_reviewer_list_cardview_mainImageView;
//        ImageView review_list_cardview_heartImageView;

        TextView request_reviewer_list_cardview_titleTextView;
        TextView request_reviewer_list_cardview_writerTextView;
        TextView request_reviewer_list_cardview_hitTextView;

        CardView cardView;
        public ViewHolder(View view) {
            super(view);

            request_reviewer_list_cardview_titleTextView=(TextView)view.findViewById(R.id.request_reviewer_list_cardview_titleTextView);
            request_reviewer_list_cardview_writerTextView=(TextView)view.findViewById(R.id.request_reviewer_list_cardview_writerTextView);
            request_reviewer_list_cardview_hitTextView=(TextView)view.findViewById(R.id.request_reviewer_list_cardview_hitTextView);
            cardView = (CardView)view.findViewById(R.id.request_reviewer_list_cardview);
        }
    }

}
