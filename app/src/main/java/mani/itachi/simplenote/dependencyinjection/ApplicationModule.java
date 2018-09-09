package mani.itachi.simplenote.dependencyinjection;

import android.app.Application;

import dagger.Module;
import dagger.Provides;
import mani.itachi.simplenote.SimpleNoteApplication;

@Module
public class ApplicationModule {
    private final SimpleNoteApplication application;
    public ApplicationModule(SimpleNoteApplication application) {
        this.application = application;
    }

    @Provides
    SimpleNoteApplication provideRoomDemoApplication(){
        return application;
    }

    @Provides
    Application provideApplication(){
        return application;
    }
}