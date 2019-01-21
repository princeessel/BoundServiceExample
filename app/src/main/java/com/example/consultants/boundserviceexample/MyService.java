package com.example.consultants.boundserviceexample;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {
private final IBinder iBinder= new InterfaceService();
    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }

    public class InterfaceService extends Binder{

        MyService getService(){

            return MyService.this;
        }

    }
    public String getClientMessage(){


        return "Client is Connected";
    }

    public String getServerMessage(){
        return "Message Saved in Server";

    }

}
