import model.Faculty;

import java.util.ArrayList;

public class DataManager {

    private ArrayList<Faculty> faculties;

    public DataManager(ArrayList<Faculty> faculties) {
        this.faculties = faculties;
    }

    public ArrayList<Faculty> getFaculties() {
        return faculties;
    }
}
