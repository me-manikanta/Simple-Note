package mani.itachi.simplenote.viewmodel;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;

import java.util.List;

import mani.itachi.simplenote.data.ListItem;
import mani.itachi.simplenote.data.ListItemRepository;

public class ListItemCollectionViewModel extends ViewModel {

    private ListItemRepository listItemRepository;

    ListItemCollectionViewModel(ListItemRepository listItemRepository){
        this.listItemRepository=listItemRepository;
    }

    public LiveData<List<ListItem>> getAllListItems(){
        return listItemRepository.getAllListItems();
    }

    public void deleteListItem(ListItem listItem){
        DeleteItemTask deleteItemTask = new DeleteItemTask();
        deleteItemTask.execute(listItem);
    }

    @SuppressLint("StaticFieldLeak")
    private class DeleteItemTask extends AsyncTask<ListItem,Void ,Void>{

        @Override
        protected Void doInBackground(ListItem... listItems) {
            listItemRepository.deleteListItem(listItems[0]);
            return null;
        }
    }

}
