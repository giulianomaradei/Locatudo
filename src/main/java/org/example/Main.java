package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Client> clientes = new ArrayList<>();
    private static List<Product> produtos = new ArrayList<>();

    public static void main(String[] args) {

        produtos.add(new Product("001", "Senhor dos Anais", 10.0, 120, new String[]{"Ação", "Aventura"}, 10));
        produtos.add(new Product("002", "Django Livre", 20.0, 120, new String[]{"Ação", "Aventura"}, 1));

        clientes.add(new Client("EU", "123", new Address("Rua 1", "Bairro 1", "12345678", "Complemento 1", 1)));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Gerenciamento de Clientes");
            System.out.println("2. Pesquisa de Produtos");
            System.out.println("Escolha uma opção:");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    manageClients(scanner);
                    break;
                case 2:
                    manageProducts(scanner);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void manageClients(Scanner scanner) {
        clearScreen();

        System.out.println("1. Cadastrar novo cliente");
        System.out.println("2. Consultar dados do cliente");
        System.out.println("3. Consultar todos os clientes");
        System.out.println("4. Realizar nova locação");
        System.out.println("5. Voltar");

        System.out.println("Escolha uma opção:");
        int opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                registerClient(scanner);
                break;
            case 2:
                searchClient(scanner);
                break;
            case 3:
                listClients(scanner);
                break;
            case 4:
                realizarLocacao(scanner);
                break;
            case 5:
                return;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private static void manageProducts(Scanner scanner) {
        clearScreen();

        System.out.println("1. Cadastrar novo produto");
        System.out.println("2. Consultar dados do produto");
        System.out.println("3. Consultar todos os produtos");
        System.out.println("4. Voltar");

        System.out.println("Escolha uma opção:");
        int opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                registerProduct(scanner);
                break;
            case 2:
                searchProducts(scanner);
                break;
            case 3:
                listProducts(scanner);
                break;
            case 4:
                return;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private static void registerClient(Scanner scanner) {
        clearScreen();


        scanner.nextLine();
        System.out.println("Digite o nome do cliente:");
        String name = scanner.nextLine();
        System.out.println("Digite o CPF do cliente:");
        String cpf = scanner.nextLine();
        System.out.println("Digite o endereço do cliente:");
        String street = scanner.nextLine();
        System.out.println("Digite o bairro do cliente:");
        String district = scanner.nextLine();
        System.out.println("Digite o CEP do cliente:");
        String zipCode = scanner.nextLine();
        System.out.println("Digite o complemento do cliente:");
        String complement = scanner.nextLine();
        System.out.println("Digite o número do endereço do cliente:");
        Integer number = scanner.nextInt();

        Address address = new Address(street, district, zipCode, complement, number);
        Client client = new Client(name, cpf, address);
        clientes.add(client);
    }

    private static void searchClient(Scanner scanner) {
        clearScreen();

        System.out.println("Digite o CPF do cliente:");
        String cpf = scanner.next();

        for (Client client : clientes) {
            if (client.getCpf().equals(cpf)) {
                System.out.println("Nome: " + client.getName());
                System.out.println("CPF: " + client.getCpf());
                System.out.println("Endereço: " + client.getAddress().getFullAddress());


                if(client.getLeases().isEmpty()) {
                    System.out.println("Cliente não possui locações.");
                    return;
                }
                for (Lease lease : client.getLeases()) {
                    System.out.println("Número do aluguel: " + lease.getLeaseNumber());
                    System.out.println("Data do aluguel: " + lease.getLeaseDate());
                    System.out.println("Data de devolução: " + lease.getReturnDate());
                    System.out.println("Produtos alugados:");
                    for (Product product : lease.getLeasedItems()) {
                        System.out.println("Título: " + product.getTitle());
                        System.out.println("Preço: " + product.getPrice());
                        System.out.println("Duração: " + product.getDuration());
                        System.out.println("Gêneros: " + String.join(", ", product.getGenres()));
                        System.out.println();
                    }
                    System.out.println("Valor total: " + lease.getTotalValue());
                    System.out.println();
                }

                return;
            }
        }
        System.out.println("Cliente não encontrado.");
    }

    private static void listClients(Scanner scanner) {
        clearScreen();

        for (Client client : clientes) {
            System.out.println("Nome: " + client.getName());
            System.out.println("CPF: " + client.getCpf());
            System.out.println("Endereço: " + client.getAddress().getFullAddress());
        }
    }

    private static void realizarLocacao(Scanner scanner) {
        clearScreen();

        System.out.println("Digite o CPF do cliente:");
        String cpf = scanner.next();

        for (Client client : clientes) {
            if (client.getCpf().equals(cpf)) {
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
                String nowString = now.format(formatter);

                String leaseNumber = nowString + cpf;

                System.out.println("Digite a data do aluguel:");
                String leaseDate = scanner.next();
                System.out.println("Digite a data de devolução:");
                String returnDate = scanner.next();

                Lease lease = new Lease(leaseNumber, leaseDate, returnDate, client, new ArrayList<>());

                while(true) {
                    System.out.println("Digite o código do produto que deseja alugar:");

                    String code = scanner.next();
                    boolean productExists = false;
                    for (Product product : produtos) {

                        if(!product.getCode().equals(code)) continue;

                        productExists = true;

                        if(product.isAvailable()) {
                            lease.addLeasedItem(product);
                            product.rent();
                            break;
                        }

                        System.out.println("Produto indisponível.");
                    }

                    if(!productExists) {
                        System.out.println("Produto não encontrado.");
                    }

                    System.out.println("Deseja adicionar mais produtos? (S/N)");
                    String answer = scanner.next();
                    if (answer.equals("N")) {
                        break;
                    }
                }

                client.addLease(lease);
                System.out.println("Locação realizada com sucesso.");
                System.out.println("Número da locação: " + leaseNumber);
                System.out.println("Valor total: " + lease.getTotalValue() + "\n");

                return;
            }
        }
        System.out.println("Cliente não encontrado.");

    }


    private static void registerProduct(Scanner scanner) {
        clearScreen();

        scanner.nextLine();
        System.out.println("Digite o título do produto:");
        String title = scanner.nextLine();
        System.out.println("Digite o preço do produto:");
        Double price = scanner.nextDouble();
        System.out.println("Digite a duração do produto:");
        Integer duration = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite os gêneros do produto separados por ',':");
        String genres = scanner.nextLine();
        String[] genresArray = genres.split(",");

        System.out.println("Digite o nome das partes da série separadas por ',' (caso não seja uma serie digite N/A):");
        String pieces = scanner.nextLine();

        System.out.println("Digite o código do produto:");
        String code = scanner.nextLine();

        System.out.println("Digite a quantidade do produto:");
        Integer quantity = scanner.nextInt();

        if(!pieces.equals("N/A")){
            String[] piecesArray = pieces.split(",");
            Series series = new Series(title, duration, genresArray, price, "001", piecesArray, quantity);
            produtos.add(series);
            return;
        }

        Product product = new Product(code, title, price, duration, genresArray, quantity);
        produtos.add(product);
    }

    private static void searchProducts(Scanner scanner) {
        clearScreen();

        System.out.println("Digite o código do produto:");
        String code = scanner.next();

        for (Product product : produtos) {
            if (product.getCode().equals(code)) {
                System.out.println("Título: " + product.getTitle());
                System.out.println("Preço: " + product.getPrice());
                System.out.println("Duração: " + product.getDuration());
                System.out.println("Gêneros: " + String.join(", ", product.getGenres()));
                System.out.println("Quantidade: " + product.getQuantity());
                System.out.println("Quantidade alugada: " + product.getRentedQuantity());
                System.out.println();
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }

    private static void listProducts(Scanner scanner) {
        clearScreen();

        for (Product product : produtos) {
            System.out.println("Título: " + product.getTitle());
            System.out.println("Preço: " + product.getPrice());
            System.out.println("Duração: " + product.getDuration());
            System.out.println("Gêneros: " + String.join(", ", product.getGenres()));
            System.out.println("Quantidade: " + product.getQuantity());
            System.out.println("Quantidade alugada: " + product.getRentedQuantity());
            System.out.println();
        }
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}