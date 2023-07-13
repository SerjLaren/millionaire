package com.bm.Droid

import android.content.Context
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module = module {
    single { DbDriverFactory(get()) }
    single { MultipleClicksCutter() }
    single<Settings> { SharedPreferencesSettings(get<Context>().getSharedPreferences("settings", Context.MODE_PRIVATE)) }
}