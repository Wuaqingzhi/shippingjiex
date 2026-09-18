package com.shipingjiexi.app.database.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.preference.PreferenceManager
import com.shipingjiexi.app.R
import com.shipingjiexi.app.database.DBManager
import com.shipingjiexi.app.database.enums.DownloadType
import com.shipingjiexi.app.database.models.DownloadItem
import com.shipingjiexi.app.database.models.Format
import com.shipingjiexi.app.database.models.FormatRecyclerView
import com.shipingjiexi.app.database.models.ResultItem
import com.shipingjiexi.app.database.repository.DownloadRepository
import com.shipingjiexi.app.ui.downloadcard.FormatSelectionBottomSheetDialog.FormatCategory
import com.shipingjiexi.app.ui.downloadcard.FormatSelectionBottomSheetDialog.FormatSorting
import com.shipingjiexi.app.ui.downloadcard.FormatTuple
import com.shipingjiexi.app.ui.downloadcard.MultipleItemFormatTuple
import com.shipingjiexi.app.util.Extensions.isYoutubeURL
import com.shipingjiexi.app.util.FileUtil
import com.shipingjiexi.app.util.FormatUtil
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import java.io.File

class DownloadCardViewModel(application: Application) : AndroidViewModel(application) {
    var resultItem: ResultItem? = null
        private set

    var downloadItem: DownloadItem? = null
        private set

    fun setDownloadItem(item: DownloadItem?) {
        downloadItem = item
    }

    fun setResultItem(item: ResultItem?) {
        resultItem = item
    }
}