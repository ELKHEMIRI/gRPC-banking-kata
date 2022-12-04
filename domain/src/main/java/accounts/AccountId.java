package accounts;

import java.util.Objects;
import java.util.UUID;

import static java.util.Objects.requireNonNull;

public class AccountId {
    private final UUID uuid;

    private AccountId(UUID uuid) {
        this.uuid = uuid;
    }

    public static AccountId generate() {
        return new AccountId(UUID.randomUUID());
    }

    public static AccountId from(String value) {
        requireNonNull(value);
        checkNotEmpty(value);
        return new AccountId(UUID.fromString(value));
    }

    private static void checkNotEmpty(String value) {
        if(value.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return uuid.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountId accountId = (AccountId) o;
        return Objects.equals(uuid, accountId.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
