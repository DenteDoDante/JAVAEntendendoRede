import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int porta = 12345; // Porta para o servidor ouvir
        try (ServerSocket serverSocket = new ServerSocket(porta)) {
            System.out.println("Servidor aguardando conexões na porta " + porta);

            try (Socket socket = serverSocket.accept()) // Aceita uma conexão do cliente

            {
                System.out.println("Cliente conectado!");

                // Criação de streams para comunicação
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

                // Lê a mensagem do cliente e responde
                String mensagem = input.readLine();
                System.out.println("Cliente disse: " + mensagem);
                output.println("Mensagem recebida: " + mensagem);

                // Responde o cliente
                String resposta = "Olá, cliente!";
                output.println(resposta);
                System.out.println("Mensagem enviada: " + mensagem);

                // Fecha o socket
                socket.close();
                System.out.println("Conexão encerrada.");
            }
        } catch (IOException e) {
            System.err.println("Erro no servidor: " + e.getMessage());
        }
    }
}
