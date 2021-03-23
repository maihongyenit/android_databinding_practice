package com.example.android_databinding_practice.domain.product

import com.example.android_databinding_practice.R
import com.example.android_databinding_practice.data.Product
import java.math.BigDecimal

class ProductRepoImpl : ProductRepo {
    override val products: List<Product> = initProducts()

    override fun getProduct(serial: Int): Product? {
        return products.find { it.serial == serial }
    }

    private fun initProducts(): List<Product> {
        val RED_LAMP = Product(
            "Red Lamp",
            "Red colored lamp, perfect for lighting up a room and matching any red furniture.",
            R.drawable.red_lamp,
            BigDecimal(10.99),
            BigDecimal(9.50),
            161,
            BigDecimal(4.5),
            1515611
        )

        val YELLOW_LAMP = Product(
            "Yellow Lamp",
            "Yellow colored lamp, perfect for lighting up a room " +
                    "and matching any Yellow furniture.",
            R.drawable.yellow_lamp,
            BigDecimal(11.99),
            BigDecimal(0),
            6,
            BigDecimal(5),
            7725277
        )

        val BLUE_MUG = Product(
            "Blue Coffee Mug", "Blue Coffee Mug for drinking coffee. 100% ceramic.",
            R.drawable.blue_mug, BigDecimal(5.99), BigDecimal(0), 66, BigDecimal(3.5), 2141515
        )

        val WHITE_MUG = Product(
            "White Coffee Mug", "White Coffee Mug for drinking coffee. 100% ceramic.",
            R.drawable.white_mug, BigDecimal(6.99), BigDecimal(0), 7, BigDecimal(4), 9704833
        )

        val RED_MUG = Product(
            "Red Coffee Mug Red", "Red Coffee Mug for drinking coffee. 100% ceramic.",
            R.drawable.red_mug, BigDecimal(8.99), BigDecimal(0), 157, BigDecimal(4.5), 9377376
        )

        val BLACK_HAT = Product(
            "Black Baseball Hat", "Black Baseball Hat made of 100% authentic " +
                    "baseball hat material.",
            R.drawable.black_hat, BigDecimal(20.99), BigDecimal(0), 121, BigDecimal(3.5), 6626622
        )

        val BLUE_HAT = Product(
            "Blue Baseball Hat", "Blue Baseball Hat made of 100% authentic " +
                    "baseball hat material.",
            R.drawable.blue_hat, BigDecimal(22.99), BigDecimal(0), 67, BigDecimal(4.5), 7837367
        )

        val WHITE_HAT = Product(
            "White Baseball Hat", "White Baseball Hat made of 100% authentic " +
                    "baseball hat material.",
            R.drawable.white_hat, BigDecimal(18.99), BigDecimal(15.99), 88, BigDecimal(2.5), 7695085
        )

        val ORANGE_HAT = Product(
            "Orange Baseball Hat", "Orange Baseball Hat made of 100% authentic " +
                    "baseball hat material.",
            R.drawable.orange_hat, BigDecimal(23.99), BigDecimal(0), 23, BigDecimal(4), 9084728
        )

        val WHITE_SHIRT_FEMALE = Product(
            "White Shirt",
            "White T-Shirt made of 100% cotton. Made for " +
                    "females.",
            R.drawable.white_shirt_female,
            BigDecimal(25.99),
            BigDecimal(0),
            98,
            BigDecimal(5),
            7265405
        )

        val WHITE_SHIRT_MALE = Product(
            "White Shirt",
            "White T-Shirt made of 100% cotton. Made for " +
                    "males.",
            R.drawable.white_shirt_male,
            BigDecimal(26.99),
            BigDecimal(0),
            11,
            BigDecimal(3),
            9575721
        )

        val BLACK_SHIRT_FEMALE = Product(
            "Black Shirt",
            "Black T-Shirt made of 100% cotton. Made for " +
                    "females.",
            R.drawable.black_shirt_female,
            BigDecimal(25.99),
            BigDecimal(0),
            51,
            BigDecimal(4.5),
            5776336
        )

        val BLACK_SHIRT_MALE = Product(
            "Black Shirt",
            "Black T-Shirt made of 100% cotton. Made for " +
                    "males.",
            R.drawable.black_shirt_male,
            BigDecimal(26.99),
            BigDecimal(0),
            616,
            BigDecimal(5),
            1408483
        )

        val GREY_FIDGET_SPINNER = Product(
            "Grey Fidget Spinner",
            "Grey Fidget Spinner. High quality" +
                    " bearing for long spin time. Light and portable.",
            R.drawable.fidget_spinner_grey,
            BigDecimal(100),
            BigDecimal(59.99),
            37,
            BigDecimal(4.5),
            8830303
        )

        val GREEN_FIDGET_SPINNER = Product(
            "Green Fidget Spinner",
            "Green Fidget Spinner. High quality" +
                    " bearing for long spin time. Light and portable.",
            R.drawable.fidget_spinner_green,
            BigDecimal(100),
            BigDecimal(0),
            3,
            BigDecimal(4),
            9082727
        )

        val ICELAND_PICTURE = Product(
            "Picture of Water in Iceland",
            "Beautiful picture of Iceland and its " +
                    "cold waters.",
            R.drawable.foggy_iceland,
            BigDecimal(189.50),
            BigDecimal(100),
            43,
            BigDecimal(4.8),
            6638393
        )

        val FRANCE_MOUNTAINS_PICTURE = Product(
            "Picture of the Mountains in France",
            "Here is an incredible picture" +
                    " of the mountains in France.",
            R.drawable.france_mtn,
            BigDecimal(356),
            BigDecimal(315),
            22,
            BigDecimal(3.2),
            8093475
        )

        val GREEN_HILLS_PICTURE = Product(
            "Picture of green hills in GreenLand", "A calming image of a sunset in " +
                    "Greenland.", R.drawable.green_hills, BigDecimal(99), BigDecimal(50), 79,
            BigDecimal(4.1), 1485032
        )

        val HAVASU_FALLS_PICTURE = Product(
            "A Very Famous Picture of Havasu Falls", "Check out this famous picture " +
                    "of Havasu Falls.", R.drawable.havasu_falls, BigDecimal(76), BigDecimal(0), 81,
            BigDecimal(4.9), 8041414
        )

        val ICEY_COAST_PICTURE = Product(
            "An Image of the Icy Coast of Iceland",
            "Looking at this picture practically " +
                    "makes you shiver! But it makes me appreciate warm weather.",
            R.drawable.icedfglrjioz,
            BigDecimal(120),
            BigDecimal(0),
            37,
            BigDecimal(3.3),
            1145614
        )
        return listOf(
            RED_LAMP,
            YELLOW_LAMP,
            BLUE_MUG,
            WHITE_MUG,
            RED_MUG,
            BLACK_HAT,
            BLUE_HAT,
            WHITE_HAT,
            ORANGE_HAT,
            WHITE_SHIRT_FEMALE,
            WHITE_SHIRT_MALE,
            BLACK_SHIRT_FEMALE,
            BLACK_SHIRT_MALE,
            GREY_FIDGET_SPINNER,
            GREEN_FIDGET_SPINNER,
            ICELAND_PICTURE,
            FRANCE_MOUNTAINS_PICTURE,
            GREEN_HILLS_PICTURE,
            HAVASU_FALLS_PICTURE,
            ICEY_COAST_PICTURE
        )
    }
}