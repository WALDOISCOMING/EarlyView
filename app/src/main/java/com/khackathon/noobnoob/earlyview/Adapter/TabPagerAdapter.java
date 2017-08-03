package com.khackathon.noobnoob.earlyview.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.khackathon.noobnoob.earlyview.fragment.RequestReviewerRootFragment;
import com.khackathon.noobnoob.earlyview.fragment.ReviewRootFragment;
import com.khackathon.noobnoob.earlyview.fragment.test2Fragment;
import com.khackathon.noobnoob.earlyview.requestreviewer.RequestReviewer;

/*
생성자:길경완
생성일자:2017_07_26
수정자:x
수정일자:x
내용:
탭을 눌렀을 때 탭의 index를 기억하여 아래의 getItem을 통하여 프레그먼트를 이동하다.
다른 방법보다 이러한 방법을 이용한다면 더 쉽다.
d
 */

public class TabPagerAdapter extends FragmentStatePagerAdapter {

    // Count number of tabs
    private int tabCount;

    public TabPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {

        // Returning the current tabs
        switch (position) {
            case 0:
                ReviewRootFragment reviewRootFragment = new ReviewRootFragment();
                return reviewRootFragment;
            case 1:
                RequestReviewerRootFragment requestReviewerRootFragment = new RequestReviewerRootFragment();
                return requestReviewerRootFragment;

            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return tabCount;
    }
}
