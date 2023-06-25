package com.simplemobiletools.commons.models

/**
 * A packed Integer is used to store "enum-like" Integers where each bit in
 * the Integer corresponds to some arbitrary values.
 *
 * For example, we may define arbitrary values like:
 * const val TYPE_IMAGES = 1
 * const val TYPE_VIDEOS = 2
 * const val TYPE_GIFS = 4
 * const val TYPE_RAWS = 8
 * const val TYPE_SVGS = 16
 * const val TYPE_PORTRAITS = 32
 *
 * Each value corresponds to a single bit flipped in a 32 bit Integer.
 *
 * For example, a PackedInt may be created like so:
 * val packed = PackedInt(TYPE_IMAGES + TYPE_VIDEOS)
 *
 * We provide helpful methods for checking existence of these arbitrary values.
 *
 * E.g:
 * packed.has(TYPE_IMAGES)
 */
@JvmInline
value class PackedInt(val data: Int) {
    infix fun has(other: Int) = (data and other) != 0
    infix fun notHas(other: Int) = (data and other) == 0

    operator fun plus(other: Int) = PackedInt(data or other)
    operator fun plus(other: PackedInt) = PackedInt(data or other.data)
    operator fun compareTo(other: Int): Int = data.compareTo(other)
}

fun Int.toPackedInt() = PackedInt(this)
