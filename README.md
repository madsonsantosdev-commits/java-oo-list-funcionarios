# Java OO + List - Employee Salary Increase

Exercício de Orientação a Objetos em Java utilizando `List`, encapsulamento e validação de IDs únicos.

## Objetivo
- Ler um inteiro `N`
- Ler `N` funcionários (id, nome, salário) sem permitir repetição de `id`
- Aplicar aumento percentual no salário de um funcionário a partir do `id`
- Se o `id` não existir, exibir mensagem e abortar a operação
- Exibir a listagem final atualizada

## Regras
- Não pode haver repetição de `id`
- O salário não pode ser alterado livremente (encapsulamento)
- Salário só pode ser alterado via operação de aumento percentual

## Como executar
### Requisitos
- Java 17+

### Rodar via terminal (dentro da pasta do projeto)
```bash
javac -d out src/Main.java src/entities/Employee.java
java -cp out Main
