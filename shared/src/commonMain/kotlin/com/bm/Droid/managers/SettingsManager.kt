package com.bm.Droid.managers

import com.russhwolf.settings.Settings

class SettingsManager(
    private val settings: Settings,
) {
    private companion object {
        private const val IS_SOUND_MUTED_KEY = "is_sound_muted"
    }

    var isSoundEnabled: Boolean
        get() {
            return settings.getBooleanOrNull(IS_SOUND_MUTED_KEY) ?: false
        }
        set(value) {
            settings.putBoolean(IS_SOUND_MUTED_KEY, value)
        }
}