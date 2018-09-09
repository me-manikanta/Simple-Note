package mani.itachi.simplenote.viewmodel;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import mani.itachi.simplenote.data.ListItem;
import mani.itachi.simplenote.data.ListItemRepository;

public class NewListItemViewModel extends ViewModel {

    private ListItemRepository listItemRepository;

    NewListItemViewModel(ListItemRepository listItemRepository){
        this.listItemRepository=listItemRepository;
    }

    public void insertListItem(ListItem listItem){
        InsertItemTask insertItemTask= new InsertItemTask();
        insertItemTask.execute(listItem);
    }

    @SuppressLint("StaticFieldLeak")
    private class InsertItemTask extends AsyncTask<ListItem,Void ,Void> {

        @Override
        protected Void doInBackground(ListItem... listItems) {
            listItemRepository.insertListItem(listItems[0]);
            return null;
        }
    }

}
