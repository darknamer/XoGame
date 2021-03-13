package com.darknamer.xo_game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class GameActivity : AppCompatActivity() {
    private var xoGame: XoGame? = null

    private var text_view_turn: TextView? = null
    private var button11: Button? = null
    private var button12: Button? = null
    private var button13: Button? = null
    private var button21: Button? = null
    private var button22: Button? = null
    private var button23: Button? = null
    private var button31: Button? = null
    private var button32: Button? = null
    private var button33: Button? = null
    private var button_reset: Button? = null
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        Log.d("GameActivity", "on create")

        xoGame = XoGame()
        xoGame?.reset()

        text_view_turn = findViewById(R.id.text_view_turn)
        button11 = findViewById(R.id.button_1_1)
        button12 = findViewById(R.id.button_1_2)
        button13 = findViewById(R.id.button_1_3)
        button21 = findViewById(R.id.button_2_1)
        button22 = findViewById(R.id.button_2_2)
        button23 = findViewById(R.id.button_2_3)
        button31 = findViewById(R.id.button_3_1)
        button32 = findViewById(R.id.button_3_2)
        button33 = findViewById(R.id.button_3_3)
        button_reset = findViewById(R.id.button_reset)

        setMonitor()

        button11?.setOnClickListener {
            xoGame!!.setPosition(0, 0)
            count++
            hasWinner()
            setMonitor()
        }
        button12?.setOnClickListener {
            xoGame!!.setPosition(0, 1)
            count++
            hasWinner()
            setMonitor()
        }
        button13?.setOnClickListener {
            xoGame!!.setPosition(0, 2)
            count++
            hasWinner()
            setMonitor()
        }
        button21?.setOnClickListener {
            xoGame!!.setPosition(1, 0)
            count++
            hasWinner()
            setMonitor()
        }
        button22?.setOnClickListener {
            xoGame!!.setPosition(1, 1)
            count++
            hasWinner()
            setMonitor()
        }
        button23?.setOnClickListener {
            xoGame!!.setPosition(1, 2)
            count++
            hasWinner()
            setMonitor()
        }
        button31?.setOnClickListener {
            xoGame!!.setPosition(2, 0)
            count++
            hasWinner()
            setMonitor()
        }
        button32?.setOnClickListener {
            xoGame!!.setPosition(2, 1)
            count++
            hasWinner()
            setMonitor()
        }
        button33?.setOnClickListener {
            xoGame!!.setPosition(2, 2)
            count++
            hasWinner()
            setMonitor()
        }

        button_reset?.setOnClickListener {
            xoGame?.reset()
            count = 0

            button11?.isEnabled = true
            button12?.isEnabled = true
            button13?.isEnabled = true
            button21?.isEnabled = true
            button22?.isEnabled = true
            button23?.isEnabled = true
            button31?.isEnabled = true
            button32?.isEnabled = true
            button33?.isEnabled = true

            setMonitor()
        }
    }

    private fun setMonitor() {
        button11?.text = xoGame!!.table[0][0]
        button12?.text = xoGame!!.table[0][1]
        button13?.text = xoGame!!.table[0][2]
        button21?.text = xoGame!!.table[1][0]
        button22?.text = xoGame!!.table[1][1]
        button23?.text = xoGame!!.table[1][2]
        button31?.text = xoGame!!.table[2][0]
        button32?.text = xoGame!!.table[2][1]
        button33?.text = xoGame!!.table[2][2]

        val turnOfPlayer = xoGame?.turnOfPlayer
        text_view_turn?.text = "Turn: $turnOfPlayer"
    }

    private fun hasWinner() {
        if (xoGame?.isGameOver == true) {
            val winnerName = xoGame?.winner
            val messageShow = "Game over, winner is $winnerName"
            Toast.makeText(applicationContext, messageShow, Toast.LENGTH_SHORT).show()

            button11?.isEnabled = false
            button12?.isEnabled = false
            button13?.isEnabled = false
            button21?.isEnabled = false
            button22?.isEnabled = false
            button23?.isEnabled = false
            button31?.isEnabled = false
            button32?.isEnabled = false
            button33?.isEnabled = false
        }

        if (count >= 9) {
            val messageShow = "Game over, No winner, game is draw"
            Toast.makeText(applicationContext, messageShow, Toast.LENGTH_SHORT).show()
            button11?.isEnabled = false
            button12?.isEnabled = false
            button13?.isEnabled = false
            button21?.isEnabled = false
            button22?.isEnabled = false
            button23?.isEnabled = false
            button31?.isEnabled = false
            button32?.isEnabled = false
            button33?.isEnabled = false
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("GameActivity", "on start")
    }

    override fun onResume() {
        super.onResume()
        Log.d("GameActivity", "on resume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("GameActivity", "on pause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("GameActivity", "on stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("GameActivity", "on destroy")
    }
}