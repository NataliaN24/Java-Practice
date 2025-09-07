public class TextJustifier {

    public static String[] justifyText(String[] words, int maxWidth) {
        String[] result = new String[words.length];
        int resIndex = 0;
        int i = 0;

        while (i < words.length) {
            int lineLen = words[i].length();
            int start = i;
            i++;

            // Събираме думи за реда
            while (i < words.length && lineLen + 1 + words[i].length() <= maxWidth) {
                lineLen += 1 + words[i].length();
                i++;
            }

            int end = i;
            int wordCount = end - start;
            int totalChars = 0;
            for (int j = start; j < end; j++) totalChars += words[j].length();

            StringBuilder sb = new StringBuilder();

            // Последен ред или ред с една дума → ляво подравнен
            if (i == words.length || wordCount == 1) {
                for (int j = start; j < end; j++) {
                    if (j > start) sb.append(" ");
                    sb.append(words[j]);
                }
                while (sb.length() < maxWidth) sb.append(" ");
            } else {
                // Двустранно подравняване
                int totalSpaces = maxWidth - totalChars;
                int spaceBetween = totalSpaces / (wordCount - 1);
                int extra = totalSpaces % (wordCount - 1);

                for (int j = start; j < end; j++) {
                    sb.append(words[j]);
                    if (j < end - 1) {
                        for (int s = 0; s < spaceBetween; s++) sb.append(" ");
                        if (extra > 0) { sb.append(" "); extra--; }
                    }
                }
            }

            result[resIndex++] = sb.toString();
        }

        // Връщаме резултата с точния размер
        String[] finalRes = new String[resIndex];
        for (int k = 0; k < resIndex; k++) finalRes[k] = result[k];
        return finalRes;
    }

    public static void main(String[] args) {
        String[] words = {"The", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog."};
        String[] justified = justifyText(words, 11);
        for (String line : justified) System.out.println("\"" + line + "\"");
    }
}
