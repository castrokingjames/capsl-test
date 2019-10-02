package cc.capsl.esports.ui.navigation

import android.content.Context
import android.content.Intent

object Activities {

    fun intentForGames(context: Context): Intent {
        return Intent("cc.capsl.esports.feature.games.open").setPackage(context.packageName)
    }

    fun intentForTournaments(context: Context, gameId: Int): Intent {
        return Intent("cc.capsl.esports.feature.tournaments.open")
                .setPackage(context.packageName)
                .putExtra(Extra.GAME_ID, gameId)
    }

    fun intentForInvites(context: Context, gameId: Int, stageId: Int): Intent {
        return Intent("cc.capsl.esports.feature.invites.open")
                .setPackage(context.packageName)
                .putExtra(Extra.GAME_ID, gameId)
                .putExtra(Extra.STAGE_ID, stageId)
    }
}