package by.yukhnevich.array.util;

public class IdGenerator {
    private static final int START_ID = 1;
    private static final int END_ID = 1000000;

    private static int idCounter;

    private IdGenerator() {
        idCounter = START_ID;
    }

    public static int generateId() {
        if (idCounter == END_ID) {
            idCounter = START_ID;
        }
        int id = idCounter;
        idCounter++;

        return id;
    }
}
