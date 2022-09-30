package encryptdecrypt;

import encryptdecrypt.factories.DecryptedAlgorithm;
import encryptdecrypt.factories.EncryptedAlgorithm;
import encryptdecrypt.strategies.DataCipherMethod;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> listArgs = new ArrayList<>(Arrays.asList(args));

        try {
            String readData = readInputData(listArgs);
            int key = getKey(listArgs);
            String mode = getMode(listArgs);
            String alg = getAlg(listArgs);
            String processedData = processInputData(mode, readData, key, alg);
            outputData(listArgs, processedData);
        } catch (IOException e) {
            System.out.println("Error! Something went wrong");
        }
    }

    private static int getKey(List<String> args) {
        if (args.contains("-key")) {
            String key = args.get(args.indexOf("-key") + 1);
            return Integer.parseInt(key);
        } else {
            return 0;
        }
    }

    private static String getAlg(List<String> args) {
        if (!args.contains("-alg")) {
            return "shift";
        } else {
            return args.get(args.indexOf("-alg") + 1);
        }
    }

    private static String getMode(List<String> args) {
        if (args.contains("-mode")) {
            return args.get(args.indexOf("-mode") + 1);
        } else {
            return "enc";
        }
    }

    private static String processInputData(String mode, String sourceText, int key, String alg) {
        if ("enc".equals(mode)) {
            return getEncryptedData(sourceText, key, alg);
        } else {
            return getDecryptedData(sourceText, key, alg);
        }
    }

    private static String readDataFromFile(String pathToFile) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(pathToFile));
        return scanner.nextLine();
    }

    private static String readInputData(List<String> args) throws FileNotFoundException {
        boolean hasDataArg = args.contains("-data");
        boolean hasInArg = args.contains("-in");
        String dataArgValue = hasDataArg ? args.get(args.indexOf("-data") + 1) : "";

        if (hasDataArg && hasInArg) {
            return dataArgValue;
        } else if (hasDataArg) {
            return dataArgValue;
        } else if (hasInArg) {
            String pathToFile = args.get(args.indexOf("-in") + 1);
            return readDataFromFile(pathToFile);
        } else {
            return dataArgValue;
        }
    }

    private static void outputData(List<String> args, String data) throws IOException {
        boolean hasOutArg = args.contains("-out");

        if (!hasOutArg) {
            System.out.println(data);
        } else {
            String path = args.get(args.indexOf("-out") + 1);
            outputDataToFile(path, data);
        }
    }

    private static void outputDataToFile(String pathToFile, String data) throws IOException {
        FileWriter writer = new FileWriter(pathToFile);
        writer.write(data);
        writer.close();
    }

    private static String getEncryptedData(String sourceText, int key, String alg) {
        EncryptedAlgorithm algorithmFactory = new EncryptedAlgorithm();
        DataCipherMethod cipherMethod = algorithmFactory.chooseCipherMethod(alg);
        return cipherMethod.cipher(sourceText, key);
    }

    private static String getDecryptedData(String sourceText, int key, String alg) {
        DecryptedAlgorithm algorithmFactory = new DecryptedAlgorithm();
        DataCipherMethod cipherMethod = algorithmFactory.chooseCipherMethod(alg);
        return cipherMethod.cipher(sourceText, key);
    }

}