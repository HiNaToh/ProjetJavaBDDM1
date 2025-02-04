package fr.insa.ProjetJavaBDD.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.insa.ProjetJavaBDD.exceptions.FunctionnalProcessException;
import fr.insa.ProjetJavaBDD.models.Compte;
import fr.insa.ProjetJavaBDD.models.Transaction;
import fr.insa.ProjetJavaBDD.repositories.TransactionRepository;
import fr.insa.ProjetJavaBDD.ressouces.dto.TransactionCreateModel;

@Service
public class TransactionService {
	@Autowired
	private TransactionRepository transactionRepository;
	
	private CompteService compteService;
	
	public List<Transaction> getOptionalTransactionMontantTransacOrderByDateTransac(Integer montantTransac) {
        return this.transactionRepository.findByMontantTransacOrderByDateTransac(montantTransac);
    } 
	
	public Transaction saveTransaction(TransactionCreateModel transactionToCreate)  throws FunctionnalProcessException
	{
		Compte compte=compteService.getCompteById(transactionToCreate.getNum_Compte());
		
		Transaction transaction = Transaction.builder()
				.dateTransac(new Date())
				.montantTransac(transactionToCreate.getMontantTransac())
				.compte(compte)
				.build();
		
		
		
		return this.transactionRepository.save(transaction);
	}
}
