package com.zavanton.appactionsdemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("zavanton", "zavanton - intent.action: ${intent.action}")
        Log.d("zavanton", "zavanton - intent.data: ${intent.data}")
    }
}