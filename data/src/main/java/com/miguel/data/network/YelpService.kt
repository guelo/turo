package com.miguel.data.network

import retrofit2.Response
import retrofit2.http.GET

const val TURO_ADDRESS = "111 Sutter St, San Francisco, CA"

internal interface YelpService {
    @GET("businesses/search?location=$TURO_ADDRESS&term=pizza")
    suspend fun nearbyPizza(): Response<YelpSearchResponse>

    @GET("businesses/search?location=$TURO_ADDRESS&term=beer")
    suspend fun nearbyBeer(): Response<YelpSearchResponse>
}

internal data class YelpSearchResponse(
    /**
     * List of business Yelp finds based on the search criteria.
     */
    val businesses: List<Business>,
    /**
     * Total number of business Yelp finds based on the search criteria. Sometimes, the value may
     * exceed 1000. In such case, you still can only get up to 1000 businesses using multiple
     * queries and combinations of the "limit" and "offset" parameters.
     */
    val total: Int,
) {

    internal data class Business(
        /**
         * List of category title and alias pairs associated with this business.
         */
        val categories: List<Category>,
        /**
         * Coordinates of this business.
         */
        val coordinates: Coordinate,
        /**
         * Phone number of the business formatted nicely to be displayed to users.
         * The format is the standard phone number format for the business's country.
         */
        val display_phone: String?,
        /**
         * Distance in meters from the search location. This returns meters regardless of the locale.
         */
        val distance: Float,
        /**
         * Unique Yelp ID of this business. Example: '4kMBvIEWPxWkWKFN__8SxQ'
         */
        val id: String,
        /**
         * Unique Yelp alias of this business. Can contain unicode characters.
         * Example: 'yelp-san-francisco'. Also see What's the difference between the Yelp business ID
         * and business alias?
         */
        val alias: String,
        /**
         * URL of photo for this business.
         */
        val image_url: String,
        /**
         * Whether business has been (permanently) closed
         */
        val is_closed: Boolean,
        /**
         * Location of this business, including address, city, state, zip code and country.
         */
        val location: Location,
        /**
         * Name of this business.
         */
        val name: String,
        /**
         * Phone number of the business.
         */
        val phone: String,
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
        val review_count: Int,
        /**
         * URL for business page on Yelp.
         */
        val url: String,
        /**
         * List of Yelp transactions that the business is registered for.
         * Current supported values are pickup, delivery and restaurant_reservation.
         */
        val transactions: List<String>,
    ) {
        data class Category(
            /**
             * Unique Yelp alias of this business. Can contain unicode characters.
             * Example: 'yelp-san-francisco'. Also see What's the difference between the Yelp business ID and business alias?
             */
            val alias: String,
            /**
             * Title of a category for display purpose.
             */
            val title: String,
        )

        data class Coordinate(
            /**
             * Latitude of this business.
             */
            val latitude: Float,
            /**
             * Longitude of this business.
             */
            val longitude: Float,
        )

        data class Location(
            /**
             * Street address of this business.
             */
            val address1: String,
            /**
             * Street address of this business, continued.
             */
            val address2: String?,
            /**
             * Street address of this business, continued.
             */
            val address3: String?,
            /**
             * City of this business.
             */
            val city: String,
            /**
             * ISO 3166-1 alpha-2 country code of this business.
             */
            val country: String,
            /**
             * 	Array of strings that if organized vertically give an address that is in the standard address format for the business's country.
             */
            val display_address: List<String>,
            /**
             * ISO 3166-2 (with a few exceptions) state code of this business.
             */
            val state: String,
            /**
             * Zip code of this business.
             */
            val zip_code: String,
        )
    }
}