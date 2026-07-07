# AnimatedBottomBar

A modern and highly customizable **Jetpack Compose bottom navigation bar** with a smooth floating curved indicator animation.

AnimatedBottomBar provides a polished navigation experience where the selected item smoothly transitions, the icon animates, and the indicator glides between destinations with a fluid motion.

<p align="center">
  <img src="ui.gif" width="420" alt="AnimatedBottomBar demo" />
</p>

## ✨ Features

* Smooth floating curved indicator animation
* Bézier-based liquid indicator shape
* Animated icon transitions
* Fully customizable colors, dimensions, and animation specs
* Support for selected and unselected icons
* Dot and count badges
* Material 3 compatible
* Accessibility-friendly semantics
* Lightweight implementation
* No unnecessary dependencies

---

## 📦 Installation

Add the dependency to your app module:

```kotlin
[versions]
animatedbottombar = "1.0.0"

[libraries]
animatedbottombar = { module = "io.github.mehdisekoba:animatedbottombar", version.ref = "animatedbottombar" }

dependencies {
    implementation(libs.animatedbottombar)
}
```

---

## 🚀 Quick Start

Create your bottom bar items:

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
```

Use `AnimatedBottomBar` inside your Composable:

```kotlin
var selectedIndex by rememberSaveable {
    mutableIntStateOf(0)
}

AnimatedBottomBar(
    items = items,
    selectedIndex = selectedIndex,
    onItemSelected = { index ->
        selectedIndex = index
    },
    modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp)
)
```

---

## 🎨 Customization

AnimatedBottomBar is designed to be flexible.

Example:

```kotlin
AnimatedBottomBar(
    items = items,
    selectedIndex = selectedIndex,
    onItemSelected = { selectedIndex = it },
    style = BottomBarDefaults.style(
        indicatorColor = MaterialTheme.colorScheme.primary,
        selectedIconColor = MaterialTheme.colorScheme.onPrimary
    ),
    animationSpec = BottomBarDefaults.animationSpec(
        indicatorSpec = spring(
            dampingRatio = 0.65f
        )
    )
)
```

---

## 🏷 Badges

You can display notification indicators using badges.

### Dot badge

```kotlin
BottomBarItem(
    icon = IconSource.Vector(Icons.Outlined.Notifications),
    label = "Notifications",
    badge = Badge.Dot
)
```

### Count badge

```kotlin
BottomBarItem(
    icon = IconSource.Vector(Icons.Outlined.Message),
    label = "Messages",
    badge = Badge.Count(5)
)
```

---

## 🎭 Icon Sources

AnimatedBottomBar supports different icon sources:

### Compose Vector Icons

```kotlin
IconSource.Vector(Icons.Outlined.Home)
```

### Drawable Resources

```kotlin
IconSource.DrawableResource(
    R.drawable.ic_home
)
```

This allows using both Material Icons and custom drawable assets.

---

## ♿ Accessibility

AnimatedBottomBar provides Compose semantics support for navigation items, including:

* Tab roles
* Content descriptions
* State information for selected items
* Badge announcements

---

## Requirements

* Android minSdk: 24+
* Kotlin: 2.4+
* Jetpack Compose

---

## 📄 License

Licensed under the Apache License 2.0.

See the [LICENSE](LICENSE) file for details.
