package cl.malditosnakamas.persistenciadedatos.main

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class MainPreferences @Inject constructor() {

    companion object {
        const val NAME_SHARED_PREF_FILE = "configuracion"
        const val IS_FIRST_OPEN_APP = "is-first-open-app"
    }

    fun getSharedPreferencesMain(context: Context): SharedPreferences {
        return context.getSharedPreferences(NAME_SHARED_PREF_FILE, Context.MODE_PRIVATE)
    }

    fun isFirstOpenApp(context: Context): Boolean {
        return getSharedPreferencesMain(context)
            .getBoolean(IS_FIRST_OPEN_APP, true)
    }

    fun saveOpenApplication(context: Context) {
        val editPreferences = getSharedPreferencesMain(context).edit()
        editPreferences.putBoolean(IS_FIRST_OPEN_APP, false)
        editPreferences.apply()
    }
}