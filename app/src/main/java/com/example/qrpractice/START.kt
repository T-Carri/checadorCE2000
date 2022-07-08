package com.example.qrpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.qrpractice.R
import com.google.gson.Gson
import org.json.JSONArray
import java.text.DateFormat
import java.util.*

class START : AppCompatActivity() {

    private var spLenguajes: Spinner?=null
    var vt: TextView? = null
    var t: TextView? = null
    private var requestQueue: RequestQueue?=null

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
        val textView = findViewById<TextView>(R.id.textView)
        // ...

    // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "https://my-json-server.typicode.com/typicode/demo/profile"

        // Request a string response from the provided URL.
      /*  val stringRequest = StringRequest(Request.Method.GET, url,
            Response.Listener<JSONArray> {
                /*  response ->
// Display the first 500 characters of the response string.
textView.text = "Response is: ${response.substring(0, 1)}"*/
            }*/
        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
            Response.Listener { response ->
                textView.text = "Response: %s".format(response.toString())
            },
            Response.ErrorListener { textView.text = "That didn't work!" })

        // Add the request to the RequestQueue.
        queue.add(jsonObjectRequest)
}}