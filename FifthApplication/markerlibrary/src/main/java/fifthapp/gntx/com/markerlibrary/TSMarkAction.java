package fifthapp.gntx.com.markerlibrary;


import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.MySSLSocketFactory;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by zman on 12/2/16.
 */
public class TSMarkAction {

    private static TSMarkAction instance;

    private   static String access_token = null;
    private  static String email_id = null;
    private  static String application_id = null;
    public static Activity ctx;


    public static synchronized TSMarkAction getInstance(Context c) {
        if(instance == null) {
            instance = new TSMarkAction(c);
        }
        return instance;
    }
    private TSMarkAction(Context c)
    {
        access_token= c.getApplicationContext().getResources().getString(R.string.access_token);
        email_id = c.getApplicationContext().getResources().getString(R.string.email_id);
        application_id = c.getApplicationContext().getResources().getString(R.string.application_id);
        ctx = (Activity)c;

    }



    public static void markAction(String SensorName, JSONObject details) {
        //mobile type, mobile os , android version

        AsyncHttpClient client = new AsyncHttpClient();
//        client.setSSLSocketFactory(MySSLSocketFactory.getFixedSocketFactory());


        String url = "http://www.w3schools.com/angular/customers.php";


          RequestParams params = new RequestParams();
//        params.put("access_token", access_token);
//        params.put("email_id", email_id);
//        params.put("application_id", application_id);
//        params.put("android_version", Build.VERSION.SDK_INT);
//        params.put("sensor_name", SensorName);
//        params.put("details", details.toString());
//        params.put("source", "android");
//        params.put("user-id", email_id);


        client.get(url, params, new JsonHttpResponseHandler() {
            @Override
            public void onStart() {
                super.onStart();
                Toast.makeText(ctx, Build.VERSION.SDK_INT + " ", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // If the response is JSONObject instead of expected JSONArray
                Toast.makeText(ctx, response.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
                Toast.makeText(ctx, responseString, Toast.LENGTH_SHORT).show();

            }
        });

    }
}
