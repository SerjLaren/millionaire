package com.bm.Droid

import org.koin.core.module.Module
import org.koin.dsl.module

val coreModule : Module get() = module {
    includes(commonModule + platformModule)
}

private val commonModule = module {
    single { SettingsManager(get()) }
}

expect val platformModule: Module
