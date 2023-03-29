package com.example.weatherforcastapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

// 1. 날씨 데이터 불러오기 - Retrofit을 위한 인터페이스 구현
interface WeatherService {
    @GET("1360000/VilageFcstInfoService_2.0/getVilageFcst?pageNo=1&numOfRows=400&dataType=JSON") // 접근 주소
    fun getVillageForecast(
        @Query("serviceKey") serviceKey: String, // 주소에 쿼리 추가 - 키
        @Query("base_date") baseDate: String, // 주소에 쿼리 추가 - 날짜
        @Query("base_time") baseTime: String, // 주소에 쿼리 추가 - 시간
        @Query("nx") nx: Int, // 주소에 쿼리 추가 - 좌표 x
        @Query("ny") ny: Int // 주소에 쿼리 추가 - 좌표 y
        ): Call<WeatherEntity>
}