package com.example.androidassessment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.ColorSpace;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.github.andreilisun.swipedismissdialog.OnCancelListener;
import com.github.andreilisun.swipedismissdialog.OnSwipeDismissListener;
import com.github.andreilisun.swipedismissdialog.SwipeDismissDialog;
import com.github.andreilisun.swipedismissdialog.SwipeDismissDirection;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.util.Map;

public final class dialogBox {

    private Context context;
    SwipeDismissDialog dialog;
    Map<String , String> map ;

    View vie ;


    private static  dialogBox box ;

    private dialogBox () {
    }

    public static dialogBox getInstance() {
        if(box == null) {
            box = new dialogBox ();
        }
        return box;
    }

    public void init(Context context,Map m)
    {
        this.context = context ;
        map = m;

        }

    public void show(  ) {
        this.context = context;


        vie= LayoutInflater.from ( context ).inflate ( R.layout.dailog,null );


        TextView textView = vie.findViewById ( R.id.text);
        ImageView imageView = vie.findViewById ( R.id.imageView );
        Button button = vie.findViewById ( R.id.btn );

        textView.setText ( map.get ( "title" ) );
        Picasso.with ( context ).load ( map.get ( "imageURL" ) ).into ( imageView );


        dialog = new SwipeDismissDialog.Builder ( context).setView ( vie ).setOnCancelListener ( new OnCancelListener () {
            @Override
            public void onCancel ( View view ) {
                Toast.makeText ( context , "On Cancel" , Toast.LENGTH_SHORT ).show ();
            }
        } ) .setOnSwipeDismissListener ( new OnSwipeDismissListener () {
            @Override
            public void onSwipeDismiss ( View view , SwipeDismissDirection direction ) {
                Toast.makeText ( context , "cancel" , Toast.LENGTH_SHORT ).show ();
//                dialog.dismiss ();
//                return ;

            }
        } ) .build () .show ();



        button.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick ( View v ) {

                context.startActivity ( new Intent (Intent.ACTION_VIEW).setData ( Uri.parse ( map.get ( "success_url" ) ) ) );
            }
        } );

    }


}
