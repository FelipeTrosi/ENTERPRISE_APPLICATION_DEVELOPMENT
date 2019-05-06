package br.com.fiap.bo;

import java.rmi.RemoteException;

public interface CalculadoraBO {
	
	int somar(int n1, int n2, int n3) throws RemoteException;

}
