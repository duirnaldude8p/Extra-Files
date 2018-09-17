

class TMstate{
	public static void main(String[] param){
		System.out.println(toInt("1001"));
		System.out.println(toInt("1011"));

	}

	public static int toInt(String bin){
		int adder = 0;
		int result = 0;
		int doubler = 1;
	    //System.out.println("hello");
		for(int i=bin.length()-1; i>=0; i--){
			//System.out.println(bin.charAt(i));
			if(bin.charAt(i)=='1'){
				adder = doubler+result;
				result = adder;
				//System.out.println("hello");
				//System.out.println(doubler);
				//System.out.println(result);
				//System.out.println(adder);
			}
			doubler = doubler*2;

		}
		return adder;	
	}
}