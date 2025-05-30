package com.chukchukhaksa.mobile.common.model

import androidx.compose.runtime.Stable
import kotlinx.serialization.Serializable

@Stable
@Serializable
data class Timetable(
  val createTime: Long = 0,
  val year: String = "",
  val semester: String = "",
  val name: String = "",
  val cellList: List<TimetableCell> = emptyList(),
)
