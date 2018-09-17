class algFib{
	public static void main(String[] param){
		System.out.println(fib(5));
		System.exit(0);
	}

	public static int fib(int n){
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		System.out.println("n: "+n) ;
	
		return fib(n-1)+fib(n-2);
	}
}