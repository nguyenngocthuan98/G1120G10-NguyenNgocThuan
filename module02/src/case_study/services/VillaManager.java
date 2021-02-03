package case_study.services;

import case_study.commons.FuncReadWrite;
import case_study.models.Villa;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class VillaManager implements CRUDServices<Villa> {
    static FuncReadWrite<Villa> funcReadWrite = new FuncReadWrite<>();

    @Override
    public void add(Villa villa) {
        List<Villa> list = new ArrayList<>();
        list.add(villa);
        funcReadWrite.writeFile("Villa.csv", list, true);
    }

    @Override
    public List<Villa> findAll() {
        List<String[]> list = funcReadWrite.readFile("Villa.csv");
        List<Villa> villaList = new ArrayList<>();
        for (String[] lines : list) {
            Villa villa = new Villa(lines);
            villaList.add(villa);
        }
        return villaList;
    }

    @Override
    public Villa findById(String id) {
        List<Villa> listVilla = findAll();
        for (Villa villa : listVilla) {
            if (villa.getIdService().equals(id)) {
                return villa;
            }
        }
        return null;
    }

    @Override
    public void edit(Villa villa, String id) {
        List<Villa> listVilla = findAll();
        int index = -1;
        for (int i = 0; i < listVilla.size(); i++) {
            if (listVilla.get(i).getIdService().equals(id)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            listVilla.remove(index);
            listVilla.add(index, villa);
            funcReadWrite.writeFile("Villa.csv", listVilla, false);
        }
    }

    @Override
    public void delete(String id) {
        List<Villa> listVilla = findAll();
        Villa temp = findById(id);
        listVilla.remove(temp);
        funcReadWrite.writeFile("Villa.csv", listVilla, false);
    }

    public Set<String> findAllName() {
        List<Villa> villaList = findAll();
        Set<String> villaListName = new TreeSet<>();
        for (Villa villa : villaList) {
            villaListName.add(villa.getNameService());
        }
        return villaListName;
    }
}
