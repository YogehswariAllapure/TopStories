package in.andriod.heady.assessmenttest;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

public class VolleyManager {

    public  VolleyManager(Context context, String url, JSONObject jsonObject) {


        RequestQueue requestQueue =
                VolleyRequestQueue.getInstance(context).getRequestQueue();

        JsonObjectRequest jsonObjectRequest  = new JsonObjectRequest(
                Request.Method.GET,
                url,
                jsonObject,
                new SuccessListner(),
                new ErrorListner()
        );
        requestQueue.add(jsonObjectRequest);
    }


    private class SuccessListner implements Response.Listener<JSONObject>{
        @Override
        public void onResponse(JSONObject response) {
            Log.e("tag" , "Response:-"+response.toString());
            mOnResponseLIstner.onResponse(response.toString());
        }
    }

    private class ErrorListner implements Response.ErrorListener{
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e("tag" , "Error:-"+error);
        }
    }


    public interface OnResponseLIstner{
        void onResponse(String json);
    }

    private OnResponseLIstner mOnResponseLIstner;

    public void SetOnResponseListner(OnResponseLIstner onResponseLIstner){
        mOnResponseLIstner = onResponseLIstner;
    }


}
