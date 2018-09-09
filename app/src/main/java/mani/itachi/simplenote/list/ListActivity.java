package mani.itachi.simplenote.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;

import mani.itachi.simplenote.R;
import mani.itachi.simplenote.util.BaseActivity;

public class ListActivity extends BaseActivity {

    private String LIST_FRAGMENT="LIST_FRAGMENT";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        FragmentManager fragmentManager = getSupportFragmentManager();

        ListFragment listFragment = (ListFragment) fragmentManager.findFragmentByTag(LIST_FRAGMENT);

        if(listFragment==null) listFragment = ListFragment.newInstance();

        addFragmentToActivity(fragmentManager, listFragment, R.id.root_activity_list,LIST_FRAGMENT);

    }
}
