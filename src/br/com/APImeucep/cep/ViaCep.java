package br.com.APImeucep.cep;

import br.com.APImeucep.Util;
import br.com.APImeucep.dominio.Endereco;
import com.google.gson.Gson;

//import jdk.jshell.execution.Util;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ViaCep {

    static String webService = "https://viacep.com.br/ws/";
    static int codigo = 200;

    public static Endereco buscarEndereco(String cep) throws Exception {
        String urlParaChamada = webService + cep + "/json";

        try {
            URL url = new URL(urlParaChamada);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();


            if (connection.getResponseCode() != codigo)
                throw new RuntimeException("Http error code: "+ connection.getResponseCode());

            BufferedReader resposta = new BufferedReader(new InputStreamReader((connection.getInputStream())));
            String jsonEmString = Util.converteJsonEmString(resposta);

            Gson gson = new Gson();
            Endereco endereco = gson.fromJson(jsonEmString, Endereco.class);

            return endereco;
        } catch (Exception e) {
            throw new Exception("Erro: " + e);
        }
    }
}
