package com.example.androidassessment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.github.andreilisun.swipedismissdialog.SwipeDismissDialog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    RequestQueue queue ;
    dialogBox box;
    Button button ;

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        queue = Volley.newRequestQueue ( this );
        String url = "https://backend-test-zypher.herokuapp.com/testData";
         box = dialogBox.getInstance ();
         button = findViewById ( R.id.button );

         button.setOnClickListener ( new View.OnClickListener () {
             @Override
             public void onClick ( View v ) {

                 box.show ();

//                 View v1 = LayoutInflater.from ( getBaseContext () ).inflate ( R.layout.dailog ,null);
//                 SwipeDismissDialog dialog = new SwipeDismissDialog.Builder ( MainActivity.this ).setView ( v1 ).build ().show ();

             }
         } );

//        Log.d ( "TAG" , "onCreate: naman"  );

        JsonObjectRequest object = new JsonObjectRequest (
                Request.Method.POST ,
                url ,
                null ,
                new Response.Listener<JSONObject> () {
                    @Override
                    public void onResponse ( JSONObject response ) {
                        Map<String ,String > map = new HashMap<> ();
                        try {
                            map.put ( "status" , response.getString ( "status" ).toString () );
                            map.put ( "title" , response.getString ( "title" ));
                            map.put ( "imageURL" , response.getString ( "imageURL" ));
                            map.put ( "success_url" , response.getString ( "success_url" ));

                        } catch (JSONException e) {
                            e.printStackTrace ();
                        }

                        Log.d ( "TAG" , "onResponse: " + response.toString () );
                        box.init ( MainActivity.this,map);

                        try {
                            Log.d ( "TAG" , "onResponse: " + response.getString ( "title" ) );


                        } catch (JSONException e) {
                            e.printStackTrace ();
                        }

                    }
                } , new Response.ErrorListener () {
            @Override
            public void onErrorResponse ( VolleyError error ) {

                Log.d ( "TAG" , "onErrorResponse: " +error.getMessage ().toString () );

            }
        });

        queue.add ( object );

    }
}