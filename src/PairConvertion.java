import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PairConvertion {

    public void convertePair (String iso1, String iso2, double amount) throws IOException, InterruptedException {


        HttpClient client = HttpClient.newHttpClient();

        String apiKeyPairConvert = "YOUR_API_KEY";
        String apiPairConvert = "https://v6.exchangerate-api.com/v6/"+apiKeyPairConvert+"/pair/"+iso1+"/"+iso2+"/"+amount;

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(apiPairConvert)).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if( response.statusCode() == 200) {
            String json = response.body();

            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            JsonStructure jsonStructure = gson.fromJson(json, JsonStructure.class);
            System.out.println("Você converteu de: " + jsonStructure.baseCode() + "\nPara: " + jsonStructure.targetCode());
            System.out.println("O reusltado da conversão é: " + jsonStructure.conversionResult());

        } else {
            System.out.println("Erro na repsosta da API: " +response.statusCode());
        }
    }

}
