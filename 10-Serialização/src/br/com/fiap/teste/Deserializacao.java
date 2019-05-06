package br.com.fiap.teste;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import br.com.fiap.entity.Cliente;

public class Deserializacao {
	public static void main(String[] args) throws Exception{
		
		FileInputStream file = new FileInputStream("churros.txt");
		ObjectInputStream input = new ObjectInputStream(file);
		
		Cliente cliente = (Cliente) input.readObject();
		
		System.out.println(cliente.getNome());
		System.out.println("CPF: "+cliente.getCpf());
		System.out.println("Saldo: "+cliente.getSaldo());		
		
		
		input.close();
		file.close();
	}

}
