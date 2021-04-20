package com.ghostapps.placapp.data.records.remote.useCases

import com.ghostapps.placapp.data.records.RecordEntity
import com.ghostapps.placapp.domain.models.RecordModel
import com.ghostapps.placapp.domain.useCases.GetAllRegister
import com.ghostapps.placapp.infra.http.HttpAdapter
import com.google.gson.*

class GetAllRemoteRegister(
    private val httpAdapter: HttpAdapter
): GetAllRegister {
    override fun execute(): Array<RecordModel> {
        val bodyResponse = httpAdapter.get("https://run.mocky.io/v3/c81080ae-0036-423b-8a7c-31bb3c2d3e92")
        val recordEntities = Gson().fromJson(bodyResponse, Array<RecordEntity>::class.java)

        return recordEntities.map { recordEntity -> recordEntity.toModel() }.toTypedArray()
    }
}