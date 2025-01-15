package pt.iade.ei.iadesocial.models

import android.content.Context
import android.content.SharedPreferences

class SessionManager(context: Context) {
    private val PREF_NAME = "UserSession"
    private val KEY_TOKEN = "token"
    private val KEY_USER_ID = "UserID"

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = sharedPreferences.edit()

    fun saveSession(token: String, userId: Int) {
        editor.putString(KEY_TOKEN, token)
        editor.putInt(KEY_USER_ID, userId)
        editor.apply()
    }

    fun getToken(): String? = sharedPreferences.getString(KEY_TOKEN, null)

    fun getUserId(): Int = sharedPreferences.getInt(KEY_USER_ID, -1)

    fun clearSession() {
        editor.clear()
        editor.apply()
    }

    fun isLoggedIn(): Boolean = getToken() != null
}
