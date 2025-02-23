import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class OptimalTaxTest {

    @ParameterizedTest
    @CsvSource({"20000, 1", "300000, 2", "1000000, 5", "-100, -4"})
    void variousVariableInputTest(int sum, int inputOperation) {

        assertDoesNotThrow(() -> doesNotThrowAnyException(sum, inputOperation));

    }

    void doesNotThrowAnyException(int sum, int inputOperation) {
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
        Assertions.assertEquals(0, earnings);
        Assertions.assertTrue(spendings == 0);
        Assertions.assertFalse(spendings > 0);
    }


}