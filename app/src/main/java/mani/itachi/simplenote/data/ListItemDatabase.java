package mani.itachi.simplenote.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {ListItem.class}, version = 10)
public abstract class ListItemDatabase extends RoomDatabase{

    public abstract ListItemDao listItemDao();

}
