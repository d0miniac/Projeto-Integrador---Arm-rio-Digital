package modelo;

public class Fornecedor {
    private int idFornecedor;
    private String email;
    private String nomeFornecedor; // Corrigido para corresponder ao nome da coluna no banco
    private String nomeCtt; // Corrigido para corresponder ao nome da coluna no banco
    private String telefone;

    // Getters e Setters
    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public String getNomeCtt() {
        return nomeCtt;
    }

    public void setNomeCtt(String nomeCtt) {
        this.nomeCtt = nomeCtt;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}