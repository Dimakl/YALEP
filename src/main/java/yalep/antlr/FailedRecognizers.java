package yalep.antlr;

import org.antlr.v4.runtime.Recognizer;

import java.util.HashSet;

public class FailedRecognizers {

    private static HashSet<Recognizer<?, ?>> failedRecognizers = new HashSet<>();

    protected static void addFailedRecognizer(Recognizer<?, ?> recognizer) {
        failedRecognizers.add(recognizer);
    }

    public static Boolean isFailedRecognizer(Recognizer<?, ?> recognizer) {
        return failedRecognizers.contains(recognizer);
    }

}
