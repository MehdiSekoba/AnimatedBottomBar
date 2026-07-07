```markdown
# AnimatedBottomBar

A modern Jetpack Compose bottom navigation bar with a **smooth floating curved indicator** that glides between tabs. The selected icon lifts, changes color, and rides the pill for a delightful feel.

<p align="center">
  <img src="ui.gif" width="420" alt="AnimatedBottomBar demo" />
</p>

**Features**

- Elegant liquid curved indicator with Bézier curves
- Fully customizable (colors, typography, sizes, animations)
- Dot & count badges
- Excellent accessibility support
- Lightweight & zero extra dependencies
- min SDK 24

---

## Installation

```kotlin
dependencies {
    implementation("io.github.mehdisekoba.animatedbottombar:animatedbottombar:1.0.0")
}
```

---

## Quick Start

```kotlin
val items = listOf(
    BottomBarItem(
        icon = IconSource.Vector(Icons.Outlined.Home),
        label = "Home",
        selectedIcon = IconSource.Vector(Icons.Filled.Home)
    ),
    BottomBarItem(
        icon = IconSource.Vector(Icons.Outlined.FavoriteBorder),
        label = "Favorites",
        selectedIcon = IconSource.Vector(Icons.Filled.Favorite),
        badge = Badge.Dot
    ),
    BottomBarItem(
        icon = IconSource.Vector(Icons.Outlined.ChatBubbleOutline),
        label = "Messages",
        badge = Badge.Count(12)
    ),
    BottomBarItem(
        icon = IconSource.Vector(Icons.Outlined.FolderOpen),
        label = "Files",
        selectedIcon = IconSource.Vector(Icons.Filled.Folder)
    )
)

var selectedIndex by rememberSaveable { mutableIntStateOf(0) }

AnimatedBottomBar(
    items = items,
    selectedIndex = selectedIndex,
    onItemSelected = { selectedIndex = it },
    modifier = Modifier.fillMaxWidth().padding(20.dp)
)
```

### State Holder

```kotlin
val state = rememberAnimatedBottomBarState()

AnimatedBottomBar(
    items = items,
    selectedIndex = state.selectedIndex,
    onItemSelected = { state.selectedIndex = it }
)
```

---

## Customization

```kotlin
style = BottomBarDefaults.style(
    indicatorColor = MaterialTheme.colorScheme.primary,
    selectedIconColor = MaterialTheme.colorScheme.onPrimary,
)

animationSpec = BottomBarDefaults.animationSpec(
    indicatorSpec = spring(dampingRatio = 0.65f)
)
```

---

## Accessibility

Fully accessible with proper `Role.Tab`, content descriptions, and badge announcements.

---

## Compatibility

- **minSdk**: 24
- **Kotlin**: 2.4.0
- **Compose BOM**: 2026.06.01

---

## License

Apache License 2.0
