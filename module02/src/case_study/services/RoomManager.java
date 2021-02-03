package case_study.services;

import case_study.commons.FuncReadWrite;
import case_study.models.House;
import case_study.models.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class RoomManager implements CRUDServices<Room> {
    static FuncReadWrite<Room> funcReadWrite = new FuncReadWrite<>();

    @Override
    public void add(Room room) {
        List<Room> list = new ArrayList<>();
        list.add(room);
        funcReadWrite.writeFile("Room.csv", list, true);
    }

    @Override
    public List<Room> findAll() {
        List<String[]> list = funcReadWrite.readFile("Room.csv");
        List<Room> roomList = new ArrayList<>();
        for (String[] lines : list) {
            Room room = new Room(lines);
            roomList.add(room);
        }
        return roomList;
    }

    @Override
    public Room findById(String id) {
        List<Room> listRoom = findAll();
        for (Room room : listRoom) {
            if (room.getIdService().equals(id)) {
                return room;
            }
        }
        return null;
    }

    @Override
    public void edit(Room room, String id) {
        List<Room> listRoom = findAll();
        int index = -1;
        for (int i = 0; i < listRoom.size(); i++) {
            if (listRoom.get(i).getIdService().equals(id)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            listRoom.remove(index);
            listRoom.add(index, room);
            funcReadWrite.writeFile("Room.csv", listRoom, false);
        }
    }

    @Override
    public void delete(String id) {
        List<Room> listRoom = findAll();
        Room temp = findById(id);
        listRoom.remove(temp);
        funcReadWrite.writeFile("Room.csv", listRoom, false);
    }

    public Set<String> findAllName() {
        List<Room> roomsList = findAll();
        Set<String> housesListName = new TreeSet<>();
        for (Room room : roomsList) {
            housesListName.add(room.getNameService());
        }
        return housesListName;
    }
}
