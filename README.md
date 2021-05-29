# WindowInsetsCompatBug

This is a sample project to reproduce the bug reported [here](https://issuetracker.google.com/issues/188727501). As can be seen in the video below, `WindowInsets.Type.systemBars()` is including IME size as well when `View#setOnApplyWindowInsetsListener` is used with `WindowInsetsCompat#getInsets()` on Android 10 (API 29). The documentation for `WindowInsets.Type.systemBars()` says:

```
/**
 * @return All system bars. Includes {@link #statusBars()}, {@link #captionBar()} as well as
 * {@link #navigationBars()}, but not {@link #ime()}.
 */
```

A simple workaround is to use `ViewCompat.setOnApplyWindowInsetsListener` instead. Here's a video showing the effects of the bug.


https://user-images.githubusercontent.com/436057/120087280-8997b800-c0b4-11eb-9ff9-ac8461540f53.mov

