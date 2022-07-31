package com.sun.training.ut.exercise_ten.domain.business

/**
 * Define some business models for the discount method
 * Depends MemberClassType
 * When need change. Just change business only
 */
internal object DiscountBusiness {

    const val UNKNOWN_CLASS_DISCOUNT_PERCENT = 0.0

    /**
     * Define percent discount with:
     * Member Class Type: BLACK
     * Minimum payment: 10,000 円
     */
    const val BLACK_CLASS_MIN_10K_DISCOUNT_PERCENT = 15.0 / 100.0

    /**
     * Define percent discount with:
     * Member Class Type: BLACK
     * Minimum payment: 5,000 円
     */
    const val BLACK_CLASS_MIN_5K_DISCOUNT_PERCENT = 7.0 / 100.0

    /**
     * Define percent discount with:
     * Member Class Type: BLACK
     * Minimum payment: 3,000 円
     */
    const val BLACK_CLASS_MIN_3K_DISCOUNT_PERCENT = 5.0 / 100.0

    /**
     * Define percent discount with:
     * Member Class Type: GOLD
     * Minimum payment: 10,000 円
     */
    const val GOLD_CLASS_MIN_10K_DISCOUNT_PERCENT = 10.0 / 100.0

    /**
     * Define percent discount with:
     * Member Class Type: GOLD
     * Minimum payment: 5,000 円
     */
    const val GOLD_CLASS_MIN_5K_DISCOUNT_PERCENT = 5.0 / 100.0

    /**
     * Define percent discount with:
     * Member Class Type: GOLD
     * Minimum payment: 3,000 円
     */
    const val GOLD_CLASS_MIN_3K_DISCOUNT_PERCENT = 3.0 / 100.0

    /**
     * Define percent discount with:
     * Member Class Type: SILVER
     * Minimum payment: 10,000 円
     */
    const val SILVER_CLASS_MIN_10K_DISCOUNT_PERCENT = 4.0 / 100.0

    /**
     * Define percent discount with:
     * Member Class Type: SILVER
     * Minimum payment: 5,000 円
     */
    const val SILVER_CLASS_MIN_5K_DISCOUNT_PERCENT = 2.0 / 100.0

    /**
     * Define percent discount with:
     * Member Class Type: SILVER
     * Minimum payment: 3,000 円
     */
    const val SILVER_CLASS_MIN_3K_DISCOUNT_PERCENT = 1.0 / 100.0
}