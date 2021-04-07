package io.geilehner.storyblok.model.content;

public enum FilterOperation {
    /**
     * Matches exactly one value
     */
    in,
    /**
     * Matches all without the given value
     */
    not_in,
    /**
     * Matches exactly one value with a wildcard search using * (Example: "john*")
     */
    like,
    /**
     * Matches all without the given value
     */
    not_like,
    /**
     * Matches any value of given array
     */
    in_array,
    /**
     * Must match all values of given array
     */
    all_in_array,
    /**
     * Greater than date (Format: YYYY-mm-dd HH:MM)
     */
    gt_date,
    /**
     * Less than date (Format:  YYYY-mm-dd HH:MM)
     */
    lt_date,
    /**
     * Greater than integer value
     */
    gt_int,
    /**
     * Less than integer value
     */
    lt_int,
    /**
     * Greater than float value
     */
    gt_float,
    /**
     * Less than float value
     */
    lt_float
}
