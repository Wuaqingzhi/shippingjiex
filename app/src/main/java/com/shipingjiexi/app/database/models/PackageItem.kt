package com.shipingjiexi.app.database.models

import com.shipingjiexi.app.core.packages.PackageBase

data class PackageItem(
    val title: String,
    val plugin: PackageBase
) {
    fun getInstance(): PackageBase = plugin.getInstance()
}