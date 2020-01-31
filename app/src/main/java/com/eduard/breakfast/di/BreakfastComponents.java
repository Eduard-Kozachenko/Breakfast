package com.eduard.breakfast.di;

import com.eduard.breakfast.ActivityScope;
import com.eduard.breakfast.AppComponent;
import com.eduard.breakfast.presentation.activity.MainActivity;
import com.eduard.breakfast.presentation.fragment.ChoiceFragment;

import javax.inject.Singleton;

import dagger.Component;

@ActivityScope
@Component(modules = {PresentationModule.class}, dependencies = AppComponent.class )

public interface BreakfastComponents {

    void inject(MainActivity activity);
    void inject(ChoiceFragment fragment);
}
