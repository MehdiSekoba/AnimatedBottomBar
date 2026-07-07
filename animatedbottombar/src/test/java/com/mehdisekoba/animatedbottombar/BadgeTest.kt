/*
 * Copyright 2026 Mehdi
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mehdisekoba.animatedbottombar

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class BadgeTest {

    @Test
    fun dot_isAlwaysVisible() {
        assertTrue(Badge.Dot.isVisible())
    }

    @Test
    fun count_isHidden_whenNonPositive() {
        assertFalse(Badge.Count(0).isVisible())
        assertFalse(Badge.Count(-3).isVisible())
    }

    @Test
    fun count_isVisible_whenPositive() {
        assertTrue(Badge.Count(1).isVisible())
    }

    @Test
    fun dot_hasNoDisplayText() {
        assertNull(Badge.Dot.displayText())
    }

    @Test
    fun count_showsValue_belowMax() {
        assertEquals("12", Badge.Count(value = 12).displayText())
    }

    @Test
    fun count_clampsToMaxPlus_aboveMax() {
        assertEquals("99+", Badge.Count(value = 100).displayText())
        assertEquals("9+", Badge.Count(value = 42, max = 9).displayText())
    }

    @Test
    fun accessibilitySuffix_describesBadge() {
        assertEquals("new notification", Badge.Dot.accessibilitySuffix())
        assertEquals("3 notifications", Badge.Count(3).accessibilitySuffix())
        assertEquals("more than 99 notifications", Badge.Count(500).accessibilitySuffix())
    }
}
