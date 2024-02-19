public class LinkStrand implements IDnaStrand {

    //private node class
    private class Node {
            String info;
            Node next;
            Node(String str) {
                this.info = str;
            }

            Node(String str, Node node){
                info = str;
                next = node;
        }

        }
    
    //instance variables
    private Node myFirst, myLast;
    private long mySize;
    private int myAppends;
    private int myIndex;
    private Node myCurrent;
    private int myLocalIndex;
    
    public LinkStrand() {
        this("");

    }

    public LinkStrand(String s) {
        initialize(s);
    }

    @Override
    public long size() {

        return mySize;

     }

    @Override
    public void initialize(String source) {
        myFirst = new Node(source);
        myLast = myFirst;
        mySize = myFirst.info.length();
        myAppends = 0;
        myIndex = 0;
        myCurrent = myFirst;
        myLocalIndex = 0;
        // TODO Auto-generated method stub
       // throw new UnsupportedOperationException("Unimplemented method 'initialize'");
    }

    @Override
    public IDnaStrand getInstance(String source) {
        return new LinkStrand(source);
    }

    @Override
    public IDnaStrand append(String dna) {
        Node appNode = new Node(dna);
        myLast.next = appNode;
        myLast = myLast.next;
        mySize += dna.length();
        myAppends += 1;
        return this;
        }

    @Override
    public IDnaStrand reverse() {
        StringBuilder revStr = new StringBuilder(this.myFirst.info);
        revStr.reverse();
        LinkStrand rev = new LinkStrand(revStr.toString());
        rev.mySize = this.mySize;
        rev.myAppends = this.myAppends;
        rev.myCurrent = rev.myFirst;
        Node curr = myFirst.next;
        while(curr !=null ){
            revStr = new StringBuilder(curr.info);
            revStr.reverse();
            rev.myFirst = new Node(revStr.toString(), rev.myCurrent);
            curr = curr.next;
            rev.myCurrent = rev.myFirst;
        }
        rev.myCurrent = myFirst;
        return rev;
    }

    @Override
    public int getAppendCount() {
        return myAppends;
    }

    @Override
    public char charAt(int index) {
        if (index >= mySize || index < 0){
            throw new IndexOutOfBoundsException("invalid idx");
        }

        int Count = 0;
	    int idx = 0;
	    Node curr = myFirst;
        if (index >= myIndex && myIndex != 0){
            idx = myLocalIndex;
            curr = myCurrent;
            Count = myIndex;
           
        }
	    while (curr != null && Count != index ) {
		    Count+=1;
		    idx+=1;
		    if (idx >= curr.info.length()) {
			    idx = 0;
			    curr = curr.next;
		    }
	    }
        myCurrent = curr;
        myIndex = index;
        myLocalIndex = idx;
        return curr.info.charAt(idx);
    }




    @Override
    public String toString() {
        StringBuilder retStr = new StringBuilder();
        Node currentNode = myFirst;
        while (currentNode != null) {
            retStr.append(currentNode.info);
            currentNode = currentNode.next;

        }
        return retStr.toString();
    }
    
}
