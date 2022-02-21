package com.example.presentation.ui.network

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ArticlePopularList(
    val copyright: String,
    val num_results: Int,
    @SerializedName("results")
    val networkResults: List<NetworkResult>,
    val status: String
) :Parcelable

@Parcelize
data class NetworkResult(
    @SerializedName("abstract")
    val abstactt: String,
    val adx_keywords: String,
    val asset_id: Long,
    val byline: String,
    val des_facet: List<String>,
    val eta_id: Int,
    val geo_facet: List<String>,
    val id: Long,
    val media: List<Media>,
    val nytdsection: String,
    val org_facet: List<String>,
    val per_facet: List<String>,
    val published_date: String,
    val section: String,
    val source: String,
    val subsection: String,
    val title: String,
    val type: String,
    val updated: String,
    val uri: String,
    val url: String
) :Parcelable

@Parcelize
data class Media(
    val approved_for_syndication: Int,
    val caption: String,
    val copyright: String,
    val subtype: String,
    val type: String
) :Parcelable