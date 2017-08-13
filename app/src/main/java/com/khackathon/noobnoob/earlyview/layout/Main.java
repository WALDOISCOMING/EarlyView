package com.khackathon.noobnoob.earlyview.layout;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.khackathon.noobnoob.earlyview.Adapter.TabPagerAdapter;
import com.khackathon.noobnoob.earlyview.Cache;
import com.khackathon.noobnoob.earlyview.R;


/*
생성자:길경완
생성일자:2017_07_24

----------------------------------------------------------------------------------------------------
수정자:길경완
수정일자:2017_07_26
수정내용:
제거:이전 프레그먼트를 위한 onstartFragementSet() 메소드->TabPagerAdapter에서 그 기능을 대신한다.
제거:Button을 통한 프레그먼트 이동
생성:tabLayout과 viewPager와 그를 위한 onstartTab() 메소드
----------------------------------------------------------------------------------------------------
수정자:길경완
수정일자:2017_08_01
수정내용:
생성:boolean onNavigationItemSelected(MenuItem item)에서 메뉴 아이템 클릭시 이동.
생성:각 액티비티와 프래그먼트에 제대로 된 패키지를 넣어줌.
생성:onstartCache()으로 현재 파일이 있는지 없는지 확인하는 메소드 만듦
생성:onBackPressed()로 앱 종료시키는 것 만듦. 추후에 바로 종료가 아닌 예,아니오로 종료 되도록 해주는
것 만들어야 함.
삭제:fragment test1은 아예 삭제, test2는 추후 삭제 예정.

----------------------------------------------------------------------------------------------------
수정자:길경완
수정일자:2017_08_02
수정내용:
생성:onBackPressed() 뒤로가기 버튼에서 만약 프래그먼트 stack이 있는데 뒤로가기를 누르면 stack이 pop되고
그렇지 않은 0이면 종료된다. 후에 종료 예 아니오 만들어야함
----------------------------------------------------------------------------------------------------
내용:
메인액티비티이다.
모든 기초 내용들과,버튼 관련과 메뉴 아이템들을 선택하였을 때 행동해야하는것을 설정한다.



 */
public class Main extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


//탭메뉴를 위한 레이아웃과 뷰페이저이다.
    private TabLayout tabLayout;
    public static ViewPager viewPager;
    Activity activity;

    private FirebaseAuth firebaseAuth;





    private void setToolbar()
    {

    }
    private void onstartTab()
    {
        // Initializing the TabLayout
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("리뷰"));
        tabLayout.addTab(tabLayout.newTab().setText("후기단"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        // Initializing ViewPager
        viewPager = (ViewPager) findViewById(R.id.pager);

        // Creating TabPagerAdapter adapter
        TabPagerAdapter pagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        // Set TabSelectedListener
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void onstartCache()
    {
        Cache cache = new Cache(this);

      if(cache.getFileExistence()==true)
      {
        //바로 메인으로.
      //    setContentView(R.layout.activity_main);
      }else
      {
          //this.finish();
          //setContentView(R.layout.activity_login);
      }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //로그인 안되어있으면 로그인으로
        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }

        //로그인 확인
        FirebaseUser user = firebaseAuth.getCurrentUser();
        Toast.makeText(this,user.getEmail()+"로그인",Toast.LENGTH_SHORT).show();

        //시작하였을 때 탭메뉴를 세팅한다.
        onstartTab();
        activity = this;

//이건 왼쪽 상단의 메뉴 아이콘이다. 제거하면 메뉴 아이콘이 사라진다.
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        onstartCache();

    }



//뒤로가기를 누른다면 바로 종료인가 아니면 이전 페이지를 기억하여 이전으로 돌아가게 해아하는가?
    @Override
    public void onBackPressed() {


        if(getSupportFragmentManager().getBackStackEntryCount()==0)
        {

            moveTaskToBack(true);
            finish();
            android.os.Process.killProcess(android.os.Process.myPid());
        }else {
            getSupportFragmentManager().popBackStack();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    //이것은 유저메뉴페이지이다.
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.nav_first) {
            //로그아웃
            FirebaseAuth.getInstance().signOut();

            this.finish();
            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_second) {
            Toast.makeText(this,"두번째",Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_third) {
            Toast.makeText(this,"세번째",Toast.LENGTH_LONG).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
