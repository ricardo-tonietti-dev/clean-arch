package br.com.alura.codechella.infra.controller.web;

import br.com.alura.codechella.application.usecases.AlterarUsuario;
import br.com.alura.codechella.application.usecases.BuscarUsuarioPorCpf;
import br.com.alura.codechella.application.usecases.CriarUsuario;
import br.com.alura.codechella.application.usecases.ExcluirUsuario;
import br.com.alura.codechella.application.usecases.ListarUsuarios;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping
public class UsuarioWebController {

    private final CriarUsuario criarUsuario;
    private final ListarUsuarios listarUsuarios;
    private final AlterarUsuario alterarUsuario;
    private final ExcluirUsuario excluirUsuario;
    private final BuscarUsuarioPorCpf buscarUsuarioPorCpf;

    public UsuarioWebController(
            CriarUsuario criarUsuario,
            ListarUsuarios listarUsuarios,
            AlterarUsuario alterarUsuario,
            ExcluirUsuario excluirUsuario,
            BuscarUsuarioPorCpf buscarUsuarioPorCpf
    ) {
        this.criarUsuario = criarUsuario;
        this.listarUsuarios = listarUsuarios;
        this.alterarUsuario = alterarUsuario;
        this.excluirUsuario = excluirUsuario;
        this.buscarUsuarioPorCpf = buscarUsuarioPorCpf;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios")
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", listarUsuarios.obterTodosUsuarios());
        return "usuarios/lista";
    }

    @GetMapping("/usuarios/novo")
    public String exibirCadastro(Model model) {
        if (!model.containsAttribute("form")) {
            model.addAttribute("form", new UsuarioForm());
        }
        configurarFormulario(model, false, null);
        return "usuarios/formulario";
    }

    @PostMapping("/usuarios")
    public String cadastrarUsuario(
            @Valid @ModelAttribute("form") UsuarioForm form,
            BindingResult bindingResult,
            Model model,
            RedirectAttributes redirectAttributes
    ) {
        if (bindingResult.hasErrors()) {
            configurarFormulario(model, false, null);
            return "usuarios/formulario";
        }

        try {
            criarUsuario.cadastrarUsuario(form.toUsuario());
        } catch (IllegalArgumentException exception) {
            bindingResult.rejectValue("cpf", "cpf.invalid", exception.getMessage());
            configurarFormulario(model, false, null);
            return "usuarios/formulario";
        }

        redirectAttributes.addFlashAttribute("successMessage", "Usuario cadastrado com sucesso.");
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/{cpf}/editar")
    public String exibirEdicao(@PathVariable String cpf, Model model, RedirectAttributes redirectAttributes) {
        Usuario usuario = buscarUsuarioPorCpf.buscar(cpf);
        if (usuario == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Usuario nao encontrado para edicao.");
            return "redirect:/usuarios";
        }

        if (!model.containsAttribute("form")) {
            model.addAttribute("form", UsuarioForm.fromUsuario(usuario));
        }
        configurarFormulario(model, true, cpf);
        return "usuarios/formulario";
    }

    @PostMapping("/usuarios/{cpf}")
    public String atualizarUsuario(
            @PathVariable String cpf,
            @Valid @ModelAttribute("form") UsuarioForm form,
            BindingResult bindingResult,
            Model model,
            RedirectAttributes redirectAttributes
    ) {
        if (buscarUsuarioPorCpf.buscar(cpf) == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Usuario nao encontrado para atualizacao.");
            return "redirect:/usuarios";
        }

        if (bindingResult.hasErrors()) {
            configurarFormulario(model, true, cpf);
            return "usuarios/formulario";
        }

        try {
            Usuario atualizado = alterarUsuario.alterarDadosUsuario(cpf, form.toUsuario());
            if (atualizado == null) {
                redirectAttributes.addFlashAttribute("errorMessage", "Usuario nao encontrado para atualizacao.");
                return "redirect:/usuarios";
            }
        } catch (IllegalArgumentException exception) {
            bindingResult.rejectValue("cpf", "cpf.invalid", exception.getMessage());
            configurarFormulario(model, true, cpf);
            return "usuarios/formulario";
        }

        redirectAttributes.addFlashAttribute("successMessage", "Usuario atualizado com sucesso.");
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/{cpf}/excluir")
    public String confirmarExclusao(@PathVariable String cpf, Model model, RedirectAttributes redirectAttributes) {
        Usuario usuario = buscarUsuarioPorCpf.buscar(cpf);
        if (usuario == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Usuario nao encontrado para exclusao.");
            return "redirect:/usuarios";
        }

        model.addAttribute("usuario", usuario);
        return "usuarios/excluir";
    }

    @PostMapping("/usuarios/{cpf}/excluir")
    public String excluirUsuario(@PathVariable String cpf, RedirectAttributes redirectAttributes) {
        Usuario usuario = buscarUsuarioPorCpf.buscar(cpf);
        if (usuario == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Usuario nao encontrado para exclusao.");
            return "redirect:/usuarios";
        }

        excluirUsuario.excluirUsuario(cpf);
        redirectAttributes.addFlashAttribute("successMessage", "Usuario excluido com sucesso.");
        return "redirect:/usuarios";
    }

    private void configurarFormulario(Model model, boolean editando, String cpfAtual) {
        model.addAttribute("editando", editando);
        model.addAttribute("pageTitle", editando ? "Editar usuario" : "Cadastrar usuario");
        model.addAttribute("pageDescription", editando
                ? "Atualize os dados do usuario mantendo o mesmo fluxo visual da criacao."
                : "Preencha os campos obrigatorios para cadastrar um novo usuario.");
        model.addAttribute("submitLabel", editando ? "Salvar alteracoes" : "Salvar usuario");
        model.addAttribute("formAction", editando ? "/usuarios/" + cpfAtual : "/usuarios");
    }
}