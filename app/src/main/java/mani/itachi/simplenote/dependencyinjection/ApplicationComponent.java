package mani.itachi.simplenote.dependencyinjection;
import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
import mani.itachi.simplenote.create.CreateFragment;
import mani.itachi.simplenote.detail.DetailFragment;
import mani.itachi.simplenote.list.ListFragment;

@Singleton
@Component(modules = {ApplicationModule.class, DatabaseModule.class})
public interface ApplicationComponent {

    void inject(ListFragment listFragment);
    void inject(CreateFragment createFragment);
    void inject(DetailFragment detailFragment);

    Application application();

}