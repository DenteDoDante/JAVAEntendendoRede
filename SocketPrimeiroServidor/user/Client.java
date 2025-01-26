import java.io.*;
import java.net.*;

public class Client

{
    public static void main(String[] args) {
        String host = "localhost"; // Endereço do servidor
        int porta = 12345; // Porta do servidor

        try (Socket socket = new Socket(host, porta)) {

            System.out.println("Conectado ao servidor!");

            // Criação de streams para comunicação
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            // Envia mensagem para o servidor
            String mensagem = "Olá, servidor!";
            output.println(mensagem);
            System.out.println("Mensagem enviada: " + mensagem);

            // Lê a resposta do servidor
            String resposta = input.readLine();
            System.out.println("Mensagem recebida: " + resposta);

        } catch (IOException e) {
            System.err.println("Erro ao conectar com o servidor: " + e.getMessage());

        }

    }

}