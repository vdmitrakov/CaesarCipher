import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Runner {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java -jar myApp.jar <ENCRYPT/DECRYPT> <filePath> <key>");
            return;
        }

        String command = args[0].toUpperCase();
        String filePath = args[1];
        int key = Integer.parseInt(args[2]);

        try {
            String content = FileService.readFile(filePath);
            String result = switch (command) {
                case "ENCRYPT" -> CaesarCipher.encrypt(content, key);
                case "DECRYPT" -> CaesarCipher.decrypt(content, key);
                default -> throw new IllegalArgumentException("Invalid command. Use ENCRYPT or DECRYPT.");
            };

            String outputFilePath = filePath.replace(".txt", command.equals("ENCRYPT") ? "[ENCRYPTED].txt" : "[DECRYPTED].txt");
            FileService.writeFile(outputFilePath, result);
            System.out.println("Operation successful. Output file: " + outputFilePath);
        } catch (IOException e) {
            System.err.println("File error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid key. It must be an integer.");
        }
    }
}