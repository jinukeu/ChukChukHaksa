package com.chukchukhaksa.moblie.di

import com.chukchukhaksa.moblie.domain.openmajor.usecase.GetOpenMajorListUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetOpenMajorListUseCase(get()) }
}