package com.example.stockMarket.di

import com.example.stockMarket.data.csv.CSVParser
import com.example.stockMarket.data.csv.CompanyListingsParser
import com.example.stockMarket.data.csv.IntradayInfoParser
import com.example.stockMarket.data.repository.StockRepositoryImpl
import com.example.stockMarket.domain.model.CompanyListing
import com.example.stockMarket.domain.model.IntraDayInfo
import com.example.stockMarket.domain.repository.StockRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCompanyListingParser(
        companyListingsParser: CompanyListingsParser
    ): CSVParser<CompanyListing>

    @Binds
    @Singleton
    abstract fun bindIntradayInfoParser(
        intradayInfoParser: IntradayInfoParser
    ): CSVParser<IntraDayInfo>


    @Binds
    @Singleton
    abstract fun bindStockRepository(
        stockRepositoryImpl: StockRepositoryImpl
    ): StockRepository
}