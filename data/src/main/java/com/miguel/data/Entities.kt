package com.miguel.data

import okhttp3.HttpUrl


data class Business(
    /**
     * Phone number of the business formatted nicely to be displayed to users.
     * The format is the standard phone number format for the business's country.
     */
    val phone: String?,
    /**
     * Distance in meters from the search location. This returns meters regardless of the locale.
     */
    val distance: Float,
    /**
     * Unique Yelp ID of this business. Example: '4kMBvIEWPxWkWKFN__8SxQ'
     */
    val id: String,
    /**
     * URL of photo for this business.
     */
    val imageUrl: HttpUrl,
    /**
     * Location of this business, including address, city, state, zip code and country.
     */
    val address: String,
    /**
     * Name of this business.
     */
    val name: String,
    /**
     * Price level of the business. Value is one of $, $$, $$$ and $$$$.
     */
    val price: String?,
    /**
     * Rating for this business (value ranges from 1, 1.5, ... 4.5, 5).
     */
    val rating: Float,
    /**
     * Number of reviews for this business.
     */
    val numberReviews: Int,
)