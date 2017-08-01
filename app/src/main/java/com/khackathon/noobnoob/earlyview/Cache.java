package com.khackathon.noobnoob.earlyview;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


/*
생성자:길경완
생성일자:2017_08_01
내용:
캐쉬값을 확인,저장,삭제하는곳


 */
public class Cache {
    Context context;
    public Cache(Context co){
        context = co;
    }

    public File getCacheDir(Context context) {
        File cacheDir = null;
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            cacheDir = new File(Environment.getExternalStorageDirectory(), "cachefolder");
            if(!cacheDir.isDirectory()) {
                cacheDir.mkdirs();
            }
        }
        if(!cacheDir.isDirectory()) {
            cacheDir = context.getCacheDir();
        }
        return cacheDir;
    }

    public void Write(String str) throws IOException {
        File cacheDir = getCacheDir(context);
        File cacheFile = new File(cacheDir, "Cache.txt");
        if(!cacheFile.exists()) {
            cacheFile.createNewFile();
        }else{
            //delete!
            cacheFile.delete();
            cacheFile.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(cacheFile);
        fileWriter.write(str);
        fileWriter.flush();
        fileWriter.close();
    }
    public void Delete ()throws  IOException{
        File cacheDir = getCacheDir(context);
        File cacheFile = new File(cacheDir, "Cache.txt");
        cacheFile.delete();

    }

    public boolean getFileExistence()
    {
        File cacheDir = getCacheDir(context);
        File cacheFile = new File(cacheDir, "Cache.txt");

        //파일 유무를 확인합니다.
        if(cacheFile.exists()==true) {
            return true;
        } else {
        return false;
        }

    }
    public String Read() throws IOException {
        File cacheDir = getCacheDir(context);
        File cacheFile = new File(cacheDir, "Cache.txt");
        if(!cacheFile.exists())cacheFile.createNewFile();
        FileInputStream inputStream = new FileInputStream(cacheFile);
        Scanner s = new Scanner(inputStream);
        String text="";
        while(s.hasNext()){
            text+=s.nextLine();
        }
        inputStream.close();
        return text;
    }


}


