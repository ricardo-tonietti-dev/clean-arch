package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

public class CriarUsuario {

    private final RepositorioDeUsuario repositorioDeUsuario;

    public CriarUsuario(RepositorioDeUsuario repositorioDeUsuario) {
        this.repositorioDeUsuario = repositorioDeUsuario;
    }


    public Usuario cadastrarUsuario(Usuario usuario){
        return repositorioDeUsuario.cadastrarUsuario(usuario);

    }
}
