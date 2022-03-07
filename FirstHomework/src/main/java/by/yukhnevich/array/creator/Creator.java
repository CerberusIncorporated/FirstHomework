package by.yukhnevich.array.creator;

import by.yukhnevich.array.entity.CustomArray;
import by.yukhnevich.array.exception.CustomArrayException;
import by.yukhnevich.array.parser.impl.CustomParserImplement;
import by.yukhnevich.array.reader.impl.CustomReaderImplement;
import by.yukhnevich.array.util.IdGenerator;
import by.yukhnevich.array.validation.fileValidation.RegexValidation;

import java.util.ArrayList;
import java.util.List;

public class Creator {
    private final CustomReaderImplement reader = new CustomReaderImplement();
    private final CustomParserImplement parser = new CustomParserImplement();
    private final RegexValidation validation = new RegexValidation();


    public CustomArray createEntity(String path) throws CustomArrayException {
        List<String> list = reader.readFromFile(path);

        List<String> correctList = new ArrayList<>();
        for (String string : list) {
            if (validation.validateRegex(string)) {
                correctList.add(string);
            }
        }
        if (correctList.isEmpty()) {
            throw new CustomArrayException("The are no strings according to the pattern in the file");
        }
        String firstCorrectString = correctList.get(0);

        int[] array = parser.parse(firstCorrectString);

        return new CustomArray(IdGenerator.generateId(),array); 
    }

}
