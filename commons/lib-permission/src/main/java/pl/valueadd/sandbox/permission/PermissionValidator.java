package pl.valueadd.sandbox.permission;

import pl.valueadd.sandbox.permission.dto.Permission;
import pl.valueadd.sandbox.permission.dto.PermissionDeniedException;

public class PermissionValidator {

    public boolean validate(Permission permission) {
        if (permission.isCan()) {
            return true;
        }
        permission.findMessage().ifPresent(msg -> {
            throw new PermissionDeniedException(msg);
        });

        return false;
    }
}