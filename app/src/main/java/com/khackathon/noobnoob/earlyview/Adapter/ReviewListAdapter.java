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
import com.khackathon.noobnoob.earlyview.fragment.review.ReviewContentFragment;
import com.khackathon.noobnoob.earlyview.review.Review;

import java.util.ArrayList;


/*
생성자:길경완
생성일자:2017_08_02
수정자:x
수정일자:x
내용:
리뷰 아이템뷰의 내용을 채워 넣는 기능을 한다.
여기에서 onclick시 이동 기능또한 있다.
*/
public class ReviewListAdapter extends   RecyclerView.Adapter<ReviewListAdapter.ViewHolder> {
    Context context;
    //내용을 가진다.
    ArrayList<Review> reviewList;


    public ReviewListAdapter(Context context, ArrayList<Review> reviewList)
    {
        this.context = context;
        this.reviewList= reviewList;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fragment_review_list_cardview,null);
        return new ViewHolder(view);
    }


    @TargetApi(23)
    /** 정보 및 이벤트 처리는 이 메소드에서 구현 **/
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Review nowReview = reviewList.get(position);

        holder.review_list_cardview_writerTextView.setText(nowReview.getUserName()); //작성자
           holder.review_list_cardview_titleTextView.setText(nowReview.getReviewTitle()); //제목
    //    holder.review_list_cardview_contentTextVeiw.setText(nowReview.getSubReviewContents()); //내용 일부
        holder.review_list_cardview_dateTextView.setText(nowReview.getReivewDate().toString()); //작성일
        holder.review_list_cardview_hitTextView.setText(nowReview.getHit()+"");//본사람
        holder.cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                //프래그먼트 이동해준다.
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Fragment fragment = new ReviewContentFragment();
                Bundle bundle  = new Bundle(1);
                bundle.putParcelable("reviewdata",reviewList.get(position));
                fragment.setArguments(bundle);

                activity.getSupportFragmentManager().beginTransaction().replace(R.id.review_root_frame,fragment).addToBackStack(null).commit();



            }
    });

    }




    @Override
    public int getItemCount() {
        return reviewList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView review_list_cardview_userImageView;
        ImageView review_list_cardview_mainImageView;
        ImageView review_list_cardview_heartImageView;

        TextView review_list_cardview_titleTextView;
        TextView review_list_cardview_dateTextView;
        TextView review_list_cardview_writerTextView;
        TextView review_list_cardview_hitTextView;

        CardView cardView;
        public ViewHolder(View view) {
            super(view);

            review_list_cardview_titleTextView=(TextView)view.findViewById(R.id.review_list_cardview_titleTextView);
            review_list_cardview_dateTextView=(TextView)view.findViewById(R.id.review_list_cardview_dateTextView);

            review_list_cardview_writerTextView=(TextView)view.findViewById(R.id.review_list_cardview_writerTextView);
            review_list_cardview_hitTextView=(TextView)view.findViewById(R.id.review_list_cardview_hitTextView);

            cardView = (CardView)view.findViewById(R.id.review_list_cardview);
        }
    }

}
