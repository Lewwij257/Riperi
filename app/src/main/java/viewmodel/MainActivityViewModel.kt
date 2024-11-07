package viewmodel

import android.app.Activity
import android.content.Context
import android.graphics.drawable.AnimatedImageDrawable
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.locaspes.riperi.R
import fragments.HomeFragment

import controllers.GifController

class MainActivityViewModel: ViewModel() {

    fun changeMainFragment(supportFragmentManager: FragmentManager, fragmentView: View, newFragmentClass: Fragment){

        val fragmentTransaction =  supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(fragmentView.id, newFragmentClass)
        fragmentTransaction.commit()

    }

    fun startAnimation(gifDrawable: AnimatedImageDrawable, imageView: ImageView, gifDuration: Long){
        val animationController = GifController
        animationController.startAnimation(gifDrawable, imageView, gifDuration)
    }

}