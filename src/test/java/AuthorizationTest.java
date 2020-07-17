import org.junit.jupiter.api.*;


public class AuthorizationTest {
    UserController userController;

    @BeforeEach
    void AuthorizationTest() {
        userController = new UserController();
        userController.loadUserList();
    }

    @Test
    @DisplayName("Проверка коректнности регистрации пользователя")
    public void checkSuccessfulUserRegistrationTest() throws RegisterException {
        Assertions.assertTrue(userController.register(new User("Белкин", "belka@mai.ru", "belkin77", "12345")),
                "Регистрация прошла не успешно");

    }

    @Test
    @DisplayName("Проверка ошибки регистрации")
    public void checkErrorUserRegistrationTest() throws RegisterException {
        Assertions.assertThrows(RegisterException.class, () -> userController.register(new User("Волкова Диана Андреевна", "voolf@tut.by", "voolfy",
                "Petrenko10")), "Ошибка генерации создания исключения при регистрации");

    }
}