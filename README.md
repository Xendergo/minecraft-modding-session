# Minecraft modding session

This is the repository that contains the starter code for the minecraft modding session and the finished code on
the `finished` branch.

## Editor setup

I won't cover this in the session and I'll expect you to do this beforehand if you're interested in following along.
I'll be at the couch circle early to support you if needed.

For these instructions I'm assuming you're using IntelliJ:
[Instructions for other editors](https://fabricmc.net/wiki/tutorial:setup)

1. Clone this template somewhere and open it in IntelliJ
2. Select the `build.gradle` file in your file tree, this will import the project. Gradle is a build automation tool for
   Java that we use for minecraft modding.
3. Close and reopen the project in IntelliJ once it's done importing
4. Click the elephant icon (the logo for gradle) to open the gradle menu, click the settings icon, and go
   to `Gradle Settings`. Then
   set `Build and run Using` and `Run tests using` to `IntelliJ IDEA`.
5. In the gradle menu, open the `fabric` folder under `Tasks`. Then double click `genSources` to run the task. That will
   decompile Minecraft's source code so that you can read at it.
6. To search for Minecraft source files, use `Ctrl-N` and change the `Project Files` dropdown
   to `Project and Libraries`. Now you can search for class files in the search bar.
7. In the file dropdown, go to project structure, and choose a folder for `Compiler Output`. This is where compiled
   files will go, so I recommend choosing the project folder or a temporary directory.
8. Now you should be able to select `Minecraft Client` from the dropdown next to the run button, run the project and
   have minecraft open. Somewhere in the logs at the bottom of the screen you should see `Hello Fabric world!`, that
   means the mod is in the game.

## Resources

The most helpful resource is [Fabric's wiki](https://fabricmc.net/wiki/tutorial:primer), I recommend that you read
the `Basics` section for a more fundamental understanding of what I covered/will be covering.

If you want to learn more about mixins, [here's the wiki](https://github.com/SpongePowered/Mixin/wiki)

It's also helpful to look at the source code for other mods similar to yours or at the minecraft source code to
understand how to do things.