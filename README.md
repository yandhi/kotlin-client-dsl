# kotlin-client-dsl
a kotlin-based dsl project for a (Client) -> (Plugin) styled program.

## So, whats the point❓
Well, it struck me that because of the ability to create language DSLs with kotlin, we could simply make "client" applications very very simple to make. <br>
Almost to the point to where writing them would feel "script-like" in nature, keeping things fairly close to just one class.

## Where can I use it⁉️
Any jvm-based project ☕️ 

## How do I use it⁉️
Simply download the source and add into your sources. (we do this because the usage of inline functions is wonky with compiled libraries in kotlin, and the event system relies on these functions).

## Sample Usage
```kotlin
  fun init() {
       client("client", "1.0.0") { client ->
            plugin("testplugin", client) {

            }
            toggle("testtoggle", client) {
                enable(it) {
                    println("enabling...")
                }
                disable(it) {
                    println("disabling...")
                }
            }
        }
  }

```

## Examples 😁!
[Minecraft 1.18.1 Fabric Mod](https://github.com/yandhi/client-dsl-example)
