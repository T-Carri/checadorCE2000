package com.example.qrpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.qrpractice.R
import java.text.DateFormat
import java.util.*

class START : AppCompatActivity() {

    private var spLenguajes: Spinner?=null
    var vt: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//cambio de actividad

val btn: ImageButton= findViewById(R.id.imageButton2)
btn.setOnClickListener{
    val intent: Intent = Intent( this, MainActivity::class.java )
    startActivity(intent)
}



//spinner
        spLenguajes=findViewById(R.id.spLenguajes)
        val listaLenguajes= arrayOf("Residente", "x", "y","z")

        var adaptador:ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_spinner_item,listaLenguajes)
        spLenguajes?.adapter=adaptador
        vt = findViewById<View>(R.id.fecha) as TextView
        val mydate = DateFormat.getDateTimeInstance().format(Calendar.getInstance().time)
        vt!!.text = mydate
        //handle operation data for spinner and project

        
    }


}