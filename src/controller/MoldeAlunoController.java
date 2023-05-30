package controller;



import javax.swing.JOptionPane;

public class MoldeAlunoController {

    private Integer id;
    private String nome;
    private String senha;
    private String email;
 
 

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            JOptionPane.showMessageDialog(null, "O campo nome não pode ser vazio!!");
        } else {
            this.nome = nome;
        }
        this.nome = nome;
    }

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		if (senha == null || senha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "O campo senha não pode ser vazio!!");
        } else {
            this.senha = senha;
        }
        this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email == null || email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "O campo email não pode ser vazio!!");
        } else {
            this.email = email;
        }
		this.email = email;
	}

}


