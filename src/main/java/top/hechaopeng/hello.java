package top.hechaopeng;

import top.hechaopeng.auth.AuthService;

public class hello {
    public static void main(String[] args) {
        AuthService authService = new AuthService();
        authService.getAuth();
    }
}
