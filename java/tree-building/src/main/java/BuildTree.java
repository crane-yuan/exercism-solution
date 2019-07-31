import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class BuildTree {

    TreeNode buildTree(ArrayList<Record> records) throws InvalidRecordsException {

        if (records.isEmpty()) {
            return null;
        }

        List<Record> sortedRecords = records.stream()
                                            .sorted(Comparator.comparing(Record::getRecordId))
                                            .collect(Collectors.toList());

        if (IntStream.range(0, sortedRecords.size())
                     .anyMatch(i -> sortedRecords.get(i)
                                                 .getRecordId() != i || sortedRecords.get(i)
                                                                                     .getRecordId() < sortedRecords.get(i)
                                                                                                                   .getParentId())) {
            throw new InvalidRecordsException("Invalid Records");
        }
        Map<Integer, TreeNode> idToTreeNode = new HashMap<>();
        for (Record record : sortedRecords) {
            TreeNode cur = findTreeNode(idToTreeNode, record.getRecordId());
            TreeNode parent = findTreeNode(idToTreeNode, record.getParentId());

            if (record.getRecordId() != record.getParentId()) {
                parent.getChildren()
                      .add(cur);
            }

        }

        return idToTreeNode.get(0);
    }

    private static TreeNode findTreeNode(Map<Integer, TreeNode> idToTreeNode, Integer id) {
        if (!idToTreeNode.containsKey(id)) {
            idToTreeNode.put(id, new TreeNode(id));
        }
        return idToTreeNode.get(id);
    }

}
