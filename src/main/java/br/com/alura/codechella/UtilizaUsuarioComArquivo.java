package br.com.alura.codechella;

import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.gateways.RepositorioDeUsuarioEmArquivo;

import java.time.LocalDate;

public class UtilizaUsuarioComArquivo {
    public static void main(String[] args) {
        RepositorioDeUsuarioEmArquivo repositorioDeUsuarioEmArquivo = new RepositorioDeUsuarioEmArquivo();

        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario("789.456.132-25","Maria",
                LocalDate.parse("2000-10-15"),"maria@mail.com"));

        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario("123.456.789-10","Joao",
                LocalDate.parse("1998-04-21"),"joao@mail.com"));

        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario("987.654.321-00","Ricardo",
                LocalDate.parse("1995-07-09"),"ricardo@mail.com"));

        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario("456.789.123-99","Priscila",
                LocalDate.parse("2001-01-30"),"priscila@mail.com"));

        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario("321.654.987-11","Ana",
                LocalDate.parse("1992-11-03"),"ana.souza@mail.com"));

        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario("654.987.321-22","Carlos",
                LocalDate.parse("1989-06-17"),"carlos.lima@mail.com"));

        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario("147.258.369-33","Fernanda",
                LocalDate.parse("1997-09-12"),"fernanda.alves@mail.com"));

        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario("258.369.147-44","Lucas",
                LocalDate.parse("1994-02-25"),"lucas.costa@mail.com"));

        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario("369.147.258-55","Camila",
                LocalDate.parse("1999-08-08"),"camila.oliveira@mail.com"));

        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario("741.852.963-66","Bruno",
                LocalDate.parse("1993-12-19"),"bruno.pereira@mail.com"));

        //System.out.println(repositorioDeUsuarioEmArquivo.listarTodos());
        repositorioDeUsuarioEmArquivo.gravaEmArquivo("usuarios.txt");

    }
}
