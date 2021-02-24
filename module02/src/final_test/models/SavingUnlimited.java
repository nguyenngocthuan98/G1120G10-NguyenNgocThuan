package final_test.models;

public class SavingUnlimited extends SavingNote {

    public SavingUnlimited() {
    }

    public SavingUnlimited(String idSavingNote, String idCustomer, String dayOpen, String daySaving,
                           double numberOfMoney, float interestRate) {
        super(idSavingNote, idCustomer, dayOpen, daySaving, numberOfMoney, interestRate);
    }

    public SavingUnlimited(String[] savingUnlimitedInfo) {
        super(savingUnlimitedInfo[0], savingUnlimitedInfo[1], savingUnlimitedInfo[2],
                savingUnlimitedInfo[3],Double.parseDouble(savingUnlimitedInfo[4]),Float.parseFloat(savingUnlimitedInfo[5]));
    }

    @Override
    public void showInfo() {
        System.out.println("SavingUnlimited{" +
                "SavingNote{" +
                "idSavingNote='" + super.getIdSavingNote() + '\'' +
                ", idCustomer='" + super.getIdCustomer() + '\'' +
                ", dayOpen='" + super.getDayOpen() + '\'' +
                ", daySaving='" + super.getDaySaving() + '\'' +
                ", numberOfMoney=" + super.getNumberOfMoney() + '\'' +
                ", interestRate=" + super.getInterestRate() + '\'' +
                '}');
    }
}
