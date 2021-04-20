package com.ghostapps.placapp.domain.models

class RecordModel(
    val homeTeamName: String,
    val homeTeamScore: Int,
    val homeTeamFauls: Int,

    val awayTeamName: String,
    val awayTeamScore: Int,
    val awayTeamFauls: Int,
    val date: Long
)