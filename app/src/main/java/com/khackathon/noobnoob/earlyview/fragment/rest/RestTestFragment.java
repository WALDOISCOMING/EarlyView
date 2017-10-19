package com.khackathon.noobnoob.earlyview.fragment.rest;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.khackathon.noobnoob.earlyview.R;
import com.khackathon.noobnoob.earlyview.restAPI.RestCompany;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/*
생성자:길경완
생성일자:2017_09_02
____________________________________________________________________________________________________
수정자:길경완
수정일자:2017_09_09
수정내용:
실제 내용을 CRUD중 CR구현하기. 완료
____________________________________________________________________________________________________
aa
내용:
rest api를 get,create,delete,update를 테스트한다.
*/

public class RestTestFragment extends Fragment {



    int count=1;
    public RestTestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rest_test,null);
        //get해서 Item을 뿌린다. 갯수만큼.



        final TextView mainText =(TextView)view.findViewById(R.id.getMainTextView);
        final RestCompany restCompany = new RestCompany();
        //테스트용도.
        Thread run = new Thread(new Runnable() {
            @Override
            public void run() {
                JSONArray jsonArray = new JSONArray();
                jsonArray = restCompany.getAllCompanyJsonObjects(count);

                final JSONArray finalJsonArray = jsonArray;
                //UI 변경되는걸 보여주기.
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for(int i = 0; i< finalJsonArray.length(); i++){
                            try {
                                mainText.append(finalJsonArray.get(i).toString());
                                Log.v("tag",""+finalJsonArray.get(i).toString());
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            }
        });
        new Thread(run).start();


        //create관련.


        final EditText createCompanyContentEditText=(EditText)view.findViewById(R.id.createCompanyContentEditText);
        final EditText createCompanyNameEditText=(EditText)view.findViewById(R.id.createCompanyNameEditText);


        final Button createButton=(Button)view.findViewById(R.id.restcreateButton);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String createCompanyContentString=createCompanyContentEditText.getText().toString();
                final String createCompanyNameString=createCompanyNameEditText.getText().toString();
                Log.v("tag",createCompanyContentString+","+createCompanyNameString);
                if(createCompanyContentString!=null&&createCompanyNameString!=null){
                    Thread innerThread = new Thread(){
                      @Override
                        public void run(){
                          try{
                              restCompany.postCreateCompany(createCompanyNameString,createCompanyContentString,"1");
                          }catch(Exception e){

                          }
                      }
                    };
                    new Thread(innerThread).start();
                }
                //쓰레드 실행.
            }
        });

        final Button deleteButton=(Button)view.findViewById((R.id.deleteButton));
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //쓰레드 실행.
            }
        });

        final Button updatebutton=(Button)view.findViewById((R.id.updateButton));
        updatebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //쓰레드 실행.
            }
        });



        return view;
    }

}
