package com.asad.easybuy.utils

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import com.asad.data.handlers.DialogListener
import com.asad.easybuy.R


object CustomDialogs {

    fun singleDialogWithoutListener(
        context: Context, message: String, positiveText: String, title: String = context.getString(
            R.string.app_name
        )
    ) {
        val alertDialog = AlertDialog.Builder(context)
        alertDialog.setCancelable(false)
        alertDialog.setTitle(title)
        alertDialog.setMessage(message)
        alertDialog.setPositiveButton(positiveText) { dialog, _ ->
            dialog!!.dismiss()
        }.show()
    }

    fun singleDialogWithNoListener(
        context: Context,
        message: String,
        listener: OnChatDeleteConfirmListener,
        title: String = context.getString(
            R.string.app_name
        )
    ) {
        val alertDialog = AlertDialog.Builder(context)
        alertDialog.setCancelable(false)
        alertDialog.setTitle(title)
        alertDialog.setMessage(message)
        alertDialog.setPositiveButton("YES") { dialog, _ ->
            listener.onSayYes(dialog)
        }
        alertDialog.setNegativeButton("NO") { dialog, _ ->
            listener.onSayNo(dialog)
        }
        alertDialog.show()

    }

    interface OnChatDeleteConfirmListener {
        fun onSayYes(dialog: DialogInterface)
        fun onSayNo(dialog: DialogInterface)
    }

    fun singleDialogWithListener(
        context: Context,
        message: String,
        positiveText: String,
        listener: DialogListener,
        title: String = context.getString(
            R.string.app_name
        )
    ) {
        val alertDialog = AlertDialog.Builder(context)
        alertDialog.setCancelable(false)
        alertDialog.setTitle(title)
        alertDialog.setMessage(message)
        alertDialog.setPositiveButton(positiveText) { dialog, _ ->
            dialog!!.dismiss()
            listener.onPositiveClicked()
        }.show()
    }

    fun choiceDialogWithListener(
        context: Context,
        message: String,
        positiveText: String,
        negativeText: String,
        listener: DialogListener,
        title: String = context.getString(R.string.app_name)
    ) {
        val alertDialog = AlertDialog.Builder(context)
        alertDialog.setCancelable(false)
        alertDialog.setTitle(title)
        alertDialog.setMessage(message)
        alertDialog.setPositiveButton(positiveText) { dialog, _ ->
            dialog!!.dismiss()
            listener.onPositiveClicked()
        }.setNegativeButton(negativeText) { dialog, _ ->
            dialog.dismiss()
            listener.onNegativeClicked()
        }.show()
    }

    fun showInternetMessage(context: Context) {
        singleDialogWithoutListener(
            context,
            context.resources.getString(R.string.internet_connection),
            context.resources.getString(R.string.ok),
            context.resources.getString(R.string.app_name)
        )
    }

}