package com.example.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Banking;
import com.example.exception.BankingException;
import com.example.facility.Facility;
import com.example.repo.BankingRepo;

@Service
public class BankingService {
	@Autowired
	private BankingRepo repo;
	Map<String,String> l=new HashMap<>();
	public Banking register(Banking user) {
	    if (repo.existsById(user.getUsername())) {
	        return null;  
	    }
	    return repo.save(user);  
	}
	

	public Banking login(String id, String pass) throws BankingException {
	    Optional<Banking> user = repo.findById(id);

	    if (user.isPresent()) {
	        if (user.get().getPassword().equals(pass)) {
	            return user.get(); 
	        } else {
	            throw new BankingException("Incorrect password!");
	        }
	    } else {
	        throw new BankingException("User not found!");
	    }
	}
	

	public Banking elogin(String id, String pass) throws BankingException {
	    Optional<Banking> user = repo.findById(id);

	    if (user.isPresent()) {
	    	if(user.get().isEmployee()) {
				return user.get();
			}
			else {
				throw new BankingException("Wrong Username or password");
			}
	    } else {
	        throw new BankingException("User not found!");
	    }
	}
	
	public Banking alogin(String id, String pass) throws BankingException {
	    Optional<Banking> user = repo.findById(id);

	    if (user.isPresent()) {
	    	if(user.get().isAdmin()) {
				return user.get();
			}
			else {
				throw new BankingException("Wrong Username or password");
			}
	    } else {
	        throw new BankingException("❌ User not found!");
	    }
	}

	public List<Banking> getAllBankingUsers() {
	    return repo.findAll(); // Assuming bankingRepo extends JpaRepository<Banking, String>
	}

	public double getBalance(String username, String password) {
        Optional<Banking> user = repo.findById(username);
        
        if (user.isPresent()) {
            Banking banking = user.get();

            // Check if password matches
            if (banking.getPassword().equals(password)) {
                return banking.getBalance();
            } else {
                throw new RuntimeException("Incorrect password for user: " + username);
            }
        } else {
            throw new RuntimeException("User not found: " + username);
        }
    }
	public String deposit(Banking b, double val) {
	    if (b.getTransaction() == null) {  
	        b.setTransaction(new ArrayList<>());
	    }
	    
	    if (b.getTransaction() == null) {  // Fix: Ensure TransPer is initialized
	        b.setTransaction(new ArrayList<>());
	    }
	    
	    if (val > 50000) {
	        if (b.isAllowTrans()) {
	            b.setAllowTrans(false);
	            if (b.getFacility().equals(Facility.valueOf("Full"))) {
	                System.out.println(b.getBalance());
	                b.setBalance(b.getBalance() + val);
	                System.out.println(b.getBalance());
	                b.setFacility(Facility.valueOf("Full"));
	                b.getTransaction().add(val);
	                b.setAllowTrans(false);
	                b.setNeededTransaction(false);
	                repo.save(b);
	                login(b.getUsername(), b.getPassword());
	                return "Money deposited properly";
	            } else {
	                return "Money can't be deposited";
	            }
	        } else {
	            b.setNeededTransaction(true);
	            b.getTransaction().add(val);  // Safe: TransPer is now initialized
	            repo.save(b);
	            return "Wait for Manager to Approve";
	        }
	    } else {
	        if (b.getFacility().equals(Facility.valueOf("view"))) {
	            return "Money can't be deposited";
	        } else {
	            b.setBalance(b.getBalance() + val);
	            b.getTransaction().add(val);
	            repo.save(b);
	            return "Money deposited properly";
	        }
	    }
	}

	public String withdraw(Banking b, double val) {
	    if (b.getTransaction() == null) {  
	        b.setTransaction(new ArrayList<>());
	    }

	    if (val > b.getBalance()) {  // ❌ Check for insufficient balance
	        return "Insufficient balance. Withdrawal failed.";
	    }

	    if (val > 25000) {  // 🔹 For withdrawals > 25,000
	        if (b.isAllowTrans()) {
	            b.setAllowTrans(false);
	            if (b.getFacility().equals(Facility.valueOf("Full"))) {
	                b.setBalance(b.getBalance() - val);
	                b.getTransaction().add(-val);
	                repo.save(b);
	                return "Withdrawal successful.";
	            } else {
	                return "Withdrawal can't be processed.";
	            }
	        } else {
	            b.setNeededTransaction(true);
	            b.getTransaction().add(-val);
	            repo.save(b);
	            return "Wait for Manager to Approve.";
	        }
	    } else {  // 🔹 For withdrawals ≤ 25,000
	        if (b.getFacility().equals(Facility.valueOf("view"))) {  
	            return "Withdrawal not allowed.";
	        } else {
	            b.setBalance(b.getBalance() - val);
	            b.getTransaction().add(-val);
	            repo.save(b);
	            return "Withdrawal successful.";
	        }
	    }
	}

