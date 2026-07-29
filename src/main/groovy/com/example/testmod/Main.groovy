package com.example.testmod

import pl.olafcio.tedge.IInitializer

final class Main implements IInitializer {
    static {
        // This is invoked immediately when the mod is loaded.
        println "-> Immediate init"
    }

    @Override
    void init() {
        // This is invoked when all mods have been loaded into memory.
        println "-> Init"
    }
}
