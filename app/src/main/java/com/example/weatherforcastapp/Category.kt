package com.example.weatherforcastapp

import com.google.gson.annotations.SerializedName

// 날씨 데이터 불러오기 - 기존 공공 데이터는 총 14개의 날씨 데이터 값을 아래와 같은 코드로 반환,
// 하지만 14개의 종류의 데이터 값이 모두 필요하지 않기 때문에 필요한 4개 타입의 값만을 받기 위한 enum class 생성
enum class Category {
    @SerializedName("POP")
    POP, // 강수확률
    @SerializedName("PTY")
    PTY, // 강수형태
    @SerializedName("SKY")
    SKY, // 하늘 상태
    @SerializedName("TMP")
    TMP // 1시간 기온
}