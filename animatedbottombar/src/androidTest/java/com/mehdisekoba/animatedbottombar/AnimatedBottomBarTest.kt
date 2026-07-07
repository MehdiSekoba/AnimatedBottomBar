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

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class AnimatedBottomBarTest {

    @get:Rule
    val rule = createComposeRule()

    private val items = listOf(
        BottomBarItem(icon = Icons.Filled.Home, label = "Home"),
        BottomBarItem(icon = Icons.Filled.Home, label = "Search"),
        BottomBarItem(icon = Icons.Filled.Home, label = "Profile", enabled = false),
    )

    @Test
    fun tappingItem_invokesCallback_withIndex() {
        var selected by mutableIntStateOf(0)
        rule.setContent {
            AnimatedBottomBar(
                items = items,
                selectedIndex = selected,
                onItemSelected = { selected = it },
            )
        }

        rule.onNodeWithContentDescription("Search").performClick()

        assertEquals(1, selected)
    }

    @Test
    fun selectedItem_reportsSelectedState() {
        rule.setContent {
            AnimatedBottomBar(
                items = items,
                selectedIndex = 0,
                onItemSelected = {},
            )
        }

        rule.onNodeWithContentDescription("Home").assertIsSelected()
    }

    @Test
    fun disabledItem_doesNotEmitSelection() {
        var selected by mutableIntStateOf(0)
        rule.setContent {
            AnimatedBottomBar(
                items = items,
                selectedIndex = selected,
                onItemSelected = { selected = it },
            )
        }

        rule.onNodeWithContentDescription("Profile").performClick()

        assertEquals(0, selected)
    }
}
