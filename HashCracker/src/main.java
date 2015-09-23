import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class main {

	public static void main(String[] args) {
		
		String plaintext = "serx";
		
		MessageDigest seedi = null;
		try {
			seedi = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		seedi.reset();
		seedi.update(plaintext.getBytes());
		byte[] digest = seedi.digest();
		BigInteger bigInt = new BigInteger(1,digest);
		String hashtext = bigInt.toString(16);
		// Now we need to zero pad it if you actually want the full 32 chars.
		while(hashtext.length() < 32 ){
		  hashtext = "0"+hashtext;
		}
		
		//System.out.println(hashtext);
		
		
		
		int len = 4;
		
		char[] guess = new char[len];
	    Arrays.fill(guess, 'a');

	    do {
	        System.out.println("Current guess:  " + new String(guess));
	        
	        seedi.reset();
	        seedi.update(new String(guess).getBytes());
	        byte[] digest2 = seedi.digest();
	        BigInteger bigInt2 = new BigInteger(1,digest2);
    		String myhash = bigInt2.toString(16);
    		
    		while(myhash.length() < 32 ){
    		  myhash = "0"+myhash;
    		}
    		  
	        int incrementIndex = guess.length - 1;
	        while (incrementIndex >= 0) {
	            guess[incrementIndex]++;
	            if (guess[incrementIndex] > 'z') {
	                if (incrementIndex > 0) {
	                    guess[incrementIndex] = 'a';
	                }
	                incrementIndex--;
	            }
	            
	            else {
	                break;
	            }
	            
	    		
	    		  
	    		}
	    		
	    		if(hashtext.equals(myhash)){
	    			System.out.println("Match found! " + myhash );
	    			break;
	    		}
	        

	    } while (guess[0] <= 'z');
		

	}

}
