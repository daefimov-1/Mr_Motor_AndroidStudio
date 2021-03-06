package com.example.mr_motor_.data.models

import com.google.gson.annotations.SerializedName

data class LoginRequest (
    @SerializedName("username")
    var email: String,

    @SerializedName("password")
    var password: String
)