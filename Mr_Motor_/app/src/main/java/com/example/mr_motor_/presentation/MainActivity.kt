
package com.example.mr_motor_.presentation

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.mr_motor_.R
import com.example.mr_motor_.presentation.home.HomeFragment
import com.example.mr_motor_.presentation.posts.CarFragment
import com.example.mr_motor_.presentation.posts.CompetitionFragment
import com.example.mr_motor_.presentation.posts.NewsFragment
import com.example.mr_motor_.presentation.posts.RacerFragment
import com.example.mr_motor_.presentation.tasks.TaskFragment


class MainActivity : AppCompatActivity() {

    private lateinit var homeButton : ImageButton
    private lateinit var newsButton : ImageButton
    private lateinit var quizButton : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
        setTheme(R.style.splashScreenTheme)
        setContentView(R.layout.activity_main)

        homeButton = findViewById(R.id.ib_homePage)
        newsButton = findViewById(R.id.ib_newsPage)
        quizButton = findViewById(R.id.ib_quizPage)

        val homeFragment = HomeFragment()
        val newsFragment = NewsFragment()
        val quizFragment = TaskFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_fragments, homeFragment)
            commit()
        }

        val bounceAnimation = AnimationUtils.loadAnimation(this, R.anim.bounce_animation)

        homeButton.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_fragments, homeFragment)
                commit()
            }
            homeButton.startAnimation(bounceAnimation)
        }
        newsButton.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_fragments, newsFragment)
                commit()
            }
            newsButton.startAnimation(bounceAnimation)
        }
        quizButton.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_fragments, quizFragment)
                commit()
            }
            quizButton.startAnimation(bounceAnimation)
        }

    }

    fun onNavigationItemSelected2(item : Int) {

        when (item) {
            1 -> {
                supportFragmentManager.beginTransaction().apply {
                    add(R.id.fl_fragments, CompetitionFragment())
                    commit()
                }
            }
            2 -> {
                supportFragmentManager.beginTransaction().apply {
                    add(R.id.fl_fragments, RacerFragment())
                    commit()
                }
            }
            3 -> {
                supportFragmentManager.beginTransaction().apply {
                    add(R.id.fl_fragments, CarFragment())
                    commit()
                }
            }
        }
    }

    companion object{
        fun start(caller : Activity){
            val intent : Intent = Intent(caller, MainActivity::class.java)
            caller.startActivity(intent)
        }
    }
}