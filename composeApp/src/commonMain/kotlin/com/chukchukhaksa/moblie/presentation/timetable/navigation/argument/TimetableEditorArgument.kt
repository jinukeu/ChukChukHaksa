package com.chukchukhaksa.moblie.presentation.timetable.navigation.argument

import com.chukchukhaksa.moblie.common.model.Timetable
import kotlinx.serialization.Serializable

@Serializable
data class TimetableEditorArgument(
  val createTime: Long = 0L,
  val name: String = "",
  val year: String = "",
  val semester: String = "",
) {
  val isEditMode = createTime != 0L
}

internal fun Timetable.toTimetableEditorArgument() = TimetableEditorArgument(
  createTime = createTime,
  name = name,
  year = year,
  semester = semester,
)
