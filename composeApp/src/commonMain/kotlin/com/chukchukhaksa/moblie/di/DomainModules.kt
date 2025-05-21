package com.chukchukhaksa.moblie.di

import com.chukchukhaksa.moblie.domain.openmajor.usecase.GetOpenMajorListUseCase
import org.koin.dsl.module

val domainModule = module {
    /*TODO("GetOpenMajorListUseCase(인자 추가 되면 get() 함수 추가)")*/
    factory { GetOpenMajorListUseCase() }
}