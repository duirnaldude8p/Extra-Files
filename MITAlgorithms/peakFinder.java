class peakFinder {
	public static void main(String[] param){
        int[] ar = {2,1,3,2};
        PeakFinder(ar);
		System.exit(0);
	}
    public static int PeakFinder(int[] a){
    	
    	return PeakFinder(a,0);
    }
    public static int PeakFinder(int[] a, int i){
       if(a[i]==0){
       	return a[i-1];
       }
       /*else if(a[i-1]==null){
       	return a[i];
       }*/
       else if(a[i]<=a[i+1]&&a[i]<=a[i-1]){
       	 return a[i];
       }
      
       else if (a[i]<=a[i+1]){
       	 return PeakFinder(a,i+1);
       }
       else if(a[i]<=a[i-1]){
       	return PeakFinder(a,i+1);
       }
       else{
       	return a[i];
       }

    }	
}