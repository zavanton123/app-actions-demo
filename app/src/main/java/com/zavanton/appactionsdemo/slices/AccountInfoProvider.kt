package com.zavanton.appactionsdemo.slices

import android.app.PendingIntent
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.core.graphics.drawable.IconCompat
import androidx.slice.Slice
import androidx.slice.SliceProvider
import androidx.slice.builders.*
import com.zavanton.appactionsdemo.MainActivity


class AccountInfoProvider : SliceProvider() {

    companion object {

        const val ACCOUNT_SLICE_AUTHORITY = "com.zavanton.slices.account.provider"
    }

    /**
     * This method is called when the Provider is first created,
     * use it to initialize your code but keep it mind
     * that you should not do heavy tasks and block the thread.
     */
    override fun onCreateSliceProvider(): Boolean {
        Log.d("zavanton", "zavanton - onCreateSliceProvider")
        return true
    }

    /**
     * When a new request is send to the SliceProvider of this app, this method is called
     * with the given slice URI.
     * Here you could directly handle the uri and create a new slice.
     */
    override fun onBindSlice(sliceUri: Uri): Slice {
        Log.d("zavanton", "zavanton - onBindSlice: $sliceUri")
        // implement logic to get some slice from uri
        return list(requireNotNull(context), sliceUri, ListBuilder.INFINITY) {
            header {
                title = "Account Info"
                subtitle = "Some Subtitle"
                primaryAction = createOpenAppAction()
            }
            gridRow {
                cell {
                    addTitleText("Some Title Text")
                    addText("Some text")
                }
            }
        }
    }

    private fun createOpenAppAction(): SliceAction {
        val intent = Intent(context, MainActivity::class.java)
        return SliceAction.create(
            PendingIntent.getActivity(context, 0, intent, 0),
            IconCompat.createWithResource(context, R.drawable.abc_ic_star_black_16dp),
            ListBuilder.SMALL_IMAGE,
            "Open App"
        )
    }
}