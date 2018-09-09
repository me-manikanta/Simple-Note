package mani.itachi.simplenote.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;


import mani.itachi.simplenote.data.ListItem;
import mani.itachi.simplenote.data.ListItemRepository;

public class ListItemViewModel extends ViewModel {

    private ListItemRepository listItemRepository;

    ListItemViewModel(ListItemRepository listItemRepository){
        this.listItemRepository=listItemRepository;
    }

    public LiveData<ListItem> getListItemById(@NonNull String itemId){
        return listItemRepository.getListItemById(itemId);
    }

}
