package com.zavanton.appactionsdemo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.zavanton.appactionsdemo.features.AccountListFragment
import com.zavanton.appactionsdemo.features.CardListFragment
import com.zavanton.appactionsdemo.features.HomeFragment
import com.zavanton.appactionsdemo.features.SearchFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (intent.action == Intent.ACTION_VIEW) {
            Log.d("zavanton", "zavanton - intent.data: ${intent.data}")
            Log.d("zavanton", "zavanton - intent.data?.path: ${intent.data?.path}")

            val fragment = when {
                intent.data?.path == Deeplink.CARD_LIST -> CardListFragment.newInstance()
                intent.data?.path == Deeplink.ACCOUNT_LIST -> AccountListFragment.newInstance()
                intent.data?.path == Deeplink.SEARCH -> SearchFragment.newInstance()
                else -> HomeFragment.newInstance()
            }

            if (supportFragmentManager.findFragmentById(R.id.fragment_container) == null) {
                supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit()
            }
        } else {
            Log.d("zavanton", "zavanton - not deep link")
        }
    }
}