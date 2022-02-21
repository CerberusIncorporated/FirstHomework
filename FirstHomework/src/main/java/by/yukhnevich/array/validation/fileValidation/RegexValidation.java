package by.yukhnevich.array.validation.fileValidation;

import java.util.regex.Pattern;

public class RegexValidation {

    public boolean validateRegex(String string) {
        Pattern pattern = Pattern.compile("^-?\\d+(\\s+(-?\\d+))*$");
        return pattern.matcher(string).matches();
    }
}
