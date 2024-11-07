package com.locaspes.riperi

import android.graphics.drawable.AnimatedImageDrawable
import android.media.Image
import android.os.Bundle
import android.os.Handler
import android.renderscript.ScriptGroup.Binding
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.customview.widget.ViewDragHelper.Callback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.common.api.Response
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import data.model.CarBrand
import fragments.FavoritesFragment
import fragments.HomeFragment
import fragments.MoreFragment
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import viewmodel.HomeFragmentViewModel
import viewmodel.MainActivityViewModel
import retrofit2.Call


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val retrofit = data.remote.RetrofitService.getInstance()
        val data = retrofit.getAllCarBrand()
        data.enqueue(object : retrofit2.Callback<List<CarBrand>>{

            override fun onResponse(
                call: Call<List<CarBrand>>,
                response: retrofit2.Response<List<CarBrand>>
            ) {
                if(response.isSuccessful){
                    Log.d("gdbhsbvcnvbcxmvxm", call.toString() + " " + response.toString())
                }
            }

            override fun onFailure(call: Call<List<CarBrand>>, t: Throwable) {
                Log.d("ASDHKJFGASKFGASe761836217", t.message.toString())
            }

        })

        val mainActivityViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        val btnHome = findViewById<ImageView>(R.id.btn_return_to_main)
        val btnProductCart = findViewById<ImageView>(R.id.btn_cart)
        val btnFavorites = findViewById<ImageView>(R.id.btn_favorites)
        val btnMore = findViewById<ImageView>(R.id.btn_more)

        val frMainFragment = findViewById<View>(R.id.frMainScreen)

        val homeFragment = HomeFragment()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frMainScreen, homeFragment)
        fragmentTransaction.commit()

        btnHome.setOnClickListener{
            if (supportFragmentManager.findFragmentById(R.id.frMainScreen) !is HomeFragment){
                mainActivityViewModel.changeMainFragment(supportFragmentManager, frMainFragment, HomeFragment())
                mainActivityViewModel.startAnimation(getDrawable(R.drawable.gif_home_50) as AnimatedImageDrawable, btnHome, 1180)
            }
        }


        btnFavorites.setOnClickListener {
            if (supportFragmentManager.findFragmentById(R.id.frMainScreen) !is FavoritesFragment){
                mainActivityViewModel.changeMainFragment(supportFragmentManager, frMainFragment, FavoritesFragment())
                mainActivityViewModel.startAnimation(getDrawable(R.drawable.gif_heart_50) as AnimatedImageDrawable, btnFavorites, 1180)
            }
        }

        btnMore.setOnClickListener {
            if (supportFragmentManager.findFragmentById(R.id.frMainScreen) !is MoreFragment){
                mainActivityViewModel.changeMainFragment(supportFragmentManager, frMainFragment, MoreFragment())
                mainActivityViewModel.startAnimation(getDrawable(R.drawable.gif_more_50) as AnimatedImageDrawable, btnMore, 1180)
            }
        }


        //TEST TEST TEST


//            val gifDrawable = getDrawable(R.drawable.gif_heart_50) as AnimatedImageDrawable
//            btnFavorites.setImageDrawable(gifDrawable)
//            gifDrawable.start()
//            Handler().postDelayed({gifDrawable.stop()}, 1180)

        //TESTETESTEST






    }
}
