// ECS629/i 759 Assignment 2 - ID3 Skeleton Code
// Author: Simon Dixon

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

class ID3 {

	/** Each node of the tree contains either the attribute number (for non-leaf
	 *  nodes) or class number (for leaf nodes) in <b>value</b>, and an array of
	 *  tree nodes in <b>children</b> containing each of the children of the
	 *  node (for non-leaf nodes).
	 *  The attribute number corresponds to the column number in the training
	 *  and test files. The children are ordered in the same order as the
	 *  Strings in strings[][]. E.g., if value == 3, then the array of
	 *  children correspond to the branches for attribute 3 (named data[0][3]):
	 *      children[0] is the branch for attribute 3 == strings[3][0]
	 *      children[1] is the branch for attribute 3 == strings[3][1]
	 *      children[2] is the branch for attribute 3 == strings[3][2]
	 *      etc.
	 *  The class number (leaf nodes) also corresponds to the order of classes
	 *  in strings[][]. For example, a leaf with value == 3 corresponds
	 *  to the class label strings[attributes-1][3].
	 **/
	class TreeNode {

		TreeNode[] children;
		int value;

		public TreeNode(TreeNode[] ch, int val) {
			value = val;
			children = ch;
		} // constructor

		public String toString() {
			return toString("");
		} // toString()
		
		String toString(String indent) {
			if (children != null) {
				String s = "";
				for (int i = 0; i < children.length; i++)
					s += indent + data[0][value] + "=" +
							strings[value][i] + "\n" +
							children[i].toString(indent + '\t');
				return s;
			} else
				return indent + "Class: " + strings[attributes-1][value] + "\n";
		} // toString(String)

	} // inner class TreeNode

	// class Node extends TreeNode {

	// 	int value;

	// 	public Node(TreeNode[] ch, int val) {
	// 		super(ch, val);
	// 		value = val;
	// 	} 

	// } 

	private int attributes; 	// Number of attributes (including the class)
	private int examples;		// Number of training examples
	private TreeNode decisionTree;	// Tree learnt in training, used for classifying
	private String[][] data;	// Training data indexed by example, attribute
	private String[][] strings; // Unique strings for each attribute
	private int[] stringCount;  // Number of unique strings for each attribute
	private double[][] probDistCount;
	private double[][] condProb;
	private double[] attributeList;
	private boolean isEntropy;

	public ID3() {
		attributes = 0;
		examples = 0;
		decisionTree = null;
		data = null;
		strings = null;
		stringCount = null;
	} // constructor
	
	public void printTree() {
		if (decisionTree == null)
			error("Attempted to print null Tree");
		else
			System.out.println(decisionTree);
	} // printTree()

	/** Print error message and exit. **/
	static void error(String msg) {
		System.err.println("Error: " + msg);
		System.exit(1);
	} // error()

	static final double LOG2 = Math.log(2.0);
	
	static double xlogx(double x) {
		return x == 0? 0: x * Math.log(x) / LOG2;
	} // xlogx()

	/** Execute the decision tree on the given examples in testData, and print
	 *  the resulting class names, one to a line, for each example in testData.
	 **/
	public void classify(String[][] testData) {
		if (decisionTree == null){
			error("Please run training phase before classification");
		}else{
			// System.out.println("test: "+testData[0][0]);
			// System.out.println("node: "+decisionTree.value);
			// Get the decision tree values if childrem exist get the children and check if 
		}
	} 

	public void train(String[][] trainingData) {
		indexStrings(trainingData);
		TreeNode t = new TreeNode(null, 0);
		// String[][] thedata = trainingData;
		// String[][] thestrings = strings;
		decisionTree = buildTree(t, trainingData, strings, false, 0, null);
		
		
	}

