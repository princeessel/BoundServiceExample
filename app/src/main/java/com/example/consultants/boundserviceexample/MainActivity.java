package com.example.consultants.boundserviceexample;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
 TextView textView;
 boolean isBind=false;
 MyService myService;
    private Object service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.textView2);
        Intent intent=new Intent(this,MyService.class);
        bindService(intent,serviceConnection, Context.BIND_AUTO_CREATE);
    }

    public void getClientServiceMessage(View view){

        String message;
        message=myService.getClientMessage();
        textView.setText(message);

    }


    public void getServerServiceMessage(View view){
        String message;
        message=myService.getServerMessage();
        textView.setText(message);


    }

    private ServiceConnection serviceConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            MyService.InterfaceService interfaceService= (MyService.InterfaceService) service;
            myService=interfaceService.getService();
            isBind=true;


        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
  isBind=false;

        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        if (isBind){
            unbindService(serviceConnection);
            isBind=false;
        }
    }
}











