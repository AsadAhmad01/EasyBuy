package com.asad.easybuy.utils

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.widget.ImageView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.asad.easybuy.App
import com.asad.easybuy.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.facebook.shimmer.ShimmerFrameLayout
import java.math.RoundingMode
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import javax.annotation.Nullable

object commonMethods {

//    fun performRightToLeftTransition(context: Context, imageView: ImageView) {
//        val animator =
//            AnimatorInflater.loadAnimator(context, R.animator.right_to_left) as ObjectAnimator
//        animator.target = imageView
//        animator.start()
//    }


    fun showShimmer(layout: ShimmerFrameLayout) {
        layout.startShimmer()
        layout.showShimmer(true)
    }

    fun stopShimmer(layout: ShimmerFrameLayout) {
        layout.stopShimmer()
        layout.hideShimmer()
    }

    fun showToast(text: String) {
        val toast = Toast.makeText(App().applicationContext, text, Toast.LENGTH_SHORT)
        toast.show()
    }

    fun showImage(imageView: ImageView, context: Context, url: String) {
        Glide.with(context)
            .asBitmap()
            .load(url)
            .error(R.drawable.baseline_account_circle_24)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(object : CustomTarget<Bitmap?>() {
                override fun onResourceReady(
                    resource: Bitmap,
                    @Nullable transition: Transition<in Bitmap?>?
                ) {
                    imageView.setImageBitmap(resource)
                }

                override fun onLoadCleared(@Nullable placeholder: Drawable?) {}
            })
    }

    fun isValidEmail(target: CharSequence): Boolean {
        return if (TextUtils.isEmpty(target)) {
            false
        } else {
            Patterns.EMAIL_ADDRESS.matcher(target).matches()
        }
    }

    fun getRealPathFromURI(context: Context, contentURI: Uri): String? {
        val result: String?
        val cursor = context.contentResolver.query(contentURI, null, null, null, null)
        if (cursor == null) { // Source is Dropbox or other similar local file path
            result = contentURI.path
        } else {
            cursor.moveToFirst()
            val idx: Int = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DISPLAY_NAME)
            result = cursor.getString(idx)
            cursor.close()
        }
        return result
    }


    fun checkPermissionForReadExternalStorage(context: Activity): Boolean {

        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            return (context.checkSelfPermission(Manifest.permission.READ_MEDIA_IMAGES) == PackageManager.PERMISSION_GRANTED && context.checkSelfPermission(
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED)
        } else {
            return (context.checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED && context.checkSelfPermission(
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED)
        }
    }


    fun requestPermissionForReadExternalStorage(context: Activity) {
        val READ_STORAGE_PERMISSION_REQUEST_CODE = 41
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                ActivityCompat.requestPermissions(
                    context,
                    arrayOf(Manifest.permission.READ_MEDIA_IMAGES, Manifest.permission.CAMERA),
                    READ_STORAGE_PERMISSION_REQUEST_CODE
                )
            } else {
                ActivityCompat.requestPermissions(
                    context, arrayOf(
                        Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA
                    ), READ_STORAGE_PERMISSION_REQUEST_CODE
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
            throw e
        }
    }


    fun dataConverter(date1: String): String {
        var result = ""
        val originalFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
        val targetFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val date: Date? = originalFormat.parse(date1)
        result = targetFormat.format(date)
        return result
    }

    @SuppressLint("SimpleDateFormat")
    fun formatTimeAgo(date1: String): String {
        var result = ""
        try {
            // Define the date format expected in the input string
            val format = "yyyy-MM-dd HH:mm"
            // Create a SimpleDateFormat object with the specified format
            val sdf = SimpleDateFormat(format, Locale.getDefault())
            // Parse the input date string into a Date object
            val postDate = sdf.parse(date1)
            if (postDate != null) {
                // Calculate the time difference between the current time and the parsed date
                val diff = Calendar.getInstance().time.time - postDate.time
                // Define constants for time conversion
                val oneSec = 1000L
                val oneMin: Long = 60 * oneSec
                val oneHour: Long = 60 * oneMin
                val oneDay: Long = 24 * oneHour
                val oneMonth: Long = 30 * oneDay
                val oneYear: Long = 365 * oneDay
                // Calculate time differences in various units
                val diffMin: Long = diff / oneMin
                val diffHours: Long = diff / oneHour
                val diffDays: Long = diff / oneDay
                val diffMonths: Long = diff / oneMonth
                val diffYears: Long = diff / oneYear
                // Determine the appropriate time unit and build the result string
                when {
                    diffYears > 0 -> {
                        result += " $diffYears years ago"
                    }

                    diffMonths > 0 -> {
                        result += " ${(diffMonths - diffYears * 12)} months ago "
                    }

                    diffDays > 0 -> {
                        result += " ${(diffDays - diffMonths * 30)} days ago "
                    }

                    diffHours > 0 -> {
                        result += " ${(diffHours - diffDays * 24)} hours ago "
                    }

                    diffMin > 0 -> {
                        result += " ${(diffMin - diffHours * 60)} min ago "
                    }

                    else -> {
                        result += " just now"
                    }
                }

            } else {
                // Handle the case where parsing failed
                result = "Invalid date format"
            }
        } catch (ex: Exception) {
            // Handle any exceptions that might occur during the process
            Log.e("formatTimeAgo", ex.toString())
        }
        // Return the final result string
        return result
    }


    fun getSubscriberCount(number: String, context: Context): String {
        var followers = ""
        val num: Double = number.toDouble()
        if (num < 999) {
            followers = if (num.toString().contains(".0")) {
                "${num.toInt()}"
            } else {
                "${num.toBigDecimal().setScale(2, RoundingMode.HALF_UP).toDouble()}"
            }
        } else if (num / 1000 < 999) {
            followers = if ((num / 1000).toString().contains(".0")) {
                " ${(num / 1000).toInt()}${
                    context.getString(R.string.k)
                } "
            } else {
                "${
                    (num / 1000).toBigDecimal().setScale(2, RoundingMode.HALF_UP).toDouble()
                }${context.getString(R.string.k)} "
            }
        } else if (num / 1000000 < 999999) {
            followers = if ((num / 1000000).toString().contains(".0")) {
                "${(num / 1000000).toInt()}${context.getString(R.string.m)} "
            } else {
                "${
                    (num / 1000000).toBigDecimal().setScale(2, RoundingMode.HALF_UP).toDouble()
                }${context.getString(R.string.m)} "
            }
        } else if (num / 1000000000 < 999999999) {

            followers = if ((num / 1000000000).toString().contains(".0")) {
                "${(num / 1000000000).toInt()}${context.getString(R.string.b)} "
            } else {
                "${
                    (num / 1000000000).toBigDecimal().setScale(2, RoundingMode.HALF_UP).toDouble()
                }${context.getString(R.string.b)} "
            }

        }

        return followers
    }

}