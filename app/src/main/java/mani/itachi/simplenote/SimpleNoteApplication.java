package mani.itachi.simplenote;

import android.app.Application;

import mani.itachi.simplenote.dependencyinjection.ApplicationComponent;
import mani.itachi.simplenote.dependencyinjection.ApplicationModule;
import mani.itachi.simplenote.dependencyinjection.DatabaseModule;

public class SimpleNoteApplication extends Application {



    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .roomModule(new DatabaseModule(this))
                .build();

    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
