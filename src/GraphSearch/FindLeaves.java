package GraphSearch;

import java.util.*;

public class FindLeaves {

    public static void printLeaves(char[][] tempChar) {
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, List<Character>> parentToLeavesMapping = new HashMap<>();


        Set<Character> parentNodes = new HashSet<>();
        for (int i = 0; i < tempChar.length; i++) {
            parentNodes.add(tempChar[i][0]);
        }

        for (int i = 0; i < tempChar.length; i++) {
            char firstChar = tempChar[i][0];
            char secondChar = tempChar[i][1];
            Set<Character> adjNodes = map.getOrDefault(firstChar, new HashSet<Character>());
            adjNodes.add(secondChar);
            map.put(firstChar, adjNodes);
            parentNodes.remove(secondChar);
        }


        for (char parent : parentNodes) {
            List<Character> childNodes = new ArrayList<>();
            dfs(parent, map, childNodes, new HashSet<>());
            parentToLeavesMapping.put(parent, childNodes);
        }

        for (char parents : parentToLeavesMapping.keySet()) {
            System.out.println(parents + " " + parentToLeavesMapping.get(parents));
        }
    }

    static void dfs(char parent, Map<Character, Set<Character>> map, List<Character> adjNodes, Set<Character> visited) {
        if (!map.containsKey(parent)) {
            adjNodes.add(parent);
            return;
        } else {
            for (char child : map.getOrDefault(parent, new HashSet<Character>())) {

                if (!visited.contains(child)) {
                    visited.add(child);
                    dfs(child, map, adjNodes, visited);
                }
            }
        }

        List<StringBuilder> temp = new ArrayList<>();

    }


    public static void main(String[] args) {

        char[][] tmpChar = {{'A', 'B'}, {'A', 'C'}, {'B', 'K'}, {'C', 'K'}, {'E', 'L'}, {'F', 'G'}, {'J', 'M'}, {'E', 'F'}, {'G', 'H'}, {'G', 'I'}};
        printLeaves(tmpChar);

        System.out.println(3 % 4);

    }
}
