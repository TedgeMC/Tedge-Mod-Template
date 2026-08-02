# 🐻 <font color="#a56953">Modding with Tedge</font>
Tedge is a fresh new Minecraft modloader (straight from the oven).
Tedge, in many cases, acts just like Fabric.                        <br/>
However, not everything is the same:

###### <u>This document is viewed best with IntelliJ IDEA.</u><br/><u>For the best experience, select the 'Preview' mode.</u>

<table>
<td>

<span style="background: #333333;padding:8px;color:#fff;font-family:Verdana;line-height:0">#1</span><span style="background: #dd4545;padding:8px;color:#000;font-family:Verdana;line-height:0;font-weight:600">DEFAULT MODIFIERS</span>
   <br/><br/>
   &emsp;&emsp;In Tedge, all types, fields and methods of Minecraft are **public**.<br/>
   &emsp;&emsp;Most of them are non-final too.

</td>
</table>

<table>
<td>

<span style="background: #333333;padding:8px;color:#fff;font-family:Verdana;line-height:0">#2</span><span style="background: #dd7745;padding:8px;color:#000;font-family:Verdana;line-height:0;font-weight:600">ACCESS EDITORS</span>
   <br/><br/>
   &emsp;&emsp;In Tedge, there's no accesswideners nor accesstransformers.         <br/>
   &emsp;&emsp;Instead, there are access editors - a great alternative that allows you to do much more.   <br/>
   &emsp;&emsp;Take a look at [src/main/resources/tedge.mod.accesseditor.](./src/main/resources/tedge.mod.accesseditor)   <br/><br/>
   &emsp;&emsp;*(when you don't specify an accesseditor to use, the modloader searches it for you)*      <br/>

</td>
</table>

<table>
<td>

<span style="background: #333333;padding:8px;color:#fff;font-family:Verdana;line-height:0">#3</span><span style="background: #ddaa77;padding:8px;color:#000;font-family:Verdana;line-height:0;font-weight:600">YAML MOD FILE</span>
   <br/><br/>
   &emsp;&emsp;In Tedge, mods use a file called `tedge.mod.yaml` to identify themselves.   <br/>
   &emsp;&emsp;This, in comparison to Fabric and (Neo)Forge, has many advantages:<ul><!--
   &emsp;&emsp;--><li>YAML has comments; JSON doesn't.</li><!--
   &emsp;&emsp;--><li>YAML is easier than TOML.</li><!--
   &emsp;&emsp;--></ul>

</td>
</table>

<table>
<td>

<span style="background: #333333;padding:8px;color:#fff;font-family:Verdana;line-height:0">#4</span><span style="background: #33ffaa;padding:8px;color:#000;font-family:Verdana;line-height:0;font-weight:600">GROOVY MIXIN SUPPORT</span>
   <br/><br/>
   &emsp;&emsp;In Tedge, mods can write mixins in other JVM languages than Java, if there's a TedgeMixin extension for it!<br/>
   &emsp;&emsp;This cannot be done on Fabric and Forge; NeoForge status is unknown.<br/>
   &emsp;&emsp;The TedgeMC team will be working on supporting more languages in mixins, such as Kotlin, soon.

</td>
</table>

You might also be asking yourself, *"is there a Tedge API?"*<br/>
The answer is *yes*, but it wasn't originally made for Tedge; it's called [Avoid Framework.](https://modrinth.com/mod/aovid)

## 📗 <font color="#86d72f">Why is the template using Groovy?</font>
Groovy has better debugging capabilities than all Java implementations I used.<br/>
You still can switch to Java, if you prefer. [Read this for some more options.](./LANGCOMP.md)

## 🏗️ <font color="#de432b">What is the whole Tedge infrastructure</font>

Tedge is the modloader itself. This includes the Main wrapper class and the java Agent.<br/>
Tedge Sharp is the Gradle plugin for Tedge mods. It runs the launcher, registers all classpath elements into Gradle, and sets up the task for running Minecraft with Tedge.<br/>
Tedge Jargen is the tool used to transform Minecraft's jar after initial download.<br/>
Tedge Launcher is the tool used to download Minecraft, use Tedge Jargen to transform it, and save its classpath.

Here's the order in which, what happens when you sync your project after adding Tedge Sharp:

<style>
    .diagram-block {background:#10487f;border:1px solid #fff3;width:fit-content;padding:9px 15px;line-height:15px}
</style>

<div align="center">
    <div class="diagram-block">Tedge Sharp starts up</div>
    <svg xmlns="http://www.w3.org/2000/svg" width="50px" height="50px" viewBox="0 0 16 16" fill="none" style="margin-block:15px 5px">
        <path d="M10 8L14 8V10L8 16L2 10V8H6V0L10 4.76995e-08V8Z" fill="#10487f"/>
    </svg>
    <div style="display: flex; justify-content: center;gap: 8px">
        <div class="diagram-block">Tedge Launcher starts up</div>
    </div>
    <svg xmlns="http://www.w3.org/2000/svg" width="50px" height="50px" viewBox="0 0 16 16" fill="none" style="margin-block:15px 5px">
        <path d="M10 8L14 8V10L8 16L2 10V8H6V0L10 4.76995e-08V8Z" fill="#10487f"/>
    </svg>
    <div style="display: flex; justify-content: center;gap: 8px;translate:8px">
        <div class="diagram-block">Tedge Launcher downloads the Minecraft JAR</div>
        <div class="diagram-block">Tedge Launcher downloads the Minecraft libraries</div>
    </div>
    <svg xmlns="http://www.w3.org/2000/svg" width="50px" height="50px" viewBox="0 0 16 16" fill="none" style="margin-block:15px 5px">
        <path d="M10 8L14 8V10L8 16L2 10V8H6V0L10 4.76995e-08V8Z" fill="#10487f"/>
    </svg>
    <div style="display: flex; justify-content: center;gap: 8px">
        <div class="diagram-block">Tedge Jargen transforms the Minecraft JAR</div>
    </div>
    <svg xmlns="http://www.w3.org/2000/svg" width="50px" height="50px" viewBox="0 0 16 16" fill="none" style="margin-block:15px 5px">
        <path d="M10 8L14 8V10L8 16L2 10V8H6V0L10 4.76995e-08V8Z" fill="#10487f"/>
    </svg>
    <div style="display: flex; justify-content: center;gap: 8px;translate:0">
        <div class="diagram-block">Tedge Launcher saves the required classpath</div>
        <div class="diagram-block">Tedge Sharp downloads the Tedge ModLoader</div>
    </div>
</div>

Tedge Sharp and Tedge Launcher are designed for dev environments.<br/>
Tedge and Tedge Jargen however are an essential part of the lifecycle.
