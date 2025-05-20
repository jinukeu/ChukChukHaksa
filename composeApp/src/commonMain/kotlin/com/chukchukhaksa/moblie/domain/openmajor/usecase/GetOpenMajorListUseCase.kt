package com.chukchukhaksa.moblie.domain.openmajor.usecase


import com.chukchukhaksa.moblie.domain.openmajor.repository.OpenMajorRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetOpenMajorListUseCase (private val openMajorRepository: OpenMajorRepository) {
    operator fun invoke(): Flow<List<String>> = flow {
        emit(listOf("전체", "컴퓨터SW"))
    }
}