package cl.malditosnakamas.persistenciadedatos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cl.malditosnakamas.persistenciadedatos.main.MainNavigator
import cl.malditosnakamas.persistenciadedatos.main.MainPreferences
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var mainNavigator : MainNavigator
    @Inject lateinit var mainPreferences : MainPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (mainPreferences.isFirstOpenApp(this)) {
            mainPreferences.isFirstOpenApp(this)
            mainNavigator.goToBienvenida(supportFragmentManager)
        } else {
            mainNavigator.goToHome(supportFragmentManager)
        }
    }
}