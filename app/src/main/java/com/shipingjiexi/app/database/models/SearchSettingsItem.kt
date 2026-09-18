package com.shipingjiexi.app.database.models

import androidx.preference.Preference
import com.shipingjiexi.app.ui.more.settings.SettingModule

data class SearchSettingsItem(
    val preference: Preference,
    val xmlId: Int,
    val module: SettingModule?,
    val groupTitle: String? = null,
    val isHeader: Boolean = false,
    var canRebind: Boolean = true
)