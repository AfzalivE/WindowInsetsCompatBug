# WindowInsetsCompatBug

This is a sample project to reproduce the bug reported [here](https://issuetracker.google.com/issues/188727501). This bug is reproducible on Android 10 (API 29) when the platform version of `setOnApplyWindowInsetsListener` is used with `WindowInsetsCompat#getInsets()`.

Simple workaround is to use `ViewCompat.setOnApplyWindowInsetsListener` instead. Here's a video showing the effects of the bug.

https://user-images.githubusercontent.com/436057/120087280-8997b800-c0b4-11eb-9ff9-ac8461540f53.mov

