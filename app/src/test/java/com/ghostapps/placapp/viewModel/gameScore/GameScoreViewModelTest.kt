package com.ghostapps.placapp.viewModel.gameScore

import com.ghostapps.placapp.domain.useCases.InsertRegister
import com.nhaarman.mockito_kotlin.*
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GameScoreViewModelTest {

    private val gameScoreContractMock: GameScoreContract = mock {}
    private val insertRegisterMock: InsertRegister = mock {
        given { it.execute(any()) }.willReturn { true }
    }

    private lateinit var sut: GameScoreViewModel

    @Before
    fun setup() {
        sut = GameScoreViewModel(gameScoreContractMock, insertRegisterMock)
    }

    @Test
    fun `Should update team names correctly`() {
        val teamAName = "team_a"
        val teamBName = "team_b"

        sut.onCreate(teamAName, teamBName)

        assertEquals(sut.homeTeamName, teamAName)
        assertEquals(sut.awayTeamName, teamBName)
    }

    @Test
    fun `Should increase home team score when onHomeTeamIncrease is called`() {
        sut.onHomeTeamIncrease()
        assertEquals(sut.formattedHomeTeamScore, "01")

        sut.onHomeTeamIncrease()
        assertEquals(sut.formattedHomeTeamScore, "02")
    }

    @Test
    fun `Should increase home team score when onHomeTeamDecrese is called`() {
        sut.onHomeTeamIncrease()
        sut.onHomeTeamIncrease()

        sut.onHomeTeamDecrease()
        assertEquals(sut.formattedHomeTeamScore, "02")

        sut.onHomeTeamDecrease()
        assertEquals(sut.formattedHomeTeamScore, "01")
    }

    @Test
    fun `Should increase home team score when onAwayTeamIncrease is called`() {
        sut.onAwayTeamIncrease()
        assertEquals(sut.formattedAwayTeamScore, "01")

        sut.onAwayTeamIncrease()
        assertEquals(sut.formattedAwayTeamScore, "02")
    }

    @Test
    fun `Should increase home team score when onAwayTeamDecrese is called`() {
        sut.onAwayTeamDecrease()
        sut.onAwayTeamDecrease()

        sut.onAwayTeamDecrease()
        assertEquals(sut.formattedAwayTeamScore, "02")

        sut.onAwayTeamDecrease()
        assertEquals(sut.formattedAwayTeamScore, "01")
    }

    @Test
    fun `Should increase home team fauls when onHomeTeamFaulIncrease is called`() {
        sut.onFaulHomeTeamIncrease()
        assertEquals(sut.formattedHomeTeamFaul, "01")

        sut.onFaulHomeTeamIncrease()
        assertEquals(sut.formattedHomeTeamFaul, "02")
    }
    @Test
    fun `Should increase home team fauls when onHomeTeamFaulDecrese is called`() {
        sut.onFaulHomeTeamIncrease()
        sut.onFaulHomeTeamIncrease()
        sut.onFaulHomeTeamDecrease()
        assertEquals(sut.formattedHomeTeamFaul, "02")

        sut.onFaulHomeTeamDecrease()
        assertEquals(sut.formattedHomeTeamFaul, "01")
    }

    @Test
    fun `Should execute onExitPressed, insertRegister and exit`() {
        sut.onExitPressed()
        verify(insertRegisterMock, times(1)).execute(any())
        verify(gameScoreContractMock, times(1)).onExitPressed()
        verify(gameScoreContractMock, times(0)).onInsertRegisterFails()
    }

//    @Test
//    fun `Should call onInsertRegisterFails when insertRegister fails`() {
//        val insertRegisterFailsMock: InsertRegister = mock {
//            given { it.execute(any()) }.willReturn { true }
//        }
//
//        sut = GameScoreViewModel(gameScoreContractMock, insertRegisterFailsMock)
//
//        sut.onExitPressed()
//
//        verify(gameScoreContractMock, times(1)).onInsertRegisterFails()
//    }





}