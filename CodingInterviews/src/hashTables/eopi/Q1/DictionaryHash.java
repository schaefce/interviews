package eopi.hashTables.Q1;

/* Design a hash function that is suitable for words in a dictionary */
public class DictionaryHash {
    /* Horner's method */
    // TODO:
    public static int hash(String key, int M) {
        int val = 0;
        int base = 997;
        for (char c : key.toCharArray()) {
            val = (val * base + c) % M;
        }
        return val;
    }
}
