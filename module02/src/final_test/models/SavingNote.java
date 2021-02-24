package final_test.models;

public abstract class SavingNote {
    private String idSavingNote;
    private String idCustomer;
    private String dayOpen;
    private String daySaving;
    private double numberOfMoney;
    private float interestRate;

    public SavingNote() {
    }

    public SavingNote(String idSavingNote, String idCustomer, String dayOpen, String daySaving, double numberOfMoney,
                      float interestRate) {
        this.idSavingNote = idSavingNote;
        this.idCustomer = idCustomer;
        this.dayOpen = dayOpen;
        this.daySaving = daySaving;
        this.numberOfMoney = numberOfMoney;
        this.interestRate = interestRate;

    }

    public String getIdSavingNote() {
        return idSavingNote;
    }

    public void setIdSavingNote(String idSavingNote) {
        this.idSavingNote = idSavingNote;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getDayOpen() {
        return dayOpen;
    }

    public void setDayOpen(String dayOpen) {
        this.dayOpen = dayOpen;
    }

    public String getDaySaving() {
        return daySaving;
    }

    public void setDaySaving(String daySaving) {
        this.daySaving = daySaving;
    }

    public double getNumberOfMoney() {
        return numberOfMoney;
    }

    public void setNumberOfMoney(double numberOfMoney) {
        this.numberOfMoney = numberOfMoney;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }


    @Override
    public String toString() {
        return idSavingNote +
                ',' + idCustomer +
                ',' + dayOpen +
                ',' + daySaving +
                ',' + numberOfMoney +
                ',' + interestRate;
    }

    public abstract void showInfo();
}
