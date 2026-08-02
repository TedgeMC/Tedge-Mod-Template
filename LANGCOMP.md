## <b>NOTE: Read [TUTORIAL.md](./TUTORIAL.md) first!</b>

# 🔊 <font color="#74a4c5">What language to pick</font>

###### <u>This document is viewed best with IntelliJ IDEA.</u><br/><u>For the best experience, select the 'Preview' mode.</u>

Picking a programming language for your project may be a hard decision.<br/>
And it is. Here I prepared a table of things to expect from the most popular JVM languages:

| Java-like Syntax                            | Debugging  | Name                                                                                                                                 | Typical usage       | Do I use it | Similar to           | Random cool syntax feature |
|---------------------------------------------|------------|--------------------------------------------------------------------------------------------------------------------------------------|---------------------|-------------|----------------------|----------------------------|
| ☑️                                          | 🆗         | [<span style="color:#0000;background:linear-gradient(180deg, #f8981d, #b83800) text">Java</span >](https://java.net)                 | Applications        | Yes         | C++                  | Records                    |
| ☑️                                          | 😁         | <span style="color:#0000;background:linear-gradient(180deg,#619cbc,#24444e) text;">Groovy</aspan>                                    | Build scripts       | Yes         | JavaScript, Python 2 | String interpolation       |
| ➗ <font color="#785dc8">*(in half)*</font> | ❓         | [<span style="color:#0000;background:linear-gradient(180deg, #5a5380, #b9b2c9) text">Xtend</span>](https://eclipse.dev/Xtext/xtend/) | Bored Eclipse devs  | Nah         | TypeScript           | Operator overloading       |
| ✖️                                          | ❓         | <span style="color:#0000;background:linear-gradient(180deg, #de3423, #380d09) text">Skala</span>                                     | Math (TODO verify)  | Nah         | Python 3, Rust       | Enum cases                 |
| ✖️                                          | ❓         | <span style="color:#0000;background:linear-gradient(180deg, #dc387e, #af27eb) text">Kotlin</span>                                    | Android development | Nah         | C#                   | Inline constructors        |

Note that some of these languages may have random cool syntax features from others.

(The Xtend statement is my personal opinion, not tryna insult anybody)<br/>
(I recommend Java or Groovy)

## 📜 <font color="#ffdea7">Code examples</font>

<table>
<tr>
<td>

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

</td>
<td>

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

</td>
</tr>
<tr>
<td>

Xtend
```kotlin
package com.tuff.examplemod

import pl.olafcio.tedge.IInitializer

class ExampleMod implements IInitializer {
    override def init() {
        IO.println("Loaded ExampleMod =D")
    }
}
```

</td>
<td>

Skala
```groovy
import pl.olafcio.tedge.IInitializer

class ExampleMod implements IInitializer:
    override def init()
        println("Loaded ExampleMod =D")
```

</td>
</tr>
<tr>
<td>

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

</td>
</tr>
</table>

## 📐 <font color="#bbbbbc">How to set your language</font>

1. Click on `build.gradle`
2. In the `plugins` section, replace `groovy` with your chosen language's artifact ID
3. In the `dependencies` section, replace `implementation 'org.apache.groovy:groovy:5.0.6'` with your chosen language's full maven path
4. Sync/reload/reopen your project or run any gradle task

Boom, that's it.<br/>
(The java language is always present too, as it's added by Tedge Sharp.)
