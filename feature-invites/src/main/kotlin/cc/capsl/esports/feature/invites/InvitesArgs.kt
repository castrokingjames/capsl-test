package cc.capsl.esports.feature.invites

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class InvitesArgs(val gameId: Int, val stageId: Int) : Parcelable