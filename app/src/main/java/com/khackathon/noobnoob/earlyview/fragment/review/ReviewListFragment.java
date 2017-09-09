package com.khackathon.noobnoob.earlyview.fragment.review;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.JsonReader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.khackathon.noobnoob.earlyview.Adapter.ReviewListAdapter;
import com.khackathon.noobnoob.earlyview.R;
import com.khackathon.noobnoob.earlyview.fragment.test;
import com.khackathon.noobnoob.earlyview.review.Review;
import com.khackathon.noobnoob.earlyview.review.ReviewController;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.net.ssl.HttpsURLConnection;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderIterator;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.annotation.Obsolete;
import cz.msebera.android.httpclient.client.ClientProtocolException;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.ResponseHandler;
import cz.msebera.android.httpclient.client.entity.UrlEncodedFormEntity;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.entity.StringEntity;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import cz.msebera.android.httpclient.impl.client.HttpClientBuilder;
import cz.msebera.android.httpclient.message.BasicNameValuePair;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;

/*
생성자:길경완
생성일자:2017_07_27
----------------------------------------------------------------------------------------------------
수정자:길경완
수정일자:2017_07_30
수정내용:
trans.addToBackStack(null);으로 back 버튼 기능을 넣음.
----------------------------------------------------------------------------------------------------
수정자:길경완
수정일자:2017_08_02
수정내용:
생성:RecyclerView recyclerView카드뷰 와 LinearLayoutManager mLinearLayoutManager; 카드뷰매니저 변수
생성:setReviewList()메소드는 ReviewListAdapter로 reivewArrayList를 보내준다.
제거:void reviewToPosition(String mData) 이제 이 기능인 클릭시 이동을 ReviewListAdapter에서 직접한다.
제거: AdapterView.OnItemClickListener listener또한 필요없으므로 제거된다.
----------------------------------------------------------------------------------------------------
내용:
ReviewListFragment이다. 이전 내용은 모두  testFragment와 동일하지만, 이제는 제대로된 이동이 가능하다.
하지만 아직은 뒤로 돌아가기가 안된다. 또한 값을 Bundle에 저장하여 보낸다.
 */
public class ReviewListFragment extends Fragment {

    ReviewController reviewController = ReviewController.getInstance();


    ArrayList<Review> reviewArrayList;

    //카드뷰!
    private RecyclerView recyclerView;
    private LinearLayoutManager mLinearLayoutManager;



    static boolean value=false;


    private void setReviewArrayList()
    {
        Review[] reivews = new Review[10];
        Date date =new Date();
        Date bf = new Date();
      //  bf.setTime(date.getTime()-((long)1000*60*2));
        for(int i=0;i<10;i++)
            reivews[i] = new Review();
        reivews[0].setdumiReview(1, 1, "헤비메탈할렐루야",date, "피듀(Fidue) A73인이어 이어폰 리뷰", "내용1", 1, "삼성", 192, 1, "핸드폰부문");
      //  date.setTime(date.getTime()-((long)1000*60*4));
        reivews[1].setdumiReview(2, 1, "영댕이",date, "갤럭시 S8 플러스 블랙 사용기", "내용2", 2, "현대", 11, 1, "자동차부문");
        reivews[2].setdumiReview(3, 1, "독눈",date, "최근에 유행하는 여러 핸드폰 케이스들", "내용3", 3, "LG", 14, 1, "핸드폰부문");
        reivews[3].setdumiReview(4, 1, "김대현4",date, "제목4", "내용4", 4, "HP", 10, 1, "컴퓨터부문");
        reivews[4].setdumiReview(5, 1, "김대현5",date, "제목5", "내용5", 5, "애플", 10, 1, "핸드폰부문");
        reivews[5].setdumiReview(6, 1, "김대현6",date, "제목6", "내용6", 1, "삼성", 10, 1, "핸드폰부문");
        reivews[6].setdumiReview(7, 1, "김대현7",date, "제목7", "내용7", 2, "현대", 10, 1, "자동차부문");
        reivews[7].setdumiReview(8, 1, "김대현8",date, "제목8", "내용8", 3, "LG", 10, 1, "가전기기");
        reivews[8].setdumiReview(9, 1, "김대현9",date, "제목9", "내용9", 4, "HP", 10, 1, "컴퓨터부문");
        reivews[9].setdumiReview(10, 1,"김대현10",date, "제목10", "내용10", 5, "애플", 10, 1, "컴퓨터부문");
        reviewArrayList = new ArrayList<Review>();


        for(int i=0;i<reivews.length;i++)
        {
            reviewArrayList.add(reivews[i]);
        }

       // reviewController.setdumitReivew(reviewArrayList,"컴퓨터부문");

    }


