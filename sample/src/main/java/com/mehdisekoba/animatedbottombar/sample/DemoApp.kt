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
package com.mehdisekoba.animatedbottombar.sample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.outlined.FolderOpen
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mehdisekoba.animatedbottombar.AnimatedBottomBar
import com.mehdisekoba.animatedbottombar.Badge
import com.mehdisekoba.animatedbottombar.BottomBarDefaults
import com.mehdisekoba.animatedbottombar.BottomBarItem
import com.mehdisekoba.animatedbottombar.IconSource

/** Indigo backdrop matching the README demo (ui.gif). */
private val DemoBackdrop = Color(0xFF3B37D9)

/** The demo items — icon set of the README demo (ui.gif); no badges. */
private val demoItems: List<BottomBarItem> = listOf(
    BottomBarItem(
        icon = IconSource.DrawableResource(R.drawable.home),
        selectedIcon = IconSource.DrawableResource(R.drawable.home_select),
        label = ""
    ),
    BottomBarItem(
        icon = IconSource.DrawableResource(R.drawable.heart),
        selectedIcon = IconSource.DrawableResource(R.drawable.heart_select),
        label = "",
        badge = Badge.Count(6),

        ),
    BottomBarItem(
        icon = IconSource.DrawableResource(R.drawable.chat),
        selectedIcon = IconSource.DrawableResource(R.drawable.chat_select),
        label = "",
    ),
    BottomBarItem(
        icon = IconSource.Vector(Icons.Outlined.FolderOpen),
        selectedIcon = IconSource.Vector(Icons.Filled.Folder),
        label = "",
    ),
)

@Composable
fun DemoApp() {
    SampleTheme(darkTheme = false, dynamicColor = false) {
        var selected by remember { mutableIntStateOf(0) }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(DemoBackdrop),
            contentAlignment = Alignment.BottomCenter
        ) {
            AnimatedBottomBar(
                items = demoItems, // Assuming demoItems is defined in this file or imported
                selectedIndex = selected,
                onItemSelected = { selected = it },
                modifier = Modifier
                    .navigationBarsPadding() // Pushes it above the system navigation bar
                    .padding(start = 10.dp, end = 10.dp)          // Your custom floating margin
            )
        }
    }
}

@Preview(name = "Dark", showBackground = true, backgroundColor = 0xFF121220)
@Composable
private fun PreviewDark() {
    SampleTheme(darkTheme = true, dynamicColor = false) {
        var selected by remember { mutableIntStateOf(2) }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.BottomCenter
        ) {
            AnimatedBottomBar(
                items = demoItems,
                selectedIndex = selected,
                onItemSelected = { selected = it },
                modifier = Modifier
                    .navigationBarsPadding()
                    .padding(start = 10.dp, end = 10.dp)
            )
        }
    }
}

@Preview(name = "Custom style", showBackground = true)
@Composable
private fun PreviewCustomStyle() {
    SampleTheme(darkTheme = false, dynamicColor = false) {
        var selected by remember { mutableIntStateOf(1) }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.BottomCenter
        ) {
            AnimatedBottomBar(
                items = demoItems,
                selectedIndex = selected,
                onItemSelected = { selected = it },
                style = BottomBarDefaults.style(
                    indicatorSize = 60.dp,
                    barHeight = 76.dp,
                    containerShapeRadius = 36.dp,
                ),
                modifier = Modifier
                    .navigationBarsPadding()
                    .padding(start = 10.dp, end = 10.dp)
            )
        }
    }
}