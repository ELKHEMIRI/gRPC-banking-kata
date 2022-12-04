import accounts.AccountId;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AccountIdTest {

    private AccountId accountId;

    @Nested
    class GenerateShould {
        @Test
        void notBeEmpty() {
            accountId = AccountId.generate();

            assertThat(accountId).isNotNull();
            assertThat(accountId.toString()).isNotEmpty();
        }
    }

    @Nested
    class CreationShould {
        private AccountId anotherAccountId;

        @Test
        void throwErrorWhenValueIsNull() {
            assertThatThrownBy(() -> AccountId.from(null))
                    .isInstanceOf(NullPointerException.class);
        }

        @Test
        void throwErrorWhenValueIsEmpty() {
            assertThatThrownBy(() -> AccountId.from(""))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void beEqualWhenValueIsTheSame() {
            String value = "e6bc11f1-4982-48da-b4ce-eaaf7e16268a";
            AccountId accountId = AccountId.from(value);
            anotherAccountId = AccountId.from(value);

            assertThat(accountId).isEqualTo(anotherAccountId);
        }

        @Test
        void notBeEqualWhenValueIsDifferent() {
            String value = "e6bc11f1-4982-48da-b4ce-eaaf7e16268a";
            String differentValue = "e6bc11b3-4982-48eb-b4ce-fbaf7e12468a";
            accountId = AccountId.from(value);
            anotherAccountId = AccountId.from(differentValue);

            assertThat(accountId).isNotEqualTo(anotherAccountId);
        }
    }
}
