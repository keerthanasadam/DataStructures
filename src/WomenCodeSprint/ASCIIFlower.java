package WomenCodeSprint;


import java.util.*;


public class ASCIIFlower {
	private int rows;
	private int columns;
	private static String middleRow="O.o.O";
	private static String topBottomRow="..O..";
	private static StringBuilder middle;
	private static StringBuilder outside;
	public ASCIIFlower(int r,int c){
		rows=r;
		columns=c;
		this.middle=new StringBuilder();
		this.outside=new StringBuilder();
		for(int i=0;i<columns;i++){
			middle.append(middleRow);
			outside.append(topBottomRow);
		}
		middle.append("\n");
		outside.append("\n");
	}
	public  String drawFlower(){
		StringBuilder output=new StringBuilder();
		for(int i=0;i<rows;i++){
			/*output.append(outside);
			output.append(middle);
			output.append(outside);
		*/
		int line=3;
		while(line-->0){
			String s=((line & 1)==0)?outside.toString():middle.toString();
			output.append(s);
		}	
		}	
		return output.toString();
	}
	
	public static void main(String[] args) {
		ASCIIFlower as=new ASCIIFlower(3, 2);
		/*Scanner in = new Scanner(System.in);
		int r = in.nextInt();
		int c = in.nextInt();*/
		// your code goes here
		//drawPattern(r,c);
		System.out.println(as.drawFlower());
		
	}
	

	public static void drawPattern(int r, int c){
	        //int horizontal=3*r;
	        //int vertical=5*c;
	        for(int i=0;i<r;i++){
	            for(int j=1;j<=c;j++){
	                System.out.print("..O..");
	                
	            }
	            System.out.println();
	            for(int j=1;j<=c;j++){
	            	System.out.print("O.o.O");
	            	
	           
	            }
	            System.out.println();
	            for(int j=1;j<=c;j++){
	            	System.out.print("..O..");
	            	
	            }
	            System.out.println();
	            
	        }
	        
	    }
}
