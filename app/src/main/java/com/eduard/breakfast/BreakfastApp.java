package com.eduard.breakfast;

import android.app.Application;

import com.eduard.breakfast.di.PresentationModule;

public class BreakfastApp extends Application {

    private static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        component.inject(this);

    }

    public static AppComponent getComponent() {
        return component;
    }

}
