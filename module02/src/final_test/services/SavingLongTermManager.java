package final_test.services;

import final_test.commons.FuncReadWrite;
import final_test.models.SavingLongTerm;

import java.util.ArrayList;
import java.util.List;

public class SavingLongTermManager implements IService<SavingLongTerm>{
    private static FuncReadWrite<SavingLongTerm> funcReadWrite = new FuncReadWrite<>();

    @Override
    public List<SavingLongTerm> findAll() {
        return null;
    }

    @Override
    public SavingLongTerm findById(String id) {
        return null;
    }

    @Override
    public void add(SavingLongTerm savingLongTerm) {
        List<SavingLongTerm> list = new ArrayList<>();
        list.add(savingLongTerm);
        funcReadWrite.writeFile("longTerm.csv", list, true);
    }

    @Override
    public void edit(SavingLongTerm savingLongTerm, String id) {

    }

    @Override
    public void delete(String id) {

    }
}
