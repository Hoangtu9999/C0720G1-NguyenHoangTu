package models;

public class AccompaniedService {
    private String nameAccompanied;
    private String unit;
    private int priceAccompanied;

    public AccompaniedService(String nameAccompanied, String unit, int priceAccompanied) {
        this.nameAccompanied = nameAccompanied;
        this.unit = unit;
        this.priceAccompanied = priceAccompanied;
    }

    public AccompaniedService() {
    }

    public String getNameAccompanied() {
        return nameAccompanied;
    }

    public void setNameAccompanied(String nameAccompanied) {
        this.nameAccompanied = nameAccompanied;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getPriceAccompanied() {
        return priceAccompanied;
    }

    public void setPriceAccompanied(int priceAccompanied) {
        this.priceAccompanied = priceAccompanied;
    }

    @Override
    public String toString() {
        return "NameAccompanied : " + nameAccompanied + "\n" +
                "Unit : " + unit + "\n" +
                "PriceAccompanied : " + priceAccompanied + "\n" ;
    }
}
