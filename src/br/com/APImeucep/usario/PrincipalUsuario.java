package br.com.APImeucep.usario;

import br.com.APImeucep.dominio.Endereco;
import br.com.APImeucep.cep.ViaCep;

import java.util.Scanner;

public class PrincipalUsuario {

    public static void main(String[] args) throws Exception {
        System.out.println("Informe seu cep: ");
        String cep = new Scanner(System.in).nextLine();
        Endereco endereco = ViaCep.buscarEndereco(cep);

        System.out.println("Cidade: "+ endereco.getLogradouro());
        System.out.println("Bairro: "+ endereco.getBairro());
        System.out.println("Rua: "+ endereco.getLocalidade());


    }
}
