package final_test.models;

public class SavingLongTerm extends SavingNote {
    private String period;
    private String offers;

    public SavingLongTerm() {
    }

    public SavingLongTerm(String idSavingNote, String idCustomer, String dayOpen, String daySaving,
                          double numberOfMoney, float interestRate, String period, String offers) {
        super(idSavingNote, idCustomer, dayOpen, daySaving, numberOfMoney, interestRate);
        this.period = period;
        this.offers = offers;
    }

    public SavingLongTerm(String[] savinglongtermInfo) {
        super(savinglongtermInfo[0], savinglongtermInfo[1], savinglongtermInfo[2],
                savinglongtermInfo[3],Double.parseDouble(savinglongtermInfo[4]),Float.parseFloat(savinglongtermInfo[5]));
        this.period = savinglongtermInfo[6];
        this.offers = savinglongtermInfo[7];
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getOffers() {
        return offers;
    }

    public void setOffers(String offers) {
        this.offers = offers;
    }

    @Override
    public String toString() {
        return super.toString() +
                ',' + period +
                ',' + offers;
    }

    @Override
    public void showInfo() {
        System.out.println("SavingLongTerm{" +
                        "SavingNote{" +
                        "idSavingNote='" + super.getIdSavingNote() + '\'' +
                        ", idCustomer='" + super.getIdCustomer() + '\'' +
                        ", dayOpen='" + super.getDayOpen() + '\'' +
                        ", daySaving='" + super.getDaySaving() + '\'' +
                        ", numberOfMoney=" + super.getNumberOfMoney() + '\'' +
                        ", interestRate=" + super.getInterestRate() + '\'' +
                        ", period='" + getPeriod() + '\'' +
                        ", offers='" + getOffers() + '\'' +
                        '}');
    }
}
