package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RepositorioDeUsuarioEmArquivo implements RepositorioDeUsuario {

    List<Usuario> usuarios = new ArrayList<>();
    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
        return usuario;
    }

    @Override
    public Usuario buscarPorCpf(String cpf) {
        return this.usuarios.stream()
                .filter(usuario -> usuario.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Usuario> listarTodos() {
        return this.usuarios;
    }

    @Override
    public Usuario alterarUsuario(String cpf, Usuario usuario) {
        Usuario existente = buscarPorCpf(cpf);
        if (existente == null) {
            return null;
        }

        usuarios.remove(existente);
        usuarios.add(usuario);
        return usuario;
    }

    @Override
    public void excluirUsuario(String cpf) {
        Usuario existente = buscarPorCpf(cpf);
        if (existente != null) {
            usuarios.remove(existente);
        }
    }

    public void gravaEmArquivo(String nomeArquivo){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(nomeArquivo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fileWriter.write(this.usuarios.toString());
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
