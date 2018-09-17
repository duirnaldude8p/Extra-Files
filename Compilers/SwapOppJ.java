import java.util.ArrayList;

class SwapOppJ extends StackCommandJ{
	public boolean swap(ArrayList<String> arr){
		boolean finishedswp = false;
		int fstlth = arr.size();
		//System.out.println("array: "+arr);
		String firstval = arr.get(arr.size()-1);
		String secval = arr.get(arr.size()-2);
		arr.remove(arr.size()-1);
		arr.remove(arr.size()-1);
		arr.add(firstval);
		arr.add(secval);
		int nwlth = arr.size();
		if(fstlth==nwlth){
			finishedswp = true;
		}
		return finishedswp;
	}
}