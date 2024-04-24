package hexlet.code;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DifferTest {

    private static final String PATH_TO_FILE_0 = "./src/test/resources/fix/file1.json";
    private static final String PATH_TO_FILE_1 = "./src/test/resources/fix/file2.json";
    private static final String PATH_TO_FILE_2 = "./src/test/resources/fix/file1.yml";
    private static final String PATH_TO_FILE_3 = "./src/test/resources/fix/file2.yml";

    private static String resultStylish;
    private static String resultPlain;
    private static String resultJson;


    @BeforeEach
    public final void beforeEach() throws Exception {
        resultStylish = Differ.getData("./src/test/resources/fix/result_stylish.txt");
        resultPlain = Differ.getData("./src/test/resources/fix/result_plain.txt");
        resultJson = Differ.getData("./src/test/resources/fix/result_json.json");
    }

    @Test
    @DisplayName("JSON test stylish")
    public void testJSONtoStylish() throws Exception {
        String result = Differ.generate(PATH_TO_FILE_0, PATH_TO_FILE_1, "stylish");
        assertThat(result).isEqualTo(resultStylish);
    }

    @Test
    @DisplayName("YAML test stylish")
    public void testYMLtoStylish2() throws Exception {
        String result = Differ.generate(PATH_TO_FILE_2, PATH_TO_FILE_3, "stylish");
        assertThat(result).isEqualTo(resultStylish);
    }

    @Test
    @DisplayName("JSON test plain")
    public void testJSONtoPlain() throws Exception {
        String result = Differ.generate(PATH_TO_FILE_0, PATH_TO_FILE_1, "plain");
        assertThat(result).isEqualTo(resultPlain);
    }

    @Test
    @DisplayName("YAML test plain")
    public void testYMLtoPlain() throws Exception {
        String result = Differ.generate(PATH_TO_FILE_2, PATH_TO_FILE_3, "plain");
        assertThat(result).isEqualTo(resultPlain);
    }

    @Test
    @DisplayName("JSON compare to JSON")
    public void testJSONtoJson() throws Exception {
        String result = Differ.generate(PATH_TO_FILE_0, PATH_TO_FILE_1, "json");
        assertThat(result).isEqualTo(resultJson);
    }

    @Test
    @DisplayName("YAML compare to JSON")
    public void testYMLtoJson() throws Exception {
        String result = Differ.generate(PATH_TO_FILE_2, PATH_TO_FILE_3, "json");
        assertThat(result).isEqualTo(resultJson);
    }

    @Test
    @DisplayName("Generate default result on files")
    public void testGenerateDefault() throws Exception {
        String result1 = Differ.generate(PATH_TO_FILE_0, PATH_TO_FILE_1);
        String result2 = Differ.generate(PATH_TO_FILE_2, PATH_TO_FILE_3);
        assertThat(result1).isEqualTo(resultStylish);
        assertThat(result2).isEqualTo(resultStylish);
    }

    @Test
    @DisplayName("Generate default result on empty files")
    public void testGenerate() throws Exception {
        String result1 = Differ.generate(PATH_TO_FILE_0, PATH_TO_FILE_1);
        String result2 = Differ.generate(PATH_TO_FILE_2, PATH_TO_FILE_3);
        assertNotNull(result1);
        assertNotNull(result2);
        assertFalse(result1.isEmpty());
        assertFalse(result2.isEmpty());
    }

    @Test
    @DisplayName("File type get test")
    public void testGetFileType() {
        String expectedType = "json";
        String actualType = Differ.getDataFormat(PATH_TO_FILE_0);
        assertEquals(expectedType, actualType);
    }
}
