package mani.itachi.simplenote.create;

import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.viewpagerindicator.CirclePageIndicator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mani.itachi.simplenote.R;
import mani.itachi.simplenote.SimpleNoteApplication;
import mani.itachi.simplenote.data.ListItem;
import mani.itachi.simplenote.list.ListActivity;
import mani.itachi.simplenote.viewmodel.NewListItemViewModel;

public class CreateFragment extends Fragment {

    @BindView(R.id.vp_create_drawable) ViewPager drawablePager;
    @BindView(R.id.vpi_create_drawable) CirclePageIndicator pageIndicator;
    @BindView(R.id.edt_create_message) EditText messageInput;

    private PagerAdapter pagerAdapter;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private NewListItemViewModel newListItemViewModel;

    public CreateFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        ((SimpleNoteApplication) Objects.requireNonNull(getActivity()).getApplication())
                .getApplicationComponent()
                .inject(this);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        newListItemViewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(NewListItemViewModel.class);

    }

    @OnClick({R.id.imb_create_back,R.id.imb_create_done})
    public void doOnClick(View view){
        switch (view.getId()){
            case R.id.imb_create_back:
                startListActivity();
                break;
            case R.id.imb_create_done:
                ListItem listItem = new ListItem(
                        getDate(),
                        messageInput.getText().toString(),
                        getDrawableResource(drawablePager.getCurrentItem())
                );
                newListItemViewModel.insertListItem(listItem);

                startListActivity();
                break;
            default:
                break;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_create, container, false);
        ButterKnife.bind(this,v);
        pagerAdapter = new DrawablePagerAdapter();
        drawablePager.setAdapter(pagerAdapter);
        pageIndicator.setViewPager(drawablePager);
        return v;
    }

    public int getDrawableResource (int pagerItemPosition){
        switch (pagerItemPosition){
            case 0:
                return R.drawable.red_drawable;
            case 1:
                return R.drawable.blue_drawable;
            case 2:
                return R.drawable.green_drawable;
            case 3:
                return R.drawable.yellow_drawable;
            default:
                return 0;
        }
    }

    private void startListActivity() {
        startActivity(new Intent(getActivity(), ListActivity.class));
    }

    private class DrawablePagerAdapter extends PagerAdapter {

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            ImageView pagerItem = (ImageView) inflater.inflate(R.layout.item_drawable_pager,
                    container,
                    false);

            switch (position) {
                case 0:
                    pagerItem.setImageResource(R.drawable.red_drawable);
                    break;
                case 1:
                    pagerItem.setImageResource(R.drawable.blue_drawable);
                    break;
                case 2:
                    pagerItem.setImageResource(R.drawable.green_drawable);
                    break;
                case 3:
                    pagerItem.setImageResource(R.drawable.yellow_drawable);
                    break;
            }

            container.addView(pagerItem);
            return pagerItem;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup collection, int position, Object view) {
            collection.removeView((View) view);
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }

    public String getDate() {

        Date currentDate = Calendar.getInstance().getTime();

        @SuppressLint("SimpleDateFormat")
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd/kk:mm:ss");

        return format.format(currentDate);
    }

    public static CreateFragment newInstance() {
        return new CreateFragment();
    }
}
