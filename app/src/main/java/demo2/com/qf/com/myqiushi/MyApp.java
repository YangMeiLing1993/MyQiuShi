package demo2.com.qf.com.myqiushi;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by ymll on 2016/7/8.
 */
public class MyApp extends Application{
    private static  MyApp app;
    private RequestQueue requestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        this.app=this;
        requestQueue = Volley.newRequestQueue(this);
    }

    public static MyApp getApp() {
        return app;
    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }
}
