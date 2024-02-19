import java.util.*;

public class HashMarkov implements MarkovInterface {
	
	protected String[] myWords;		// Training text split into array of words 
	protected Random myRandom;		// Random number generator
	protected int myOrder;
    protected Map<WordGram, ArrayList<String>> hushmap;	// Length of WordGrams used
	


    public HashMarkov (){
        this(2);
    }
	public HashMarkov(int order) {
		myOrder = order;
        myRandom = new Random();
		hushmap = new HashMap<>();
	}

    @Override
	public void setTraining(String text){
		//hushmap = new HashMap<>();
		myWords = text.split("\\s+");
        hushmap.clear();
		for (int j = 0; j < myWords.length - myOrder; j++) {
			WordGram wg = new WordGram(myWords, j, myOrder);
			if(!hushmap.containsKey(wg)) {
				hushmap.put(wg, new ArrayList<>());
			}
			hushmap.get(wg).add(myWords[j+myOrder]);
			//wg = wg.add(myWords[j + myOrder]);
		}      
	}
	@Override
	public List<String> getFollows(WordGram wgram) {
	if (hushmap.containsKey(wgram)){
		return hushmap.get(wgram);
	}
	else {
		return new ArrayList<String>();
	}
	}

	@Override
	public String getRandomText(int length){
		ArrayList<String> randomWords = new ArrayList<>(length);
		int index = myRandom.nextInt(myWords.length - myOrder + 1);
		WordGram current = new WordGram(myWords,index,myOrder);
		randomWords.add(current.toString());

		for(int k=0; k < length-myOrder; k += 1) {
			String nextWord = getNext(current);
			randomWords.add(nextWord);
			current = current.shiftAdd(nextWord);
		}
		return String.join(" ", randomWords);
	}

	private String getNext(WordGram wgram) {
		List<String> follows = getFollows(wgram);
		if (follows.size() == 0) {
			int randomIndex = myRandom.nextInt(myWords.length);
			return myWords[randomIndex];
		}
		else {
			int randomIndex = myRandom.nextInt(follows.size());
			return follows.get(randomIndex);
		}
	}
	@Override
	public int getOrder() {
		return myOrder;
	}

	@Override
	public void setSeed(long seed) {
		myRandom.setSeed(seed);
	}



}