
package com.example.projectf2f3.Utilidades;

public class Utilidades {

    // Constantes Tabla Usuario
    public static final String TABLA_USUARIO = "Usuario"; // Table

    public static final String CAMPO_NOMBRE = "User_Nombre";
    public static final String CAMPO_EMAIL = "User_Email";
    public static final String CAMPO_PASSWORD = "User_Password";

    public static final String CREAR_TABLA_USUARIO="CREATE TABLE " +
    ""+TABLA_USUARIO+" (" +CAMPO_NOMBRE+" TEXT," + CAMPO_EMAIL+" TEXT," + CAMPO_PASSWORD+" TEXT)";

// ------------------------------------------------------------------------------------------------------------

    // Constantes Tabla Menu
    public static final String TABLA_MENU = "Menu";  // Table

    public static final String CAMPO_NOMBRE_MENU = "Menu_Nombre";
    public static final String CAMPO_DESCRIP_MENU = "Menu_Descrip";
    public static final String CAMPO_PRICE_MENU = "Menu_Price";
    public static final String CAMPO_FOTO_MENU = "Menu_Foto";

    public static final String CREAR_TABLA_MENU="CREATE TABLE " +
    ""+TABLA_MENU+" ("+CAMPO_NOMBRE_MENU+" TEXT,"  +CAMPO_DESCRIP_MENU+" TEXT," +CAMPO_PRICE_MENU+" TEXT,"  +CAMPO_FOTO_MENU+" TEXT)";

// ------------------------------------------------------------------------------------------------------------

    // Constantes Tabla puntuacion
    public static final String TABLA_PUNTUACIO = "UserPuntuacion";  // Table

    public static final String CAMPO_ID = "User_ID";
    public static final String CAMPO_Puntuacion = "User_Puntuacion";
    public static final String CAMPO_NOMBRE_GAME = "User_GameName";

    public static final String CREAR_TABLA_PUNTUACIO="CREATE TABLE " +
            ""+TABLA_PUNTUACIO+" ("+CAMPO_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,  "+CAMPO_Puntuacion+" TEXT,"  +CAMPO_NOMBRE_GAME+" TEXT)";
}

