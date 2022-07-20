package com.example.stockMarket.data.mapper

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.stockMarket.data.remote.dto.IntraDayInfoDto
import com.example.stockMarket.domain.model.IntraDayInfo
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
fun IntraDayInfoDto.toIntradayInfo(): IntraDayInfo {
    val pattern = "yyyy-MM-dd HH:mm:ss"
    val formatter = DateTimeFormatter.ofPattern(pattern, Locale.getDefault())
    val localDateTime = LocalDateTime.parse(timeStamp, formatter)
    return IntraDayInfo(
        date = localDateTime,
        close = close
    )
}