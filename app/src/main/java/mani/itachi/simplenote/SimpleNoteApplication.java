package mani.itachi.simplenote;

import android.annotation.SuppressLint;
import android.app.Application;

import mani.itachi.simplenote.dependencyinjection.ApplicationComponent;
import mani.itachi.simplenote.dependencyinjection.ApplicationModule;
import mani.itachi.simplenote.dependencyinjection.DaggerApplicationComponent;
import mani.itachi.simplenote.dependencyinjection.DatabaseModule;

@SuppressLint("Registered")
public class SimpleNoteApplication extends Application {


    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .databaseModule(new DatabaseModule(this))
                .build();

    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
