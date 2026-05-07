# Creating a Screen

## Create a new Java file

```text
{Name}Screen.java
```

## Have it extend the `Screen` class

```java
public class {Name}Screen extends Screen {}
```

## Constructor Example

```java
public {Name}Screen(ScreenLoader loader, ScreenManager manager) {
    try {

        // Add the background
        this.addLayer(
            loader.loadBackground("/test/{Name}_screen.txt")
        );

        // Add other layers
        this.addLayer(...);

    } catch (IOException e) {
        e.printStackTrace();
    }
}
```
