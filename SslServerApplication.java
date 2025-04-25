package com.snhu.sslserver;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SslServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SslServerApplication.class, args);
	}

}
//FIXME: Add route to enable check sum return of static data example:  String data = "Hello World Check Sum!";\\

@RestController
class ServerContoller{
	
	private SecretKey secretKey;
	
	public void ServerController() throws Exception{
		//Generate AES secret key
		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		keyGen.init(128); //AES 128 bit encryption
		this.secretKey = keyGen.generateKey();
	}
	@RequestMapping("/encrypt")
	public String encryptAndHash() throws Exception{
		//data to encrypt
		String data = "Julie's Check Sum";
		//Encrypt data using AES
		String encryptedData = encrypt(data, secretKey);
		//calculate checksum (SHA-256) of encrypted data
		String checksum = calculateHash(encryptedData);
		//return response
		return "<p>data: " + data + "</p><p>Name of Cipher Alogrithm used: SHA-256</p><p> CheckSum: " + checksum;
	}
	
	//method to encrypt data using AES cipher
	private String encrypt(String data, SecretKey secretKey) throws Exception {
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		byte [] encryptedBytes = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
		return new String(encryptedBytes, StandardCharsets.ISO_8859_1);
	}
	
	//method to calculate SHA-256 checksum
	private String calculateHash(String data) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		byte[] hashBytes = md.digest(data.getBytes(StandardCharsets.UTF_8));
		StringBuilder hashString = new StringBuilder();
		for (byte b : hashBytes) {
			hashString.append(String.format("%02x", b));
			
		}
		return hashString.toString();
	}
}
