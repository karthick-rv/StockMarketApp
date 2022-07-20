package com.example.stockMarket.presentation.company_info

import com.example.stockMarket.domain.model.CompanyInfo
import com.example.stockMarket.domain.model.IntraDayInfo

data class CompanyInfoState(
    val stockInfos: List<IntraDayInfo> = emptyList(),
    val company: CompanyInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)