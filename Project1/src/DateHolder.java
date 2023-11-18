import java.util.ArrayList;

public class DateHolder {

    private final ArrayList<Week> TRAVEL_WEEKS;
    private final Month MAY;
    private final Month JUNE;
    private final Month JULY;
    private final Month AUGUST;

    public DateHolder() {
        this.TRAVEL_WEEKS = new ArrayList<>();
        MAY = new Month("May",31);
        JUNE = new Month("June", 30);
        JULY = new Month("July", 31);
        AUGUST = new Month("August", 15);
    }

    public ArrayList<Week> getTRAVEL_WEEKS() {
        return TRAVEL_WEEKS;
    }

    public void fillTravelWeeks() {
        int carryOverDay = 1;

        for(int i = 1; i <= MAY.getNUMBER_OF_DAYS(); i++){
            int leaveDate = i;
            int returnDate = i + 7;

            String firstMonth = MAY.getNAME();
            String secondMonth = MAY.getNAME();

            if(returnDate > MAY.getNUMBER_OF_DAYS()){
                secondMonth = JUNE.getNAME();
                returnDate = carryOverDay;
                carryOverDay++;
            }

            TRAVEL_WEEKS.add(new Week(firstMonth, secondMonth, leaveDate, returnDate));
        }

        carryOverDay = 1;

        for(int i = 1; i <= JUNE.getNUMBER_OF_DAYS(); i++){
            int leaveDate = i;
            int returnDate = i + 7;

            String firstMonth = JUNE.getNAME();
            String secondMonth = JUNE.getNAME();

            if(returnDate > JUNE.getNUMBER_OF_DAYS()){
                secondMonth = JULY.getNAME();
                returnDate = carryOverDay;
                carryOverDay++;
            }

            TRAVEL_WEEKS.add(new Week(firstMonth, secondMonth, leaveDate, returnDate));
        }

        carryOverDay = 1;

        for(int i = 1; i <= JULY.getNUMBER_OF_DAYS(); i++){
            int leaveDate = i;
            int returnDate = i + 7;

            String firstMonth = JULY.getNAME();
            String secondMonth = JULY.getNAME();

            if(returnDate > JULY.getNUMBER_OF_DAYS()){
                secondMonth = AUGUST.getNAME();
                returnDate = carryOverDay;
                carryOverDay++;
            }

            TRAVEL_WEEKS.add(new Week(firstMonth, secondMonth, leaveDate, returnDate));
        }

        carryOverDay = 1;

        for(int i = 1; i <= AUGUST.getNUMBER_OF_DAYS() - 7; i++){
            int leaveDate = i;
            int returnDate = i + 7;

            String firstMonth = AUGUST.getNAME();
            String secondMonth = AUGUST.getNAME();

            if(returnDate > AUGUST.getNUMBER_OF_DAYS()){
                secondMonth = AUGUST.getNAME();
                returnDate = carryOverDay;
                carryOverDay++;
            }

            TRAVEL_WEEKS.add(new Week(firstMonth, secondMonth, leaveDate, returnDate));
        }




// Leaving this here to remind myself to think for a bit before hardcoding
//        this.travelWeeks.add(new Week("May","May",1,8));
//        this.travelWeeks.add(new Week("May","May",2,9));
//        this.travelWeeks.add(new Week("May","May",3,10));
//        this.travelWeeks.add(new Week("May","May",4,11));
//        this.travelWeeks.add(new Week("May","May",5,12));
//        this.travelWeeks.add(new Week("May","May",6,13));
//        this.travelWeeks.add(new Week("May","May",7,14));
//        this.travelWeeks.add(new Week("May","May",8,15));
//        this.travelWeeks.add(new Week("May","May",9,16));
//        this.travelWeeks.add(new Week("May","May",10,17));
//        this.travelWeeks.add(new Week("May","May",11,18));
//        this.travelWeeks.add(new Week("May","May",12,19));
//        this.travelWeeks.add(new Week("May","May",13,20));
//        this.travelWeeks.add(new Week("May","May",14,21));
//        this.travelWeeks.add(new Week("May","May",15,22));
//        this.travelWeeks.add(new Week("May","May",16,23));
//        this.travelWeeks.add(new Week("May","May",17,24));
//        this.travelWeeks.add(new Week("May","May",18,25));
//        this.travelWeeks.add(new Week("May","May",19,26));
//        this.travelWeeks.add(new Week("May","May",20,27));
//        this.travelWeeks.add(new Week("May","May",21,28));
//        this.travelWeeks.add(new Week("May","May",22,29));
//        this.travelWeeks.add(new Week("May","May",23,30));
//        this.travelWeeks.add(new Week("May","May",24,31));
//        this.travelWeeks.add(new Week("May","June",25,1));
//        this.travelWeeks.add(new Week("May","June",26,2));
//        this.travelWeeks.add(new Week("May","June",27,3));
//        this.travelWeeks.add(new Week("May","June",28,4));
//        this.travelWeeks.add(new Week("May","June",29,5));
//        this.travelWeeks.add(new Week("May","June",30,6));
//        this.travelWeeks.add(new Week("May","June",31,7));
//        this.travelWeeks.add(new Week("June","June",1,8));
//        this.travelWeeks.add(new Week("June","June",2,9));
//        this.travelWeeks.add(new Week("June","June",3,10));
//        this.travelWeeks.add(new Week("June","June",4,11));
//        this.travelWeeks.add(new Week("June","June",5,12));
//        this.travelWeeks.add(new Week("June","June",6,13));
//        this.travelWeeks.add(new Week("June","June",7,14));
//        this.travelWeeks.add(new Week("June","June",8,15));
//        this.travelWeeks.add(new Week("June","June",9,16));
//        this.travelWeeks.add(new Week("June","June",10,17));
//        this.travelWeeks.add(new Week("June","June",11,18));
//        this.travelWeeks.add(new Week("June","June",12,19));
//        this.travelWeeks.add(new Week("June","June",13,20));
//        this.travelWeeks.add(new Week("June","June",14,21));
//        this.travelWeeks.add(new Week("June","June",1,8));

    }
    public void addWeek(String firstMonth, String secondMonth, int leaveDate, int returnDate) {
        TRAVEL_WEEKS.add(new Week(firstMonth, secondMonth, leaveDate, returnDate));
    }
}
