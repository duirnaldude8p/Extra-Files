import java.util.ArrayList;

class DisplayOppJ extends StackCommandJ{
	public void display(ArrayList<String> arr){
		for(int i=arr.size()-1; i>=0; i--){
			System.out.println(arr.get(i));
		}
	}
}