package case_study.services;

import case_study.commons.FuncReadWrite;
import case_study.models.House;
import case_study.models.Villa;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class HouseManager implements CRUDServices<House> {
    static FuncReadWrite<House> funcReadWrite = new FuncReadWrite<>();

    @Override
    public void add(House house) {
        List<House> list = new ArrayList<>();
        list.add(house);
        funcReadWrite.writeFile("House.csv", list, true);
    }

    @Override
    public List<House> findAll() {
        List<String[]> list = funcReadWrite.readFile("House.csv");
        List<House> houseList = new ArrayList<>();
        for (String[] lines :  list){
            House house = new House(lines);
            houseList.add(house);
        }
        return houseList;
    }

    @Override
    public House findById(String id) {
        List<House> listHouse = findAll();
        for (House house : listHouse) {
            if (house.getIdService().equals(id)) {
                return house;
            }
        }
        return null;
    }

    @Override
    public void edit(House house, String id) {
        List<House> listHouse = findAll();
        int index = -1;
        for (int i = 0; i < listHouse.size(); i++) {
            if (listHouse.get(i).getIdService().equals(id)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            listHouse.remove(index);
            listHouse.add(index, house);
            funcReadWrite.writeFile("Villa.csv", listHouse, false);
        }
    }

    @Override
    public void delete(String id) {
        List<House> listHouse = findAll();
        House temp = findById(id);
        listHouse.remove(temp);
        funcReadWrite.writeFile("Villa.csv", listHouse, false);
    }

    public Set<String> findAllName() {
        List<House> housesList = findAll();
        Set<String> housesListName = new TreeSet<>();
        for (House house : housesList) {
            housesListName.add(house.getNameService());
        }
        return housesListName;
    }
}
