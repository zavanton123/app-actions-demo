package com.zavanton.appactionsdemo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zavanton.appactionsdemo.features.AccountListFragment
import com.zavanton.appactionsdemo.features.CardListFragment
import com.zavanton.appactionsdemo.features.HomeFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (intent.action == Intent.ACTION_VIEW) {
            val fragment = when {
                intent.data?.path == Deeplink.CARD_LIST -> CardListFragment.newInstance()
                intent.data?.path == Deeplink.ACCOUNT_LIST -> AccountListFragment.newInstance()
                else -> HomeFragment.newInstance()
            }
            if (supportFragmentManager.findFragmentById(R.id.fragment_container) == null) {
                supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit()
            }
        }
    }
}