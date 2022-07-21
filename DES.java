import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
public class DES{    
	public static void main(String[] args) {
		try{
		    KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
		    SecretKey myDesKey = keygenerator.generateKey();
		    Cipher desCipher;
		    desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
		    desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
		    byte[] text = "Anirudh Mittal".getBytes();
		    System.out.println(text);
		    System.out.println(new String(text));
		    byte[] textEncrypted = desCipher.doFinal(text);
		    System.out.println(textEncrypted);
		    desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
		    byte[] textDecrypted = desCipher.doFinal(textEncrypted);
		    System.out.println(new String(textDecrypted));
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}catch(NoSuchPaddingException e){
			e.printStackTrace();
		}catch(InvalidKeyException e){
			e.printStackTrace();
		}catch(IllegalBlockSizeException e){
			e.printStackTrace();
		}catch(BadPaddingException e){
			e.printStackTrace();
		} 
	}
}