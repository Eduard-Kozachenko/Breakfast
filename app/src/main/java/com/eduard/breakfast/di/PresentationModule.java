package com.eduard.breakfast.di;

import com.eduard.breakfast.BreakfastApp;
import com.eduard.breakfast.presentation.fragment.RecipeAlertFragment;

import dagger.Module;
import dagger.Provides;

@Module
public class PresentationModule {

    @Provides
    public RecipeAlertFragment provideRecipeAlertFragment() {
        return new RecipeAlertFragment();
    }
}