	public double getBalance(String username) {
	    return repo.findById(username)
	        .map(Banking::getBalance)
	        .orElseThrow(() -> new RuntimeException("User Balance Service not found"));
	}

	public double balance(Banking b) {
		return b.getBalance();
	}
	public String transaction(Banking b,String id,double val) throws BankingException{
		if (b.getTransaction() == null) {
	        b.setTransaction(new ArrayList<>());
	    }
		if(withdraw(b,val).equals("Money withdrawl is done properly")) {
			Banking x = repo.findById(id).orElseThrow(()->new BankingException("User not found with the User name "+id));
			System.out.println("Balance of "+b.getUsername()+" is: "+b.getBalance());
			if (x.getTransaction() == null) {
	            x.setTransaction(new ArrayList<>());
	        }
			if(deposit(x,val).equals("Money deposited properly")) {
				System.out.println("Balance of "+id+" is: "+x.getBalance());
				return "Transaction is made properly";
			}
			else {
				deposit(b,val);
				return "Transaction failed";
			}
		}
		else {
			return "transaction failed";
		}
	}
	
	public String loan(Banking b, String type, float l, int time) {
	    if (b.getTransaction() == null) {  
	        b.setTransaction(new ArrayList<>());
	    }

	    b.setLoanval(b.getLoanval() + l);
	    type = type.toLowerCase(); // Normalize case

	    // Interest Calculation
	    double interestRate;
	    switch (type) {
	        case "vehicle":
	            interestRate = 1.10;
	            break;
	        case "home":
	            interestRate = 1.08;
	            break;
	        case "education":
	            interestRate = 1.06;
	            break;
	        default:
	            interestRate = 1.05;
	            break;
	    }
	    b.setIntrest((l * Math.pow(interestRate, time)) - l);

	    // Loan Approval Logic
	    if (b.isAllowLoan()) {
	        b.setBalance(b.getBalance() + l);
	        b.setAllowLoan(false);
	        repo.save(b);
	        return "Loan is provided successfully.";
	    } else {
	        b.setNeedLoan(true);
	        b.setNeededLoan(l);
	        b.setLoanTime(time);
	        b.setLoanType(type);
	        repo.save(b);
	        return "Loan is pending approval.";
	    }
	}

	public List<Double> getTrans(Banking b){
		return b.getTransaction();
	}
	public List<Double> getAllTrans(Banking b, String id) {
	    Optional<Banking> userOpt = repo.findById(id);
	    if (userOpt.isPresent()) {
	        return userOpt.get().getTransaction(); // Get the correct user's transactions
	    } else {
	        throw new BankingException("There is no user with UserName " + id);
	    }
	}

	public List<Banking> getAllDetails(Banking b) {
		return repo.findAll();
	}
	public Optional<Banking> getDetails(Banking b,String id) {
		if(repo.existsById(id)) {
			return repo.findById(id);
		}
		else {
			throw new BankingException("Wrong Username"); 
		}
	}
	public Banking getMyDetails(Banking b){
		return b;
	}
	/*public String addFeed(Banking b, String message) {
		b.setMessage(message);
		repo.save(b);
		return "Feedback is given successfully";
	}
	public List<String> getAllFeedback(Banking b){
		return repo.findAll().stream()
				.map(Banking::getMessage)
	            .filter(msg -> msg != null && !msg.isEmpty())
	            .collect(Collectors.toList());
	}*/
	
	public String addFeed(Banking banking, String message) {
	    if (banking == null) {
	        throw new RuntimeException("Invalid banking credentials.");
	    }

	    banking.setMessage(message);  // Store feedback in banking entity
	    repo.save(banking);  // Save to database
	    return "Feedback updated successfully.";
	}


