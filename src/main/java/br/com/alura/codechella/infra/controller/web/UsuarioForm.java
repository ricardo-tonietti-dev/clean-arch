package br.com.alura.codechella.infra.controller.web;

import br.com.alura.codechella.domain.entities.usuario.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class UsuarioForm {

    @NotBlank(message = "Informe o nome do usuario.")
    private String nome;

    @NotBlank(message = "Informe o CPF.")
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}", message = "Use o formato 000.000.000-00.")
    private String cpf;

    @NotNull(message = "Informe a data de nascimento.")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate nascimento;

    @NotBlank(message = "Informe o email.")
    @Email(message = "Informe um email valido.")
    private String email;

    public static UsuarioForm fromUsuario(Usuario usuario) {
        UsuarioForm form = new UsuarioForm();
        form.setNome(usuario.getNome());
        form.setCpf(usuario.getCpf());
        form.setNascimento(usuario.getNascimento());
        form.setEmail(usuario.getEmail());
        return form;
    }

    public Usuario toUsuario() {
        return new Usuario(cpf, nome, nascimento, email);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}