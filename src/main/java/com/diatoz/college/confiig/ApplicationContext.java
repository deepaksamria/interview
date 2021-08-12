package com.diatoz.college.confiig;

import com.diatoz.college.model.UserSession;

public class ApplicationContext {
    public static final String X_PASSWORD = "X-PASSWORD";
    public static final String AUTHORIZATION = "Authorization";
    public static final String X_USER_ROLE = "UserRole";
    public static final String X_USER_ID = "X-USER-ID";
    private static final ThreadLocal<UserSession> currentTenantContext = new ThreadLocal<>();

    public static UserSession getCurrentTenantContext() {
        return currentTenantContext.get();
    }

    public static void setCurrentContext(UserSession authenticationToken) {
        currentTenantContext.set(authenticationToken);
    }

    public static void clear() {
        currentTenantContext.remove();
    }

}
