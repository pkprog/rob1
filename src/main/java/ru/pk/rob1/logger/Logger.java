package ru.pk.rob1.logger;

public class Logger {
    private static final String MASK = "{}";

    public static void debug(String pattern, Object ... objMessages) {
        log(pattern, objMessages);
    }

    public static void log(String pattern, Object ... objMessages) {
        if (pattern == null || pattern.equals("")) return;
        String[] messages = new String[objMessages.length];

        if (messages.length == 0) {
            print(pattern);
        } else {
            String text = pattern;
            for (int i = 0; i < objMessages.length; i++) {
                if (objMessages[i] == null) continue;

                int idx = text.indexOf(MASK);
                if (idx < 0) break;
                String newText = text.substring(0, idx) + String.valueOf(objMessages[i]) + text.substring(idx + MASK.length());
                text = newText;
            }

            print(text);
        }
    }

    private static void print(String text) {
        System.out.println(text);
    }
}
