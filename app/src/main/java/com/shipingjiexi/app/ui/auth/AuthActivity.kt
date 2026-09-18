package com.shipingjiexi.app.ui.auth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.platform.ComposeView

/**
 * 登录 / 注册 / 找回密码页：账号数据存云端（CloudBase），登录成功返回主界面。
 */
class AuthActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(
            ComposeView(this).apply {
                setContent {
                    AuthScreen(onLoggedIn = { finish() })
                }
            }
        )
    }
}
