package com.example.weatherforcastapp

import java.time.LocalDateTime
import java.time.LocalTime

// 2. 날짜 정보 가져오기
data class BaseDateTime(
    val baseDate: String, val baseTime: String
) {
    companion object {
        fun getBaseDateTime(): BaseDateTime {
            var dateTime = LocalDateTime.now()

            val baseTime = when (dateTime.toLocalTime()) { // 시간대 별 가져오는 측정 시간 데이터 구분
                in LocalTime.of(0, 0)..LocalTime.of(2,30) -> {
                    dateTime = dateTime.minusDays(1) // 당일 오전 00시~02시 30분에 시간을 호출할 경우, 공공 db 기록 시간인 전날 23시 데이터를 기반으로 파악해야 하므로 하루 전을 호출하기 위해 1일을 뺌
                    "2300"
                }
                in LocalTime.of(2, 30)..LocalTime.of(5, 30) -> "0200"
                in LocalTime.of(5, 30)..LocalTime.of(8, 30) -> "0500"
                in LocalTime.of(8, 30)..LocalTime.of(11, 30) -> "0800"
                in LocalTime.of(11, 30)..LocalTime.of(14, 30) -> "1100"
                in LocalTime.of(14, 30)..LocalTime.of(17, 30) -> "1400"
                in LocalTime.of(17, 30)..LocalTime.of(20, 30) -> "1700"
                in LocalTime.of(20, 30)..LocalTime.of(23, 30) -> "2000"
                else -> "2300"
            }

            val baseDate = String.format("%04d%02d%02d", dateTime.year, dateTime.monthValue, dateTime.dayOfMonth)


            return BaseDateTime(baseDate, baseTime)
        }
    }
}