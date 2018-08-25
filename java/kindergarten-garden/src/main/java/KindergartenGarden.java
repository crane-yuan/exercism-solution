import java.util.ArrayList;
import java.util.List;

class KindergartenGarden {

    private String garden;
    private List<char[]> plantList = new ArrayList<>();
    private static final List<String[]> STUDENT_LIST = new ArrayList<>();
    private static final String _students = "Alice,Bob,Charlie,David\n" + "Eve,Fred,Ginny,Harriet\n" + "Ileana,Joseph,Kincaid,Larry";

    static {
        String[] lines = _students.split("\n");
        for (String line : lines) {
            STUDENT_LIST.add(line.split(","));
        }
    }

    KindergartenGarden(String garden) {
        this.garden = garden;

    }

    List<Plant> getPlantsOfStudent(String student) {
        List<Plant> result = new ArrayList<>();
        if (plantList.isEmpty()) {
            String[] lines = garden.split("\n");
            for (String line : lines) {
                plantList.add(line.toCharArray());
            }
        }
        int index = getColumnIndex(student) * 2;
        char[] line1 = plantList.get(0);
        char[] line2 = plantList.get(1);
        result.add(Plant.getPlant(line1[index]));
        result.add(Plant.getPlant(line1[index + 1]));
        result.add(Plant.getPlant(line2[index]));
        result.add(Plant.getPlant(line2[index + 1]));

        return result;
    }

    private int getColumnIndex(String student) {
        int index = 0;
        for (int i = 0; i < STUDENT_LIST.size(); i++) {
            String[] row = STUDENT_LIST.get(i);
            for (int j = 0; j < row.length; j++) {
                if (student.equals(row[j])) {
                    index = i * row.length + j;
                }
            }
        }
        return index;
    }

}
