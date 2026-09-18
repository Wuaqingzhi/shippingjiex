package com.shipingjiexi.app.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.shipingjiexi.app.database.enums.DownloadType

@Entity(tableName = "logs")
data class LogItem(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var title: String,
    var content: String,
    var format: Format,
    var downloadType: DownloadType,
    var downloadTime: Long,
)
