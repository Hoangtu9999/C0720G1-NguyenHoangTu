package models;

public class Room extends Services {
    private String freeServiceIncluded;
    private AccompaniedService accompaniedService;

    public Room(String id, String serviceName, double areaOfUse, int rentalCosts, int numberOfPeopleMax, String rentType, String freeServiceIncluded, AccompaniedService accompaniedService) {
        super(id, serviceName, areaOfUse, rentalCosts, numberOfPeopleMax, rentType);
        this.freeServiceIncluded = freeServiceIncluded;
        this.accompaniedService = accompaniedService;
    }

    public Room() {
    }

    public AccompaniedService getAccompaniedService() {
        return accompaniedService;
    }

    public void setAccompaniedService(AccompaniedService accompaniedService) {
        this.accompaniedService = accompaniedService;
    }

    public String getFreeServiceIncluded() {
        return freeServiceIncluded;
    }

    public void setFreeServiceIncluded(String freeServiceIncluded) {
        this.freeServiceIncluded = freeServiceIncluded;
    }

    @Override
    public String toString() {
        return super.toString() +
                "FreeServiceIncluded : " + freeServiceIncluded + "\n" +
                "AccompaniedService : " + accompaniedService ;
    }

    @Override
    public void showInfor() {
        System.out.println(this.toString());
    }
}
