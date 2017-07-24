package layout;

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
생성일자:2017_07_24
수정자:x
수정일자:x
바뀌는거 보여주는용도임.
 */

public class test2Fragment extends Fragment {


    public test2Fragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test2, container, false);
    }



}
