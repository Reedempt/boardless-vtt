package org.boardlessvtt.app

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

fun isDesktopPlatform(): Boolean = getPlatform().name.startsWith("Java")