package final_test.services;

import final_test.commons.FuncReadWrite;
import final_test.models.SavingUnlimited;

import java.util.ArrayList;
import java.util.List;

public class SavingUnlimitedManager implements IService<SavingUnlimited> {
    private static final FuncReadWrite<SavingUnlimited> funcReadWrite = new FuncReadWrite<>();

    @Override
    public List<SavingUnlimited> findAll() {
        return null;
    }

    @Override
    public SavingUnlimited findById(String id) {
        return null;
    }

    @Override
    public void add(SavingUnlimited savingUnlimited) {
        List<SavingUnlimited> list = new ArrayList<>();
        list.add(savingUnlimited);
        funcReadWrite.writeFile("shortTerm.csv", list, true);
    }

    @Override
    public void edit(SavingUnlimited savingUnlimited, String id) {

    }

    @Override
    public void delete(String id) {

    }
}
