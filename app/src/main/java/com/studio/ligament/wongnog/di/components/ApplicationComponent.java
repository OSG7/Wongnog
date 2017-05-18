package com.studio.ligament.wongnog.di.components;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import com.studio.ligament.wongnog.di.modules.ApplicationModule;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    Context context();
}
