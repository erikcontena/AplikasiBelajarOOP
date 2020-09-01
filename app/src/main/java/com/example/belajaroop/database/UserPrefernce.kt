package com.example.belajaroop.database

import android.content.Context


internal class UserPrefernce(context: Context) {
    companion object {
        private const val PREFS_NAME = "user_pref"
        private const val NAME = "name"
        private const val POIN = "email"


    }
    private val preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun setUser(value: User) {
        val editor = preferences.edit()
        editor.putString(NAME, value.nama)
        editor.putString(POIN, value.poin)
        editor.apply()
    }

    fun getUser(): User {
        val model = User()
        model.nama = preferences.getString(NAME, "User")
        model.poin = preferences.getString(POIN, "0")
        return model
    }
}


