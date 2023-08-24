package com.dg.lesson3.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val name: String,
    val surname: String,
    val height: String,
    val weight: String,
    val birthday: String,
    val game: GameStatus
) : Parcelable {

    enum class GameStatus {
        LOL,
        APEX
    }

}
