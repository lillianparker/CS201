import java.util.*;

public class HashListAutocomplete implements Autocompletor {

    private static final int MAX_PREFIX = 10;
    private Map<String, List<Term>> myMap;
    private int mySize;

    public HashListAutocomplete(String[] terms, double[] weights) {
        if (terms == null || weights == null) {
			throw new NullPointerException();
		}
        
        if (terms.length != weights.length) {
            throw new IllegalArgumentException();    
    }
    initialize(terms,weights);
}


    

    @Override
    public List<Term> topMatches(String prefix, int k) {
        if(!myMap.containsKey(prefix)) return new ArrayList<>();
        if(prefix.length() > MAX_PREFIX) {
            prefix = prefix.substring(0, MAX_PREFIX);
        }
        List<Term> all = myMap.get(prefix);
        return myMap.get(prefix).subList(0, Math.min(k, all.size()));
    }


    @Override
    public void initialize(String[] terms, double[] weights) {
        // creates the hashmap of all prefixes
    
        myMap = new HashMap<String, List<Term>>();

        for (int j =0; j < terms.length; j++) {
            String word = terms[j];
            double weight = weights[j];
            int highest = Math.min(word.length(), MAX_PREFIX);
            Term term = new Term(word, weight);

            for (int i = 0; i <= highest; i++){
                String pre = terms[j].substring(0,i);
                myMap.putIfAbsent(pre, new ArrayList<>());
                myMap.get(pre).add(term);
            }
        }
        for (String prefix : myMap.keySet()) {
            Collections.sort(myMap.get(prefix), Comparator.comparing(Term::getWeight).reversed());
        }
        
    }

    @Override
    public int sizeInBytes() {
        int mySize = 0;

        HashSet<Term> terms = neAw HashSet<>();

        for(String key: myMap.keySet()) {
            mySize += BYTES_PER_CHAR*key.length();
            terms.addAll(myMap.get(key));
        }
        for(Term term: terms) {
            mySize += BYTES_PER_CHAR*term.getWord().length() + BYTES_PER_DOUBLE;
        }
        return mySize;
    }
    
}

