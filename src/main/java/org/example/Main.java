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

        produtos.add(new Product("001", "Senhor dos Anéis", 10.0, 120, new String[]{"Ação", "Aventura"}, 10));
        produtos.add(new Product("002", "Django Livre", 20.0, 120, new String[]{"Ação", "Aventura"}, 1));

        clientes.add(new Client("EU", "123", new Address("1", "1", "12345678", "Apto 0", "1")));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Gerenciamento de Clientes");
            System.out.println("2. Gerenciamento de Produtos");
            System.out.print("Escolha uma opção: ");
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

        System.out.println("\n1. Cadastrar novo cliente");
        System.out.println("2. Consultar dados do cliente");
        System.out.println("3. Consultar todos os clientes");
        System.out.println("4. Realizar nova locação");
        System.out.println("5. Voltar");

        System.out.print("Escolha uma opção: ");
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

        System.out.println("\n1. Cadastrar novo produto");
        System.out.println("2. Consultar dados do produto");
        System.out.println("3. Consultar todos os produtos");
        System.out.println("4. Remover produto do catálogo");
        System.out.println("5. Voltar");

        System.out.print("Escolha uma opção: ");
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
                removeProduct(scanner); //remove do catalogo

                break;

            case 5:
                return;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private static void registerClient(Scanner scanner) {

        scanner.nextLine();
        System.out.print("Nome: ");
        String name = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Rua/Avenida: ");
        String street = scanner.nextLine();
        System.out.print("Bairro: ");
        String district = scanner.nextLine();
        System.out.print("CEP: ");
        String zipCode = scanner.nextLine();
        System.out.print("Complemento: ");
        String complement = scanner.nextLine();
        System.out.print("Número: ");
        String number = scanner.next();

        Address address = new Address(street, district, zipCode, complement, number);
        Client client = new Client(name, cpf, address);
        clientes.add(client);
        System.out.println("Cliente cadastrado com sucesso.");
    }

    private static void searchClient(Scanner scanner) {

        System.out.print("Digite o CPF do cliente: ");
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
                    System.out.println("Produtos alugados:\n");
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

        for (Client client : clientes) {
            System.out.println("Nome: " + client.getName());
            System.out.println("CPF: " + client.getCpf());
            System.out.println("Endereço: " + client.getAddress().getFullAddress());
            System.out.println();
        }
    }

    private static void realizarLocacao(Scanner scanner) {
    
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.next();
    
        for (Client client : clientes) {
            if (client.getCpf().equals(cpf)) {
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
                String nowString = now.format(formatter);
    
                String leaseNumber = nowString + cpf;
    
                System.out.print("Digite a data do aluguel: ");
                String leaseDate = scanner.next();
                System.out.print("Digite a data de devolução: ");
                String returnDate = scanner.next();
    
                ArrayList<Product> leasedItems = new ArrayList<>();
    
                while(true) {
                    System.out.print("Digite o código do produto que deseja alugar: ");
    
                    String code = scanner.next();
                    boolean productExists = false;
                    for (Product product : produtos) {
    
                        if(!product.getCode().equals(code)) continue;
    
                        productExists = true;
    
                        if(product.isAvailable()) {
                            product.rent();
                            leasedItems.add(product);
                            break;
                        }
    
                        System.out.println("Produto indisponível.");
                    }
    
                    if(!productExists) {
                        System.out.println("Produto não encontrado.");
                    }
    
                    System.out.print("Deseja adicionar mais produtos? (S/N) ");
                    String answer = scanner.next();
                    if (answer.equalsIgnoreCase("N")) {
                        break;
                    }
                }
    
                if (leasedItems.isEmpty()) {
                    System.out.println("Nenhum produto foi selecionado para alugar.\n");
                    return;
                }
    
                Lease lease = new Lease(leaseNumber, leaseDate, returnDate, client, leasedItems);
                client.addLease(lease);
    
                while (true) {
                    System.out.print("Deseja remover algum produto adicionado? (S/N) ");
                    String answer = scanner.next();
                    if (answer.equalsIgnoreCase("S")) {
                        System.out.print("Digite o código do produto a ser removido: ");
                        String codeToRemove = scanner.next();
                        boolean removed = false;
                        for (Product product : lease.getLeasedItems()) {
                            if (product.getCode().equals(codeToRemove)) {
                                lease.removeLeasedItem(product);
                                product.returnProduct();  // Devolve o produto
                                System.out.println("Produto removido com sucesso.");
                                removed = true;
                                break;
                            }
                        }
                        if (!removed) {
                            System.out.println("Produto não encontrado na lista de produtos alugados.");
                        }
                    } else if (answer.equalsIgnoreCase("N")) {
                        break;
                    } else {
                        System.out.println("Opção inválida. Tente novamente.");
                    }
                }

                if (leasedItems.isEmpty()) {
                    System.out.println("Nenhum produto foi selecionado para alugar.\n");
                    return;
                }
    
                System.out.println("Locação realizada com sucesso.");
                System.out.println("Número da locação: " + leaseNumber);
                System.out.println("Valor total: " + lease.getTotalValue());
    
                return;
            }
        }
        System.out.println("Cliente não encontrado.");
    }




    private static void registerProduct(Scanner scanner) {

        scanner.nextLine();
        System.out.print("Digite o título do produto: ");
        String title = scanner.nextLine();
        System.out.print("Digite o preço do produto (R$): ");
        Double price = scanner.nextDouble();
        System.out.print("Digite a duração do produto (min): ");
        Integer duration = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite os gêneros do produto separados por ',': ");
        String genres = scanner.nextLine();
        String[] genresArray = genres.split(",");

        System.out.print("Digite o nome das partes da série separadas por ',' (caso não seja uma serie digite n/a): ");
        String pieces = scanner.nextLine();

        System.out.print("Digite o código do produto: ");
        String code = scanner.nextLine();

        System.out.print("Digite a quantidade do produto: ");
        Integer quantity = scanner.nextInt();

        if(!pieces.equalsIgnoreCase("N/A")){
            String[] piecesArray = pieces.split(",");
            Product series = new Series(title, duration, genresArray, price, code, piecesArray, quantity);
            produtos.add(series);
            return;
        }

        Product product = new Product(code, title, price, duration, genresArray, quantity);
        produtos.add(product);
    }

    private static void removeProduct(Scanner scanner) {

        System.out.print("Digite o código do produto: ");
        String code = scanner.next();

        for (Product product : produtos) {
            if (product.getCode().equals(code)) {
                produtos.remove(product);
                System.out.println("Produto removido com sucesso.");
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }

    private static void searchProducts(Scanner scanner) {

        System.out.print("Digite o código do produto: ");
        String code = scanner.next();

        for (Product product : produtos) {
            if (product.getCode().equals(code)) {
                System.out.println("Código: " + product.getCode());
                System.out.println("Título: " + product.getTitle());
                System.out.println("Preço: " + product.getPrice());
                System.out.println("Duração: " + product.getDuration());
                System.out.println("Gêneros: " + String.join(", ", product.getGenres()));
                if (product instanceof Series) {
                    System.out.println("Partes: " + String.join(", ", ((Series) product).getPieces()));
                }
                System.out.println("Quantidade: " + product.getQuantity());
                System.out.println("Quantidade alugada: " + product.getRentedQuantity());
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }

    private static void listProducts(Scanner scanner) {

        for (Product product : produtos) {
            System.out.println();
            System.out.println("Código: " + product.getCode());
            System.out.println("Título: " + product.getTitle());
            System.out.println("Preço: " + product.getPrice());
            System.out.println("Duração: " + product.getDuration());
            System.out.println("Gêneros: " + String.join(", ", product.getGenres()));
            if (product instanceof Series) {
                System.out.println("Partes: " + String.join(", ", ((Series) product).getPieces()));
            }
            System.out.println("Quantidade: " + product.getQuantity());
            System.out.println("Quantidade alugada: " + product.getRentedQuantity());
        }
    }
}