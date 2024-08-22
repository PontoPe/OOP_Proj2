public class Cliente {
    private String name;
    private String email;
    private String cpf;
    private String passwd;
    private double balance;
    private Banco banco;

    public Cliente(String nome, Integer idade, String email, String cpf, String passwd, String banco) {
        this.name = nome;
        this.email = email;
        this.cpf = cpf;
        this.passwd = passwd;
        this.balance = 0;
    }

    public void deposit(double valor) {
        this.balance += valor;
    }

    public void withdraw(double valor) {
        this.balance -= valor;
    }

    public double getBalance() {
        return this.balance;
    }

    public void payBill(double valor) {
        this.balance -= valor;
    }

    public void updatePassword(String senhaAtual, String novaSenha) {
        if (this.passwd.equals(senhaAtual)) {
            this.passwd = novaSenha;
        }
    }

    public String getNome() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getSenha() {
        return this.passwd;
    }

}
