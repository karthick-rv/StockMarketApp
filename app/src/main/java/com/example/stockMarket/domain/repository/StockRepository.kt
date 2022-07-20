package com.example.stockMarket.domain.repository

import com.example.stockMarket.domain.model.CompanyInfo
import com.example.stockMarket.domain.model.CompanyListing
import com.example.stockMarket.domain.model.IntraDayInfo
import com.example.stockMarket.util.Resource
import kotlinx.coroutines.flow.Flow

interface StockRepository {

    suspend fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<CompanyListing>>>

    suspend fun getIntraDayInfo(
        symbol: String
    ): Resource<List<IntraDayInfo>>

    suspend fun getCompanyInfo(
        symbol: String
    ): Resource<CompanyInfo>
}