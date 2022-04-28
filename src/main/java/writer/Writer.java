package writer;
import java.io.*;
import model.Cosmetic;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Writer {
    public static void writeCSV(Map<Cosmetic, Integer> products, String fileName) {
        try (FileWriter writer = new FileWriter("src//main//resources//" + fileName + ".csv")) {
            Map<Cosmetic, Integer> productsSortedByClass = products.entrySet().stream()
                    .sorted((o1, o2) ->
                            CharSequence.compare(o1.getKey().getClass().getSimpleName(), o2.getKey().getClass().getSimpleName()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (o1, o2) -> o1, LinkedHashMap::new));
            String prevClassName = "";
            for (Map.Entry<Cosmetic, Integer> entrySet : productsSortedByClass.entrySet()) {
                if (!entrySet.getKey().getClass().getSimpleName().equals(prevClassName)) {
                    writer.write(entrySet.getKey().getClass().getSimpleName() + ":");
                    writer.write("\r\n");
                    writer.write(entrySet.getKey().getHeaders() + ", count");
                    writer.write("\r\n");
                    prevClassName = entrySet.getKey().getClass().getSimpleName();
                }
                writer.write(entrySet.getKey().toCSV() + ", " + entrySet.getValue());
                writer.write("\r\n");
            }
        } catch (IOException e) {
            e.getMessage();

        }
        }
    }

