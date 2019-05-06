package br.com.fiap.teste;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import br.com.fiap.entity.Cliente;

public class SerializaçãoTeste {

	
	public static void main(String[] args) throws Exception {
		Cliente cliente = new Cliente("Jao","123456789102",3000);
		
		FileOutputStream file = new FileOutputStream("churros.txt");
		ObjectOutputStream output = new ObjectOutputStream(file);
		
		output.writeObject(cliente);
		System.out.println("Serializando o objeto cliente!");
		
		output.close();
		file.close();
				
	}
}
