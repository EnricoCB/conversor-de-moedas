import com.google.gson.Gson;
import model.Conversor;
import model.MoedaAPI;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        String apiKey = "1841e36dbc9ab075a51ccfdb";
        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/";
        String continuar = " ";
        while (!continuar.equalsIgnoreCase("nao")) {
            try{
                System.out.print("insira a sigla da moeda que base (USD, BRL...): ");
                String sigla = sc.nextLine();
                System.out.print("Insira a sigla da moeda a ser convertida (USD, BRL...): ");
                String moeda = sc.nextLine();
                System.out.print("Insira o valor a ser convertido: ");
                Double valor = sc.nextDouble();
                sc.nextLine(); // limpa o buffer
                url = url + sigla;
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                String json = response.body();
                Gson gson = new Gson();
                MoedaAPI moedaAPI = gson.fromJson(json, MoedaAPI.class);
                Conversor conversor = new Conversor(moedaAPI, valor, moeda);
                System.out.println(conversor.converter());

            }catch(NullPointerException e){
                System.out.println("Sigla não encontrada");
            }catch (InputMismatchException e){
                System.out.println("Entrada invalida");
                sc.nextLine(); // limpa o buffer
            }
            System.out.println("deseja continuar? (sim/nao)");
            continuar = sc.nextLine();
        }
    }
}