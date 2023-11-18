public class Flight {

    private final String AIRLINE;
    private final String DEPARTURE_CITY;
    private final String ARRIVAL_CITY;
    private final String LEAVING_DATE;
    private final String RETURN_DATE;
    private final boolean NONSTOP;
    private final String PRICE;

    public Flight(String AIRLINE, String DEPARTURE_CITY, String ARRIVAL_CITY, String LEAVING_DATE, String RETURN_DATE, boolean NONSTOP, String PRICE) {
        this.AIRLINE = AIRLINE;
        this.DEPARTURE_CITY = DEPARTURE_CITY;
        this.ARRIVAL_CITY = ARRIVAL_CITY;
        this.LEAVING_DATE = LEAVING_DATE;
        this.RETURN_DATE = RETURN_DATE;
        this.NONSTOP = NONSTOP;
        this.PRICE = PRICE;
    }

    public String getAIRLINE() {
        return AIRLINE;
    }

    public String getDEPARTURE_CITY() {
        return DEPARTURE_CITY;
    }

    public String getARRIVAL_CITY() {
        return ARRIVAL_CITY;
    }

    public String getLEAVING_DATE() {
        return LEAVING_DATE;
    }

    public String getRETURN_DATE() {
        return RETURN_DATE;
    }

    public boolean isNONSTOP() {
        return NONSTOP;
    }

    public String getPRICE() {
        return PRICE;
    }

    @Override
    public String toString(){
        return "Airline: " + this.AIRLINE + "; Departure City: " + this.DEPARTURE_CITY + "; Destination: " + this.ARRIVAL_CITY + "; " +
                "Departure Date: " + this.LEAVING_DATE + "; Return Date: " + this.RETURN_DATE + "; Price: $" + this.PRICE + "; Nonstop: " + this.NONSTOP;
    }
}
