import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bankingapplication.Bank.account.Account;
import com.Bankingapplication.Bank.account.AccountRepository;

@Service
public class TransactionService {

    @Autowired
    private TransactionHistoryRepository transactionHistoryRepository;

    @Autowired
    private AccountRepository accountRepository;

    // ஒரு transaction save செய்யும்
    public TransactionResponse saveHistory(TransactionRequest request) {
        Account account = accountRepository.findById(request.getAccountId())
                .orElseThrow(() -> new RuntimeException("Account not found: " + request.getAccountId()));
        TransactionHistory entity = TransactionMapper.toEntity(request, account);
        transactionHistoryRepository.save(entity);
        return TransactionMapper.toResponse(entity);
    }

    // ஒரு account க்கு அனைத்து transaction history
    public List<TransactionResponse> allHistory(String id) {
        return transactionHistoryRepository.findByAccount_Id(id)  // TransactionHistory fetch செய்கிறது
                .stream()
                .map(TransactionMapper::toResponse)                        // இதோ, வேலை செய்கிறது
                .collect(Collectors.toList());
    }

    // ஒரு type க்கு filter செய்ய
    public List<TransactionResponse> getHistoryByType(String accountId, TransactionType type) {
        return transactionHistoryRepository.findByAccount_IdAndType(accountId, type) // TransactionHistory fetch
                .stream()
                .map(TransactionMapper::toResponse)                                // வேலை செய்கிறது
                .collect(Collectors.toList());
    }
}