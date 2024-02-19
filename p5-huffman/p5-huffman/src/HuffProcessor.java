import java.util.PriorityQueue;
//import java.util.*;
/*
 * Authors: Lily Parker + Jack Erens
 * CS201
 */

/**
 * Although this class has a history of several years,
 * it is starting from a blank-slate, new and clean implementation
 * as of Fall 2018.
 * <P>
 * Changes include relying solely on a tree for header information
 * and including debug and bits read/written information
 * 
 * @author Ow	en Astrachan
 *
 * Revise
 */

public class HuffProcessor {

	private class HuffNode implements Comparable<HuffNode> {
		HuffNode left;
		HuffNode right;
		int value;
		int weight;

		public HuffNode(int val, int count) {
			value = val;
			weight = count;
		}
		public HuffNode(int val, int count, HuffNode ltree, HuffNode rtree) {
			value = val;
			weight = count;
			left = ltree;
			right = rtree;
		}

		public int compareTo(HuffNode o) {
			return weight - o.weight;
		}
	}

	public static final int BITS_PER_WORD = 8;
	public static final int BITS_PER_INT = 32;
	public static final int ALPH_SIZE = (1 << BITS_PER_WORD); 
	public static final int PSEUDO_EOF = ALPH_SIZE;
	public static final int HUFF_NUMBER = 0xface8200;
	public static final int HUFF_TREE  = HUFF_NUMBER | 1;

	private boolean myDebugging = false;
	
	public HuffProcessor() {
		this(false);
	}
	
	public HuffProcessor(boolean debug) {
		myDebugging = debug;
	}

	/**
	 * Compresses a file. Process must be reversible and loss-less.
	 *
	 * @param in
	 *            Buffered bit stream of the file to be compressed.
	 * @param out
	 *            Buffered bit stream writing to the output file.
	 */
	public void compress(BitInputStream in, BitOutputStream out){


		// foundational code maybe not finished
		int[] counts = getCounts(in);
		HuffNode root = makeTree(counts);
		in.reset();
		out.writeBits(BITS_PER_INT, HUFF_TREE);
		writeTree(root, out);
		String[] encodings = new String[ALPH_SIZE +1];
		makeEncodings(root, encodings, "");
		// now write compressed bits, converts string into bit-sequence
		//using parse.Int
		while (true) {
			//looks very similar to the while loop in decompress
			int val = in.readBits(BITS_PER_WORD);
			if (val == -1) {
				break;
			}
			String code = encodings[val];
			out.writeBits(code.length(), Integer.parseInt(code,2));

		}
		//accounts for pseudo_eof buffer
		String code = encodings[PSEUDO_EOF];
		out.writeBits(code.length(), Integer.parseInt(code,2));
		//close output file
		out.close();
	}

	private int[] getCounts(BitInputStream in) {
		//determines frequencies of each character (how many times
		//that bit chunk appears in "in"
		int[] counts = new int[ALPH_SIZE];
		while (true) {
			int value = in.readBits(BITS_PER_WORD);
			if (value == -1) {
				break;
			}
			counts[value] += 1;
		}
		return counts;
	}

	private HuffNode makeTree(int[] counts) {
		//makes tree using priority queue based off the weights found
		//in the above method
		PriorityQueue<HuffNode> pq = new PriorityQueue<>();
		for (int j =0; j <counts.length; j++) {
			if (counts[j] > 0){
				pq.add(new HuffNode(j, counts[j], null, null));
			}
			pq.add(new HuffNode(PSEUDO_EOF, 1, null, null));
		}
		while(pq.size()>1){
			HuffNode left = pq.remove();
			HuffNode right = pq.remove();
			HuffNode t = new HuffNode(0, left.weight+right.weight, left, right);
			pq.add(t);
		}
		HuffNode root = pq.remove();
		return root;
	}

	private void makeEncodings(HuffNode node, String[] encodings, String path) {
		//makes encodings based off the tree
		//populates string array so that you can find a characters
		//8-bit chunk encoding
		if (node == null) {
			return;
		}
		else if (node.left ==  null && node.right == null) {
			encodings[node.value] = path;
			return;
		}
		else {
			makeEncodings(node.left, encodings, path + "0");
			makeEncodings(node.right, encodings, path+"1");
		}
	}

	private void writeTree(HuffNode node, BitOutputStream out) {
		//implements helper method writeBits
		//writes the tree based off the bits (ex. internal vs leaf node)
		if (node == null) {
			return;
		}
		else if (node.left == null && node.left == null) {
			out.writeBits(1,1);
			out.writeBits(BITS_PER_WORD+1, node.value);
		}
		else {
			out.writeBits(1,0);
			writeTree(node.left, out);
			writeTree(node.right, out);
		}
		return;
	}

	/**
	 * Decompresses a file. Output file must be identical bit-by-bit to the
	 * original.
	 *
	 * @param in
	 *            Buffered bit stream of the file to be decompressed.
	 * @param out
	 *            Buffered bit stream writing to the output file.
	 */
	public void decompress(BitInputStream in, BitOutputStream out){
		//reads the 32-bit magic number to see if file is Huffman coded
		int bits = in.readBits(BITS_PER_INT);
		if (bits != HUFF_TREE) {
			throw new HuffException("invalid magic number "+bits);
		}
		//Read through tree to decompress (same tree that was used to 
		// compress)
		HuffNode root = readTree(in);
		HuffNode current = root;
		//reads remaining bits from "in"
		//traverses tree going left(0) or right(1)
		while (true) {
			int bitNum = in.readBits(1);
			if (bitNum == -1) {
				throw new HuffException("bad input, no PSEUDO_EOF");
			}
			else {
				if (bitNum == 0) current = current.left;
				else current = current.right;
			}
			if(current.left == null && current.right == null) {
					if (current.value == PSEUDO_EOF) {
						break;
					}	
					else {
						out.writeBits(BITS_PER_WORD, current.value);
						current = root;
					}
				}
			}
		//close output file
		out.close();
		}
		
		//reads the bit sequence that represents the tree
	private HuffNode readTree(BitInputStream in) {
		int bit = in.readBits(1);
		if (bit == -1) {
			throw new HuffException("bits == -1, out of bounds");
		}
		if (bit == 0) {
			HuffNode left = readTree(in);
			HuffNode right = readTree(in);
			return new HuffNode(0,0,left,right);
		}
		else {
			int val = in.readBits(BITS_PER_WORD +1);
			return new HuffNode (val, 0, null, null);
		}
	}
}