	public String getAllFeedback(Banking banking) {
	    if (banking == null) {
	        throw new RuntimeException("Unauthorized access.");
	    }

	    return banking.getMessage() == null ? "No feedback available" : banking.getMessage();
	}

	public void updateBanking(Banking banking) {
	    if (banking == null) {
	        throw new RuntimeException("Invalid banking user.");
	    }
	    repo.save(banking);  // Save updated data to database
	}



	public String makeEmp(Banking b,String id) {
		if(b.isAdmin()) {
			Banking x = repo.getById(id);
			x.setEmployee(true);
			repo.save(x);
			return "Entry of a new employee is done with User name "+id;
		}
		else {
			return "It is restricted to Admin";
		}
	}
	public String deleteData(Banking b,String id) throws BankingException {
		if(b.isAdmin()) {
			if(repo.existsById(id)) {
				repo.deleteById(id);
				return "User name with id "+id+" is deleted";
			}
			else {
				throw new BankingException("There is no user with user name"+id);
			}
		}
		else {
			throw new BankingException("It is restricted");
		}
	}
	/*public String freeze(Banking b,String id) {
		if(repo.existsById(id)) {
			Banking x = repo.getById(id);
			x.setFacility(Facility.valueOf("view"));
			x.setAllowLoan(false);
			x.setAllowTrans(false);
			x.setNeededTransaction(false);
			x.setNeedLoan(false);
			x.setFreeze(true);
			repo.save(x);
			return "The account of user with "+id+" is freezed";
		}
		else {
			throw new BankingException("There is no user with user name"+id);
		}
	}*/
	
	public String freeze(String userId) {
	    Optional<Banking> optionalUser = repo.findById(userId);

	    if (!optionalUser.isPresent()) {
	        throw new BankingException("No user found with ID: " + userId);
	    }

	    Banking user = optionalUser.get();
	    user.setFacility(Facility.valueOf("view"));
	    user.setAllowLoan(false);
	    user.setAllowTrans(false);
	    user.setNeededTransaction(false);
	    user.setNeedLoan(false);
	    user.setFreeze(true);
	    
	    repo.save(user);
	    return " The account of user with ID: " + userId + " has been frozen.";
	}



	public String approveTrans(Banking b, String id,boolean a) {
		Banking x=repo.getById(id);
		x.setAllowTrans(a);
		if(a) {
			double val=x.getTransaction().get(x.getTransaction().size()-1);
			System.out.println(val);
			if(val>0) {
				System.out.println("Deposit");
				return deposit(x,val);
			}
			else {
				System.out.println("Withdraw");
				return withdraw(x,Math.abs(val));
			}
		}
		else {
			return "Transaction is not approved";
		}
	}
	/*public String approveLoan(Banking employee, String loanId, boolean approve) {
	    Optional<Banking> optionalBanking = repo.findById(loanId);
	    if (!optionalBanking.isPresent()) {
	        return "Loan application not found.";
	    }

	    Banking user = optionalBanking.get();
	    user.setAllowTrans(approve);

	    if (approve) {
	        return loan(user, user.getLoanType(), user.getNeededLoan(), user.getLoanTime());
	    } else {
	        user.setNeedLoan(false);
	        user.setLoanType(null);
	        user.setNeededLoan(0);
	        user.setLoanTime(0);
	        repo.save(user);
	        return "Loan is not approved.";
	    }
	}

	public List<String> showApprovals(Banking b) {
	    if (!b.isEmployee()) {
	        throw new BankingException("Only employees can view approvals.");
	    }

	    List<Banking> pendingApprovals = repo.findAll().stream()
	        .filter(user -> user.isNeededTransaction() || user.isNeedLoan())
	        .collect(Collectors.toList());

	    if (pendingApprovals.isEmpty()) {
	        return List.of("No pending approvals.");
	    }

	    return pendingApprovals.stream()
	        .map(user -> {
	            StringBuilder approvalInfo = new StringBuilder("User: " + user.getUsername());
	            
	            if (user.isNeededTransaction() && !user.getTransaction().isEmpty()) {
	                double lastTransaction = user.getTransaction().get(user.getTransaction().size() - 1);
	                String transactionType = lastTransaction > 0 ? "Deposit" : "Withdraw";
	                approvalInfo.append(" | Pending Transaction: ")
	                        .append(transactionType)
	                        .append(" ₹")
	                        .append(Math.abs(lastTransaction));
	            }
	            
	            if (user.isNeedLoan()) {
	                approvalInfo.append(" | Pending Loan Amount: ₹").append(user.getNeededLoan()).append(user.getLoanTime());
	            }
	            
	            return approvalInfo.toString();
	        })
	        .collect(Collectors.toList());
	}*/
	/*@Autowired
    private LoanRepo loanRepo;

    // Fetch all pending loans
    public List<Map<String, Object>> getPendingLoans() {
        List<Loan> loans = loanRepo.findAllByStatus("Pending");
        return loans.stream().map(loan -> {
            Map<String, Object> loanMap = new HashMap<>();
            loanMap.put("loanId", loan.getId());
            loanMap.put("username", loan.getUser().getUsername());
            loanMap.put("amount", loan.getAmount());
            loanMap.put("type", loan.getType());
            loanMap.put("status", loan.getStatus());
            return loanMap;
        }).collect(Collectors.toList());
    }

    // Approve or Reject a Loan
    public String approveLoan(Long loanId, boolean isApproved) {
        Optional<Loan> loanOpt = loanRepo.findById(loanId);
        if (loanOpt.isEmpty()) return "Loan not found";

        Loan loan = loanOpt.get();
        loan.setStatus(isApproved ? "Approved" : "Rejected");
        loanRepo.save(loan);
        return "Loan " + (isApproved ? "approved" : "rejected");
    }
    public List<Loan> getAllLoans() {
        return loanRepo.findAll();  // Ensure Loan entity exists
    }*/
	
	
	public List<Map<String, Object>> getPendingLoans(List<Map<String, Object>> loans) {
        List<Map<String, Object>> pendingLoans = new ArrayList<>();
        for (Map<String, Object> loan : loans) {
            if ("Pending".equals(loan.get("status"))) {
                pendingLoans.add(loan);
            }
        }
        return pendingLoans;
    }

