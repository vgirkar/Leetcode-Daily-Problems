// Problem Statement:
// Given a string word and a string abbr, determine if abbr is a valid abbreviation of word. 
// A valid abbreviation replaces any number of consecutive characters in word with their count. For example, 
// if word is "internationalization", "i12iz" is a valid abbreviation, which means "i" + "12" characters (which are "nternationaliz") + "z".

// The abbreviation abbr can only contain:

// Letters (which must match the corresponding letter in word),
// Digits (which represent the number of characters to skip in word).
// Input:
// word: A string representing the original word.
// abbr: A string representing the abbreviation.
// Output:
// Return true if abbr is a valid abbreviation of word, and false otherwise.
// Examples:
// Example 1:

// vbnet
// Copy code
// Input: word = "internationalization", abbr = "i12iz"
// Output: true
// Example 2:

// vbnet
// Copy code
// Input: word = "apple", abbr = "a2e"
// Output: true
// Example 3:

// vbnet
// Copy code
// Input: word = "apple", abbr = "a2e2"
// Output: false
// Example 4:

// vbnet
// Copy code
// Input: word = "a", abbr = "1"
// Output: false

//Time COmplexity= O(n + m);
//Space Complexity = O(1);


public class validWordAbbreviation {

    public static boolean validWordAbbreviation(String word, String abbr){
        int i = 0; // Pointer for word
        int j = 0; // Pointer for abbr
        while(i < word.length() && j < abbr.length()){
            if(Character.isDigit(abbr.charAt(j))){
                if(abbr.charAt(j) == '0') return false;
                int skip = 0;
                while(j < abbr.length() && Character.isDigit(abbr.charAt(j))){
                    skip = skip * 10 + (abbr.charAt(j) - '0');
                    j++;
                }
                i += skip;
            }
            else {
                if(i > word.length() && word.charAt(i) != abbr.charAt(j)){
                    return false;
                }
            }
            i++;
            j++;
        }
        return i == word.length() && j == abbr.length();
    }
    public static void main(String args[]){
        System.out.println(validWordAbbreviation("internationalization", "i12iz4n"));
        System.out.println(validWordAbbreviation("apple", "a2e"));
    }
    
}
