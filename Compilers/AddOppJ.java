import java.util.ArrayList;

class AddOppJ extends StackCommandJ{
	private int firstval = 0;
	private int secval = 0;
	public void performAddition(ArrayList<String> arr){
		//System.out.println("add array: "+arr);
		if(this.checkMe(arr.get(arr.size()-1),arr.get(arr.size()-2))){
			int newInt = firstval + secval;
			String nwstr = String.valueOf(newInt);
			//System.out.println("add array: "+arr);
			arr.remove(arr.size()-1);
			arr.remove(arr.size()-1);
			arr.add(nwstr);
			//System.out.println("new int: "+nwstr+" "+newInt);
			//System.out.println("new add array: "+arr);
		}
	}
	public boolean checkMe(String str1, String str2){
		boolean amIValid = false;
  		try{
   			firstval = Integer.parseInt(str1);
			secval = Integer.parseInt(str2);
   			amIValid = true;
  		}catch(NumberFormatException e){
   
  		}	
  		return amIValid;
	}
}