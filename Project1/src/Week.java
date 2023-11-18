public class Week {

    private final String FIRST_MONTH;
    private final String SECOND_MONTH;
    private final int FIRST_DAY;
    private final int SECOND_DAY;

    public Week(String FIRST_MONTH, String SECOND_MONTH, int FIRST_DAY, int SECOND_DAY) {
        this.FIRST_MONTH = FIRST_MONTH;
        this.SECOND_MONTH = SECOND_MONTH;
        this.FIRST_DAY = FIRST_DAY;
        this.SECOND_DAY = SECOND_DAY;
    }

    public String getFIRST_MONTH() {
        return FIRST_MONTH;
    }

    public String getSECOND_MONTH() {
        return SECOND_MONTH;
    }

    public int getFIRST_DAY() {
        return FIRST_DAY;
    }

    public int getSECOND_DAY() {
        return SECOND_DAY;
    }

    @Override
    public String toString() {
        return "Week from " + FIRST_MONTH + " " + FIRST_DAY + " to " + SECOND_MONTH + " " + SECOND_DAY;
    }
}
