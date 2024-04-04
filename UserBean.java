package MODEL;

import java.security.Timestamp;
import java.sql.Date;
import java.sql.Time;


public class UserBean 
{
	   private long accountNumber;
	    private String userName;
	    private String firstName;
	    private String lastName;
	    private long adharNumber;
	    private String dateOfBirth;
	    private String accountType;
	    private double balance;
	    private String passwordHash;
	    
	    
		public long getAccountNumber() {
			return accountNumber;
		}
		public void setAccountNumber(long accountNumber) {
			this.accountNumber = accountNumber;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public long getAdharNumber() {
			return adharNumber;
		}
		public void setAdharNumber(long adharNumber) {
			this.adharNumber = adharNumber;
		}
		
		
		public String getDateOfBirth() {
			return dateOfBirth;
		}
		public void setDateOfBirth(String dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
		public String getAccountType() {
			return accountType;
		}
		public void setAccountType(String accountType) {
			this.accountType = accountType;
		}
		public double getBalance() {
			return balance;
		}
		public void setBalance(double balance) {
			this.balance = balance;
		}
		public String getPasswordHash() {
			return passwordHash;
		}
		public void setPasswordHash(String passwordHash) {
			this.passwordHash = passwordHash;
		}
	    
}