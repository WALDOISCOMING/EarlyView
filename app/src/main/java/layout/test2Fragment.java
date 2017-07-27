package layout;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.khackathon.noobnoob.earlyview.R;


/*
생성자:길경완
생성일자:2017_07_24
____________________________________________________________________________________________________
수정자:길경완
수정일자:2017_07_26
수정내용:
edittext에 버튼을 통해 사진 넣기 추가시킴.
____________________________________________________________________________________________________
수정자:길경완
수정일자:2017_07_27
수정내용:
버튼을 누르면 유저 갤러리로 간다. 이거에 대한 내용은 먼저 하던지 내가 오면 하던지하면된다.
____________________________________________________________________________________________________
내용:
글을 쓰는 용도. 이미지와 글을 함께 쓰도록 한다.
*/

public class test2Fragment extends Fragment {


    final int REQ_CODE_SELECT_IMAGE=100;

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
        View view = inflater.inflate(R.layout.fragment_test2,null);
        final EditText imgtext =(EditText)view.findViewById(R.id.editText);
        //버튼을 누르면 괴상한 산 이미지를 호출한다.
        final Button button = (Button)view.findViewById(R.id.imgbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(android.provider.MediaStore.Images.Media.CONTENT_TYPE);
                intent.setData(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, REQ_CODE_SELECT_IMAGE);

                /*

                //시작위치
                int start = imgtext.getSelectionStart();
                imgtext.append("----------------------");
                //끝위치
                int end = imgtext.getSelectionEnd();

                //이미지를 가져오고 비트맵으로 변경하는것.
                Spannable span = imgtext.getText();
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.m);
                span.setSpan(new ImageSpan(getActivity(),bitmap),start,end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                */
            }
        });
        return view;
    }



}
