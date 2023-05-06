package app.util;

import app.User;
import org.hamcrest.collection.IsMapContaining;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class UserUtilsTest {
    static UserUtils utils;

    @BeforeAll
    static void init() {
        utils = new UserUtils();
    }

    @ParameterizedTest
    @ValueSource(strings = {"username", "username1", "Iuser2name", "h3loo", "dateObject"})
    void validateCorrectUsername(String userName) {
        boolean result = utils.validateUsername(userName);
        assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "as", "asd", "123", "2", "", "email@gmail.com"})
    void validateInCorrectUsername(String userName) {
        boolean result = utils.validateUsername(userName);
        assertFalse(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123Mki@", "Vklr5!", "User123&"})
    void validateCorrectPassword(String password) {
        boolean result = utils.validatePassword(password);
        assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "vjfh2", "qwerty@", "QWERTY", "", " ", "12345"})
    void validateInCorrectPassword(String password) {
        boolean result = utils.validatePassword(password);
        assertFalse(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"adh@gmail.com", "Vjfkfl@mail.com", "qwerty@user.net", "123@i.ua"})
    void validateCorrectEmail(String email) {
        boolean result = utils.validateEmail(email);
        assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"adh.gmail.com", "Vjfkfl@mail", "qwerty@.net", "@gmail.com", "", " "})
    void validateInCorrectEmail(String email) {
        boolean result = utils.validateEmail(email);
        assertFalse(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"02/29/2000", "02/01/1986"})
    void validateCorrectDate(String userName) {
        boolean result = utils.validateDate(userName);
        assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "asd", "1234", "2022-12-02", "02-12-2022", "2023/31/02"})
    void validateInCorrectDate(String date) {
        boolean result = utils.validateDate(date);
        assertFalse(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"+380502587425", "+480456982000", "+540503547896"})
    void validateCorrectPhoneNumber(String phone) {
        boolean result = utils.validatePhoneNumber(phone);
        assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "asd", "1234", "+3808252200"})
    void validateInCorrectPhoneNumber(String phone) {
        boolean result = utils.validatePhoneNumber(phone);
        assertFalse(result);
    }

    @Test
    void correctShowUsersLogins() {
        List<User> users = createUsers();
        users.add(createUser(111L, "username2", "SFirstName1", "Last Name1", "someone1@gmail.com1", LocalDate.of(1900, 01, 10), true, "+380502456781"));
        users.add(createUser(112L, "username3" + 112, "SFirstName1" + 112, "Last Name1" + 112, "someone1@gmail.com2", LocalDate.of(1900, 02, 10), true, "+380502456781"));
        List<String> filterUsers = utils.showUsersLogins(users);
        assertEquals(8, users.size());
        assertEquals(8, filterUsers.size());
    }

    @Test
    void incorrectShowUsersLogins() {
        List<User> users = createUsers();
        users.add(createUser(111L, "username2", "SFirstName1", "Last Name1", "someone1@gmail.com1", LocalDate.of(1900, 01, 10), true, "+380502456781"));
        users.add(createUser(112L, "username3" + 112, "SFirstName1" + 112, "Last Name1" + 112, "someone1@gmail.com2", LocalDate.of(1900, 02, 10), true, "+380502456781"));
        List<String> filterUsers = utils.showUsersLogins(users);
        assertNotEquals(9, users.size());
        assertNotEquals(9, users.size());
        assertNotEquals(7, filterUsers.size());
    }

    @Test
    void correctFilterByLastName() {
        List<User> users = createUsers();
        users.add(createUser(111L, "username2", "FirstName1", "SLast Name1", "someone1@gmail.com1", LocalDate.of(1900, 11, 10), true, "+380502456781"));
        users.add(createUser(112L, "username3", "FirstName2", "SLast Name2", "someone1@gmail.com2", LocalDate.of(1900, 11, 10), true, "+380502456781"));
        List<User> filterUsers = utils.filterByLastName(users, "S");
        assertEquals(8, users.size());
        assertEquals(2, filterUsers.size());
        assertFalse(filterUsers.isEmpty());
    }

    @Test
    void incorrectFilterByLastName() {
        List<User> users = createUsers();
        users.add(createUser(111L, "username2", "FirstName1", "SLast Name1", "someone1@gmail.com1", LocalDate.of(1900, 11, 10), true, "+380502456781"));
        users.add(createUser(112L, "username3", "FirstName2", "SLast Name2", "someone1@gmail.com2", LocalDate.of(1900, 11, 10), true, "+380502456781"));
        List<User> filterUsers = utils.filterByLastName(users, "P");
        assertNotEquals(0, users.size());
        assertNotEquals(2, filterUsers.size());
        assertTrue(filterUsers.isEmpty());
    }


    @Test
    void correctFilterCorrectMailEndingWithString() {
        List<User> users = createUsers();
        users.add(createUser(111L, "username1" + 0, "FirstName1" + 0, "Last Name1" + 0, "someone1@gmail.com1", LocalDate.of(1900, 11, 10), true, "+380502456781"));
        users.add(createUser(112L, "username1" + 112, "FirstName1" + 112, "Last Name1" + 112, "someone1@gmail.com2", LocalDate.of(1900, 11, 10), true, "+380502456781"));
        List<User> filterUsers = utils.filterCorrectMailEndingWithString(users, ".com");
        assertEquals(8, users.size());
        assertEquals(6, filterUsers.size());
        assertIterableEquals(createUsers(), filterUsers);
    }

    @Test
    void incorrectFilterCorrectMailEndingWithString() {
        List<User> users = createUsers();
        users.add(createUser(111L, "username1" + 0, "FirstName1" + 0, "Last Name1" + 0, "someone1@gmail.com1", LocalDate.of(1900, 11, 10), true, "+380502456781"));
        users.add(createUser(112L, "username1" + 112, "FirstName1" + 112, "Last Name1" + 112, "someone1@gmail.com2", LocalDate.of(1900, 11, 10), true, "+380502456781"));
        List<User> filterUsers = utils.filterCorrectMailEndingWithString(users, ".com1");
        assertNotEquals(3, users.size());
        assertNotEquals(12, filterUsers.size());
        assertFalse(filterUsers.isEmpty());
    }

    @Test
    void correctShowAvailable() {
        List<User> users = createUsers();
        users.add(createUser(111L, "username1" + 0, "SFirstName1" + 0, "Last Name1" + 0, "someone1@gmail.com1", LocalDate.of(1900, 11, 10), false, "+380502456781"));
        users.add(createUser(112L, "username1" + 112, "SFirstName1" + 112, "Last Name1" + 112, "someone1@gmail.com2", LocalDate.of(1900, 11, 10), false, "+380502456781"));
        List<User> filterUsers = utils.showAvailable(users);
        assertEquals(8, users.size());
        assertEquals(6, filterUsers.size());
        assertIterableEquals(createUsers(), filterUsers);
    }

    @Test
    void incorrectShowAvailable() {
        List<User> users = createUsers();
        users.add(createUser(111L, "username1" + 0, "SFirstName1" + 0, "Last Name1" + 0, "someone1@gmail.com1", LocalDate.of(1900, 11, 10), false, "+380502456781"));
        users.add(createUser(112L, "username1" + 112, "SFirstName1" + 112, "Last Name1" + 112, "someone1@gmail.com2", LocalDate.of(1900, 11, 10), false, "+380502456781"));
        List<User> filterUsers = utils.showAvailable(users);
        assertNotEquals(12, users.size());
        assertNotEquals(1, filterUsers.size());
    }

    @Test
    void correctViewOnlyWithPhone() {
        List<User> users = createUsers();
        users.add(createUser(111L, "username1", "SFirstName1", "Last Name1", "someone1@gmail.com1", LocalDate.of(1900, 11, 10), false, null));
        users.add(createUser(112L, "username1" + 112, "SFirstName1" + 112, "Last Name1" + 112, "someone1@gmail.com2", LocalDate.of(1900, 11, 10), false, ""));
        List<User> filterUsers = utils.showOnlyWithPhone(users);
        assertEquals(8, users.size());
        assertEquals(6, filterUsers.size());
        assertIterableEquals(createUsers(), filterUsers);
    }

    @Test
    void incorrectViewOnlyWithPhone() {
        List<User> users = createUsers();
        users.add(createUser(111L, "username1", "SFirstName1", "Last Name1", "someone1@gmail.com1", LocalDate.of(1900, 11, 10), false, null));
        users.add(createUser(112L, "username1" + 112, "SFirstName1" + 112, "Last Name1" + 112, "someone1@gmail.com2", LocalDate.of(1900, 11, 10), false, ""));
        List<User> filterUsers = utils.showOnlyWithPhone(users);
        assertNotEquals(2, users.size());
        assertNotEquals(12, filterUsers.size());
    }

    @Test
    void correctGroupUsers() {
        List<User> users = createUsers();
        users.add(createUser(111L, "username1" + 1, "SFirstName1" + 1, "ALast Name1" + 1, "someone1@gmail.com1", LocalDate.of(1900, 01, 10), true, "+380502456781"));
        users.add(createUser(112L, "username1" + 112, "SFirstName1" + 112, "Last Name1" + 112, "someone1@gmail.com2", LocalDate.of(1900, 02, 10), true, "+380502456781"));
        Map<String, List<User>> groupUsers = utils.groupUsers(users);
        assertEquals(8, users.size());
        assertThat(groupUsers.size(), is(8));
    }

    @Test
    void incorrectGroupUsers() {
        List<User> users = createUsers();
        users.add(createUser(111L, "username1" + 1, "SFirstName1" + 1, "ALast Name1" + 1, "someone1@gmail.com1", LocalDate.of(1900, 01, 10), true, "+380502456781"));
        users.add(createUser(112L, "username1" + 112, "SFirstName1" + 112, "Last Name1" + 112, "someone1@gmail.com2", LocalDate.of(1900, 02, 10), true, "+380502456781"));
        Map<String, List<User>> groupUsers = utils.groupUsers(users);
        assertNotEquals(12, users.size());
        assertNotEquals(1, groupUsers.size());
    }

    @Test
    void correctFindByPattern() {
        List<User> users = createUsers();
        users.add(createUser(111L, "username1", "SFirstName1", "ALast Name1", "someone1@gmail.com1", LocalDate.of(1900, 01, 10), true, "+380502456781"));
        users.add(createUser(112L, "username", "SFirstName1", "Last Name1", "someone1@gmail.com2", LocalDate.of(1900, 02, 10), true, "+380502456781"));
        List<User> findUsers = utils.findByPattern(users, "[a-zA-Z]{3,}[0-9]{2,}");
        assertEquals(6, findUsers.size());
    }

    @Test
    void incorrectFindByPattern() {
        List<User> users = createUsers();
        users.add(createUser(111L, "username1", "SFirstName1", "ALast Name1", "someone1@gmail.com1", LocalDate.of(1900, 01, 10), true, "+380502456781"));
        users.add(createUser(112L, "username", "SFirstName1", "Last Name1", "someone1@gmail.com2", LocalDate.of(1900, 02, 10), true, "+380502456781"));
        List<User> findUsers = utils.findByPattern(users, "[a-z]{1,}[0-9]{8,}");
        assertNotEquals(6, findUsers.size());
    }

    @Test
    void correctFindEarliestDate() {
        List<User> users = createUsers();
        users.add(createUser(111L, "username1" + 0, "SFirstName1" + 0, "Last Name1" + 0 + "", "someone1@gmail.com1", LocalDate.of(1900, 11, 10), true, "+380502456781"));
        users.add(createUser(112L, "username1" + 112, "SFirstName1" + 112, "Last Name1" + 112, "someone1@gmail.com2", LocalDate.of(1901, 11, 10), true, "+380502456781"));
        Map<Long, LocalDate> groupedUsers = utils.findEarliestDate(users);
        assertThat(groupedUsers.size(), is(1));
        assertThat(groupedUsers, IsMapContaining.hasEntry(111L, LocalDate.of(1900, 11, 10)));
    }

    @Test
    void incorrectFindEarliestDate() {
        List<User> users = createUsers();
        users.add(createUser(111L, "username1" + 0, "SFirstName1" + 0, "Last Name1" + 0 + "", "someone1@gmail.com1", LocalDate.of(1900, 11, 10), true, "+380502456781"));
        users.add(createUser(112L, "username1" + 112, "SFirstName1" + 112, "Last Name1" + 112, "someone1@gmail.com2", LocalDate.of(1901, 11, 10), true, "+380502456781"));
        Map<Long, LocalDate> groupedUsers = utils.findEarliestDate(users);
        assertNotEquals(2, groupedUsers.size());
        assertNotEquals(groupedUsers, IsMapContaining.hasEntry(111, LocalDate.of(1902, 12, 12)));
    }

    @Test
    void correctFilterByYearSortByMonth() {
        List<User> users = createUsers();
        users.add(createUser(111L, "username1" + 0, "SFirstName1" + 0, "Last Name1" + 0 + "", "someone1@gmail.com1", LocalDate.of(1900, 01, 10), true, "+380502456781"));
        users.add(createUser(112L, "username1" + 112, "SFirstName1" + 112, "Last Name1" + 112, "someone1@gmail.com2", LocalDate.of(1986, 02, 10), true, "+380502456781"));
        Map<Month, List<User>> sortedByMonthUsers = utils.filterByYearSortByMonth(users, LocalDate.of(1986, 01, 01));
        assertThat(sortedByMonthUsers.size(), is(2));
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
        List<User> users = createUsers();
        users.add(createUser(111L, "username1" + 0, "SFirstName1" + 0, "Last Name1" + 0 + "", "someone1@gmail.com1", LocalDate.of(1900, 01, 10), true, "+380502456781"));
        users.add(createUser(112L, "username1" + 112, "SFirstName1" + 112, "Last Name1" + 112, "someone1@gmail.com2", LocalDate.of(1986, 02, 10), true, "+380502456781"));
        Map<Month, List<User>> sortedByMonthUsers = utils.filterByYearSortByMonth(users, LocalDate.of(1986, 01, 01));
        assertNotEquals(8, sortedByMonthUsers.size());
        assertNotEquals(sortedByMonthUsers, IsMapContaining.hasKey(Month.of(3)));
        List<User> testUser = new ArrayList<>();
        testUser.add(users.get(4));
        System.out.println(testUser);
        assertNotEquals(sortedByMonthUsers, IsMapContaining.hasValue(testUser));
        testUser.add(users.get(3));
        assertThat(sortedByMonthUsers, not(IsMapContaining.hasValue(testUser)));
    }

    private User createUser(Long id, String username, String firstNme, String lastName, String email, LocalDate birthday, boolean isAvailable, String phoneNumber) {
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

    private List<User> createUsers() {
        User user;
        List<User> list = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            user = createUser((long) i, "username1" + i, "FirstName1" + i, "Last Name1" + i, "someone1@gmail.com", LocalDate.of(1980 + i, 05, 10 + i), true, "+380502456781");
            list.add(user);
        }
        return list;
    }
}