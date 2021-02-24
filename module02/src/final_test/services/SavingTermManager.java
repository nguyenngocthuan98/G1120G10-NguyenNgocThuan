package final_test.services;

import final_test.commons.FuncReadWrite;
import final_test.models.SavingTerm;

import java.util.ArrayList;
import java.util.List;

public class SavingTermManager implements IService<SavingTerm> {
    private static FuncReadWrite<SavingTerm> funcReadWrite = new FuncReadWrite<>();

    @Override
    public List<SavingTerm> findAll() {
        return null;
    }

    @Override
    public SavingTerm findById(String id) {
        return null;
    }

    @Override
    public void add(SavingTerm savingTerm) {
        List<SavingTerm> list = new ArrayList<>();
        list.add(savingTerm);
        funcReadWrite.writeFile("shortTerm.csv", list, true);
    }

    @Override
    public void edit(SavingTerm savingTerm, String id) {

    }

    @Override
    public void delete(String id) {

    }
}
