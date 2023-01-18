package com.tester;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.dal.BankDalImplement;
import com.pojo.sbi;
import com.util.DButil;

public class ClientTester {

	public static void main(String[] args)  {

		
		boolean exit=false;
		
		Scanner sc=new Scanner(System.in);
		try {
			DButil.openconnection();
			BankDalImplement bank = new BankDalImplement();
			
			while(!exit)
			{
				
				System.out.println("1.show all 2.insert 3.updta 4.delete");
				switch(sc.nextInt())
				{
				case 1:
					 List<sbi> list =bank.showallaccount();
					 list.forEach(p->System.out.println(p));
					break;
				case 2:
					System.out.println("enter the details eg. account number , balance , name , location");
					bank.insertaccount(new sbi(sc.nextInt(), sc.nextDouble(), sc.next(), sc.next()));
					break;
				case 3:
					System.out.println("enter the account number and details which you want to update balance , name , location");
					bank.updateaccount(sc.nextInt(), new sbi(sc.nextDouble(), sc.next(), sc.next()));
					break;
				case 4:
					System.out.println("enter the account no whose account you want to remove");
					bank.deleteaccount(sc.nextInt());
					break;
				case 5:
					exit=true;
					break;
				}
			}
			
			
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
	
	}

}
