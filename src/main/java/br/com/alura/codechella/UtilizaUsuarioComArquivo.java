package br.com.alura.codechella;

import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.gateways.RepositorioDeUsuarioEmArquivo;

import java.time.LocalDate;

public class UtilizaUsuarioComArquivo {
    public static void main(String[] args) {
        RepositorioDeUsuarioEmArquivo repositorioDeUsuarioEmArquivo = new RepositorioDeUsuarioEmArquivo();

        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario("789.456.132-25","Maria",
                LocalDate.parse("2000-10-15"),"maria@mail.com"));

        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario("789.456.132-25","Jaoa",
                LocalDate.parse("2000-10-15"),"joao@mail.com"));

        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario("789.456.132-25","Ricardo",
                LocalDate.parse("2000-10-15"),"ricardo@mail.com"));

        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario("789.456.132-25","Pri",
                LocalDate.parse("2000-10-15"),"pri@mail.com"));

        //System.out.println(repositorioDeUsuarioEmArquivo.listarTodos());
        repositorioDeUsuarioEmArquivo.gravaEmArquivo("usuarios.txt");

    }
}
