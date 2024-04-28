package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import java.util.concurrent.Callable;

@Command(name = "gendiff", version = "App 1.0", mixinStandardHelpOptions = true,
        description = "Compares two files and shows a difference between them.")

public final class App implements Callable<Integer> {

    private static final int SUCCESS_EXIT_CODE = 0;
    private static final int ERROR_EXIT_CODE = 1;

    @Option(names = { "-f", "--format"}, defaultValue = "stylish", description = "output format [default: stylish]")
    private String format;
    @Parameters(index = "0", paramLabel = "filepath1", description = "path to first file")
    private String filePath1;
    @Parameters(index = "1", paramLabel = "filepath2", description = "path to second file")
    private String filePath2;

    @Override
    public Integer call() throws Exception {
        try {
            String formattedDiff = Differ.generate(filePath1, filePath2, format);
            System.out.println(formattedDiff);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ERROR_EXIT_CODE;
        }
        return SUCCESS_EXIT_CODE;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
