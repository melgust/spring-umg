package gt.edu.umg.desaweb.service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import java.util.Arrays;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;

@Service
public class EncryptService {
	
	public String encrypt(String texto, String semilla) {
		String result = "";
		try {
			byte[] key = semilla.getBytes("UTF-8");
			key = Arrays.copyOf(key, 16);
			SecretKeySpec aesKey = new SecretKeySpec(key, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, aesKey);
			byte[] encrypted = cipher.doFinal(texto.getBytes());
			byte[] tmpByte = Base64.encodeBase64(encrypted);
			result = new String(tmpByte);
		} catch (Exception e) {
			result = "";
		}
		return result;
	}
	
	public String decrypt(String texto, String semilla) {
		String resultado = "";
		try {
			byte[] key = semilla.getBytes("UTF-8");
			key = Arrays.copyOf(key, 16);
			SecretKeySpec aesKey = new SecretKeySpec(key, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			byte[] tmpBClave = Base64.decodeBase64(texto);
			cipher.init(Cipher.DECRYPT_MODE, aesKey);
			byte[] decrypted = cipher.doFinal(tmpBClave);
			resultado = new String(decrypted);
		} catch (Exception e) {
			resultado = "";
		}
		return resultado;
	}

}
