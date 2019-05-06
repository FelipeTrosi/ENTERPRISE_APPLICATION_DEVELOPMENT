package br.com.fiap.test;


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import br.com.fiap.bo.CalculadoraBOImpl;

public class RMIServerTest {
	public static void main(String[] args) throws Exception{
		Registry registry = LocateRegistry.createRegistry(1234);
		
		registry.bind("churros", new CalculadoraBOImpl());
		
		System.out.println("Objeto publicado com sucesso"); 
		
	}
}
