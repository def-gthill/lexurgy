package com.meamoria.lexurgy.sc;

import kotlin.Unit;

import java.util.List;

public class JavaSoundChanger {
    private final JavaKotlinBridgeSoundChanger sc;

    public JavaSoundChanger(String rules) {
        sc = new JavaKotlinBridgeSoundChanger(rules);
    }

    public List<String> apply(List<String> words) {
        return sc.change(
                words,
                null,
                null,
                List.of(),
                true,
                s -> Unit.INSTANCE
        );
    }
}
