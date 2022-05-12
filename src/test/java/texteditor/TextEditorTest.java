package texteditor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextEditorTest {
    @Test
    void textEditor(){
        String expected = "The is simple: is more than just vowel-packed word, it is also comprised only of letters. In contrast, the word only brings three letters to the table and significantly diminishes the chances of receiving positive feedback.";
        TextEditor result = new TextEditor("The rationale is simple: ADIEU is more than just a vowel-packed word, it is also comprised only of unique letters. In contrast, the word QUEUE only brings three unique letters to the table and significantly diminishes the chances of receiving positive feedback.");
        assertEquals(result.textEdit(), expected);
        assertFalse(result.textEdit().isEmpty());
    }

}