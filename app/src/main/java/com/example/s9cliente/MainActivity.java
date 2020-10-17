package com.example.s9cliente;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.s9cliente.model.Pedido;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView coca;
    private ImageView hot;
    private ImageView sand;
    private ImageView jugo;
    private UDPconection udp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //referenciaaaaar
        coca = findViewById(R.id.coca);
        coca.setOnClickListener(this);
        hot = findViewById(R.id.hot);
        hot.setOnClickListener(this);
        sand = findViewById(R.id.sand);
        sand.setOnClickListener(this);
        jugo = findViewById(R.id.jugo);
        jugo.setOnClickListener(this);

        udp = new UDPconection();
        udp.start();


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.coca:
                Gson gson = new Gson();

               Pedido cocacola = new Pedido("cocacola");
                String json = gson.toJson(cocacola);
                Log.e(">>>",""+json);

                udp.sendMessage(json);

                break;
            case R.id.hot:

                gson = new Gson();
                Pedido hotdog = new Pedido("hotdog");
                json = gson.toJson(hotdog);
                Log.e(">>>",""+json);

                udp.sendMessage(json);

                break;
            case R.id.jugo:

                gson = new Gson();
                Pedido jugo = new Pedido("jugo");
                json = gson.toJson(jugo);
                Log.e(">>>",""+json);

                udp.sendMessage(json);

                break;

            case R.id.sand:

                gson = new Gson();
                Pedido sandwish= new Pedido("sandwish");
                json = gson.toJson(sandwish);
                Log.e(">>>",""+json);

                udp.sendMessage(json);

                break;

        }
    }

    public void onMessage(String msg) {
        runOnUiThread(
                ()->{

                }
        );
    }

}