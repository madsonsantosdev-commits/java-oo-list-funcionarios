
// ---
// ## 3) Código Java (OO + List + validações)
// ### `src/Employee.java`
// ```java
//-----------------------------------------------------------------------------------------------------------

public class Employee {
    private final int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        if (id <= 0) throw new IllegalArgumentException("Id deve ser positivo.");
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Nome é obrigatório.");
        if (salary < 0) throw new IllegalArgumentException("Salário não pode ser negativo.");

        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Getters (encapsulamento)
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    // Set para nome pode existir (não é regra do exercício impedir)
    public void setName(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Nome é obrigatório.");
        this.name = name;
    }

    // Regra do exercício: salário NÃO pode ser mudado livremente
    // então NÃO existe setSalary.

    public void increaseSalary(double percent) {
        if (percent <= 0) throw new IllegalArgumentException("Percentual deve ser maior que zero.");
        salary += salary * (percent / 100.0);
    }

    @Override
    public String toString() {
        return id + ", " + name + ", " + String.format("%.2f", salary);
    }
}
