import com.vdurmont.emoji.EmojiParser;

public class EmojiTranslator {
  public static String translateToEmojiLanguage(String text) {
    String result = "";
    String[] words = text.split("");
    for (String word : words) {
      result += transformWordToEmoji(word) + " ";
    }
    return result;
  }

  private static String transformWordToEmoji(String text) {
    String word = ":" + text.toLowerCase() + ":";
    String emoji = EmojiParser.parseToUnicode(word);
    if (!emoji.equals(word)) {
      return emoji;
    }
    return text;
  }

}
