import java.util.*;

/**
 * MSInterviewSolution
 *
 * @author black
 * @date 2019-07-24
 */
public class MSInterviewSolution {

    public static void main(String[] args) {
        CLICompletion cliCompletion = new CLICompletion();
        cliCompletion.init(Arrays.asList("az vm create", "az webapp config"));
        List<Character> characters = Arrays.asList('a', 'z', ' ', 'v', 'c');
        for (Character character : characters) {
            List<String> results = cliCompletion.getOptions(character);
            for (String result : results) {
                System.out.println(result);
            }
        }

    }

    public static class TrieTree {
        public HashMap<Character, TrieTree> node;
        public TrieTree() {
            node = new HashMap<Character, TrieTree>();
        }
    }

    public static class CLICompletion {

        private TrieTree tree;
        private TrieTree currentNode;
        private String prefix;

        public void init(List<String> commands) {
            if (commands != null && commands.size() > 0) {
                tree = new TrieTree();
                for (String command : commands) {
                    addWord(command, tree);
                }
            }
        }

        public List<String> getOptions(Character input) {
            List<String> result = new ArrayList<String>();
            if (currentNode == null) {
                currentNode = tree;
                prefix = "";
            }
            if (!currentNode.node.containsKey(input)) {
                return result;
            } else {
                prefix = prefix + input;
                result = appendCommand(prefix, currentNode.node.get(input));
                currentNode = currentNode.node.get(input);
                return result;
            }
        }

        private List<String> appendCommand(String prefix, TrieTree next) {
            List<String> list = new ArrayList(next.node.size());
            if (next.node.size() == 0) {
                list.add(prefix);
            } else {
                for (Map.Entry<Character, TrieTree> entry : next.node.entrySet()) {
                    prefix = prefix + entry.getKey();
                    List<String> currentList = appendCommand(prefix, entry.getValue());
                    if (currentList.size() > 0) {
                        list.addAll(currentList);
                    }
                }
            }
            return list;
        }

        private void addWord(String command, TrieTree tree) {
            if (command != null && command.length() > 0) {
                for (int i = 0; i < command.length(); i++) {
                    Character ch = command.charAt(i);
                    if (!tree.node.containsKey(ch)) {
                        tree.node.put(ch, new TrieTree());
                    }
                    tree = tree.node.get(ch);
                }
            }
        }
    }
}
