package com.edgon.retrofitexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class MainActivity extends AppCompatActivity {

    private EditText edtUsuario;
    private Button btnBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUsuario = (EditText) findViewById(R.id.edt_user);
        btnBuscar = (Button) findViewById(R.id.btn_buscar);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getRetrofitData(edtUsuario.getText().toString());
            }
        });

    }

    public void getRetrofitData(String usuario) {
        //Configuracion basica de nuestro objeto retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .build();

        //crear instancia de mi interfaz que ya tiene configurado la estructura de mi solicitud
        GitHubService gitHubService = retrofit.create(GitHubService.class);

       // gitHubService.getUserInfo().enqueue(new Callback<ResponseBody>() {
        gitHubService.getUserIntoPath(usuario).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                //obtener el bodydel mensaje HTTP como string
                int code = response.code();
                Log.e("MyLog", code + "");

                if (code == 200) {

//                    String body = null;

                    if (response.body() != null) {
                        try {
                            String body = response.body().string();
                            //parsear el string como JSON
                            try {
                                JSONObject jsonObject = new JSONObject(body);
                                Log.e("MyLog",jsonObject.getString("login"));
                                Log.e("MyLog",jsonObject.getString("bio"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (code == 404) {
                    Toast.makeText(MainActivity.this, "El Usuario no existe", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error, intenta mas tarde", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private interface GitHubService {
        //Nombre del metodo
        //URI del recurso que qieremos obtener

        @GET("/users/Dagorik")
        public Call<ResponseBody> getUserInfo();


        @GET("/users/{username}")
        public Call<ResponseBody> getUserIntoPath(@Path("username") String  userName);

    }
}
