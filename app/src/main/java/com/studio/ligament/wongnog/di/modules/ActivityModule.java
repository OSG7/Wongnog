package com.studio.ligament.wongnog.di.modules;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;
import com.studio.ligament.wongnog.di.ActivityScope;

@Module
public class ActivityModule {

    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    Activity activity() {
        return this.activity;
    }
}
