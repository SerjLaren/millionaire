package com.bm.Droid

import com.bm.Droid.managers.SettingsManager
import com.bm.Droid.repositories.QuestionsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

const val ioDispatcher = "ioDispatcher"
const val mainDispatcher = "mainDispatcher"
const val defaultDispatcher = "defaultDispatcher"

val coreModule : Module get() = module {
    includes(commonModule + platformModule)
}

private val commonModule = module {
    single(named(ioDispatcher)) { Dispatchers.IO }
    single(named(mainDispatcher)) { Dispatchers.Main }
    single(named(defaultDispatcher)) { Dispatchers.Default }

    single { Database(get<DbDriverFactory>().createDriver()) }
    single { QuestionsRepository(get(), get(named(defaultDispatcher))) }
    single { SettingsManager(get()) }
}

expect val platformModule: Module
