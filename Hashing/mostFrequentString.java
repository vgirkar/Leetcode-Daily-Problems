// Given a dictionary with strings as keys and lists of strings as values, return the most frequent string from all lists.
// If there's a tie, return any of the most frequent strings.

// Example: Input:

// python
// Copy code
// d = {"a": ["apple", "banana"], "b": ["apple", "orange", "banana"]}
// Output: "apple"




import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class mostFrequentString {

    public static String mostFrequentString(Map<String, List<String>> dictionary){
        // HashMap to store the frequency of each String
        HashMap<String, Integer> frequencyMap = new HashMap<>();

        //Traverse each list in the dictionary
        for(Map.Entry<String, List<String>> entry : dictionary.entrySet()){
            List<String> list = entry.getValue();
            for(String str: list){
                //Count the occurrences of each string
                frequencyMap.put(str, frequencyMap.getOrDefault(str, 0) + 1);
            }
        }

        //Find the most frequent string
        String mostFrequent = "";
        int maxCount = 0;
        for(Map.Entry<String, Integer> entry : frequencyMap.entrySet()){
            if(entry.getValue() > maxCount){
                maxCount = entry.getValue();
                mostFrequent = entry.getKey();
            }
        }
        return mostFrequent;
    }
    public static void main(String[] args){
        Map<String, List<String>> dictionary = Map.of(
            "key", List.of("apple", "banana", "apple"),
            "key2", List.of("banana", "orange", "apple"),
            "key3", List.of("banana", "banana", "orange")
        );

        //Calling the method to find the most frequent String
        String result = mostFrequentString(dictionary);

        System.out.println("Most Frequent String: "+ result);
    }
    
}
