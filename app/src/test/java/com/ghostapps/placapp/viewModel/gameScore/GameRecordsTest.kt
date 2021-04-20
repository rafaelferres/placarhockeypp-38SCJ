package com.ghostapps.placapp.viewModel.gameRecords

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.ghostapps.placapp.domain.models.RecordModel
import com.ghostapps.placapp.domain.useCases.DeleteRegister
import com.ghostapps.placapp.domain.useCases.GetAllRegister
import com.ghostapps.placapp.domain.useCases.InsertRegister
import com.ghostapps.placapp.viewModel.gameRecords.GameRecordsViewModel
import com.ghostapps.placapp.viewModel.gameScore.GameScoreViewModel
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.willReturn
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.*


class GameRecordsTest{
    private val gameScoreContractMock: GameRecordsViewModel = mock {}
    private val insertRegisterMock: InsertRegister = mock {
        given { it.execute(any()) }.willReturn { true }
    }

    private lateinit var sut: GameRecordsViewModel

    @Before
    fun setup() {
        sut = GameRecordsViewModel(gameScoreContractMock, insertRegisterMock)
    }

    @Test
    fun `Should update team names correctly`() {
        val teamAName = "team_a"
        val teamBName = "team_b"

        sut.onCreate(teamAName, teamBName)

        Assert.assertEquals(sut.homeTeamName, teamAName)
        Assert.assertEquals(sut.awayTeamName, teamBName)
    }
}