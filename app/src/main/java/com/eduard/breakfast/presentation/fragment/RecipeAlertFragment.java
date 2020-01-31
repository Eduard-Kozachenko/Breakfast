package com.eduard.breakfast.presentation.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.eduard.breakfast.R;
import com.eduard.breakfast.presentation.model.RecipeInfo;

public class RecipeAlertFragment {

    public void showDialog(ChoiceFragment fragment,RecipeInfo mClass){
        final Dialog dialog = new Dialog(fragment);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_recipe_info);

        TextView text = dialog.findViewById(R.id.tv_recipeText);
        text.setText(mClass.getDescription());

        ImageView imageView = dialog.findViewById(R.id.iv_recipeImg);
        imageView.setImageResource(mClass.getImage());

        Button dialogButton = dialog.findViewById(R.id.btn_recipeOK);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }
}
