package app.util;

import app.User;
import org.hamcrest.collection.IsMapContaining;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;


class UserUtilsTest {
    @ParameterizedTest
    @ValueSource(strings = {"username", "username1", "Iuser2name","h3loo","dateObject"})
    void validateCorrectUsername(String userName) {
        UserUtils utils =new UserUtils();
        boolean result=utils.validateUsername(userName);
        assertTrue(result);
    }
    @ParameterizedTest
    @ValueSource(strings = {"a", "as", "asd","123","2","","email@gmail.com"})
    void validateInCorrectUsername(String userName) {
        UserUtils utils =new UserUtils();
        boolean result=utils.validateUsername(userName);
        assertFalse(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123Mki@", "Vklr5!","User123&"})
    void validateCorrectPassword(String password) {
        UserUtils utils =new UserUtils();
        boolean result=utils.validatePassword(password);
        assertTrue(result);
    }
    @ParameterizedTest
    @ValueSource(strings = {"123", "vjfh2", "qwerty@","QWERTY", "", " ", "12345"})
    void validateInCorrectPassword(String password) {
        UserUtils utils =new UserUtils();
        boolean result= utils.validatePassword(password);
        assertFalse(result);
    }
    @ParameterizedTest
    @ValueSource(strings = {"adh@gmail.com", "Vjfkfl@mail.com", "qwerty@user.net","123@i.ua"})
    void validateCorrectEmail(String email) {
        UserUtils utils =new UserUtils();
        boolean result=utils.validateEmail(email);
        assertTrue(result);
    }
    @ParameterizedTest
    @ValueSource(strings = {"adh.gmail.com", "Vjfkfl@mail", "qwerty@.net","@gmail.com", "", " "})
    void validateInCorrectEmail(String email) {
        UserUtils utils =new UserUtils();
        boolean result=utils.validateEmail(email);
        assertFalse(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"02/29/2000", "02/01/1986"})
    void validateCorrectDate(String userName) {
        UserUtils utils =new UserUtils();
        boolean result=utils.validateDate(userName);
        assertTrue(result);
    }
    @ParameterizedTest
    @ValueSource(strings = {"", "asd", "1234", "2022-12-02", "02-12-2022","2023/31/02"})
    void validateInCorrectDate(String date) {
        UserUtils utils =new UserUtils();
        boolean result=utils.validateDate(date);
        assertFalse(result);
    }
    @ParameterizedTest
    @ValueSource(strings = {"+380502587425", "+480456982000", "+540503547896"})
    void validateCorrectPhoneNumber(String phone) {
        UserUtils utils =new UserUtils();
        boolean result=utils.validatePhoneNumber(phone);
        assertTrue(result);
    }
    @ParameterizedTest
    @ValueSource(strings = {"", "asd", "1234", "+3808252200"})
    void validateInCorrectPhoneNumber(String phone) {
        UserUtils utils =new UserUtils();
        boolean result=utils.validatePhoneNumber(phone);
        assertFalse(result);
    }

    @Test
    void correctShowUsersLogins() {
        UserUtils utils=new UserUtils();
        List<User> users=createUsers();
        users.add(createUser(111,"username2", "SFirstName1", "Last Name1", "someone1@gmail.com1", LocalDate.of(1900,01,10),true,"+380502456781"));
        users.add(createUser(112,"username3"+112, "SFirstName1"+112, "Last Name1"+112, "someone1@gmail.com2", LocalDate.of(1900,02,10),true,"+380502456781"));
        List<String> filterUsers=utils.showUsersLogins(users);
        assertEquals(8,users.size());
        assertEquals(8,filterUsers.size());
    }

    @Test
    void incorrectShowUsersLogins() {
        UserUtils utils=new UserUtils();
        List<User> users=createUsers();
        users.add(createUser(111,"username2", "SFirstName1", "Last Name1", "someone1@gmail.com1", LocalDate.of(1900,01,10),true,"+380502456781"));
        users.add(createUser(112,"username3"+112, "SFirstName1"+112, "Last Name1"+112, "someone1@gmail.com2", LocalDate.of(1900,02,10),true,"+380502456781"));
        List<String> filterUsers=utils.showUsersLogins(users);
        assertFalse(users.size() == 9);
        assertNotEquals(9,users.size());
        assertNotEquals(7,filterUsers.size());
    }

    @Test
    void correctFilterByLastName() {
        UserUtils utils=new UserUtils();
        List<User> users=createUsers();
        users.add(createUser(111,"username2", "FirstName1", "SLast Name1", "someone1@gmail.com1", LocalDate.of(1900,11,10),true,"+380502456781"));
        users.add(createUser(112,"username3", "FirstName2", "SLast Name2", "someone1@gmail.com2", LocalDate.of(1900,11,10),true,"+380502456781"));
        List<User> filterUsers=utils.filterByLastName(users,"S");
        assertEquals(8,users.size());
        assertEquals(2,filterUsers.size());
        assertFalse(filterUsers.isEmpty());
    }

    @Test
    void incorrectFilterByLastName() {
        UserUtils utils=new UserUtils();
        List<User> users=createUsers();
        users.add(createUser(111,"username2", "FirstName1", "SLast Name1", "someone1@gmail.com1", LocalDate.of(1900,11,10),true,"+380502456781"));
        users.add(createUser(112,"username3", "FirstName2", "SLast Name2", "someone1@gmail.com2", LocalDate.of(1900,11,10),true,"+380502456781"));
        List<User> filterUsers=utils.filterByLastName(users,"P");
        assertNotEquals(0,users.size());
        assertNotEquals(2,filterUsers.size());
        assertTrue(filterUsers.isEmpty());
    }


    @Test
    void correctFilterCorrectMailEndingWithString() {
        UserUtils utils=new UserUtils();
        List<User> users=createUsers();
        users.add(createUser(111,"username1"+0, "FirstName1"+0, "Last Name1"+0, "someone1@gmail.com1", LocalDate.of(1900,11,10),true,"+380502456781"));
        users.add(createUser(112,"username1"+112, "FirstName1"+112, "Last Name1"+112, "someone1@gmail.com2", LocalDate.of(1900,11,10),true,"+380502456781"));
        List<User> filterUsers=utils.filterCorrectMailEndingWithString(users,".com");
        assertEquals(8,users.size());
        assertEquals(6,filterUsers.size());
        assertIterableEquals(createUsers(),filterUsers);
    }

    @Test
    void incorrectFilterCorrectMailEndingWithString() {
        UserUtils utils=new UserUtils();
        List<User> users=createUsers();
        users.add(createUser(111,"username1"+0, "FirstName1"+0, "Last Name1"+0, "someone1@gmail.com1", LocalDate.of(1900,11,10),true,"+380502456781"));
        users.add(createUser(112,"username1"+112, "FirstName1"+112, "Last Name1"+112, "someone1@gmail.com2", LocalDate.of(1900,11,10),true,"+380502456781"));
        List<User> filterUsers=utils.filterCorrectMailEndingWithString(users,".com1");
        assertNotEquals(3,users.size());
        assertNotEquals(12,filterUsers.size());
        assertFalse(filterUsers.isEmpty());
    }

    @Test
    void correctShowAvailable() {
        UserUtils utils=new UserUtils();
        List<User> users=createUsers();
        users.add(createUser(111,"username1"+0, "SFirstName1"+0, "Last Name1"+0, "someone1@gmail.com1", LocalDate.of(1900,11,10),false,"+380502456781"));
        users.add(createUser(112,"username1"+112, "SFirstName1"+112, "Last Name1"+112, "someone1@gmail.com2", LocalDate.of(1900,11,10),false,"+380502456781"));
        List<User> filterUsers=utils.showAvailable(users);
        assertEquals(8,users.size());
        assertEquals(6,filterUsers.size());
        assertIterableEquals(createUsers(),filterUsers);
    }

    @Test
    void incorrectShowAvailable() {
        UserUtils utils=new UserUtils();
        List<User> users=createUsers();
        users.add(createUser(111,"username1"+0, "SFirstName1"+0, "Last Name1"+0, "someone1@gmail.com1", LocalDate.of(1900,11,10),false,"+380502456781"));
        users.add(createUser(112,"username1"+112, "SFirstName1"+112, "Last Name1"+112, "someone1@gmail.com2", LocalDate.of(1900,11,10),false,"+380502456781"));
        List<User> filterUsers=utils.showAvailable(users);
        assertNotEquals(12,users.size());
        assertNotEquals(1,filterUsers.size());
    }

    @Test
    void correctViewOnlyWithPhone() {
        UserUtils utils=new UserUtils();
        List<User> users=createUsers();
        users.add(createUser(111,"username1", "SFirstName1", "Last Name1", "someone1@gmail.com1", LocalDate.of(1900,11,10),false,null));
        users.add(createUser(112,"username1"+112, "SFirstName1"+112, "Last Name1"+112, "someone1@gmail.com2", LocalDate.of(1900,11,10),false,""));
        List<User> filterUsers=utils.showOnlyWithPhone(users);
        assertEquals(8,users.size());
        assertEquals(6,filterUsers.size());
        assertIterableEquals(createUsers(),filterUsers);
    }

    @Test
    void incorrectViewOnlyWithPhone() {
        UserUtils utils=new UserUtils();
        List<User> users=createUsers();
        users.add(createUser(111,"username1", "SFirstName1", "Last Name1", "someone1@gmail.com1", LocalDate.of(1900,11,10),false,null));
        users.add(createUser(112,"username1"+112, "SFirstName1"+112, "Last Name1"+112, "someone1@gmail.com2", LocalDate.of(1900,11,10),false,""));
        List<User> filterUsers=utils.showOnlyWithPhone(users);
        assertNotEquals(2,users.size());
        assertNotEquals(12,filterUsers.size());
    }

    @Test
    void correctGroupUsers() {
        UserUtils utils=new UserUtils();
        List<User> users=createUsers();
        users.add(createUser(111,"username1"+1, "SFirstName1"+1, "ALast Name1"+1, "someone1@gmail.com1", LocalDate.of(1900,01,10),true,"+380502456781"));
        users.add(createUser(112,"username1"+112, "SFirstName1"+112, "Last Name1"+112, "someone1@gmail.com2", LocalDate.of(1900,02,10),true,"+380502456781"));
        Map<String, List<User>> groupUsers = utils.groupUsers(users);
        assertEquals(8,users.size());
        assertThat(groupUsers.size(),is(8));
    }

    @Test
    void incorrectGroupUsers() {
        UserUtils utils=new UserUtils();
        List<User> users=createUsers();
        users.add(createUser(111,"username1"+1, "SFirstName1"+1, "ALast Name1"+1, "someone1@gmail.com1", LocalDate.of(1900,01,10),true,"+380502456781"));
        users.add(createUser(112,"username1"+112, "SFirstName1"+112, "Last Name1"+112, "someone1@gmail.com2", LocalDate.of(1900,02,10),true,"+380502456781"));
        Map<String, List<User>> groupUsers = utils.groupUsers(users);
        assertNotEquals(12,users.size());
        assertFalse(groupUsers.size()==1);
    }

    @Test
    void correctFindByPattern() {
        UserUtils utils=new UserUtils();
        List<User> users=createUsers();
        users.add(createUser(111,"username1", "SFirstName1", "ALast Name1", "someone1@gmail.com1", LocalDate.of(1900,01,10),true,"+380502456781"));
        users.add(createUser(112,"username", "SFirstName1", "Last Name1", "someone1@gmail.com2", LocalDate.of(1900,02,10),true,"+380502456781"));
        List<User> findUsers=utils.findByPattern(users,"[a-zA-Z]{3,}[0-9]{2,}");
        assertEquals(6,findUsers.size());
    }

    @Test
    void incorrectFindByPattern() {
        UserUtils utils=new UserUtils();
        List<User> users=createUsers();
        users.add(createUser(111,"username1", "SFirstName1", "ALast Name1", "someone1@gmail.com1", LocalDate.of(1900,01,10),true,"+380502456781"));
        users.add(createUser(112,"username", "SFirstName1", "Last Name1", "someone1@gmail.com2", LocalDate.of(1900,02,10),true,"+380502456781"));
        List<User> findUsers=utils.findByPattern(users,"[a-z]{1,}[0-9]{8,}");
        assertNotEquals(6,findUsers.size());
    }

    @Test
    void correctFindEarliestDate() {
        UserUtils utils=new UserUtils();
        List<User> users=createUsers();
        users.add(createUser(111,"username1"+0, "SFirstName1"+0, "Last Name1"+0+"", "someone1@gmail.com1", LocalDate.of(1900,11,10),true,"+380502456781"));
        users.add(createUser(112,"username1"+112, "SFirstName1"+112, "Last Name1"+112, "someone1@gmail.com2", LocalDate.of(1901,11,10),true,"+380502456781"));
        Map<Integer, LocalDate> groupedUsers = utils.findEarliestDate(users);
        assertThat(groupedUsers.size(),is(1));
        assertThat(groupedUsers, IsMapContaining.hasEntry(111, LocalDate.of(1900,11,10)));
    }

    @Test
    void incorrectFindEarliestDate() {
        UserUtils utils=new UserUtils();
        List<User> users=createUsers();
        users.add(createUser(111,"username1"+0, "SFirstName1"+0, "Last Name1"+0+"", "someone1@gmail.com1", LocalDate.of(1900,11,10),true,"+380502456781"));
        users.add(createUser(112,"username1"+112, "SFirstName1"+112, "Last Name1"+112, "someone1@gmail.com2", LocalDate.of(1901,11,10),true,"+380502456781"));
        Map<Integer, LocalDate> groupedUsers = utils.findEarliestDate(users);
        assertFalse(groupedUsers.size()==2);
        assertNotEquals(groupedUsers, IsMapContaining.hasEntry(111, LocalDate.of(1902,12,12)));
    }

    @Test
    void correctFilterByYearSortByMonth() {
        UserUtils utils=new UserUtils();
        List<User> users=createUsers();
        users.add(createUser(111,"username1"+0, "SFirstName1"+0, "Last Name1"+0+"", "someone1@gmail.com1", LocalDate.of(1900,01,10),true,"+380502456781"));
        users.add(createUser(112,"username1"+112, "SFirstName1"+112, "Last Name1"+112, "someone1@gmail.com2", LocalDate.of(1986,02,10),true,"+380502456781"));
        Map<Month,List<User>> sortedByMonthUsers  = utils.filterByYearSortByMonth(users,LocalDate.of(1986,01,01));
        assertThat(sortedByMonthUsers.size(),is(2));
        assertThat(sortedByMonthUsers, IsMapContaining.hasKey(Month.of(5)));
        assertThat(sortedByMonthUsers, IsMapContaining.hasKey(Month.of(2)));
        assertThat(sortedByMonthUsers, not(IsMapContaining.hasKey(Month.of(4))));
        List<User> testUser = new ArrayList<>();
        testUser.add(users.get(5));
        assertThat(sortedByMonthUsers, IsMapContaining.hasValue(testUser));
        testUser.clear();
        testUser.add(users.get(7));
        assertThat(sortedByMonthUsers, IsMapContaining.hasValue(testUser));
    }

    @Test
    void incorrectFilterByYearSortByMonth() {
        UserUtils utils=new UserUtils();
        List<User> users=createUsers();
        users.add(createUser(111,"username1"+0, "SFirstName1"+0, "Last Name1"+0+"", "someone1@gmail.com1", LocalDate.of(1900,01,10),true,"+380502456781"));
        users.add(createUser(112,"username1"+112, "SFirstName1"+112, "Last Name1"+112, "someone1@gmail.com2", LocalDate.of(1986,02,10),true,"+380502456781"));
        Map<Month,List<User>> sortedByMonthUsers  = utils.filterByYearSortByMonth(users,LocalDate.of(1986,01,01));
        assertFalse(sortedByMonthUsers.size()==8);
        assertFalse(sortedByMonthUsers.equals(IsMapContaining.hasKey(Month.of(3))));
        List<User> testUser = new ArrayList<>();
        testUser.add(users.get(4));
        System.out.println(testUser);
        assertFalse(sortedByMonthUsers.equals(IsMapContaining.hasValue(testUser)));
        testUser.add(users.get(3));
        assertThat(sortedByMonthUsers, not(IsMapContaining.hasValue(testUser)));
    }

    private User createUser(int id, String username, String firstNme, String lastName, String email, LocalDate birthday, boolean isAvailable, String phoneNumber){
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setEmail(email);
        user.setFirstName(firstNme);
        user.setLastName(lastName);
        user.setDate(birthday);
        user.setAvailable(isAvailable);
        user.setPhoneNumber(phoneNumber);
        return user;
    }
    private List<User> createUsers(){
        User user;
        List<User> list=new ArrayList<>();
        for (int i=1;i<=6;i++){
            user=createUser(i,"username1"+i, "FirstName1"+i, "Last Name1"+i, "someone1@gmail.com", LocalDate.of(1980+i,05,10+i),true,"+380502456781");
            list.add(user);
        }
        return list;
    }
}