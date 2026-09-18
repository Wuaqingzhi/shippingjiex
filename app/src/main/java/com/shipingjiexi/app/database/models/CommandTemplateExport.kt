package com.shipingjiexi.app.database.models

import kotlinx.serialization.Serializable

@Serializable
data class CommandTemplateExport(
    val templates: List<CommandTemplate>,
    val shortcuts: List<TemplateShortcut>
)
