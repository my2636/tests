import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestOptimalTaxTest {

    @ParameterizedTest
    @CsvSource({"20000, 1", "300000, 2", "1000000, 5", "-100, -4"})
    void variousVariableInputTest(int sum, int inputOperation) {


        //given
        int earnings = 0;
        int spendings = 0;
        int operation = inputOperation;

        //when
        switch (operation) {
            case 1:
                System.out.println("\nВведите сумму дохода:\n");
                earnings += sum;
                break;
            case 2:
                System.out.println("\nВведите сумму расхода:\n");
                spendings += sum;
                break;
            default:
                System.out.println("\nТакой операции нет");
        }

        //then
        assertThat(earnings, is(0));
        assertThat(spendings == 0, is(true));
        assertThat(spendings > 0, is(false));
        assertThat(spendings, lessThanOrEqualTo(earnings));
        assertThat(earnings + spendings, Matchers.notNullValue());
    }
}