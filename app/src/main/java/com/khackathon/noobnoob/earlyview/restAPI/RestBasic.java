package com.khackathon.noobnoob.earlyview.restAPI;




/*
생성자:길경완
생성일자:2017_09_09
____________________________________________________________________________________________________

내용:
rest api에서 사용될 기본 Basic이다. 추후 다른곳에서도 쓰일 getStringFromInputStream가 존재함.
*/

import android.util.Log;

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

public class RestBasic {





        //inputstreamreader에 글을 String으로 변환한다. 이것은 이후 Json으로 변환된다.
        protected String getStringFromInputStream(InputStream in){
            BufferedReader br = null;
            StringBuilder sb = new StringBuilder();
            String line;
            try {
                br = new BufferedReader(new InputStreamReader(in));
                //내용물을 계속 읽어들인다.
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }

            } catch (IOException e) {
                Log.e("err","RestBasic getStringFromInputStream err:"+e);
                e.printStackTrace();
            } finally {
                if (br != null) {
                    try {
                        //br이 종료되지 않은 비정상경우 강제종류
                        br.close();
                    } catch (IOException e) {
                        Log.e("err","RestBasic getStringFromInputStream err:"+e);
                    }
                }
            }
            return sb.toString();
        }








}
