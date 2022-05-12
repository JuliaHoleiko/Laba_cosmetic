package texteditor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextEditor {
    private String text;

    public TextEditor(String text) {
        this.text = text;
    }

    public String textEdit() {

        Pattern pattern = Pattern.compile("(\\w+)");
        Matcher matcher = pattern.matcher(text);
        return matcher.replaceAll(m -> {
            int consonant = m.group().replaceAll("[aeiouAIEUO]", "").length();
            if (consonant < m.group().length() - consonant) {
                return "";
            }
            else return m.group();
        }).trim().replaceAll(" +", " ");
    }






}
