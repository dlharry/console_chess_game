package chess;

public class CheckInput {

	public static boolean checkCoordinateValidity(String input){
		if(input.length()!=2) return false;
		char row = input.charAt(0), col = input.charAt(1);
		if(	row>='1' && row<='8' &&
				col>='a' && col<='h'){
			return true;
		}
		return false;
	}
}
