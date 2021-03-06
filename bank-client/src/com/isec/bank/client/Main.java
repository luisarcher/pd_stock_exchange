/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isec.bank.client;

import com.isec.bank.client.ws.ClientRS;
import com.isec.bank.dto.DTOBankAccount;
import java.io.Console;
import java.util.List;
import java.util.Scanner;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

public class Main {

    static ClientRS c;
    
    public static void main(String[] args) {       
        Scanner scan = new Scanner(System.in);
        
        int opcao = 0;
	do {
            System.out.println("***********BANK**************");
            System.out.println("1 - Entrar");
            // System.out.println("2 - Registar");
            System.out.println("0 - Sair");
            System.out.println("*****************************");

            opcao = scan.nextInt();
            System.out.print("\n");
            switch (opcao) {
            case 1:
                logInUser();
                break;
            // case 2:
               // registerUser();
               //  break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Opção Inválida!");
                break;
            }
	} while (opcao != 0);
        
        c.close();
    }
    
    public static void registerUser() {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Introduza o seu Username: ");
        String newUser = scan.nextLine();
        System.out.println("Introduza a sua password: ");
        String newPassword = scan.nextLine();
        // TODO: Método para registar conta.

    }
    
    public static void logInUser() {
        boolean isLogged = false;
        @SuppressWarnings("UnusedAssignment")
        String usernameInput = "";
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Username: ");
        usernameInput = scan.nextLine();
        System.out.println("Password: ");
        String passwordInput = scan.nextLine();
        
        c = new ClientRS();
        c.setUser(usernameInput);   // luis
        c.setPasswd(passwordInput); // 123

        System.out.println("Bem vindo, " + usernameInput + ".");
        loggedArea();
    }
    
    public static void loggedArea() {
        Scanner scan = new Scanner(System.in);
        
        int opcao = 0;
	do {
            System.out.println("-------------------------------");
            System.out.println("1 - Listagem de contas");
            System.out.println("2 - Obter detalhes da conta");
            System.out.println("3 - Editar saldo da conta");
            System.out.println("0 - Sair");
            System.out.println("-------------------------------");

            opcao = scan.nextInt();
            System.out.print("\n");
            switch (opcao) {
            case 1:
                listAllAccounts();
                break;
            case 2:
                System.out.println("Introduza o id da conta a consultar: ");
                int idDetails = scan.nextInt();
                getAccountDetails(idDetails);    // obter dados conta 1000
                break;
            case 3:
                System.out.println("Introduza o id da conta a consultar: ");
                int idEdit = scan.nextInt();
                System.out.println("Introduza o valor a adicionar: ");
                int valEdit = scan.nextInt();
                setAccountValue(idEdit, valEdit); // id = 1000, valor = 10
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Opção Inválida!");
                break;
            }
	} while (opcao != 0);
    }
    
    public static void listAllAccounts(){
        Response r = c.getAllAccounts(Response.class, null);
        // System.out.println("Status: " + r.getStatus());
        List<DTOBankAccount> list = r.readEntity(new GenericType<List<DTOBankAccount>>(){});
        
        for (DTOBankAccount i: list){
            System.out.println("-Conta ID: " + i.getIdAccount() + " - Valor: " + i.getBalance());
        }
    }
    
    public static void getAccountDetails(int accNum){
        String n = Integer.toString(accNum);
        Response r = c.getAccountById(Response.class, n);
        // System.out.println("Status: " + r.getStatus());
                
        if (r.getStatus() != 200) {
            System.out.println("Nao existe conta com o id indicado!");
            return;
        }
        
        DTOBankAccount obj = r.readEntity(new GenericType<DTOBankAccount>(){});
        System.out.println("Detalhes da conta " + accNum);
        System.out.println(obj.getIdAccount());
        System.out.println(obj.getBalance());
   
        System.out.println("ID: " + obj.getIdAccount());
        System.out.println("Saldo: " + obj.getBalance());
    }
    
    public static void setAccountValue(int accNum, int val){
        String n = Integer.toString(accNum);
        Response rUser = c.getAccountById(Response.class, n); 
        Response r = c.setAccountCredits(Response.class, accNum, val);

        System.out.println(rUser.getStatus());
        System.out.println(r.getStatus());
        
        if (r.getStatus() != 200 || rUser.getStatus() != 200) {
            System.out.println("Nao foi possivel efectuar o pedido. Verifique os dados introduzidos!");
            return;
        }
        
        DTOBankAccount obj = rUser.readEntity(new GenericType<DTOBankAccount>(){});
        double novoValor = obj.getBalance() + val;
        System.out.println("Saldo da conta " + accNum + " alterado para: " + novoValor);
    }
}
