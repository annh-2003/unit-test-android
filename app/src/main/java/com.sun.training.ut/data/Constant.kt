package com.sun.training.ut.data

object Constant {

    //Exercise 1:
    const val REGULAR_PRICE = 490
    const val VOUCHER_PRICE = 100
    const val TIME_PRICE = 290

    const val BASE_BADMINTON_FEE: Int = 1800
    const val BADMINTON_FEE_1200: Int = 1200
    const val BADMINTON_FEE_1400: Int = 1400
    const val BADMINTON_FEE_1600: Int = 1600
    const val BADMINTON_MIN_AGE: Int = 0
    const val BADMINTON_MAX_AGE: Int = 120

    enum class Gender(val type: Int) {
        MALE(1),
        FEMALE(2)
    }

    /**
     * Because min api 19
     */
    enum class DayOfWeek {
        /**
         * The singleton instance for the day-of-week of Monday.
         * This has the numeric value of `1`.
         */
        MONDAY,

        /**
         * The singleton instance for the day-of-week of Tuesday.
         * This has the numeric value of `2`.
         */
        TUESDAY,

        /**
         * The singleton instance for the day-of-week of Wednesday.
         * This has the numeric value of `3`.
         */
        WEDNESDAY,

        /**
         * The singleton instance for the day-of-week of Thursday.
         * This has the numeric value of `4`.
         */
        THURSDAY,

        /**
         * The singleton instance for the day-of-week of Friday.
         * This has the numeric value of `5`.
         */
        FRIDAY,

        /**
         * The singleton instance for the day-of-week of Saturday.
         * This has the numeric value of `6`.
         */
        SATURDAY,

        /**
         * The singleton instance for the day-of-week of Sunday.
         * This has the numeric value of `7`.
         */
        SUNDAY;
    }

    //Exercise 5
    const val DEFAULT_PRICE = 1500

    enum class TypeDelivery {
        DELIVERY,
        RECEIVE_AT_STORE
    }

    enum class Coupon(val coupon: String) {
        POTATO_PROMOTION("Potato promotion\n"),
        OFF_20("Sale off bill with 20%\n"),
        PIZZA_SECOND_FREE("Free pizza second\n"),
        REGULAR_FEE("Regular fee\n")
    }

    //Exercise 3:
    const val DEFAULT_ITEM_HAVE_DISCOUNT = 7
    const val DISCOUNT_7 = 7
    const val DISCOUNT_5 = 5
    const val DISCOUNT_12 = 12

    //Exercise 2:
    const val TIME_8_45 = 526
    const val TIME_17_59 = 1079
    const val FEE_110 = 110

    //Exercise 4:
    enum class Color {
        RED,
        BLUE,
        BLACK
    }
}