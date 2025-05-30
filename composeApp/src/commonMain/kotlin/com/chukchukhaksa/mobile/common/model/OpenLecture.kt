package com.chukchukhaksa.mobile.common.model

import androidx.compose.runtime.Stable
import kotlinx.serialization.Serializable

@Stable
data class OpenLectureData(
  val isLast: Boolean,
  val content: List<OpenLecture>,
)

@Stable
@Serializable
data class OpenLecture(
  val id: Long = -1L,
  val name: String = "",
  val type: String = "",
  val major: String = "",
  val grade: Int = -1,
  val professorName: String = "",
  val originalCellList: List<Cell> = emptyList(),
)

@Stable
@Serializable
data class Cell(
  val location: String,
  val day: TimetableDay,
  val startPeriod: Int,
  val endPeriod: Int,
)
