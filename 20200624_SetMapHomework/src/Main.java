import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Set method 1
        List<String> input = Arrays.asList("Ivan", "Maria", "Piotr", "Anna", "Maria", "Ivan");
        System.out.println(removeDuplicates(input));

        // Set method 2
        System.out.println(getDuplicates(input));

        // Map method 1
        Map <String, String> map = new LinkedHashMap<>();
        map.put("a", "hi");
        map.put("b", "there");
        System.out.println(mergeMapValues(map));

        // Map method 2
        String[] strings = {"a", "b", "a", "b", "c"};
        System.out.println(wordMultiple(strings));

        // Map method 3 Anagram
        String[] names = {"anna", "naan", "nana", "ivan", "vani", "piotr", "navi"};
        //System.out.println(createMapKeys(names));
        System.out.println(findAnagram(names, "ivan"));

        // Map method 4
        System.out.println(getCountOfNames(input, "Maria"));
        System.out.println(getCountOfNames2(input, "Ivan"));

        // Map method 5
        String text = "create words, a list of words, by splitting the input by whitespace\n" +
                "for every word, strip out whitespace and punctuation -on the left and the right.";
        System.out.println(getMostOccurrentWord(text));
    }

    // Set method 1
    private static Set<String> removeDuplicates(List<String> input){
        return new LinkedHashSet<>(input);
    }

    // Set method 2
    private static Set<String> getDuplicates (List<String> input) {
        Set<String> uniqueList = new LinkedHashSet<>();
        Set<String> duplicatesList = new LinkedHashSet<>();
        for (String str : input) {
            if (!uniqueList.add(str)){
                duplicatesList.add(str);
            }
        }
        return duplicatesList;
    }

    // Map method 1 - AB
    private static Map<String,String> mergeMapValues(Map<String,String> map){
        Map<String,String> mergedMap = new LinkedHashMap<>();
        if(map.containsKey("a")){
            mergedMap.put("a", map.get("a"));
        }
        if(map.containsKey("a") && map.containsKey("b")){
            mergedMap.put("ab", map.get("a") + map.get("b"));
        }
        if(map.containsKey("b")){
            mergedMap.put("b", map.get("b"));
        }
        return mergedMap;
    }

    // Map metod 2 - boolean
    private static Map<String,Boolean> wordMultiple (String[] strings){
        Map<String,Boolean> res = new HashMap<>();
        for (String s: strings) {
            res.computeIfPresent(s, (key, value) -> true);
            res.computeIfAbsent(s, string -> false);
        }
        return res;
    }

    // Map method 3 - Anagrams
    private static String getSortedChars(String string) {
        char[] charArr = string.toCharArray();
        Arrays.sort(charArr);
        return new String(charArr);
    }

    private static Map<String,List<String>> findAnagram(String[] anagrams, String name) {
        List<String> namesList = new ArrayList<>();
        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String str : anagrams) {
            if (getSortedChars(str).equals(getSortedChars(name))) {
                namesList.add(str);
            }
        }
        anagramMap.put(name, namesList.subList(1, namesList.size()));
        return anagramMap;
    }

//    private static HashMap<String,String> createMapKeys(String[] str) {
//        HashMap<String,String> map = new HashMap<>();
//        for (String string : str) {
//            if (map.containsKey(string)) {
//                String count = map.get(string);
//                map.put(string, count + 1);
//            } else
//                map.put(string, "0");
//        }
//        return map;
//    }

    // Map method 4
    private static int getCountOfNames(List<String> names, String name){
        int occurrences = Collections.frequency(names, name);
        return occurrences;
    }

    private static int getCountOfNames2(List<String> names, String name){
        Map<String,Integer> frequencyMap = new HashMap<>();
        //int occurrences = 0;
        for (int i = 0; i < names.size(); i++) {
            String currName = names.get(i);
            if (frequencyMap.containsKey(currName)) {
                frequencyMap.put(currName, frequencyMap.get(currName)+1);
                //occurrences++;
            } else {
                frequencyMap.put(currName, 1);
            }
        }
        return frequencyMap.get(name);
    }

    // Map method 5
    private static Map<String ,Integer> getMostOccurrentWord(String text){
        Map<String,Integer> wordCountMap = new HashMap<>();
        // 1 - replace all signs with space
        System.out.println("before: " + text);
        String nextText = text.replace(",", " ").replace(".", " ")
                .replace("-", " ").replace("  ", " ");
        System.out.println("after: " + nextText);

        // 2 - get all words from text (String => String[])
        String[] splitedText = nextText.toLowerCase().split(" ");

        // 3 - make map with all words and occurrences
        for (String string : splitedText) {
            if (wordCountMap.containsKey(string)) {
                wordCountMap.put(string, wordCountMap.get(string) + 1);
            } else {
                wordCountMap.put(string, 1);
            }
        }

        // 4 - find the biggest number and return a word associated
        Map<String ,Integer> map = new HashMap<>();
        String mostRepeatedWord = null;
        int count = 0;
        Set<Map.Entry<String, Integer>> entrySet = wordCountMap.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            if(entry.getValue() > count && entry.getKey().length() > 3) {
                mostRepeatedWord = entry.getKey();
                count = entry.getValue();
            }
        }
        map.put(mostRepeatedWord, count);
        return map;
    }
}
