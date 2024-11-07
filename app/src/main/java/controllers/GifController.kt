package controllers
import android.content.Context
import android.graphics.drawable.AnimatedImageDrawable
import android.graphics.drawable.AnimationDrawable
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.locaspes.riperi.R


class GifController {

    companion object {

        fun startAnimation(gifDrawable: AnimatedImageDrawable, imageView: ImageView, gifDuration: Long){

            imageView.setImageDrawable(gifDrawable)
            gifDrawable.start()
            Handler().postDelayed({gifDrawable.stop()}, gifDuration)

        }

    }
}