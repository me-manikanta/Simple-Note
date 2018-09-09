package mani.itachi.simplenote.create;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;

import mani.itachi.simplenote.R;
import mani.itachi.simplenote.util.BaseActivity;

public class CreateActivity extends BaseActivity {

    private String CREATE_FRAGMENT="CREATE_FRAGMENT";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        FragmentManager fragmentManager = getSupportFragmentManager();

        CreateFragment createFragment = (CreateFragment) fragmentManager.findFragmentByTag(CREATE_FRAGMENT);

        if(createFragment!=null) createFragment = CreateFragment.newInstance();

        addFragmentToActivity(fragmentManager, createFragment, R.id.root_activity_list, CREATE_FRAGMENT);

    }
}
