package io.github.matthewcmckenna.ktxplayground

import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.doOnEnd
import androidx.core.animation.doOnStart
import kotlinx.android.synthetic.main.activity_animation.*

class AnimationActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)

        animate_button.setOnClickListener {
            startAnimation()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun startAnimation() {
        val animator = ValueAnimator.ofInt(10, 600)

        animator.doOnStart {
            animation_stage_text_view.text = "doOnStart"
        }

        animator.addUpdateListener {
            view.layoutParams.width = animator.animatedValue as Int
            view.requestLayout()
        }

        animator.doOnEnd {
            animation_stage_text_view.text = "doOnEnd"
        }

        animator.start()
    }

}
