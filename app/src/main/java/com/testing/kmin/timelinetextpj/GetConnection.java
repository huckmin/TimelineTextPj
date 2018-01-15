package com.testing.kmin.timelinetextpj;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by kmin on 2018-01-11.
 */


public class GetConnection {
    private Context context;

    public GetConnection(Context current) {
        this.context = current;
    }
    /* pathParam : requestPath,   methodParam : requestMethod,   sendObj : sendParam*/
    public String sendRequest(String pathParam , String methodParam, String sendString) {
        String resultString = "";
        try{
            RequestQueue queue = Volley.newRequestQueue(context);
            String urlString ="http://13.124.168.201:8000/timeline/";

            StringRequest stringRequest = new StringRequest(Request.Method.GET, urlString,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            // Display the first 500 characters of the response string.
                            Log.d("response", "onResponse: "+ response);
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            queue.add(stringRequest);

//            String urlString = context.getResources().getString(R.string.serverUrl);
//            String urlString ="http://13.124.168.201:8000/timeline/";
//            if(pathParam != null){
//                urlString = urlString +"/"+ pathParam;
//            }
//            URL url = new URL(urlString);
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setConnectTimeout(15000);
//            connection.setDoOutput(true);

//            if(methodParam != null){
//                methodParam = "POST";
//            }
//            methodParam = "GET";
//            connection.setRequestMethod(methodParam);
//            connection.setRequestProperty("content-type","application/json");
//            connection.connect();
//            OutputStream outst = connection.getOutputStream();
//            if(sendString != null){
//                outst.write(sendString.getBytes());
//            }
//            outst.flush();

//            int resCode = connection.getResponseCode();
//            Log.e("resCode",resCode+"");
//            if (resCode == HttpURLConnection.HTTP_OK) {
//                StringBuilder builder = new StringBuilder();
//                BufferedReader buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//                String line;
//                while (true) {
//                    line = buffer.readLine();
//                    if (line == null) {
//                        break;
//                    }
//                    builder.append(line + "\n");
//                }
//                resultString = builder.toString();
//                buffer.close();
//                connection.disconnect();
//            }else{
//                Log.e("connetion error",resCode+"  resCode");
//            }

        } catch(Exception e){
            e.printStackTrace();
        }

        return resultString;
    }
}