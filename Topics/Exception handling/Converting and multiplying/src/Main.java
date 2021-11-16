import java.util.Scanner;

class Main {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	
    	do {
    		String input = scanner.next();
    		if (input.equals("0")) {
    			break;
    		}
    		int intInput = 0;
    		try {
    			intInput = Integer.parseInt(input);
    			System.out.print(intInput * 10);
    		} catch (NumberFormatException nfe) {
    			System.out.print("Invalid user input: " + input);
    		}
        	System.out.println("");
    	} while (scanner.hasNext());
    }
}
