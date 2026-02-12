import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US); // ajuda em double com ponto
        Scanner sc = new Scanner(System.in);

        List<Employee> employees = new ArrayList<>();

        System.out.print("Quantos funcionarios serao registrados? ");
        int n = readInt(sc);

        for (int i = 1; i <= n; i++) {
            System.out.println();
            System.out.println("Funcionario #" + i + ":");

            int id;
            while (true) {
                System.out.print("Id: ");
                id = readInt(sc);
                if (!idExists(employees, id)) break;
                System.out.println("Id ja existe. Tente novamente.");
            }

            System.out.print("Nome: ");
            String name = sc.nextLine();

            System.out.print("Salario: ");
            double salary = readDouble(sc);

            employees.add(new Employee(id, name, salary));
        }

        System.out.println();
        System.out.print("Digite o id do funcionario que tera aumento: ");
        int targetId = readInt(sc);

        Employee emp = findById(employees, targetId);
        if (emp == null) {
            System.out.println("Este id nao existe. Operacao abortada.");
            sc.close();
            return;
        }

        System.out.print("Digite o percentual de aumento: ");
        double percent = readDouble(sc);

        try {
            emp.increaseSalary(percent);
        } catch (IllegalArgumentException ex) {
            System.out.println("Erro: " + ex.getMessage());
            System.out.println("Operacao abortada.");
            sc.close();
            return;
        }

        System.out.println();
        System.out.println("Lista atualizada de funcionarios:");
        for (Employee e : employees) {
            System.out.println(e);
        }

        sc.close();
    }

    private static boolean idExists(List<Employee> list, int id) {
        return findById(list, id) != null;
    }

    private static Employee findById(List<Employee> list, int id) {
        for (Employee e : list) {
            if (e.getId() == id) return e;
        }
        return null;
    }

    // Leitura robusta (evita travar por causa de enter/formatos)
    private static int readInt(Scanner sc) {
        while (true) {
            String line = sc.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException ex) {
                System.out.print("Valor invalido. Digite um numero inteiro: ");
            }
        }
    }

    private static double readDouble(Scanner sc) {
        while (true) {
            String line = sc.nextLine().trim().replace(",", ".");
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException ex) {
                System.out.print("Valor invalido. Digite um numero (ex: 2500.00): ");
            }
        }
    }
}
