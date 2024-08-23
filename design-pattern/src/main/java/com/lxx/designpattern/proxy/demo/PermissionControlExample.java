package com.lxx.designpattern.proxy.demo;

interface User {
    void performAction();
}

class AuthenticatedUser implements User {
    @Override
    public void performAction() {
        System.out.println("Authenticated user is performing an action.");
    }
}

/**
 * 代理模式 权限控制
 */
class UserProxy implements User {
    private User user;

    public UserProxy(User user) {
        this.user = user;
    }

    @Override
    public void performAction() {
        // 检查用户是否已登录
        if (isUserAuthenticated()) {
            user.performAction();
        } else {
            System.out.println("Access denied. User is not authenticated.");
        }
    }

    private boolean isUserAuthenticated() {
        // 模拟检查用户是否已登录的逻辑
        // 可以根据实际情况进行实现
        return true;
    }
}

public class PermissionControlExample {
    public static void main(String[] args) {
        // 创建已登录用户对象
        AuthenticatedUser authenticatedUser = new AuthenticatedUser();

        // 创建代理对象，并将已登录用户对象传递给它
        UserProxy proxy = new UserProxy(authenticatedUser);

        // 调用 performAction 方法，进行权限控制
        proxy.performAction();
    }
}