	public String approveLoan(Banking user, String loanId, boolean status) {
	    Optional<Banking> loanUser = repo.findById(loanId);

	    if (loanUser.isPresent()) {
	        Banking loan = loanUser.get();
	        loan.setAllowTrans(status); // Approve or Reject
	        repo.save(loan);
	        return "Loan " + (status ? "approved" : "rejected") + " for user: " + loan.getUsername();
	    } else {
	        throw new RuntimeException("Loan application not found for ID: " + loanId);
	    }
	}


    public List<Map<String, Object>> getAllLoans(List<Map<String, Object>> loans) {
        return loans;
    }
    public List<String> showApprovals(Banking banking) {
        List<String> approvals = new ArrayList<>();
        List<Banking> users = repo.findAll();
        
        for (Banking user : users) {
            if (user.isNeedLoan() && !user.isAllowTrans()) {
                approvals.add("Loan pending for user: " + user.getUsername());
            }
        }

        return approvals;
    }

	/*public String approveLoan(Banking employee, String loanId, boolean approve) {
        Optional<Banking> optionalBanking = repo.findById(loanId);
        if (!optionalBanking.isPresent()) {
            return "Loan application not found.";
        }

        Banking user = optionalBanking.get();
        user.setAllowTrans(approve);

        if (approve) {
            return loan(user, user.getLoanType(), user.getNeededLoan(), user.getLoanTime());
        } else {
            user.setNeedLoan(false);
            user.setLoanType(null);
            user.setNeededLoan(0);
            user.setLoanTime(0);
            repo.save(user);
            return "Loan is not approved.";
        }
    }
     
    // Show pending approvals
    public List<String> showApprovals(Banking employee) {
        if (!employee.isEmployee()) {
            throw new BankingException("Only employees can view approvals.");
        }

        List<Banking> pendingApprovals = repo.findAll().stream()
            .filter(user -> user.isNeededTransaction() || user.isNeedLoan())
            .collect(Collectors.toList());

        if (pendingApprovals.isEmpty()) {
            return List.of("No pending approvals.");
        }

        return pendingApprovals.stream()
            .map(user -> "User: " + user.getUsername() + 
                         " | Pending Loan: ₹" + user.getNeededLoan())
            .collect(Collectors.toList());
    }*/
}
