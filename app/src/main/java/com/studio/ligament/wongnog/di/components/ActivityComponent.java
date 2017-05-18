package com.studio.ligament.wongnog.di.components;

import android.app.Activity;
import android.app.Application;

import dagger.Component;
import com.studio.ligament.wongnog.di.ActivityScope;
import com.studio.ligament.wongnog.di.modules.ActivityModule;

@ActivityScope
@Component(dependencies = Application.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity activity();
}
