import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AccountUtils {
    public void showAccountsByBalance(List<Account> accountsList, Double balance){
        accountsList.stream()
                .filter(user->user.getBalance()>balance)
                .forEach(System.out::println);

    }
    public void showAccountsByCountry(List<Account> accountsList, String country){
        accountsList.stream()
                .filter(user->user.getCountry().equals(country))
                .map(user->"User firstname: "+ user.getFirstName()+","+"User lastname: "+user.getLastName())
                .forEach(System.out::println);

    }
    public List<Account> getListAccountsByMonth(List<Account> listAccounts, int month) {
        return listAccounts.stream()
                .filter(account -> account.getBirthday().getMonthValue() == month)
                .collect(Collectors.toList());
    }
    public long countAccountsByGender(List<Account> listAccounts, String gender){
        return listAccounts.stream()
                .filter(user->user.getGender().equals(gender))
                .count();
    }
    public Double getBalanceByLastName(List<Account> listAccounts, String lastName){
        return listAccounts.stream()
                .filter(us->us.getLastName().equals(lastName))
                .mapToDouble(user->(user.getBalance()))
                .reduce(Double.valueOf(0),(us1, us2)->us1+us2);
    }
    public List<Account> sortListByName(List<Account> accountList){
        return accountList.stream()
                        .sorted(Comparator
                                .comparing((Account account) -> account.getLastName())
                                .thenComparing(account1 -> account1.getFirstName()))
                        .collect(Collectors.toList());
    }
    public List<Account> getListAccountsByYear(List<List<Account>> listOfListsAccounts, int year){
        return listOfListsAccounts.stream()
                .flatMap(account->account.stream())
                .filter(account -> account.getAge()>=year)
                .collect(Collectors.toList());
    }
    public Map<String, List<Account>> getSortedByCountry(List<Account> listAccounts){
        Map<String,List<Account>> accountMap = listAccounts.stream()
                .collect(Collectors.groupingBy(Account::getCountry));
        return accountMap;
    }
}
