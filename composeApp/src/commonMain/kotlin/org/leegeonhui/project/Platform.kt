package org.leegeonhui.project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform