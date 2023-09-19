package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private String processorName;
    private Long period = 10000000000000L;
    protected StringBuilder processorVersion;
    private Integer valueOfCheap;
    private Scanner informationScanner;
    private LinkedList<String> stringArrayList;

    @ListIteratorAnnotation
    public void listIterator(LinkedList<String> stringList) {
        for (String e : stringList) {
            if (e != null) {
                System.out.println(e.hashCode());
            }
        }
    }


    @FullNameProcessorGeneratorAnnotation
    public String generateFullNameProcessor(LinkedList<String> stringList) {
        for (String e : stringList) {
            processorVersion.append(e);
        }
        return processorVersion.toString();
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws FileNotFoundException {
        try {
            informationScanner = new Scanner(file);
            while (informationScanner.hasNext()) {
                processorVersion.append(informationScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            informationScanner.close();
        }

    }
}
