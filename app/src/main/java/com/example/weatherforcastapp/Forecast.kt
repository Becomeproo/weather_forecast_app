package com.example.weatherforcastapp

// 1. 날씨 데이터 불러오기 - 반환 값을 간소화하고 좀 더 쉽게 볼 수 있도록 하기 위해 이를 구현한 새로운 데이터 클래스 생성
data class Forecast(
    val forecastDate: String,
    val forecastTime: String,

    var temperature: Double = 0.0,
    var sky: String = "",
    var precipitation: Int = 0,
    var precipitationType: String = ""
) {

    // 5. 시간대별 날씨 정보 출력 - 기존 날씨 상태 출력은 3가지이나 강수 상태의 정보가 비 또는 눈 또한 나타내므로 해당 정보를 같이 가져와 출력
    val weather: String
        get() {
            return if (precipitationType == "" || precipitationType == "없음") {
                sky
            } else {
                precipitationType
            }
        }
}