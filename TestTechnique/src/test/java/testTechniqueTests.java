import file_processing.FileProcessing;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;


public class testTechniqueTests {


    @Test
    public void testWordExclusion() throws Exception {
        String[] wordsExclusion = new String[2];
        wordsExclusion[0] = ("Hello");
        wordsExclusion[1] = ("Bye");
        ArrayList<String> wordsList = new ArrayList<String>(
                Arrays.asList("Hello", "Bonjour", "Au Revoir", "Bye"));
        ArrayList<String> result = FileProcessing.compareWords(wordsExclusion, wordsList);
        Assertions.assertEquals(result.size(), 2);
        }
}
