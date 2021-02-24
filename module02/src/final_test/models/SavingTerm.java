package final_test.models;

public class SavingTerm extends SavingNote {
    private String period;

    public SavingTerm() {
    }

    public SavingTerm(String idSavingNote, String idCustomer, String dayOpen, String daySaving,
                      double numberOfMoney, float interestRate, String period) {
        super(idSavingNote, idCustomer, dayOpen, daySaving, numberOfMoney, interestRate);
        this.period = period;
    }

    public SavingTerm(String[] savingtermInfo) {
        super(savingtermInfo[0], savingtermInfo[1], savingtermInfo[2],
                savingtermInfo[3],Double.parseDouble(savingtermInfo[4]),Float.parseFloat(savingtermInfo[5]));
        this.period = savingtermInfo[6];
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    @Override
    public void showInfo() {
        System.out.println("SavingTerm{" +
                "SavingNote{" +
                "idSavingNote='" + super.getIdSavingNote() + '\'' +
                ", idCustomer='" + super.getIdCustomer() + '\'' +
                ", dayOpen='" + super.getDayOpen() + '\'' +
                ", daySaving='" + super.getDaySaving() + '\'' +
                ", numberOfMoney=" + super.getNumberOfMoney() + '\'' +
                ", interestRate=" + super.getInterestRate() + '\'' +
                ", period='" + getPeriod() + '\'' +
                '}');
    }
}
