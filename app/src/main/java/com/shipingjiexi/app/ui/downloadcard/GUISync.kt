package com.shipingjiexi.app.ui.downloadcard

import com.shipingjiexi.app.database.models.ResultItem

interface GUISync {
    fun updateTitleAuthor(t: String, a: String)
    fun updateUI(res: ResultItem?)
}