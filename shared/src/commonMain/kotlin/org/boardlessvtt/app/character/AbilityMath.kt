package org.boardlessvtt.app.character

fun abilityModifier(score: Int): Int = (score - 10) / 2

fun proficiencyBonus(level: Int): Int = 2 + (level - 1) / 4