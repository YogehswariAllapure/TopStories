package in.andriod.heady.assessmenttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<TopStories> mListStories;
    private AdapterTopStories mAdapterTopStories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    private void init(){

        RecyclerView mRecyclerStories = findViewById(R.id.recyclerStories);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                this,LinearLayoutManager.VERTICAL,false
        );
        mRecyclerStories.setLayoutManager(linearLayoutManager);

        mListStories = new ArrayList<>();

        mAdapterTopStories = new AdapterTopStories(mListStories);

        mRecyclerStories.setAdapter(mAdapterTopStories);

        getTopStories();

    }


    private void getTopStories(){

        String mUrl = "https://api.nytimes.com/svc/topstories/v2/arts.json?api-key=MCABNnii4sKr62JLIaR7GWy1UwR4DKcb";

        VolleyManager volleyManager = new VolleyManager(MainActivity.this, mUrl, null);
        volleyManager.SetOnResponseListner(new getPaymentHistoryResponse());
    }

    private class getPaymentHistoryResponse implements VolleyManager.OnResponseLIstner {

        @Override
        public void onResponse(String response) {

            try {
                JSONObject jsonObject = new JSONObject(response);
                String data = jsonObject.getString("results");
                JSONArray jsonArray = new JSONArray(data);

                for (int i = 0; i < jsonArray.length(); i++) {

                    JSONObject jsonObj = jsonArray.getJSONObject(i);
                    String section = jsonObj.getString("section");
                    String title = jsonObj.getString("title");
                    String desc = jsonObj.getString("abstract");
                    String published_date = jsonObj.getString("published_date");


                    mListStories.add(new TopStories(section, title, desc,published_date));
                    mAdapterTopStories.notifyDataSetChanged();

                }
            } catch (JSONException e) {
                e.printStackTrace();

            }
        }
    }

}