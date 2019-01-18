package com.example.a1thefull.wifidirect;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


/**
 * Created by Phaneendra on 04-Jan-17.
 */

public class MainClint extends Activity {
    ImageView imgv;
    Button buttonConnect,buttoncancle;
    private String ip;
    private int port;
    static int flag=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clint);
        ip = getIntent().getStringExtra("ip");
        port = getIntent().getIntExtra("port",0);


        buttonConnect = (Button) findViewById(R.id.connectButton);
        buttoncancle = (Button) findViewById(R.id.cancleButton);

        imgv=(ImageView) findViewById(R.id.imgv);

        buttonConnect.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                flag=1;
                buttonConnect.setVisibility(View.INVISIBLE);
                buttoncancle.setVisibility(View.VISIBLE);

                Log.e("가능",String.valueOf(flag));
                if(flag==1) {
                    Client myClient = new Client(ip, port, imgv,buttonConnect,MainClint.this);
                    myClient.execute();
                }

            }
        });

        buttoncancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag=0;
                buttonConnect.setVisibility(View.VISIBLE);
                buttoncancle.setVisibility(View.INVISIBLE);

            }
        });

    }

}

