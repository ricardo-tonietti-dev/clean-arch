package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

import java.util.List;

public class ListarUsuarios {

    private final RepositorioDeUsuario repositorioDeUsuario;

    public ListarUsuarios(RepositorioDeUsuario repositorioDeUsuario) {
        this.repositorioDeUsuario = repositorioDeUsuario;
    }

    public List<Usuario> obterTodosUsuarios(){
        return this.repositorioDeUsuario.listarTodos();
    }
}
