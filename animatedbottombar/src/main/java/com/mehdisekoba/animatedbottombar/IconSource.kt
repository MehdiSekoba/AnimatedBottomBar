package com.mehdisekoba.animatedbottombar

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Represents the source of an icon for the bottom bar.
 */
@Immutable
public sealed interface IconSource {
    /** A standard Jetpack Compose Material Icon. */
    public data class Vector(val imageVector: ImageVector) : IconSource

    /** A traditional Android drawable resource ID (e.g., R.drawable.my_icon). */
    public data class DrawableResource(@DrawableRes val resId: Int) : IconSource
}