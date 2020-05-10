package com.sebastianmurgu.monstermatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity: AppCompatActivity() {
    private val monsters: List<Monster> = listOf(
        Monster(R.drawable.monster1_head, R.drawable.monster1_body, R.drawable.monster1_feet, R.string.monster_one_name),
        Monster(R.drawable.monster2_head, R.drawable.monster2_body, R.drawable.monster2_feet, R.string.monster_two_name),
        Monster(R.drawable.monster3_head, R.drawable.monster3_body, R.drawable.monster3_feet, R.string.monster_three_name)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        shuffleMonsters()

        match_button.setOnClickListener {
            shuffleMonsters()
        }
    }

    private fun shuffleMonsters() {
        val top = monsters.random()
        val mid = monsters.random()
        val bot = monsters.random()

        monster_head_image_view.setImageResource(top.head)
        monster_body_image_view.setImageResource(mid.body)
        monster_feet_image_view.setImageResource(bot.feet)

        if (top == mid && mid == bot) {
            val name = resources.getString(top.name)
            match_message.setText(getString(R.string.match_status_messsage, name))
        } else {
            match_message.setText("")
        }
    }
}

data class Monster(val head: Int, val body: Int, val feet: Int, val name: Int)
