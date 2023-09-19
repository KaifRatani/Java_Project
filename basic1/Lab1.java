/**

 *Lab1- Calculating the Sequence and the count for it 

 * Student Name: Kaif Ratani

 * Student Number: 041076291

 * Course: CST8132 Object Oriented Programming

 * Program: CET-CS-Level 2

 * Professor: daniel cormier 
 
  */
public class Lab1 {
	public int computerNextValue(int value){
		 int nextValue;
		 if (value %2 == 0) {

	          nextValue = (value / 2) ;
	     }else {
	    	 nextValue = (value * 3) + 1 ;
	     }
	 		return nextValue;
	}
		 

	void generateAllValues(int value) {
		int i = 1;//counter for the loop
		 do{
			 i++;//counter
			 System.out.println(value);//printing the value after the coming for the computerNextValue
			value = computerNextValue(value);//setting the value to nextValue for next loop 
			
		}while (value !=1);//loop condition
		System.out.print( 1 + "\nSequence "+ i + " long"); // printing the Sequence  count
	}
}
