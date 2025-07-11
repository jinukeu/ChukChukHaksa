package com.chukchukhaksa.mobile.data.openmajor.repository

import com.chukchukhaksa.mobile.common.model.OpenMajor
import com.chukchukhaksa.mobile.data.openmajor.datasource.LocalOpenMajorDataSource
import com.chukchukhaksa.mobile.data.openmajor.datasource.RemoteOpenMajorDataSource
import com.chukchukhaksa.mobile.domain.openmajor.repository.OpenMajorRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow

class OpenMajorRepositoryImpl(
    private val localOpenMajorDataSource: LocalOpenMajorDataSource,
    private val remoteOpenMajorDataSource: RemoteOpenMajorDataSource,
) : OpenMajorRepository {
    override suspend fun getOpenMajorList(): Flow<List<String>> = flow {
        emit(localOpenMajorDataSource.getLocalOpenMajorList().map { it.name })

        val localVersion = localOpenMajorDataSource.getLocalOpenMajorVersion().firstOrNull() ?: 0f
        val remoteVersion = remoteOpenMajorDataSource.getOpenMajorVersion()

        if (remoteVersion > localVersion) {
            val remoteOpenMajorList = remoteOpenMajorDataSource.getOpenMajorList()

            emit(remoteOpenMajorList)

            with(localOpenMajorDataSource) {
                deleteAllOpenMajors()
                saveAllOpenMajors(
                    remoteOpenMajorList.mapIndexed { index, major ->
                        OpenMajor(id = index, name = major)
                    },
                )
                setLocalOpenMajorVersion(remoteVersion)
            }
        }
    }
}
