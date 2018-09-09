package mani.itachi.simplenote.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;

import mani.itachi.simplenote.R;
import mani.itachi.simplenote.util.BaseActivity;

public class DetailActivity extends BaseActivity {


    private String DETAIL_FRAGMENT="DETAIL_FRAGMENT";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        FragmentManager fragmentManager = getSupportFragmentManager();

        DetailFragment detailFragment= (DetailFragment) fragmentManager.findFragmentByTag(DETAIL_FRAGMENT);

        if(detailFragment!=null) detailFragment = DetailFragment.newInstance();

        addFragmentToActivity(fragmentManager, detailFragment, R.id.root_activity_detail, DETAIL_FRAGMENT);

    }

}
