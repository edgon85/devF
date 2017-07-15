package com.edgon.quizapp;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.edgon.quizapp.fragments.QuestionFragment;
import com.edgon.quizapp.fragments.ResultadoFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView btnLeft;
    private ImageView btnRight;
    private  int questionPosition = 0;
    QuestionFragment fragment;
    private List<String> listQuestion  = new ArrayList<>();
    private List<Integer> mListRespuesta = new ArrayList<>();
    private int punteo = 0;
    int respuestasCorrectas = 0;
    int respuestasIncorrectas = 0;

    ResultadoFragment resultadoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initPreguntas();
        initRespuesta();
        cambiarFragment(questionPosition);


    }

    private void initViews(){
        btnLeft = (ImageView) findViewById(R.id.btn_left);
        btnRight = (ImageView) findViewById(R.id.btn_right);

        btnRight.setOnClickListener(this);
        btnLeft.setOnClickListener(this);
    }

    private void cambiarFragment(int position){
        fragment = new QuestionFragment(listQuestion.get(position));
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.slide_right_enter,R.anim.slide_left_exit)
                .replace(R.id.fragmet_question,fragment)
                .commit();
    }

    private void initPreguntas(){
        listQuestion.add("Visual Basic es un ejemplo de lenguaje de programación."); //verdadero
        listQuestion.add("El código fuente y el algoritmo son lo mismo."); // Falso
        listQuestion.add("Microsoft Access es un ejemplo de un lenguaje de programación."); //Falso
        listQuestion.add("La programación estructurada es una técnica para desarrollar algoritmos."); //Falso
        listQuestion.add("Un algoritmo es una serie de pasos definidos para resolver un problema."); //Verdadero
        listQuestion.add("La estructura selectiva sólo ejecuta las tareas si se cumple una condición determinada."); //Verdadero
        listQuestion.add("Un lenguaje de programación es lo mismo que un compilador."); //Falso
        listQuestion.add("El programa objeto es lo mismo que el programa ejecutable."); //Falso
        listQuestion.add("El pseudocódigo es un tipo de compilador."); //Falso
        listQuestion.add("Un paradigma es un modelo a seguir."); //Verdadero
    }

    private void initRespuesta(){
                               /*Correctas */
        mListRespuesta.add(0); // 1
        mListRespuesta.add(1); // 0
        mListRespuesta.add(1); // 0
        mListRespuesta.add(1); // 0
        mListRespuesta.add(0); // 1
        mListRespuesta.add(0); // 1
        mListRespuesta.add(1); // 0
        mListRespuesta.add(1); // 0
        mListRespuesta.add(1); // 0
        mListRespuesta.add(0); // 1
    }

    private void fragmentFinal(){
        resultadoFragment = new ResultadoFragment(respuestasCorrectas);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragmet_question,resultadoFragment)
                .commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_left:
                if (questionPosition >= 0){
                    cambiarFragment(questionPosition--);
                    if (questionPosition < 0){
                        questionPosition = 0;
                    }
                }
                break;

            case R.id.btn_right:

              //  if ()

                if (fragment.getRespuesta() == mListRespuesta.get(questionPosition)){

                    if (fragment.getRespuesta() == 1){
                        respuestasCorrectas++;
                    }else if(fragment.getRespuesta() == 0){
                        respuestasIncorrectas++;
                    }

                    Log.e("Respuestas Correctas",""+respuestasCorrectas);
                    Log.e("Respuestas Incorrectas",""+respuestasIncorrectas);
                }
                questionPosition++;
                cambiarFragment(questionPosition);
                if (questionPosition>=9){
                    fragmentFinal();
                }

                break;
        }
    }
}

// share sharePreferences.

