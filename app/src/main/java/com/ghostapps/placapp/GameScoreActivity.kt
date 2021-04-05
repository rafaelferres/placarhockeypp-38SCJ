package com.ghostapps.placapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_score_game.*

class GameScoreActivity: AppCompatActivity() {

    companion object {
        const val TEAM_HOME_NAME = "home_team_name"
        const val TEAM_AWAY_NAME = "away_team_name"
    }
    
    var homeTeamScore = 0
    var awayTeamScore = 0

    var homeTeamFaul = 0
    var awayTeamFaul = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score_game)

        gameScoreHomeTeamName.text = intent.getStringExtra(TEAM_HOME_NAME)
        gameScoreAwayTeamName.text = intent.getStringExtra(TEAM_AWAY_NAME)

        gameScoreHomeIncrease.setOnClickListener { 
            homeTeamScore++
            updateScore()
        }
        
        gameScoreHomeDecrease.setOnClickListener { 
            if (homeTeamScore > 0) homeTeamScore--
            updateScore()
        }
        
        gameScoreAwayIncrease.setOnClickListener {  
            awayTeamScore++
            updateScore()
        }
        
        gameScoreAwayDecrease.setOnClickListener { 
            if (awayTeamScore > 0) awayTeamScore--
            updateScore()
        }

        gameScoreExitButton.setOnClickListener {
            finish()
        }

        // fauls

        gameFaulHomeIncrease.setOnClickListener {
            homeTeamFaul++
            updateFauls()
        }

        gameFaulHomeDecrease.setOnClickListener {
            if (homeTeamFaul > 0) homeTeamFaul--
            updateFauls()
        }

        gameFaulAwayIncrease.setOnClickListener {
            awayTeamFaul++
            updateFauls()
        }

        gameFaulAwayDecrease.setOnClickListener {
            if (awayTeamFaul > 0) awayTeamFaul--
            updateFauls()
        }
    }
    
    private fun updateScore() {
        gameScoreHomeTeamScore.text = String.format("%02d", homeTeamScore)
        gameScoreAwayTeamScore.text = String.format("%02d", awayTeamScore)
    }

    private fun updateFauls(){
        gameFaulHomeTeamFaul.text = String.format("%02d", homeTeamFaul)
        gameFaulAwayTeamFaul.text = String.format("%02d", awayTeamFaul)
    }

}