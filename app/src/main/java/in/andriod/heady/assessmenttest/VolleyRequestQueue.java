package in.andriod.heady.assessmenttest;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleyRequestQueue {

    private static VolleyRequestQueue volleyRequestQueue =null;
    private  RequestQueue requestQueue;

    private VolleyRequestQueue(Context context) {
        requestQueue = Volley.newRequestQueue(context);
    }
    public static VolleyRequestQueue getInstance(Context context){
        if (volleyRequestQueue == null){
            volleyRequestQueue = new VolleyRequestQueue(context);
        }
        return volleyRequestQueue;
    }

    public RequestQueue getRequestQueue(){
        return requestQueue;
    }
 }