	public TreeNode buildTree(TreeNode t, String[][] my_data, String[][] my_strings, boolean isLeafNode, int n, boolean[] usedAttrList){
		if(my_data==null){
			my_data = data;
		}
		if(my_strings==null){
			my_strings = strings;
		}

		condProb = setCondProb(my_data, my_strings);
		attributeList = setAttributeList(condProb);
		
		if(usedAttrList==null){
			usedAttrList = new boolean[attributeList.length];
			usedAttrList[4] = true;
		}
		
		attributeList = getUnUsedAttrList(usedAttrList, attributeList);
		int attr_index = getBestIndex(attributeList);	

		if(t==null){
			t = new TreeNode(null, attr_index);
		}
		//System.out.println("stringy: "+my_strings[3][1]+" condy: "+condProb[3][1]);
		if(!isLeafNode){
			attributeList = setAttributeList(condProb);
			attributeList = getUnUsedAttrList(usedAttrList, attributeList);
			attr_index = getBestIndex(attributeList);
			t = new TreeNode(null, attr_index);
			usedAttrList[attr_index] = true;
			int ex_count = 0;
			//System.out.println("condProb l: "+condProb[attr_index].length);
			for(int i=0; i<condProb[attr_index].length; i++){
				if(condProb[attr_index][i]!=0.0){
					ex_count = ex_count + 1;
					System.out.println("cond dude: "+condProb[attr_index][i]);
					//System.out.println("strings: "+my_strings[attr_index][i]);
				}
			}
			t.children = new TreeNode[ex_count];
			System.out.println("after condProb l: "+condProb[attr_index].length+" count: "+ex_count);
			for(int j=0; j<ex_count; j++){
				if(condProb[attr_index][j]!=0.0&&!isEntropy){
					t.children[j] = buildTree(new TreeNode(null, j), my_data, my_strings, true, attr_index, usedAttrList);
				}
			}
			return t;	
		}
		else if(isLeafNode){
			int leaf_index = getBestIndex(condProb[n]);
			System.out.println("leaf_index: "+leaf_index);
			String leaf_value = my_strings[n][leaf_index];
			String[][] thedata = splitdata(my_data, n, leaf_value);
			String[][] thestrings = setStrings(thedata);
			//condProb = setCondProb(my_data, my_strings);
			String currentClassification = showClassification(my_data);
			TreeNode node = new TreeNode(null, leaf_index);
			// t.children = new TreeNode[1];
			// t.children[0] = node;
			System.out.println("current classification: "+currentClassification+" att: "+n+" ex: "+leaf_index+" value: "+leaf_value);
			if(currentClassification.equals("homogeneous")){
				System.out.println("nicely done sam"+" att: "+n+" ex: "+leaf_index+" value: "+leaf_value);
				isEntropy = true;
				return t;
			}else{
				System.out.println("hello continue");
				if(isEntropy){
					return t;
				}
				// }else{
				// 	return buildTree(node, thedata, thestrings, false, leaf_index, usedAttrList);
				// }
			}
		}
		return t;
		//System.out.println("string: "+strings[3][0]+" cond: "+condProb[3][0]);

	}

	
	public double[] getUnUsedAttrList(boolean[] usedattr, double[] attrlist){
		for(int i=0; i<usedattr.length; i++){
			if(usedattr[i]==true){
				attrlist[i] = 0.0;
			}
		}
		return attrlist;
	}

	public String showClassification(String[][] inputdata){
		int half = inputdata.length/2;
		int classCounter = 0;
		for(int i=1; i<inputdata.length; i++){
			if(!inputdata[i][4].equals(null)&&inputdata[i][4].equals("Yes")){
				classCounter = classCounter + 1;
			}
		}
		if(classCounter==inputdata.length-1&&classCounter!=0){
			return "homogeneous";
		}
		else if(classCounter>=half&&classCounter!=0){
			return "most";
		}
		else if(classCounter<half&&classCounter!=0){
			return "some";
		}
		return "none";
		
	}

	public String[][] splitdata(String[][] inputdata, int attrIndex, String example){
		String[][] mydata = new String[inputdata.length][inputdata[0].length];
		int counter = 0;
		if(inputdata[0]!=null){
			mydata[0] = inputdata[0];
			counter = counter + 1;
		}
		for(int i=1; i<inputdata.length; i++){
			if(!inputdata[i][attrIndex].equals(null)&&inputdata[i][attrIndex].equals(example)){
				mydata[counter] = inputdata[i];
				counter = counter + 1;
			}
		}
		String[][] mynewdata = new String[counter][inputdata[0].length];
		for(int j=0; j<counter; j++){
			if(mydata[j]!=null){
				mynewdata[j] = mydata[j];
			}
		}
		return mynewdata;
	}

	public int getBestIndex(double[] attrlist){
		int bestAttrIndex = 0;
		double bestAttr = 0.0;
		for(int i=0; i<attrlist.length; i++){
			if(attrlist[i]>bestAttr){
				bestAttr = attrlist[i];
				bestAttrIndex = i;
			}
		}
		return bestAttrIndex;
	}

