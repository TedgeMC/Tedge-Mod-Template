## <b>NOTE: Read [TUTORIAL.md](./TUTORIAL.md) first!</b>

# 🔊 <font color="#74a4c5">What language to pick</font>

Picking a programming language for your project may be a hard decision.<br/>
And it is. Here I prepared a table of things to expect from the most popular JVM languages:

| Java-like Syntax                            | Debugging  | Name                                      | Typical usage       | Do I use it | Similar to           | Random cool syntax feature |
|---------------------------------------------|------------|-------------------------------------------|---------------------|-------------|----------------------|----------------------------|
| ☑️                                          | 🆗         | [Java](https://java.net)                  | Applications        | Yes         | C++                  | Records                    |
| ☑️                                          | 😁         | Groovy                                    | Build scripts       | Yes         | JavaScript, Python 2 | String interpolation       |
| ➗ <font color="#785dc8">*(in half)*</font> | ❓         | [Xtend](https://eclipse.dev/Xtext/xtend/) | Bored Eclipse devs  | Nah         | TypeScript           | Operator overloading       |
| ✖️                                          | ❓         | Skala                                     | Math (TODO verify)  | Nah         | Python 3, Rust       | Enum cases                 |
| ✖️                                          | ❓         | Kotlin                                    | Android development | Nah         | C#                   | Inline constructors        |

Note that some of these languages may have random cool syntax features from others.

(The Xtend statement is my personal opinion, not tryna insult anybody)<br/>
(I recommend Java or Groovy)

## 📜 <font color="#ffdea7">Code examples</font>

Java
```java
package com.tuff.examplemod;

import pl.olafcio.tedge.IInitializer;

public class ExampleMod implements IInitializer {
    @Override
    public void init() {
        IO.println("Loaded ExampleMod =D");
    }
}
```

Groovy
```groovy
package com.tuff.examplemod

import pl.olafcio.tedge.IInitializer

class ExampleMod implements IInitializer {
    @Override
    void init() {
        println "Loaded ExampleMod =D"
    }
}
```

Xtend
```groovy
//ive no clue
```

Skala
```groovy
//no clue either
```

Kotlin

```kotlin
package com.tuff.examplemod

import pl.olafcio.tedge.IInitializer

class ExampleMod : IInitializer {
    override fun init() {
        IO.println("Loaded ExampleMod =D")
    }
}
```

## 📐 <font color="#bbbbbc">How to set your language</font>

1. Click on `build.gradle`
2. In the `plugins` section, replace `groovy` with your chosen language's artifact ID
3. In the `dependencies` section, replace `implementation 'org.apache.groovy:groovy:5.0.6'` with your chosen language's full maven path
4. Sync/reload/reopen your project or run any gradle task

Boom, that's it.<br/>
(The java language is always present too, as it's added by Tedge Sharp.)
