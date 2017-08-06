package com.khackathon.noobnoob.earlyview.layout;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.khackathon.noobnoob.earlyview.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
생성자:김대현
생성일자:2017_07_?

내용:
니가써


 */

public class LoginActivity extends AppCompatActivity{

    private Intent intent;

    private FirebaseAuth firebaseAuth;

    @BindView(R.id.loginId)
    EditText loginId;

    @BindView(R.id.loginPasswd)
    EditText loginPasswd;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        firebaseAuth = FirebaseAuth.getInstance();

        //이전 로그인 확인
        if(firebaseAuth.getCurrentUser() != null){
            finish();
            startActivity(new Intent(getApplicationContext(), Main.class));
        }
    }

    private void userLogIn(){
        String email = loginId.getText().toString().trim();
        String passwd = loginPasswd.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"이메일을 입력해 주세요",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(passwd)){
            Toast.makeText(this,"비밀번호를 입력해 주세요",Toast.LENGTH_SHORT).show();
            return;
        }

        firebaseAuth.signInWithEmailAndPassword(email,passwd)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            finish();
                            startActivity(new Intent(getApplicationContext(), Main.class));
                        }else {
                            Toast.makeText(LoginActivity.this,"아이디 또는 비밀번호를 확인해 주세요",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @OnClick(R.id.logInBtn)
    public void onLogInBtnClick(){
        userLogIn();
    }


    @OnClick(R.id.signInTextBtn)
    public void onSignInBtnClick(){
        intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
    }
}

