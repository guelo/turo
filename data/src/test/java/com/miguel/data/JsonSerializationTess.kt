package com.miguel.data

import com.miguel.data.network.YelpSearchResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import junit.framework.TestCase
import org.junit.Test

class JsonSerializationTess {

    @Test
    fun validateJson() {
        val moshi = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()

        val response = moshi.adapter(YelpSearchResponse::class.java).fromJson(SAMPLE_RESPONSE)!!

        TestCase.assertEquals("Square Pie Guys", response.businesses[4].name)
    }
}

const val SAMPLE_RESPONSE = """
{
  "businesses": [
    {
      "id": "PTFxtXS47ZVRCdZIrEWvGw",
      "alias": "golden-boy-pizza-san-francisco",
      "name": "Golden Boy Pizza",
      "image_url": "https://s3-media1.fl.yelpcdn.com/bphoto/F8OxoXdS51h2VfU9Je2cNQ/o.jpg",
      "is_closed": false,
      "url": "https://www.yelp.com/biz/golden-boy-pizza-san-francisco?adjust_creative=51SsU9NI_tuXrEuO3-2lqg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=51SsU9NI_tuXrEuO3-2lqg",
      "review_count": 3666,
      "categories": [
        {
          "alias": "pizza",
          "title": "Pizza"
        },
        {
          "alias": "italian",
          "title": "Italian"
        }
      ],
      "rating": 4.5,
      "coordinates": {
        "latitude": 37.7997956,
        "longitude": -122.4080729
      },
      "transactions": [
        "delivery"
      ],
      "price": "${'$'}",
      "location": {
        "address1": "542 Green St",
        "address2": "",
        "address3": "",
        "city": "San Francisco",
        "zip_code": "94133",
        "country": "US",
        "state": "CA",
        "display_address": [
          "542 Green St",
          "San Francisco, CA 94133"
        ]
      },
      "phone": "+14159829738",
      "display_phone": "(415) 982-9738",
      "distance": 1211.7494013395174
    },
    {
      "id": "I8T8aoAsFQYwQiRvLBayFA",
      "alias": "il-casaro-pizzeria-and-mozzarella-bar-north-beach-location-san-francisco",
      "name": "Il Casaro Pizzeria & Mozzarella Bar - North Beach Location",
      "image_url": "https://s3-media4.fl.yelpcdn.com/bphoto/ef3tF8ogJIycWxOd9cKCsw/o.jpg",
      "is_closed": false,
      "url": "https://www.yelp.com/biz/il-casaro-pizzeria-and-mozzarella-bar-north-beach-location-san-francisco?adjust_creative=51SsU9NI_tuXrEuO3-2lqg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=51SsU9NI_tuXrEuO3-2lqg",
      "review_count": 1229,
      "categories": [
        {
          "alias": "italian",
          "title": "Italian"
        },
        {
          "alias": "pizza",
          "title": "Pizza"
        }
      ],
      "rating": 4.5,
      "coordinates": {
        "latitude": 37.79852,
        "longitude": -122.40739
      },
      "transactions": [
        "restaurant_reservation",
        "delivery",
        "pickup"
      ],
      "price": "${'$'}${'$'}",
      "location": {
        "address1": "348 Columbus Ave",
        "address2": "",
        "address3": "",
        "city": "San Francisco",
        "zip_code": "94133",
        "country": "US",
        "state": "CA",
        "display_address": [
          "348 Columbus Ave",
          "San Francisco, CA 94133"
        ]
      },
      "phone": "+14156779455",
      "display_phone": "(415) 677-9455",
      "distance": 1052.7653682357202
    },
    {
      "id": "mSMZJj2pFvttWLpcDmgrEA",
      "alias": "tonys-pizza-napoletana-san-francisco",
      "name": "Tony's Pizza Napoletana",
      "image_url": "https://s3-media3.fl.yelpcdn.com/bphoto/rrBlePEDLrbD27VVE0Ze2A/o.jpg",
      "is_closed": false,
      "url": "https://www.yelp.com/biz/tonys-pizza-napoletana-san-francisco?adjust_creative=51SsU9NI_tuXrEuO3-2lqg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=51SsU9NI_tuXrEuO3-2lqg",
      "review_count": 5227,
      "categories": [
        {
          "alias": "pizza",
          "title": "Pizza"
        },
        {
          "alias": "italian",
          "title": "Italian"
        },
        {
          "alias": "cocktailbars",
          "title": "Cocktail Bars"
        }
      ],
      "rating": 4.0,
      "coordinates": {
        "latitude": 37.8003315377662,
        "longitude": -122.409053979377
      },
      "transactions": [
        "delivery"
      ],
      "price": "${'$'}${'$'}",
      "location": {
        "address1": "1570 Stockton St",
        "address2": "",
        "address3": "",
        "city": "San Francisco",
        "zip_code": "94133",
        "country": "US",
        "state": "CA",
        "display_address": [
          "1570 Stockton St",
          "San Francisco, CA 94133"
        ]
      },
      "phone": "+14158359888",
      "display_phone": "(415) 835-9888",
      "distance": 1302.4161115186528
    },
    {
      "id": "xak4bC7dZFM9vuEYIJPF0Q",
      "alias": "escape-from-new-york-pizza-san-francisco",
      "name": "Escape From New York Pizza",
      "image_url": "https://s3-media1.fl.yelpcdn.com/bphoto/zNXTIuTy5eRUvmhbndQKWQ/o.jpg",
      "is_closed": false,
      "url": "https://www.yelp.com/biz/escape-from-new-york-pizza-san-francisco?adjust_creative=51SsU9NI_tuXrEuO3-2lqg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=51SsU9NI_tuXrEuO3-2lqg",
      "review_count": 270,
      "categories": [
        {
          "alias": "pizza",
          "title": "Pizza"
        }
      ],
      "rating": 3.5,
      "coordinates": {
        "latitude": 37.79059,
        "longitude": -122.40306
      },
      "transactions": [
        "delivery",
        "pickup"
      ],
      "price": "${'$'}",
      "location": {
        "address1": "333 Bush St",
        "address2": "Ste 104",
        "address3": "",
        "city": "San Francisco",
        "zip_code": "94104",
        "country": "US",
        "state": "CA",
        "display_address": [
          "333 Bush St",
          "Ste 104",
          "San Francisco, CA 94104"
        ]
      },
      "phone": "+14154210700",
      "display_phone": "(415) 421-0700",
      "distance": 103.42595588900261
    },
    {
      "id": "iyo3pjuRb7mTpaDwXnAzuQ",
      "alias": "square-pie-guys-san-francisco",
      "name": "Square Pie Guys",
      "image_url": "https://s3-media4.fl.yelpcdn.com/bphoto/xg7CO5qJFUkJoUueAyu3Yg/o.jpg",
      "is_closed": false,
      "url": "https://www.yelp.com/biz/square-pie-guys-san-francisco?adjust_creative=51SsU9NI_tuXrEuO3-2lqg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=51SsU9NI_tuXrEuO3-2lqg",
      "review_count": 347,
      "categories": [
        {
          "alias": "pizza",
          "title": "Pizza"
        }
      ],
      "rating": 4.5,
      "coordinates": {
        "latitude": 37.779479,
        "longitude": -122.4103136
      },
      "transactions": [
        "delivery",
        "pickup"
      ],
      "price": "${'$'}${'$'}",
      "location": {
        "address1": "1077 Mission St",
        "address2": null,
        "address3": "",
        "city": "San Francisco",
        "zip_code": "94103",
        "country": "US",
        "state": "CA",
        "display_address": [
          "1077 Mission St",
          "San Francisco, CA 94103"
        ]
      },
      "phone": "+14158729290",
      "display_phone": "(415) 872-9290",
      "distance": 1343.285213405086
    },
    {
      "id": "ikkPHZqQQ2UU2hGFyBuffQ",
      "alias": "montesacro-pinseria-sf-san-francisco-2",
      "name": "Montesacro Pinseria SF",
      "image_url": "https://s3-media3.fl.yelpcdn.com/bphoto/VU6d7csGD1Blhb_fRC2ilA/o.jpg",
      "is_closed": false,
      "url": "https://www.yelp.com/biz/montesacro-pinseria-sf-san-francisco-2?adjust_creative=51SsU9NI_tuXrEuO3-2lqg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=51SsU9NI_tuXrEuO3-2lqg",
      "review_count": 726,
      "categories": [
        {
          "alias": "pizza",
          "title": "Pizza"
        }
      ],
      "rating": 4.5,
      "coordinates": {
        "latitude": 37.7815976,
        "longitude": -122.410121
      },
      "transactions": [
        "delivery",
        "pickup"
      ],
      "price": "${'$'}${'$'}",
      "location": {
        "address1": "510 Stevenson St",
        "address2": "",
        "address3": "",
        "city": "San Francisco",
        "zip_code": "94103",
        "country": "US",
        "state": "CA",
        "display_address": [
          "510 Stevenson St",
          "San Francisco, CA 94103"
        ]
      },
      "phone": "+14157953040",
      "display_phone": "(415) 795-3040",
      "distance": 1127.1131748067041
    },
    {
      "id": "MDTJK0mH5Xc14aCwNuMg7Q",
      "alias": "uncle-vitos-pizza-san-francisco",
      "name": "Uncle Vito's Pizza",
      "image_url": "https://s3-media1.fl.yelpcdn.com/bphoto/g70TXaubG_SXJGDWTzxKug/o.jpg",
      "is_closed": false,
      "url": "https://www.yelp.com/biz/uncle-vitos-pizza-san-francisco?adjust_creative=51SsU9NI_tuXrEuO3-2lqg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=51SsU9NI_tuXrEuO3-2lqg",
      "review_count": 1244,
      "categories": [
        {
          "alias": "pizza",
          "title": "Pizza"
        },
        {
          "alias": "italian",
          "title": "Italian"
        }
      ],
      "rating": 4.0,
      "coordinates": {
        "latitude": 37.7901919931173,
        "longitude": -122.408970594406
      },
      "transactions": [
        "delivery"
      ],
      "price": "${'$'}${'$'}",
      "location": {
        "address1": "700 Bush St",
        "address2": "",
        "address3": "",
        "city": "San Francisco",
        "zip_code": "94108",
        "country": "US",
        "state": "CA",
        "display_address": [
          "700 Bush St",
          "San Francisco, CA 94108"
        ]
      },
      "phone": "+14153915008",
      "display_phone": "(415) 391-5008",
      "distance": 552.003249748203
    },
    {
      "id": "H2IZSqvr71k9-tBn91mgrA",
      "alias": "del-popolo-san-francisco-3",
      "name": "Del Popolo",
      "image_url": "https://s3-media1.fl.yelpcdn.com/bphoto/PtpsPU-o2OVEbDjnDsV7yQ/o.jpg",
      "is_closed": false,
      "url": "https://www.yelp.com/biz/del-popolo-san-francisco-3?adjust_creative=51SsU9NI_tuXrEuO3-2lqg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=51SsU9NI_tuXrEuO3-2lqg",
      "review_count": 465,
      "categories": [
        {
          "alias": "pizza",
          "title": "Pizza"
        }
      ],
      "rating": 4.0,
      "coordinates": {
        "latitude": 37.789627,
        "longitude": -122.411374
      },
      "transactions": [
        "delivery",
        "pickup"
      ],
      "price": "${'$'}${'$'}",
      "location": {
        "address1": "855 Bush St",
        "address2": "",
        "address3": "",
        "city": "San Francisco",
        "zip_code": "94108",
        "country": "US",
        "state": "CA",
        "display_address": [
          "855 Bush St",
          "San Francisco, CA 94108"
        ]
      },
      "phone": "+14155897940",
      "display_phone": "(415) 589-7940",
      "distance": 783.8271148733786
    },
    {
      "id": "GjdLppkFQODOiV4DQZ5EyA",
      "alias": "victors-pizzeria-and-italian-restaurant-san-francisco",
      "name": "Victor's Pizza",
      "image_url": "https://s3-media4.fl.yelpcdn.com/bphoto/lAdI5WGgAyyw3oCapR6NDA/o.jpg",
      "is_closed": false,
      "url": "https://www.yelp.com/biz/victors-pizzeria-and-italian-restaurant-san-francisco?adjust_creative=51SsU9NI_tuXrEuO3-2lqg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=51SsU9NI_tuXrEuO3-2lqg",
      "review_count": 992,
      "categories": [
        {
          "alias": "pizza",
          "title": "Pizza"
        },
        {
          "alias": "italian",
          "title": "Italian"
        }
      ],
      "rating": 4.0,
      "coordinates": {
        "latitude": 37.78991,
        "longitude": -122.42073
      },
      "transactions": [
        "delivery",
        "pickup"
      ],
      "price": "${'$'}${'$'}",
      "location": {
        "address1": "1411 Polk St",
        "address2": "",
        "address3": "",
        "city": "San Francisco",
        "zip_code": "94109",
        "country": "US",
        "state": "CA",
        "display_address": [
          "1411 Polk St",
          "San Francisco, CA 94109"
        ]
      },
      "phone": "+14158851660",
      "display_phone": "(415) 885-1660",
      "distance": 1613.8709925978847
    },
    {
      "id": "A0A797fPf8D3MnfxbGTj7A",
      "alias": "pachino-pizzeria-san-francisco-3",
      "name": "Pachino Pizzeria",
      "image_url": "https://s3-media3.fl.yelpcdn.com/bphoto/lYyI2QGlOX1zIlKnfnTz_Q/o.jpg",
      "is_closed": false,
      "url": "https://www.yelp.com/biz/pachino-pizzeria-san-francisco-3?adjust_creative=51SsU9NI_tuXrEuO3-2lqg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=51SsU9NI_tuXrEuO3-2lqg",
      "review_count": 584,
      "categories": [
        {
          "alias": "pizza",
          "title": "Pizza"
        },
        {
          "alias": "italian",
          "title": "Italian"
        }
      ],
      "rating": 4.0,
      "coordinates": {
        "latitude": 37.7912633,
        "longitude": -122.4039616
      },
      "transactions": [
        "delivery",
        "pickup"
      ],
      "price": "${'$'}${'$'}",
      "location": {
        "address1": "318 Kearny St",
        "address2": "",
        "address3": "",
        "city": "San Francisco",
        "zip_code": "94104",
        "country": "US",
        "state": "CA",
        "display_address": [
          "318 Kearny St",
          "San Francisco, CA 94104"
        ]
      },
      "phone": "+14159564056",
      "display_phone": "(415) 956-4056",
      "distance": 205.97124740803403
    },
    {
      "id": "Xby671iywqIfGDlmg1HdYA",
      "alias": "gochees-pizza-san-francisco",
      "name": "Gochees Pizza",
      "image_url": "https://s3-media3.fl.yelpcdn.com/bphoto/yTcQFew4-3nAHDDFljkpRQ/o.jpg",
      "is_closed": false,
      "url": "https://www.yelp.com/biz/gochees-pizza-san-francisco?adjust_creative=51SsU9NI_tuXrEuO3-2lqg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=51SsU9NI_tuXrEuO3-2lqg",
      "review_count": 72,
      "categories": [
        {
          "alias": "pizza",
          "title": "Pizza"
        },
        {
          "alias": "salad",
          "title": "Salad"
        }
      ],
      "rating": 3.5,
      "coordinates": {
        "latitude": 37.795085,
        "longitude": -122.398944
      },
      "transactions": [
        "delivery",
        "pickup"
      ],
      "price": "${'$'}",
      "location": {
        "address1": "2 Embarcadero Ctr",
        "address2": "",
        "address3": "",
        "city": "San Francisco",
        "zip_code": "94111",
        "country": "US",
        "state": "CA",
        "display_address": [
          "2 Embarcadero Ctr",
          "San Francisco, CA 94111"
        ]
      },
      "phone": "+14158349600",
      "display_phone": "(415) 834-9600",
      "distance": 659.708366906725
    },
    {
      "id": "MWaeG9XhJdFzbcrSrpF6mQ",
      "alias": "tommaso-ristorante-italiano-san-francisco-2",
      "name": "Tommaso Ristorante Italiano",
      "image_url": "https://s3-media4.fl.yelpcdn.com/bphoto/Mc-sfdXRGg4qVEGpLrxE9w/o.jpg",
      "is_closed": false,
      "url": "https://www.yelp.com/biz/tommaso-ristorante-italiano-san-francisco-2?adjust_creative=51SsU9NI_tuXrEuO3-2lqg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=51SsU9NI_tuXrEuO3-2lqg",
      "review_count": 1617,
      "categories": [
        {
          "alias": "italian",
          "title": "Italian"
        },
        {
          "alias": "pizza",
          "title": "Pizza"
        },
        {
          "alias": "seafood",
          "title": "Seafood"
        }
      ],
      "rating": 4.5,
      "coordinates": {
        "latitude": 37.797778,
        "longitude": -122.405204
      },
      "transactions": [
        "delivery",
        "pickup"
      ],
      "price": "${'$'}${'$'}",
      "location": {
        "address1": "1042 Kearny St",
        "address2": "",
        "address3": "",
        "city": "San Francisco",
        "zip_code": "94133",
        "country": "US",
        "state": "CA",
        "display_address": [
          "1042 Kearny St",
          "San Francisco, CA 94133"
        ]
      },
      "phone": "+14153989696",
      "display_phone": "(415) 398-9696",
      "distance": 919.1253568485216
    },
    {
      "id": "HlyIiK-k7SkmbxhcbTUQhg",
      "alias": "jersey-san-francisco",
      "name": "Jersey",
      "image_url": "https://s3-media1.fl.yelpcdn.com/bphoto/YkD1sWGTQpRvERgQmGW3PQ/o.jpg",
      "is_closed": false,
      "url": "https://www.yelp.com/biz/jersey-san-francisco?adjust_creative=51SsU9NI_tuXrEuO3-2lqg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=51SsU9NI_tuXrEuO3-2lqg",
      "review_count": 445,
      "categories": [
        {
          "alias": "pizza",
          "title": "Pizza"
        },
        {
          "alias": "italian",
          "title": "Italian"
        },
        {
          "alias": "sandwiches",
          "title": "Sandwiches"
        }
      ],
      "rating": 4.0,
      "coordinates": {
        "latitude": 37.7875207205968,
        "longitude": -122.398987077177
      },
      "transactions": [
        "delivery",
        "pickup"
      ],
      "price": "${'$'}${'$'}",
      "location": {
        "address1": "145 2nd St",
        "address2": "",
        "address3": "",
        "city": "San Francisco",
        "zip_code": "94105",
        "country": "US",
        "state": "CA",
        "display_address": [
          "145 2nd St",
          "San Francisco, CA 94105"
        ]
      },
      "phone": "+14159121502",
      "display_phone": "(415) 912-1502",
      "distance": 399.5880810556005
    },
    {
      "id": "o43B4DnnQbvkdDK6AVafQg",
      "alias": "piccolo-forno-san-francisco",
      "name": "Piccolo Forno",
      "image_url": "https://s3-media3.fl.yelpcdn.com/bphoto/SgkcY-4OaGYiPlsHKABZ8Q/o.jpg",
      "is_closed": false,
      "url": "https://www.yelp.com/biz/piccolo-forno-san-francisco?adjust_creative=51SsU9NI_tuXrEuO3-2lqg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=51SsU9NI_tuXrEuO3-2lqg",
      "review_count": 632,
      "categories": [
        {
          "alias": "pizza",
          "title": "Pizza"
        },
        {
          "alias": "italian",
          "title": "Italian"
        }
      ],
      "rating": 4.5,
      "coordinates": {
        "latitude": 37.8013699308642,
        "longitude": -122.411981038749
      },
      "transactions": [
        "delivery",
        "pickup"
      ],
      "price": "${'$'}${'$'}",
      "location": {
        "address1": "725 Columbus Ave",
        "address2": "",
        "address3": "",
        "city": "San Francisco",
        "zip_code": "94133",
        "country": "US",
        "state": "CA",
        "display_address": [
          "725 Columbus Ave",
          "San Francisco, CA 94133"
        ]
      },
      "phone": "+14157570087",
      "display_phone": "(415) 757-0087",
      "distance": 1530.7565695682433
    },
    {
      "id": "8skVQNkVBv90iiPtFeSpzw",
      "alias": "zero-zero-san-francisco",
      "name": "Zero Zero",
      "image_url": "https://s3-media3.fl.yelpcdn.com/bphoto/zznz1mV-4wt_WYWkcnuqgg/o.jpg",
      "is_closed": false,
      "url": "https://www.yelp.com/biz/zero-zero-san-francisco?adjust_creative=51SsU9NI_tuXrEuO3-2lqg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=51SsU9NI_tuXrEuO3-2lqg",
      "review_count": 3302,
      "categories": [
        {
          "alias": "pizza",
          "title": "Pizza"
        },
        {
          "alias": "italian",
          "title": "Italian"
        },
        {
          "alias": "cocktailbars",
          "title": "Cocktail Bars"
        }
      ],
      "rating": 4.0,
      "coordinates": {
        "latitude": 37.78163,
        "longitude": -122.40204
      },
      "transactions": [
        "restaurant_reservation",
        "pickup"
      ],
      "price": "${'$'}${'$'}",
      "location": {
        "address1": "826 Folsom St",
        "address2": "",
        "address3": "",
        "city": "San Francisco",
        "zip_code": "94107",
        "country": "US",
        "state": "CA",
        "display_address": [
          "826 Folsom St",
          "San Francisco, CA 94107"
        ]
      },
      "phone": "+14153488800",
      "display_phone": "(415) 348-8800",
      "distance": 912.6993472154555
    },
    {
      "id": "huUzLVDESMfD-MV0w3BjpQ",
      "alias": "tonys-coal-fired-pizza-and-slice-house-san-francisco-4",
      "name": "Tony's Coal-Fired Pizza And Slice House",
      "image_url": "https://s3-media2.fl.yelpcdn.com/bphoto/BwgE56n7diA8bF6j9ojZgg/o.jpg",
      "is_closed": false,
      "url": "https://www.yelp.com/biz/tonys-coal-fired-pizza-and-slice-house-san-francisco-4?adjust_creative=51SsU9NI_tuXrEuO3-2lqg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=51SsU9NI_tuXrEuO3-2lqg",
      "review_count": 472,
      "categories": [
        {
          "alias": "pizza",
          "title": "Pizza"
        },
        {
          "alias": "sandwiches",
          "title": "Sandwiches"
        },
        {
          "alias": "italian",
          "title": "Italian"
        }
      ],
      "rating": 3.5,
      "coordinates": {
        "latitude": 37.80022796436069,
        "longitude": -122.40902691147747
      },
      "transactions": [
        "delivery"
      ],
      "price": "${'$'}",
      "location": {
        "address1": "1556 Stockton St",
        "address2": "",
        "address3": "",
        "city": "San Francisco",
        "zip_code": "94133",
        "country": "US",
        "state": "CA",
        "display_address": [
          "1556 Stockton St",
          "San Francisco, CA 94133"
        ]
      },
      "phone": "+14158359888",
      "display_phone": "(415) 835-9888",
      "distance": 1291.047661473176
    },
    {
      "id": "hhBWXLpqkFo3HOCBIrLP9A",
      "alias": "zpizza-san-francisco",
      "name": "zpizza",
      "image_url": "https://s3-media2.fl.yelpcdn.com/bphoto/QWczaEJaDasV84vgj6pk-g/o.jpg",
      "is_closed": false,
      "url": "https://www.yelp.com/biz/zpizza-san-francisco?adjust_creative=51SsU9NI_tuXrEuO3-2lqg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=51SsU9NI_tuXrEuO3-2lqg",
      "review_count": 403,
      "categories": [
        {
          "alias": "pizza",
          "title": "Pizza"
        }
      ],
      "rating": 4.0,
      "coordinates": {
        "latitude": 37.7829829325943,
        "longitude": -122.405959
      },
      "transactions": [
        "delivery",
        "pickup"
      ],
      "price": "${'$'}${'$'}",
      "location": {
        "address1": "883 Mission St",
        "address2": "",
        "address3": "",
        "city": "San Francisco",
        "zip_code": "94103",
        "country": "US",
        "state": "CA",
        "display_address": [
          "883 Mission St",
          "San Francisco, CA 94103"
        ]
      },
      "phone": "+14159955552",
      "display_phone": "(415) 995-5552",
      "distance": 822.4169039681766
    },
    {
      "id": "3a36_kQBI8dB32Dt2aEEHg",
      "alias": "gusto-pinsa-romana-san-francisco-4",
      "name": "Gusto Pinsa Romana",
      "image_url": "https://s3-media1.fl.yelpcdn.com/bphoto/Mz8_apcnqBm01hzlF4URag/o.jpg",
      "is_closed": false,
      "url": "https://www.yelp.com/biz/gusto-pinsa-romana-san-francisco-4?adjust_creative=51SsU9NI_tuXrEuO3-2lqg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=51SsU9NI_tuXrEuO3-2lqg",
      "review_count": 352,
      "categories": [
        {
          "alias": "pizza",
          "title": "Pizza"
        },
        {
          "alias": "italian",
          "title": "Italian"
        },
        {
          "alias": "salad",
          "title": "Salad"
        }
      ],
      "rating": 5.0,
      "coordinates": {
        "latitude": 37.7896740586658,
        "longitude": -122.413919270039
      },
      "transactions": [
        "delivery",
        "pickup"
      ],
      "price": "${'$'}${'$'}",
      "location": {
        "address1": "1000 Bush St",
        "address2": "",
        "address3": null,
        "city": "San Francisco",
        "zip_code": "94109",
        "country": "US",
        "state": "CA",
        "display_address": [
          "1000 Bush St",
          "San Francisco, CA 94109"
        ]
      },
      "phone": "+14156785339",
      "display_phone": "(415) 678-5339",
      "distance": 1007.2964166831161
    },
    {
      "id": "-qkskY4TMHrcWXCkfxiEWA",
      "alias": "pizza-squared-san-francisco",
      "name": "Pizza Squared",
      "image_url": "https://s3-media2.fl.yelpcdn.com/bphoto/pd23QFmh0yGQ6-tjx_mU8g/o.jpg",
      "is_closed": false,
      "url": "https://www.yelp.com/biz/pizza-squared-san-francisco?adjust_creative=51SsU9NI_tuXrEuO3-2lqg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=51SsU9NI_tuXrEuO3-2lqg",
      "review_count": 156,
      "categories": [
        {
          "alias": "pizza",
          "title": "Pizza"
        }
      ],
      "rating": 4.5,
      "coordinates": {
        "latitude": 37.771485,
        "longitude": -122.405001
      },
      "transactions": [
        "delivery"
      ],
      "price": "${'$'}",
      "location": {
        "address1": "885 Brannan St",
        "address2": "",
        "address3": null,
        "city": "San Francisco",
        "zip_code": "94103",
        "country": "US",
        "state": "CA",
        "display_address": [
          "885 Brannan St",
          "San Francisco, CA 94103"
        ]
      },
      "phone": "+14155253861",
      "display_phone": "(415) 525-3861",
      "distance": 2053.416565249415
    },
    {
      "id": "FrSm4BNOZwRHVeY_oKnNiw",
      "alias": "slices-san-francisco",
      "name": "Slices",
      "image_url": "https://s3-media1.fl.yelpcdn.com/bphoto/C7H6sLIsqf27qNZWHSbUiA/o.jpg",
      "is_closed": false,
      "url": "https://www.yelp.com/biz/slices-san-francisco?adjust_creative=51SsU9NI_tuXrEuO3-2lqg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=51SsU9NI_tuXrEuO3-2lqg",
      "review_count": 86,
      "categories": [
        {
          "alias": "pizza",
          "title": "Pizza"
        },
        {
          "alias": "chicken_wings",
          "title": "Chicken Wings"
        },
        {
          "alias": "salad",
          "title": "Salad"
        }
      ],
      "rating": 4.5,
      "coordinates": {
        "latitude": 37.77669056008666,
        "longitude": -122.39577745889335
      },
      "transactions": [
        "delivery",
        "pickup"
      ],
      "price": "${'$'}",
      "location": {
        "address1": "330 Townsend St",
        "address2": "Ste 101",
        "address3": "",
        "city": "San Francisco",
        "zip_code": "94107",
        "country": "US",
        "state": "CA",
        "display_address": [
          "330 Townsend St",
          "Ste 101",
          "San Francisco, CA 94107"
        ]
      },
      "phone": "+14158729424",
      "display_phone": "(415) 872-9424",
      "distance": 1575.842312133899
    }
  ],
  "total": 1200,
  "region": {
    "center": {
      "longitude": -122.40245819091797,
      "latitude": 37.789842153990776
    }
  }
}
"""