# 🐻 <font color="#a56953">Modding with Tedge</font>
Tedge is a fresh new Minecraft modloader (straight from the oven).
Tedge, in many cases, acts just like Fabric.                        <br/>
However, not everything is the same:

<table>
<td>

1. **Auto-changed Modifiers**                                          <br/>
   In Tedge, all types, fields and methods of Minecraft are **public**.<br/>
   Most of them are non-final too.

</td>
</table>

<table>
<td>

2. **Access Editors**                                                  <br/>
   In Tedge, there's no accesswideners nor accesstransformers.         <br/>
   Instead, there are access editors - a great alternative that allows you to do much more.   <br/>
   Take a look at [src/main/resources/tedge.mod.accesseditor.](./src/main/resources/tedge.mod.accesseditor)   <br/><br/>
   *(when you don't specify an accesseditor to use, the modloader searches it for you)*      <br/>

</td>
</table>

<table>
<td>

3. **YAML Mod File**                                                   <br/>
   In Tedge, mods use a file called `tedge.mod.yaml` to identify themselves.   <br/>
   This, in comparison to Fabric and (Neo)Forge, has many advantages:
   - YAML has comments; JSON doesn't.
   - YAML is easier than TOML.

</td>
</table>

<table>
<td>

4. **Groovy Mixin Support**                                                   <br/>
   In Tedge, mods can write mixins in other JVM languages than Java, if there's a TedgeMixin extension for it!<br/>
   This cannot be done on Fabric; it may require tweaking your build pipeline on (Neo)Forge.<br/>
   The TedgeMC team will be working on supporting more languages in mixins, such as Kotlin, soon.

</td>
</table>

You might also be asking yourself, *"is there a Tedge API?"*<br/>
The answer is *yes*, but it wasn't originally made for Tedge; it's called [Avoid Framework.](https://modrinth.com/mod/aovid)

## 📗 <font color="#86d72f">Why is the template using Groovy?</font>
Groovy has better debugging capabilities than all Java implementations I used.<br/>
You still can switch to Java, if you prefer. [Read this for some more options.](./LANGCOMP.md)

## What is the whole Tedge infrastructure

Tedge is the modloader itself. This includes the Main wrapper class and the java Agent.<br/>
Tedge Sharp is the Gradle plugin for Tedge mods. It runs the launcher, registers all classpath elements into Gradle, and sets up the task for running Minecraft with Tedge.<br/>
Tedge Jargen is the tool used to transform Minecraft's jar after initial download.<br/>
Tedge Launcher is the tool used to download Minecraft, use Tedge Jargen to transform it, and save its classpath.

Here's the order in which, what happens when you sync your project after adding Tedge Sharp:
1. Tedge Sharp starts up
2. Tedge Launcher starts up
3. Tedge Launcher downloads the Minecraft JAR
4. Tedge Launcher downloads the Minecraft libraries
5. Tedge Jargen transforms the Minecraft JAR
6. Tedge Launcher saves the required classpath
7. Tedge Sharp downloads the Tedge ModLoader
8. Complete

Tedge Sharp and Tedge Launcher are designed for dev environments.<br/>
Tedge and Tedge Jargen however are an essential part of the lifecycle.
