package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.khackathon.noobnoob.earlyview.R;

/*
생성자:길경완
생성일자:2017_07_27
수정자:x
수정일자:x
내용:
글 내용을 본다. 원래라면 뒤로가기로 ReviewListFragment로 돌아가야한다. 이건 스택을 이용해야 될것이다.
Bundle값을 받아 textview로 뽑는다.
*/

public class ReviewContentFragment extends Fragment {

    public ReviewContentFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_review_content,container,false);

        String data = getArguments().getString("DATA");
        TextView textView = (TextView)view.findViewById(R.id.review_content_test);
        textView.setText(data);

        return view;
    }





}
