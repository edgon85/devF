package com.edgon.camara;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.txtDescription)
    TextView txtDescription;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.btn_ok)
    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        tomarFoto();

    }

    @OnClick(R.id.btn_ok)
    public void tomarFoto() {
        //obtener perimsos de la camara
        int permissionStatus = ActivityCompat
                .checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA);

        //verificamos que tenga permiso permitido
        if (permissionStatus == PackageManager.PERMISSION_GRANTED){
            iniciarCamara();
        }else{
            requestCameraPermission();
        }
    }

    private void iniciarCamara(){
        //Configurar el intent
        Intent intentTakePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intentTakePicture.resolveActivity(getPackageManager()) != null){
            //startActivity(intentTakePicture);
            startActivityForResult(intentTakePicture,Constants.POTHO_REQUEST_CODE);
        }
    }

    private void requestCameraPermission(){
        String[] permissions = new String[]{Manifest.permission.CAMERA};
        //verificamos si tenemos permiso para pedir permiso

            ActivityCompat.requestPermissions(
                    MainActivity.this,
                    permissions,
                    Constants.CAMERA_PERMISSION_REQUEST_CODE);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == Constants.CAMERA_PERMISSION_REQUEST_CODE){
            if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                iniciarCamara();
            }else{
                //lo rechazo!!
                if (!ActivityCompat.shouldShowRequestPermissionRationale(
                        MainActivity.this,Manifest.permission.CAMERA)){
                    }else {
                    Toast.makeText(this, "Activa permiso manualmente", Toast.LENGTH_SHORT).show();
                    return;
                }
                requestCameraPermission();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if(Constants.POTHO_REQUEST_CODE == requestCode){
            if (requestCode == RESULT_OK){
                Bundle extras = data.getExtras();
                Bitmap imagen = (Bitmap) extras.get("data");
                imageView.setImageBitmap(imagen);


            }else{
                Toast.makeText(MainActivity.this, "No tomo foto", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
