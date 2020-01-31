package com.eduard.breakfast.presentation.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import com.eduard.breakfast.BreakfastApp;
import com.eduard.breakfast.R;
import com.eduard.breakfast.di.DaggerBreakfastComponents;
import com.eduard.breakfast.di.PresentationModule;
import com.eduard.breakfast.presentation.activity.MainActivity;
import com.eduard.breakfast.presentation.model.RecipeInfo;

import java.util.List;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;

public class ChoiceFragment extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Inject
    RecipeAlertFragment recipeAlertFragment;

    List<RecipeInfo> recipeInfo;

    RecipeInfo recipe1 = new RecipeInfo();
    RecipeInfo recipe2 = new RecipeInfo();
    RecipeInfo recipe3 = new RecipeInfo();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choice_fragment);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        recipe1.setImage(R.drawable.buter_avokado);
        recipe1.setDescription("Ингредиенты\n" +
                "\t•\t1 ломтик хлеба;\n" +
                "\t•\t¼–½ авокадо;\n" +
                "\t•\t1 столовая ложка консервированной или варёной фасоли;\n" +
                "\t•\t2–3 помидора черри;\n" +
                "\t•\t1–2 веточки петрушки или другой зелени;\n" +
                "\t•\tсоль — по вкусу;\n" +
                "\t•\tмолотый чёрный перец — по вкусу.\n" +
                "Приготовление\n" +
                "Слегка подсушите хлеб на сухой сковороде. Пюрируйте авокадо вилкой или другим удобным способом и намажьте на ломтик.\n" +
                "Сверху выложите фасоль и половинки помидоров. Посыпьте бутерброд рубленой зеленью, солью и перцем.");


        recipe2.setImage(R.drawable.hleb_rikotta_yagodi);
        recipe2.setDescription("Ингредиенты\n" +
                "\t•\t1 ломтик хлеба;\n" +
                "\t•\t2–3 столовые ложки рикотты;\n" +
                "\t•\tгорсть голубики (можно взять другие ягоды на ваш вкус);\n" +
                "\t•\tнемного мелко натёртой лимонной цедры;\n" +
                "\t•\tмёд — по вкусу.\n" +
                "Приготовление\n" +
                "Слегка подсушите хлеб на сухой сковороде на среднем огне. \n" +
                "Намажьте на ломтик рикотту и выложите сверху ягоды. Посыпьте лимонной цедрой и полейте мёдом.\n" +
                "\n");


        recipe3.setImage(R.drawable.rulet_lavash_sir);
        recipe3.setDescription("Ингредиенты\n" +
                "\t•\t1 лаваш;\n" +
                "\t•\t300 г твёрдого сыра;\n" +
                "\t•\t2 яйца;\n" +
                "\t•\tсоль — по вкусу;\n" +
                "\t•\tмолотый чёрный перец — по вкусу.\n" +
                "Приготовление\n" +
                "Разрежьте лаваш на полоски по ширине кусочка сыра. \n" +
                "Сыр разделите на несколько ломтиков, выложите каждый на полоску лаваша и заверните рулетом. К сыру можно добавить помидоры и зелень.\n" +
                "Венчиком взбейте яйца с солью и перцем. \n" +
                "Обмакните рулетики в яичную смесь и выложите на сухую горячую сковороду. \n" +
                "Обжаривайте на среднем огне по 2–3 минуты с каждой стороны.");

        Spinner spinner1 = findViewById(R.id.sp_productLeft);

        // адаптер
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,R.array.products_spin_lift,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(this);

    }

    // устанавливаем обработчик нажатия Left
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, final int position, long l) {

        int[] local = {R.array.products_bread_option,R.array.products_cheese_option};
        final Spinner spinner2 = findViewById(R.id.sp_productRight);
        Button buttonGenetate = findViewById(R.id.btn_showRecipe);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                local[position],
                android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);

        onInjection();

        buttonGenetate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 switch (position) {

                    case 0:
                        recipeAlertFragment.showDialog(ChoiceFragment.this,recipe1);
                        break;
                    case 1:
                        recipeAlertFragment.showDialog(ChoiceFragment.this,recipe2);
                        break;
                    default:
                        break;
                }


            }
        });
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    //builder alert dialog
    protected void onInjection() {
        DaggerBreakfastComponents.builder()
                .appComponent(BreakfastApp.getComponent())
                .presentationModule(new PresentationModule())
                .build()
                .inject(this);
    }

    //системная кнопка "назад"
    @Override
    public void onBackPressed() {
        //начало конструкции
        try {
            Intent intent = new Intent(ChoiceFragment.this, MainActivity.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {

        }//конец конструкции
    }

}





