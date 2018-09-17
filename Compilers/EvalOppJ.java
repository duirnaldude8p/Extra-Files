import java.util.ArrayList;

class EvalOppJ extends StackCommandJ{
	public void evaluate(ArrayList<String> arr){
		AddOppJ ao = new AddOppJ();
		DisplayOppJ dispo = new DisplayOppJ();
	    SwapOppJ swpo = new SwapOppJ(); 
		for(int i=arr.size()-1; i>=0; i--){
			System.out.println("i: "+i);
			System.out.println("array: "+arr);
			System.out.println(arr.get(i));
			String next = arr.get(i);
			if(next.equals("+")){
				arr.remove(i);
				i--;
				ao.performAddition(arr);
			}
			else if(next.equals("d")){
				arr.remove(i);
				dispo.display(arr);
			}
			else if(next.equals("x")){
				arr.remove(i);
				break;
			}
			else if(next.equals("s")){
				arr.remove(i);
			   	swpo.swap(arr);
			}
			else if(next.equals("e")){
				arr.remove(i);
				this.evaluate(arr);
			}
		}
	}
}