package com.ghostapps.placapp.viewModel.gameRecords

import com.ghostapps.placapp.domain.models.RecordModel
import com.ghostapps.placapp.domain.useCases.InsertRegister
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.willReturn
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.*


class GameRecordsTest{
    private val dataTest = RecordModel(
        homeTeamName = "Vancouver",
        awayTeamName = "Torono",
        awayTeamFauls = 2,
        homeTeamFauls = 1,
        homeTeamScore = 20,
        awayTeamScore = 10,
        date = Date().time
    )

    private lateinit var recordTest: GameRecordsViewModel
}