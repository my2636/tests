import java.util.Scanner;


class OptimalTax {
    public static void main(String[] args) {
        int earnings = 0;
        int spendings = 0;

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nВыберите операцию и введите её номер:\n");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогообложения\n");

            String input = scanner.nextLine();
            if ("end".equals(input)) break;
            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println("\nВведите сумму дохода:\n");
                    int moneyEarnings = Integer.parseInt(scanner.nextLine());
                    earnings += moneyEarnings;
                    break;
                case 2:
                    System.out.println("\nВведите сумму расхода:\n");
                    int moneySpendings = Integer.parseInt(scanner.nextLine());
                    spendings += moneySpendings;
                    break;
                case 3:
                    chooseAndShowTax(earnings, spendings);
                    break;
                default:
                    System.out.println("\nТакой операции нет");
            }
        }
        System.out.println("\nПрограмма завершена!");
    }


    private static void chooseAndShowTax(int earnings, int spendings) {
        int taxEarnings = calcTaxEarnings(earnings);
        int taxEarningsMinusSpendings = calcTaxEarningsMinusSpendings(earnings, spendings);
        String taxType = taxEarnings < taxEarningsMinusSpendings ? "УСН доходы\n" : "УСН доходы минус расходы\n";

        int minTax = Math.min(taxEarnings, taxEarningsMinusSpendings);
        int maxTax = Math.max(taxEarnings, taxEarningsMinusSpendings);

        if(minTax == maxTax) {
            System.out.println("Можете выбрать любую систему налогообложения\n");
            System.out.printf("Ваш налог составит: %d рублей\n", minTax);
        } else {
            System.out.printf("\nМы советуем Вам %s", taxType);
            System.out.printf("Ваш налог составит: %d рублей\n", minTax);
            System.out.printf("Налог по другой системе: %d рублей\n", maxTax);
            System.out.printf("Экономия: %d рублей\n", maxTax - minTax);
        }

    }

    private static int calcTaxEarnings(int earnings) {
        int tax = earnings * 6 / 100;
        return Math.max(tax, 0); // возможность внесения отрицательных значений earnings в коде не ограничена
    }

    private static int calcTaxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        return Math.max(tax, 0);
    }
}
