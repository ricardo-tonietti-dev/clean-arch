package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

public class BuscarUsuarioPorCpf {

    private final RepositorioDeUsuario repositorioDeUsuario;

    public BuscarUsuarioPorCpf(RepositorioDeUsuario repositorioDeUsuario) {
        this.repositorioDeUsuario = repositorioDeUsuario;
    }

    public Usuario buscar(String cpf) {
        return repositorioDeUsuario.buscarPorCpf(cpf);
    }
}