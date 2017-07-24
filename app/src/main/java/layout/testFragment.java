package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.khackathon.noobnoob.earlyview.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

/*
생성자:길경완
생성일자:2017_07_24
수정자:x
수정일자:x

테스트용 프래그먼트이다.
리스트 뷰를 이용하는 예이다. 이것을 통하여 후에 나올 두개 리뷰와 후기단지원리스트를 만들면된다.
 */
public class testFragment extends Fragment {

    ArrayList<String> mData = new ArrayList<String>();

    public testFragment() {
    }
    private void setmData()
    {

        mData.add(0,"리뷰1");
        mData.add(1,"리뷰2");
        mData.add(2,"리뷰3");
        mData.add(3,"리뷰4");
        mData.add(4,"리뷰5");
        mData.add(5,"리뷰6");
        mData.add(6,"리뷰7");
        mData.add(7,"리뷰8");
        mData.add(8,"리뷰9");
        mData.add(9,"리뷰10");
        mData.add(10,"곰보선장");
        mData.add(11,"감자");
        mData.add(12,"공대협");
        mData.add(13,"17김도");
        mData.add(14,"김대현");


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //return으로 보여줄 view이다.
        View view = inflater.inflate(R.layout.fragment_test,null);
        //아래 mdata를 쓰기위해 부른다.
        setmData();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getActivity().getApplicationContext(), // 현재 화면의 제어권자
                R.layout.fragment_test_item,
                R.id.testList_textView,
                //한행마다 보여줄 레이아웃을 지정
                mData); // 다량의 데이터

        ListView lv = (ListView)view.findViewById(R.id.testListView);
        lv.setAdapter(adapter);
       // lv.setOnItemClickListener(listener);누를수 있는 기능. 이건 후에 쓸것이다.




        return view;
    }




}
