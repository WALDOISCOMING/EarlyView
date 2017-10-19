package com.khackathon.noobnoob.earlyview.restAPI;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.entity.UrlEncodedFormEntity;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import cz.msebera.android.httpclient.impl.client.HttpClientBuilder;
import cz.msebera.android.httpclient.message.BasicNameValuePair;

/*
생성자:길경완
생성일자:2017_09_09
____________________________________________________________________________________________________
aa
내용:
rest api에서 사용될 Company관련 클래스이다.
현 페이지를 통해 내용을 역순으로 가져오는 getAllCompanyJsonObjects가 존재함. 이후 이것을 카테고리를 통해
가져오도록 바꾸어주면된다.->C
회사 관련 내용을 post 해주는 postCreateCompany가 존재->R
*/
public class RestCompany extends  RestBasic{

    String addr;

    public RestCompany(){
        RestBasic restBasic=new RestBasic();
        addr = restBasic.getAddr()+"/company/";
    }


    //Arraylist JsonObject을 return한다.일정 이하로 내려가면 page가 +되는건 나중에 만들기로하자.
    public JSONArray getAllCompanyJsonObjects(int page){
        ArrayList<JSONObject> jsonObjects=new ArrayList<JSONObject>();
        //주소가 10.0.0.2인 이유는 원래의 default 로컬 주소는 127.0.0.1을 이 AVD가 미리 가져버린다.
        //방지하는 방법은 AVM을 변경하던가 주소를 들어갈때 다른 로컬 주소로 들어가면 된다 AWS 사용하면 이렇게 안해도된다.

        //http://127.0.0.1:8000/company/?page=1

        String address=addr+"?page="+page;
        JSONArray jsonArray = new JSONArray();
        try{
            URL url = new URL(address);

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            //거르기
            JSONObject json = new JSONObject(getStringFromInputStream(in));
            jsonArray =json.getJSONArray("results");

        }catch(MalformedURLException e){
            Log.e("err","RestCompany getAllCompanyJsonObjects err:"+e);
        }catch(JSONException e) {
            Log.e("err","RestCompany getAllCompanyJsonObjects err:"+e);
        }catch(IOException e){
            Log.e("err","RestCompany getAllCompanyJsonObjects err:"+e);
        }
        return jsonArray;
    }




//일단 지금은 카테고리 String이다.
    public void postCreateCompany(String companyName,String companyContent,String companyCategory){


//        HttpClient httpClient =new H
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(addr);

        try{
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(3);
            //내용 3개를 맞추어 넣어준다.
            nameValuePairs.add(new BasicNameValuePair("company_name",companyName));
            nameValuePairs.add(new BasicNameValuePair("company_content",companyContent));
            nameValuePairs.add(new BasicNameValuePair("company_category",companyCategory));
            //utf-8로 해주지 않으면 한글이 깨진다.
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs,"UTF-8"));


            HttpResponse response = httpClient.execute(httpPost);
            httpPost.getEntity().getContent().close();
            response.getEntity().getContent().close();


        }catch(IOException e){
            Log.e("err","RestCompany postCreateCompany err:"+e);
        }


    }



}
