public UserService() {
    this.users = new ArrayList<>();
}

@Override
public boolean login(String email, String password) {
    for (IUser user : users) {
        if (user.login(email, password)) {
            return true;
        }
    }
    return false;
}

@Override
public void Register(IUser user) {
    users.add(user);
}

public List<IUser> getUsers() {
    return users;
}