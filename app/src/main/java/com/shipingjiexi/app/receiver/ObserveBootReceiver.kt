package com.shipingjiexi.app.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.shipingjiexi.app.database.DBManager
import com.shipingjiexi.app.database.repository.ObserveSourcesRepository
import com.shipingjiexi.app.util.Extensions.hasReachedEnd
import com.shipingjiexi.app.util.ObserveAlarmScheduler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ObserveBootReceiver : BroadcastReceiver() {
    override fun onReceive(ctx: Context?, intent: Intent?) {
        val ctx = ctx ?: return
        val action = intent?.action
        if (action != Intent.ACTION_BOOT_COMPLETED &&
            action != Intent.ACTION_MY_PACKAGE_REPLACED) return

        val pending = goAsync()
        CoroutineScope(Dispatchers.IO).launch {
            runCatching {
                val db = DBManager.getInstance(ctx)
                val scheduler = ObserveAlarmScheduler(ctx)
                db.observeSourcesDao.getAllSources()
                    .filter { it.status == ObserveSourcesRepository.SourceStatus.ACTIVE && !it.hasReachedEnd() }
                    .forEach { scheduler.schedule(it) }
            }
            pending.finish()
        }
    }
}