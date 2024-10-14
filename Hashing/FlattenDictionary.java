// Given:

// let test = {
//         "Key1" : "1",
//         "Key2" : {
//                   "a" : "2",
//                   "b" : "3",
//                   "c" : {
//                           "d" : {"x":{"y": "10"}},
//                           "e" : "1"
//                          }
//                    }
//              }
// Write a function that yields:

//      {'Key1': '1', 
//       'Key2.a': '2', 
//       'Key2.b': '3', 
//       'Key2.c.d.x.y': '10',   
//       'Key2.c.e': '1' }

import java.util.HashMap;
import java.util.Map;

public class FlattenDictionary {
    // Update method signature to Map<String, Object> instead of Map<String, String>
    public static Map<String, String> flattenMap(Map<String, Object> map) {
        Map<String, String> flatMap = new HashMap<>();
        flatten("", map, flatMap);  // Pass map of type Map<String, Object>
        return flatMap;
    }

    // Update the method signature to accept Map<String, Object> as input
    private static void flatten(String prefix, Map<String, Object> map, Map<String, String> flatMap) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String newKey = prefix.isEmpty() ? entry.getKey() : prefix + "." + entry.getKey();
            if (entry.getValue() instanceof Map) {
                // Recursively flatten the nested map
                flatten(newKey, (Map<String, Object>) entry.getValue(), flatMap);
            } else {
                // Add flattened key and value to flatMap
                flatMap.put(newKey, entry.getValue().toString());
            }
        }
    }

    public static void main(String[] args) {
        Map<String, Object> test = new HashMap<>(); // Update to Map<String, Object>
        test.put("Key1", "1");

        Map<String, Object> key2 = new HashMap<>();
        key2.put("a", "2");
        key2.put("b", "3");

        Map<String, Object> c = new HashMap<>();
        Map<String, Object> d = new HashMap<>();
        Map<String, Object> x = new HashMap<>();
        x.put("y", "10");
        d.put("x", x);
        c.put("d", d);
        c.put("e", 1);  // Use integer for "e"

        key2.put("c", c);
        test.put("Key2", key2);

        // Flatten the map
        Map<String, String> result = flattenMap(test);

        // Print the result
        System.out.println(result);
    }
}
