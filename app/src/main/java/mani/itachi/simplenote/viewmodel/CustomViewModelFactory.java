package mani.itachi.simplenote.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import mani.itachi.simplenote.data.ListItemRepository;

public class CustomViewModelFactory implements ViewModelProvider.Factory{

    private final ListItemRepository listItemRepository;

    CustomViewModelFactory(ListItemRepository listItemRepository){
        this.listItemRepository=listItemRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if(modelClass.isAssignableFrom(ListItemCollectionViewModel.class))
            return (T) new ListItemCollectionViewModel(listItemRepository);

        if(modelClass.isAssignableFrom(ListItemViewModel.class))
            return  (T) new ListItemViewModel(listItemRepository);

        if(modelClass.isAssignableFrom(NewListItemViewModel.class))
            return  (T) new NewListItemViewModel(listItemRepository);

        throw new IllegalArgumentException("View Model Not Found");
    }
}
