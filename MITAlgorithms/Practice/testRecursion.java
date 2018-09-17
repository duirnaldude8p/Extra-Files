
class testRecursion{

	public static void main(String[] arg){
		//String[][] arr = {{"d","a","a"}, {"b","a","a"}, {"a","a","a"}};
		//System.out.println("rec: "+recursion(arr));
		System.out.println("value: "+airec(6)+" 6: "+insix+" 8: "+ineight);
		System.exit(0);
	}

	private static boolean ineight = false;
	private static boolean insix = false;

	public static int numRec(int n){
		if(n==2){
			return n;
		}else{
			return n + secRec(n-2);
		}
	}
	public static int secRec(int n){
		if(n==2){
			return n;
		}else{
			return n + numRec(n-2);
		}
	}

	// public static String recursion(String[] a){
	// 	if(a[0].equals("b")){
	// 		return a[0];
	// 	}else if(a[0][0].equals("d")){
	// 		return recursion(a[1]);
	// 	}
	// }

	public static int airec(int n){
		if(n==1){
			System.out.println("found 1");
			return n;
		}else if(n==10){
			System.out.println("found 10");
			
			return n;
		}
		else if(n==8){
			ineight = true;
			insix = false;
			return n + airec(n+2); 
		}
		else if(n>=6){
			ineight = false;
			insix = true;
			return n + airec(n+1);
		}
		else{
			return n + airec(n-1);
		}
	}
}