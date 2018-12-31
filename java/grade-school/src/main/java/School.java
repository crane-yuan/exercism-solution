import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class School {

    private Map<Integer, List<String>> gradeMap;

    public School() {
        this.gradeMap = new TreeMap<>();
    }

    public void add(String name, int grade) {
        List<String> nameList = this.gradeMap.get(grade);
        if (nameList == null) {
            nameList = new LinkedList<>();
        }
        nameList.add(name);
        this.gradeMap.put(grade, nameList);
    }

    public List<String> roster() {
        List<String> resultList = new LinkedList<>();
        for (Integer grade : this.gradeMap.keySet()) {
            resultList.addAll(grade(grade));
        }
        return resultList;
    }

    public List<String> grade(int grade) {
        List<String> nameList = this.gradeMap.get(grade);
        if (nameList == null) {
            return new ArrayList<>();
        }
        Collections.sort(nameList);
        return nameList;
    }
}
