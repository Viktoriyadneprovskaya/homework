//Создать класс Account c полями firstName, lastName, country, birthday, balance, gender (и все сопутствующие методы необходимые для работы с классом)
//создать класс AccountUtils в котором будет реализована логика изменения акаунтов. Для примера лучше использовать 10+ акаунтов
//1) Создать метод который обрабатывает полученный список аккаунтов возвращая акаунты с балансом больше 1000
//2) Создать метод который обрабатывает полученный список аккаунтов возвращая список имя+фамилия в акаунтах, где страна Бразилия
//3) Создать метод который обрабатывает полученный список аккаунтов возвращая Optional<Account> с наибольшим балансом
//4) Создать метод который обрабатывает полученный список аккаунтов, принимая как параметр месяц рождения, метод должен вывести на екран всех пользователей с указанным месяцем рождения, ничего не возвращая
//5) Создать метод который обрабатывает полученный список аккаунтов, вернуть кол-во акаунтов с женским полом
//6) Создать метод который обрабатывает полученный список аккаунтов, вернуть общую сумму на счетах всех аккаунтов с фамилией "johnson"
//7) Создать метод который обрабатывает полученный список аккаунтов, вернуть отсортированный список пользователей, по фамилии, если фамилия совпадает то по имени
//8) Создать метод который обрабатывает полученный список аккаунтов, который возвращает сгруппированную коллекцию по странам
//9) Реализовать метод который принимает список списков акаунтов (List<List<Account>>) который считает кол-во акаунтов с возрастом 30+ лет. В примере создать три разных списка акакунтов


import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Account user1 = new Account("Peter","Petrov", "Ukraine",  LocalDate.of(1991,02,21),1000.00, "male");
        Account user2 = new Account("Max","Maximov", "Poland", LocalDate.of(1986,06,15), 1500.50, "male");
        Account user3 = new Account("Sergio","Sergeev", "Ukraine", LocalDate.of(1989,02,25), 25478.8, "male");
        Account user4 = new Account("Kate","Ivanova", "Ukraine", LocalDate.of(1979,03,30), 1000056.25, "female");
        Account user5 = new Account("Monika","Petrova", "USA", LocalDate.of(1982,04,18), 243.5, "female");
        Account user6 = new Account("Eric","Smith", "Germany", LocalDate.of(1985,12,15), 5789.23, "male");
        Account user7 = new Account("Alex","Exel", "Italy", LocalDate.of(2002,01,24), 255687.25, "male");
        Account user8 = new Account("Nata","Johnson", "Ukraine", LocalDate.of(1976,05,03), 6578.21, "female");
        Account user9 = new Account("Miroslava","May", "USA", LocalDate.of(2000,01,05), 569871.32, "female");
        Account user10 = new Account("Erica","Johnson", "Brazil", LocalDate.of(1986,06,02), 985.25, "female");
        Account user11 = new Account("John","Gym", "Poland", LocalDate.of(1981,12,30), 15478.27, "male");
        Account user12 = new Account("Liza","Verna", "Ukraine", LocalDate.of(1985,03,25), 5458787.14, "female");
        Account user13 = new Account("Oksana","Evseenko", "Ukraine", LocalDate.of(1978,06,06), 4587.25, "female");
        Account user14 = new Account("Dmytro","Bondarenko", "Ukraine", LocalDate.of(1993,02,11), 457.19, "male");
        Account user15 = new Account("Mary","Johnson", "Brazil", LocalDate.of(1993,02,28), 125.47, "female");
        List<Account> listAccounts = new ArrayList<>();
        listAccounts.add(user1);
        listAccounts.add(user2);
        listAccounts.add(user3);
        listAccounts.add(user4);
        listAccounts.add(user5);
        listAccounts.add(user6);
        listAccounts.add(user7);
        listAccounts.add(user8);
        listAccounts.add(user9);
        listAccounts.add(user10);
        listAccounts.add(user11);
        listAccounts.add(user12);
        listAccounts.add(user13);
        listAccounts.add(user14);
        listAccounts.add(user15);

        Account user1_1 = new Account("Peter1","Petrov", "Ukraine",  LocalDate.of(1994,02,21),1000.00, "male");
        Account user1_2 = new Account("Max1","Maximov", "Poland", LocalDate.of(1986,06,15), 1500.50, "male");
        List<Account> listAccounts1 = new ArrayList<>();
        listAccounts.add(user1_1);
        listAccounts.add(user1_2);

        Account user2_1 = new Account("Peter2","Petrov", "Ukraine",  LocalDate.of(1991,02,21),1000.00, "male");
        Account user2_2 = new Account("Max2","Maximov", "Poland", LocalDate.of(1996,06,15), 1500.50, "male");
        List<Account> listAccounts2 = new ArrayList<>();
        listAccounts.add(user2_1);
        listAccounts.add(user2_2);

        System.out.println("#1");
        AccountUtils accountUtils = new AccountUtils();
        accountUtils.showAccountsByBalance(listAccounts,1000.00);
        System.out.println();

        System.out.println("#2");
        accountUtils.showAccountsByCountry(listAccounts,"Brazil");
        System.out.println();

        System.out.println("#3");
        Optional<Account> optional = listAccounts.stream()
                .max(Comparator.comparing(account -> account.getBalance()));
        System.out.println(optional.isEmpty());
        System.out.println(optional.isPresent());
        System.out.println(optional.get());
        System.out.println();

        System.out.println("#4");
        List<Account> sortedAccount = accountUtils.getListAccountsByMonth(listAccounts,1);
        System.out.println(sortedAccount);
        System.out.println();

        System.out.println("#5");
        long count=accountUtils.countAccountsByGender(listAccounts,"female");
        System.out.println(count);
        System.out.println();

        System.out.println("#6");
        Double Sum= accountUtils.getBalanceByLastName(listAccounts,"Johnson");
        System.out.println(Sum);
        System.out.println();

        System.out.println("#7");
        List<Account> sortedByName = accountUtils.sortListByName(listAccounts);
        sortedByName.forEach(System.out::println);
        System.out.println("#8");
        List<Account> sortedByCountry =accountUtils.getSortedByCountry(listAccounts);
        sortedByCountry.forEach(System.out::println);
        System.out.println("#9");
        List<List<Account>> listOfLists = Arrays.asList(listAccounts,listAccounts1,listAccounts2);


        List<Account> sortedByYear=accountUtils.getListAccountsByYear(listOfLists,30);
        sortedByYear.forEach(System.out::println);



    }
}
