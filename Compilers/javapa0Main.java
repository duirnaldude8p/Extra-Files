import java.util.ArrayList;
import java.util.Scanner;

class javapa0Main{
	//ArrrayList opArr = new ArrayList();
	public static void main(String[] param){
		readConsole();
		System.exit(0);
	}

	public static void readConsole(){
		
		StackCommandJ st = new StackCommandJ();
		AddOppJ ao = new AddOppJ();
		DisplayOppJ dispo = new DisplayOppJ();
		SwapOppJ swpo = new SwapOppJ(); 
		EvalOppJ evlo = new EvalOppJ();
		boolean isAdding = true;
		String cmdstr = ""; 
		while(isAdding){
			Scanner s = new Scanner(System.in);
			String str = s.nextLine();
			String value = String.valueOf(str.charAt(0));
			//char chval = value.charAt(0);
			
			//System.out.println("value: "+value+" length "+str.length());
			if(value.equals("d")||value.equals("e")||value.equals("x")||value.equals("+")||value.equals("s")){
				st.adder(value);
				//System.out.println("value: "+value);
			}
			if(checkMe(str)){
				st.adder(str);
			}
			if(value.equals(">")&&str.length()==2){
				cmdstr = str;
				//System.out.println("is adding: "+isAdding+" value: "+value);
			}
			ArrayList<String> nwArr = new ArrayList<String>();
			nwArr = st.charArr;
			if(value.equals(">")&&cmdstr.length()==2){
				String promptval = String.valueOf(cmdstr.charAt(1));
				if(promptval.equals("+")&&st.charArr.size()>=2){
					ao.performAddition(nwArr);
				}
				else if(promptval.equals("d")&&st.charArr.size()>=2){
					dispo.display(nwArr);
				}
				else if(promptval.equals("x")){
					isAdding = false;
				}
				else if(promptval.equals("s")&&st.charArr.size()>=2){
					swpo.swap(nwArr);
				}
				else if(promptval.equals("e")&&st.charArr.size()>=2){
					evlo.evaluate(nwArr);
				}
			}
		}
	}
	public static boolean checkMe(String s){
  		boolean amIValid = false;
  		try{
   			Integer.parseInt(s);
   			amIValid = true;
  		}catch(NumberFormatException e){
   
  		}	
  		return amIValid;
	}
}