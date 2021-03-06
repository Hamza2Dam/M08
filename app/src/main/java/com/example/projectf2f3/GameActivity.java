package com.example.projectf2f3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projectf2f3.Utilidades.Utilidades;

public class GameActivity extends AppCompatActivity {

    EditText campoId,campoNombre,campPuntuacion;
    Button btnconsulta, btnActua, btnDele,btnadd;

    public boolean musicatorn = false ;


    MediaPlayer player;
    Animation play;
    Button buttonPlay;


    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Variable MediaPlayer on guardem la musica
        player = MediaPlayer.create(getApplicationContext(), R.raw.musicadefons);

        // Variable bool que controla el torn de la musica
        // Iniciem amb false
        musicatorn = false;


        buttonPlay = findViewById(R.id.playmusic);

        play = AnimationUtils.loadAnimation(this,R.anim.play) ;


        conn=new ConexionSQLiteHelper(getApplicationContext(),"User_Database",null,1);

        campoId= (EditText) findViewById(R.id.documentoId);
        campoNombre= (EditText) findViewById(R.id.nombreGame);
        campPuntuacion= (EditText) findViewById(R.id.puntuacion);

        btnadd = (Button) findViewById(R.id.btnAdd);
        btnconsulta = (Button) findViewById(R.id.btnConsultar);
        btnActua = (Button) findViewById(R.id.btnActualizar);
        btnDele = (Button) findViewById(R.id.btnEliminar);


        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Si esta false será true i si está true será false així activem o
                // desactivem quan premem el botó

                if(musicatorn == false){
                    musicatorn = true;
                    // Cridem a la funció que retorna la musica passant-li el torn (bool)
                    MusicControl(musicatorn);

                }else {
                    musicatorn = false;
                    MusicControl(musicatorn);
                }





            }
        });

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InsertUsuario();
            }
        });

        btnconsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                consultarSql();
            }
        });

        btnActua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actualizarUsuario();
            }
        });

        btnDele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarUsuario();
            }
        });

    }

    public void MusicControl(boolean musicatorn){
        if(musicatorn){
            player.start();
            buttonPlay.startAnimation(play);



        }else{
            player.pause();
            buttonPlay.clearAnimation();

        }

    }

    private void InsertUsuario() {
        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_NOMBRE_GAME,campoNombre.getText().toString());
        values.put(Utilidades.CAMPO_Puntuacion,campPuntuacion.getText().toString());

        db.insert(Utilidades.TABLA_PUNTUACIO, null, values);


        Toast.makeText(getApplicationContext(),"Ya se actualizó el usuario",Toast.LENGTH_LONG).show();
        limpiar();
        db.close();

    }

    private void eliminarUsuario() {
        SQLiteDatabase db=conn.getWritableDatabase();
        String[] parametros={campoId.getText().toString()};

        db.delete(Utilidades.TABLA_PUNTUACIO,Utilidades.CAMPO_ID+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Ya se Eliminó el usuario",Toast.LENGTH_LONG).show();
        campoId.setText("");
        limpiar();
        db.close();
    }

    private void actualizarUsuario() {
        SQLiteDatabase db = conn.getWritableDatabase();
        String[] parametros={campoId.getText().toString()};
        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_NOMBRE_GAME,campoNombre.getText().toString());
        values.put(Utilidades.CAMPO_Puntuacion,campPuntuacion.getText().toString());

        db.update(Utilidades.TABLA_PUNTUACIO,values,Utilidades.CAMPO_ID+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Ya se actualizó el usuario",Toast.LENGTH_LONG).show();
        limpiar();
        db.close();

    }

    private void consultarSql() {
        SQLiteDatabase db=conn.getReadableDatabase();
        String[] parametros={campoId.getText().toString()};

        try {
            Cursor cursor=db.rawQuery("SELECT " +Utilidades.CAMPO_NOMBRE_GAME+"  ,  "+Utilidades.CAMPO_Puntuacion+
                    " FROM "+Utilidades.TABLA_PUNTUACIO+" WHERE "+Utilidades.CAMPO_ID+ "=? ",parametros);

            cursor.moveToFirst();
            campoNombre.setText(cursor.getString(0));
            campPuntuacion.setText(cursor.getString(1));

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El documento no existe",Toast.LENGTH_LONG).show();
            limpiar();

        }
        db.close();
    }


    private void limpiar() {
        campoNombre.setText("");
        campPuntuacion.setText("");
    }

}