package com.example.qrpractice

import androidx.appcompat.app.AppCompatActivity
import com.budiyev.android.codescanner.CodeScanner
import android.os.Bundle
import com.example.qrpractice.R
import com.budiyev.android.codescanner.CodeScannerView
import com.budiyev.android.codescanner.DecodeCallback
import android.widget.Toast

internal class MainActivity : AppCompatActivity() {
    private var mCodeScanner: CodeScanner? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qrdisplay)
        val scannerView = findViewById<CodeScannerView>(R.id.scanner_view)
        mCodeScanner = CodeScanner(this, scannerView)
        mCodeScanner!!.decodeCallback = DecodeCallback { result ->
            runOnUiThread {
                Toast.makeText(
                    this@MainActivity,
                    result.text,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        scannerView.setOnClickListener { mCodeScanner!!.startPreview() }
    }

    override fun onResume() {
        super.onResume()
        mCodeScanner!!.startPreview()
    }

    override fun onPause() {
        mCodeScanner!!.releaseResources()
        super.onPause()
    }
}