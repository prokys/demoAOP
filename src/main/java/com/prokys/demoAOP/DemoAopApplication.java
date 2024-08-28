package com.prokys.demoAOP;

import com.prokys.demoAOP.dao.AccountDAO;
import com.prokys.demoAOP.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoAopApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO){
		return runner -> {

//			demoTheBeforeAdvice(accountDAO, membershipDAO);
//			demoTheAfterReturningAdvice(accountDAO);
//			demoTheAfterThrowingAdvice(accountDAO);
			demoTheAfterAdvice(accountDAO);
		};
	}

	private void demoTheAfterAdvice(AccountDAO accountDAO) {
		//call method to find accounts
		List<Account> accounts = null;

		try{
			boolean tripWire = false;

			accounts = accountDAO.findAccounts(tripWire);
		} catch (Exception e){
			System.out.println("\n\nMain program caught exception: " + e);
		}

		//display the accounts
		System.out.println("\n\nMain program: demoTheAfterAdvice");
		System.out.println("----");
		System.out.println(accounts);
		System.out.println("\n");
	}

	private void demoTheAfterThrowingAdvice(AccountDAO accountDAO) {
		//call method to find accounts
		List<Account> accounts = null;

		try{
			boolean tripWire = true;

			accounts = accountDAO.findAccounts(tripWire);
		} catch (Exception e){
			System.out.println("\n\nMain program caught exception: " + e);
		}

		//display the accounts
		System.out.println("\n\nMain program: demoTheAfterThrowingAdvice");
		System.out.println("----");
		System.out.println(accounts);
		System.out.println("\n");
	}

	private void demoTheAfterReturningAdvice(AccountDAO accountDAO) {

		//call method to find accounts
		List<Account> accounts = accountDAO.findAccounts();

		//display the accounts
		System.out.println("\n\nMain program: demoTheAfterReturningAdvice");
		System.out.println("----");
		System.out.println(accounts);
		System.out.println("\n");


	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO){

		//call business method
		Account account = new Account();
		account.setName("Madhu");
		account.setLevel("platinum");
		accountDAO.addAccount(account, true);
		accountDAO.doWork();

		//call the account getter/setter
		accountDAO.setName("foobar");
		accountDAO.setName("silver");

		String name = accountDAO.getName();
		String serviceCode = accountDAO.getServiceCode();


		//call them membership business method
		membershipDAO.addSillyMember();
		membershipDAO.goToSleep();
	}

}
