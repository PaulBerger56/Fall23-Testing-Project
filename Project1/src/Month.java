public class Month {

    private final String NAME;
    private final int NUMBER_OF_DAYS;

    public Month(String NAME, int NUMBER_OF_DAYS) {
        this.NAME = NAME;
        this.NUMBER_OF_DAYS = NUMBER_OF_DAYS;
    }

    public String getNAME() {
        return NAME;
    }

    public int getNUMBER_OF_DAYS() {
        return NUMBER_OF_DAYS;
    }
}
