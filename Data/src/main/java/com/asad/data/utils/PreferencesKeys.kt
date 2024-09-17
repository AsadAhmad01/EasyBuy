package com.asad.data.utils

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

object PreferencesKeys {
    const val USER_PREFERENCES_NAME = "biiView"

    val userName = stringPreferencesKey("UserName")
    val userModel = stringPreferencesKey("userModel")
    val isRememberLogin = booleanPreferencesKey("isRememberLogin")
    val isGmailLogin = booleanPreferencesKey("isGmail")
    val isFacebookLogin = booleanPreferencesKey("isFacebook")
    val email = stringPreferencesKey("email")
    val pass = stringPreferencesKey("pass")
    val firebaseToken = stringPreferencesKey("firebaseToken")

}