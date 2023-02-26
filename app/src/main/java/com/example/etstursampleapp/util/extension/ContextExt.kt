package com.example.etstursampleapp.util.extension

import android.app.AlertDialog
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.example.etstursampleapp.R

fun Context?.isConnected(): Boolean {
    val connectivityManager =
        this?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    return run {
        val activeNetwork = connectivityManager.activeNetwork ?: return false
        val networkCapabilities =
            connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
        when {
            networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            else -> false
        }
    }
}


fun Context?.showErrorDialog(message: String) {
    val title = this?.getString(R.string.title_error_dialog)
    with(AlertDialog.Builder(this)) {
        setTitle(title)
        setMessage(message)
        setPositiveButton(android.R.string.ok) { dialog, _ -> { dialog.dismiss() } }
        show()
    }
}