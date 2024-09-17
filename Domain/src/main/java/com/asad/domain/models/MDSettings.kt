package com.asad.domain.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MDSettings {

    @SerializedName("message")
    @Expose
    var message: String? = null

    @SerializedName("data")
    @Expose
    var data: SettingsData? = null

    @SerializedName("status")
    @Expose
    var status: Boolean? = null

    class SettingsData {

        @SerializedName("mapKey")
        @Expose
        var mapKey: String? = null

        @SerializedName("chatAdminId")
        @Expose
        var chatAdminId: String? = null

        @SerializedName("followersRange")
        @Expose
        var followersRange: List<FollowersRange>? = null

        @SerializedName("ageRange")
        @Expose
        var ageRange: List<Int>? = null

        @SerializedName("radiusRange")
        @Expose
        var radiusRange: List<Int>? = null
    }

    class FollowersRange {

        @SerializedName("description")
        @Expose
        var description: String? = null

        @SerializedName("range")
        @Expose
        var range: Long? = null
    }
}