    private void setReviewList()
    {
        ReviewListAdapter adapter = new ReviewListAdapter(getActivity(),reviewArrayList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void testPrint(JSONObject jsonObject){


    }

    private String getStringFromInputStream(InputStream in){

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            br = new BufferedReader(new InputStreamReader(in));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }



    private void postTest(){
        String address="http://10.0.2.2:8000/company/";

//        HttpClient httpClient =new H
        HttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost httpPost = new HttpPost(address);

        try{

            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(3);
            nameValuePairs.add(new BasicNameValuePair("company_name","회사이름"));
            nameValuePairs.add(new BasicNameValuePair("company_content","회사내용"));
            nameValuePairs.add(new BasicNameValuePair("company_category","1"));
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs,"UTF-8"));


            HttpResponse response = httpClient.execute(httpPost);
            response = httpClient.execute(httpPost);



            /*
            JSONObject jsonObject = new JSONObject();
            test test = new test("회사2","회사2입니다.",1);
            jsonObject.accumulate("company_name","회사2");
            jsonObject.accumulate("company_content", "회사2입니다");
            jsonObject.accumulate("company_category", "[\n1\n]");
           String json = jsonObject.toString();

            Log.v("tag",""+json);
            StringEntity se = new StringEntity(json);
            httpPost.setEntity(se);
          //  httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            HttpResponse httpResponse = httpClient.execute(httpPost);
            */
           /*
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(3);

            nameValuePairs.add(new BasicNameValuePair("company_name", "회사3"));
            nameValuePairs.add(new BasicNameValuePair("company_content", "회사3입니다."));
            nameValuePairs.add(new BasicNameValuePair("company_category", "1"));
            Log.v("tag",""+httpPost.getURI());
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse response = httpClient.execute(httpPost);
            */
        }catch(IOException e){
            Log.v("tag",""+e);
        }

    }

    private void getTest(){
    String address="http://10.0.2.2:8000/company/image/2/?format=json";
    try{
        URL url = new URL(address);

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        InputStream in = new BufferedInputStream(urlConnection.getInputStream());
        //거르기
        JSONObject json = new JSONObject(getStringFromInputStream(in));
        for(int i=0;i<json.length();i++){
            Log.v("tag","count"+i);
        }
        Log.v("tag","get tag"+json.get("companyImage_image"));


        Log.v("tag",""+json);


    }catch(MalformedURLException e){
        Log.v("tag",""+e);
    }catch(JSONException e) {
        System.err.println("early JSON parsing error");
        Log.v("tag",""+e);
    }catch(IOException e){
        System.err.println("ealry IO error");
        Log.v("tag",""+e);
    }


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_review_list, container, false);


        Thread run = new Thread() {
            @Override
            public void run() {
                try {
                    if(value==false) {
                    //    postTest();
                        value=true;
                    }
                } catch (Exception e) {
                    Log.v("tag",""+e);
                }
            }
        };
        new Thread(run).start();



        mLinearLayoutManager=new LinearLayoutManager(getActivity());
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView = (RecyclerView) view.findViewById(R.id.review_lists);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(mLinearLayoutManager);
        //어댑터와 연결



        setReviewArrayList();
        setReviewList();

        return view;

    }


}