	public double[] setAttributeList(double[][] condprob){
		double[] myattributeList = new double[condProb.length];
		double bestCond = 0.0;
		for(int i=0; i<condProb.length; i++){
			bestCond = 0.0;
			for(int j=0; j<condProb[0].length; j++){
				if(condProb[i][j]>bestCond){
					bestCond = condProb[i][j];
				}
			}
			myattributeList[i] = bestCond;
		}
		return myattributeList;
	}

	public double[][] setCondProb(String[][] traindata, String[][] exs){
		double[][] mycondProb = new double[exs.length][exs[0].length];
		for(int i=0; i<exs[0].length; i++){
			for(int j=0; j<exs.length; j++){
				String value = exs[j][i];
				if(value!=null){
					for(int n=1; n<traindata.length; n++){
						if(traindata[n][j].equals(value)&&traindata[n][4].equals("Yes")){
							mycondProb[j][i] = mycondProb[j][i] + 1;
						}
					}
					mycondProb[j][i] = mycondProb[j][i]/(exs[0].length-1);
				}
			}
		}
		return mycondProb;
		//System.out.println("probDistCount: "+probDistCount[4][0]);
	}

	public String[][] setStrings(String[][] inputdata){
		String[][] mystrings = new String[inputdata[0].length][inputdata.length];
		String[] prev = new String[inputdata[0].length];
		for(int i=0; i<mystrings.length; i++){
			int strCounter = 0;
			for(int j=1; j<inputdata.length; j++){
				for(int m=0; m<prev.length; m++){
					if(!inputdata[j][i].equals(prev[m])&&!inputdata[j][i].equals(null)){
						mystrings[i][strCounter] = inputdata[j][i];
						prev[m] = inputdata[j][i]; 
						strCounter = strCounter + 1;
						break;
					}
				}
			}
		}
		return mystrings;
	}

	/** Given a 2-dimensional array containing the training data, numbers each
	 *  unique value that each attribute has, and stores these Strings in
	 *  instance variables; for example, for attribute 2, its first value
	 *  would be stored in strings[2][0], its second value in strings[2][1],
	 *  and so on; and the number of different values in stringCount[2].
	 **/
	void indexStrings(String[][] inputData) {
		data = inputData;
		examples = data.length;
		attributes = data[0].length;
		stringCount = new int[attributes];
		strings = new String[attributes][examples];// might not need all columns
		int index = 0;
		for (int attr = 0; attr < attributes; attr++) {
			stringCount[attr] = 0;
			for (int ex = 1; ex < examples; ex++) {
				for (index = 0; index < stringCount[attr]; index++)
					if (data[ex][attr].equals(strings[attr][index]))
						break;	// we've seen this String before
				if (index == stringCount[attr])		// if new String found
					strings[attr][stringCount[attr]++] = data[ex][attr];
			} // for each example
		} // for each attribute
	} // indexStrings()

	/** For debugging: prints the list of attribute values for each attribute
	 *  and their index values.
	 **/
	void printStrings() {
		for (int attr = 0; attr < attributes; attr++)
			for (int index = 0; index < stringCount[attr]; index++)
				System.out.println(data[0][attr] + " value " + index +
									" = " + strings[attr][index]);
	} // printStrings()
		
	/** Reads a text file containing a fixed number of comma-separated values
	 *  on each line, and returns a two dimensional array of these values,
	 *  indexed by line number and position in line.
	 **/
	static String[][] parseCSV(String fileName)
								throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String s = br.readLine();
		int fields = 1;
		int index = 0;
		while ((index = s.indexOf(',', index) + 1) > 0)
			fields++;
		int lines = 1;
		while (br.readLine() != null)
			lines++;
		br.close();
		String[][] data = new String[lines][fields];
		Scanner sc = new Scanner(new File(fileName));
		sc.useDelimiter("[,\n]");
		for (int l = 0; l < lines; l++)
			for (int f = 0; f < fields; f++)
				if (sc.hasNext())
					data[l][f] = sc.next();
				else
					error("Scan error in " + fileName + " at " + l + ":" + f);
		sc.close();
		return data;
	} // parseCSV()

	public static void main(String[] args) throws FileNotFoundException,
												  IOException {
		if (args.length != 2)
			error("Expected 2 arguments: file names of training and test data");
		String[][] trainingData = parseCSV(args[0]);
		String[][] testData = parseCSV(args[1]);
		ID3 classifier = new ID3();
		classifier.train(trainingData);
		classifier.printTree();
		classifier.classify(testData);
	} // main()

} // class ID3
