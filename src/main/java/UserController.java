import java.util.ArrayList;

public class UserController {
    ArrayList<User>  userList;

    void loadUserList() {
        userList = new ArrayList<User>();
        userList.add(new User("Петренко Денис Сергеевич", "petrenko@mail.ru", "petrro", "Petrenko10"));
        userList.add(new User("Волкова Диана Андреевна", "voolf@tut.by", "voolfy", "Petrenko10"));
        userList.add(new User("Белко Ольга Петровна", "bebeshka@gmail.com", "squirell", "Petrenko10"));
    }

    boolean register(User newUser) throws RegisterException { //++++

        for (User record : userList) {
            if (record.getEmail().equals(newUser.getEmail()) && record.getLogin().equals(newUser.getLogin())) {
                throw new RegisterException("Такой пльзователь уже существует");
            }
        }
        userList.add(newUser);
        return true;
    }


    boolean checkPassword(String login, String password) { //++++
        for (User record : userList) {
            if (record.getLogin().equals(login) && (record.getPassword().equals(password))) {
                return true;

            }
        }
        return false;
    }

    User getUser(String login) { //++++
        for (User record : userList) {
            if (record.getLogin().equals(login)) {
                return record;
            }
        }
        return null;
    }

    void sendActivationEmail(String login, String email) throws ActivationException {//++
        for (User record : userList) {
            if (record.getLogin().equals(login) && record.getEmail().equals(email)) {
                // происходит отправка сообщения!
                return;
            }
        }
        throw new ActivationException("Данный пользователь не найден");

    }

    boolean createDBConnection() { //++++
        if (userList == null) {
            return false;
        } else
            return true;
    }

    User createUser(String fio, String email, String login, String password, String passwordConfirmation) throws CreateUserException { //++++
        if (!fio.matches("[\\p{L}| ]+")) { //"(?ui)[\\p{L}| ]"
            throw new CreateUserException("Не корректное ФИО");
        }
        if (!email.matches("/^\\w+([\\.\\w]+)*\\w@\\w((\\.\\w)*\\w+)*\\.\\w{2,3}$/")) {
            throw new CreateUserException("Не корректный Email");
        }
        if (!login.matches("/[A-Za-z0-9]/")) {
            throw new CreateUserException("Не корректный Login");
        }
        for (User record : userList) {
            if (record.getLogin().equals(login)) {
                throw new CreateUserException("Login Занят!");
            }
        }
        if (!password.matches("/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[^\\w\\s]).{6,}/")) {
            throw new CreateUserException("Пароль не корректный");
        }
        if (!password.equals(passwordConfirmation)) {
            throw new CreateUserException("Пароли не совпадают");
        }


        User newUser = new User(fio, email, login, password);
        userList.add(newUser);

        return newUser;
    }

}
