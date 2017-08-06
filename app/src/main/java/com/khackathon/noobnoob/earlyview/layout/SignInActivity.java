package com.khackathon.noobnoob.earlyview.layout;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.khackathon.noobnoob.earlyview.R;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by JJ on 2017-08-02.
 */

public class SignInActivity extends AppCompatActivity {

//    private ArrayList<String> interestSelection = new ArrayList<>();

    private Intent intent;

    private FirebaseAuth firebaseAuth;

    private boolean id_checker = false;
    private boolean pwd_checker = false;
    private boolean birthdate_checker = false;
    private boolean interest_checker = false;

    int year_b,month_b,day_b;
    static final int DIALOG_ID = 0;

    @BindView(R.id.signInId)
    EditText signInId;

    @BindView(R.id.birthDate)
    TextView birthDate;

    @BindView(R.id.signInPassword)
    EditText signInPassword;

    @BindView(R.id.signInRePassword)
    EditText signInRePassword;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        ButterKnife.bind(this);

        final Calendar calendar = Calendar.getInstance();
        year_b = calendar.get(Calendar.YEAR);

        firebaseAuth = FirebaseAuth.getInstance();

        //이전 로그인 확인
        if(firebaseAuth.getCurrentUser() != null){
            finish();
            startActivity(new Intent(getApplicationContext(), Main.class));
        }

    }

    //아이디 중복확인
    @OnClick(R.id.IdCheck)
    public void onIdCheckBtnClick(View v){

        Toast.makeText(SignInActivity.this,"중복확인",Toast.LENGTH_SHORT).show();

        id_checker = true;
        //조건 확인하고 중복인지 아닌지 토스트 말고 텍스트 수정으로
    }

    @OnClick(R.id.birthDateSelectorBtn)
    public void onBirthDateSelectorBtnClick(View v){
        showDialog(DIALOG_ID);
    }

    @Override
    protected Dialog onCreateDialog(int id){
        if (id == DIALOG_ID)
            return new DatePickerDialog(this,datePickerListner,year_b,month_b,day_b);
        return null;
    }

    //생년월일 텍스트에 저장
    private DatePickerDialog.OnDateSetListener datePickerListner
            = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            year_b = year;
            month_b = monthOfYear;
            day_b = dayOfMonth;
            birthDate.setText(year_b + "/" + month_b + "/" + day_b);

            birthdate_checker = true;
        }
    };

//    public void interestSelection(View v){
//        boolean checked = ((CheckBox)v).isChecked();
//        switch (v.getId()){
//            case R.id.interestA:
//                if(checked){
//                    interestSelection.add("A");
//                } else {
//                    interestSelection.remove("A");
//                }
//            case R.id.interestB:
//                if(checked){
//                    interestSelection.add("B");
//                } else {
//                    interestSelection.remove("B");
//                }
//            case R.id.interestC:
//                if(checked){
//                    interestSelection.add("C");
//                } else {
//                    interestSelection.remove("C");
//                }
//            case R.id.interestD:
//                if(checked){
//                    interestSelection.add("D");
//                } else {
//                    interestSelection.remove("D");
//                }
//            case R.id.interestE:
//                if(checked){
//                    interestSelection.add("E");
//                } else {
//                    interestSelection.remove("E");
//                }
//            case R.id.interestF:
//                if(checked){
//                    interestSelection.add("F");
//                } else {
//                    interestSelection.remove("F");
//                }
//        }
//    }

    //회원가입
    @OnClick(R.id.signInBtn)
    public void onSignInBtnClick(View v){

        //관심사 선택 임시
        interest_checker = true;

        String email = signInId.getText().toString().trim();
        String passwd = signInPassword.getText().toString().trim();
        String passwdRe = signInRePassword.getText().toString().trim();


        if(passwd.length() > 0 && passwdRe.equals(passwd)){
            pwd_checker = true;
        } else if(!(passwd.length() > 6)){
            Toast.makeText(this, "비밀번호를 6자리 이상 입력해 주세요",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "비밀번호가 다릅니다",Toast.LENGTH_SHORT).show();
        }
        if(id_checker && pwd_checker && birthdate_checker && interest_checker){

            firebaseAuth.createUserWithEmailAndPassword(email,passwd)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                finish();
                                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                            } else {
                                Toast.makeText(SignInActivity.this, "에러가 발생했습니다", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

            intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
        else {
            if(!id_checker){
                Toast.makeText(this, "아이디 중복 확인을 해주세요",Toast.LENGTH_SHORT).show();
            } else if(!birthdate_checker){
                Toast.makeText(this, "생일을 선택해 주세요",Toast.LENGTH_SHORT).show();
            } else if(!interest_checker){
                Toast.makeText(this, "관심사를 선택해 주세요",Toast.LENGTH_SHORT).show();
            }
        }
    }

    @OnClick(R.id.signInCancelBtn)
    public void onSignInCancelBtnClick(View v){
        intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

}