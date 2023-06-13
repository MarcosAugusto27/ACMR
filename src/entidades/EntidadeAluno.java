package entidades;



import javax.swing.JOptionPane;

public class EntidadeAluno {

    private Integer id;
    private String nome;
    private String senha;
    private String email;
    public boolean passaNome;
    public boolean passaEmail;
    public boolean passaSenha;
 
 

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
            passaNome=true;
        }
       
    }

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		if (senha == null || senha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "O campo senha não pode ser vazio!!");
        } else {
            this.senha = senha;
            passaSenha=true;
        }
       
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email == null || email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "O campo email não pode ser vazio!!");
        } else {
            this.email = email;
            passaEmail=true;
        }
		
	}

}


