import java.util.Date;



public class Conta {

    private static int numerodecontas;
    private double saldo;
    private int numero;
    private String agencia;
    private int limite;
    private int indice;
    private Operacao[] operacoes;
    private String nome;
    public Conta(){
        indice = 0;
        numerodecontas++;
        saldo = 20000;
    }

    boolean depositar(double valor) {
        if(valor > 0.0) {
            this.saldo += valor;
            this.operacoes[this.indice] = new Operacao('d', valor);
            this.indice++;
            return true;
        } else {
            return false;
        }
    }


    boolean sacar(double valor) {
        if(valor > 0.0 && valor <= this.saldo) {
            this.saldo -= valor;
            this.operacoes[this.indice] = new Operacao('s', valor);
            this.indice++;
            return true;
        } else {
            return false;
        }
    }


    boolean transferir(Conta contaDestino, double valor) {
        boolean saqueRealizado = this.sacar(valor);
        if(saqueRealizado) {
            boolean depositoRealizado = contaDestino.depositar(valor);
            return depositoRealizado;
        } else {
            return false;
        }
    }
    void imprimir(){
        System.out.println("DADOS DA CONTA \nNOME DO DONO: " + this.nome + "\nNUMERO DA CONTA: " + this.numero + "\nSALDO DA CONTA: " + this.saldo + "\nLIMITE: " + this.limite);
    }
    void historico(){
        for(int i = 0; i < this.indice; i++){
            System.out.println("Detalhes da operação:");
            Date dt = OgetData(i);
            char tp = OgetTipo(i);
            double valor = OgetValor(i);
            System.out.println("Data: " + dt);
            System.out.println("Tipo: " + tp);
            System.out.println("Valor: " + valor);

        }
    }
    public String getDono(){
        return nome;
    }
    public void definirOp(){
        operacoes = new Operacao[100];
    }
    public int getNumero(){
        return numero;
    }
    public double getSaldo(){
        return saldo;
    }
    public int getLimite(){
        return limite;
    }
    public void setDono(String novastring){
        nome = novastring;
    }
    public void setNum(int num){
        numero = num;
    }
    public void setLim(int lim){
        limite = lim;
    }
    public Date OgetData(int i){
        Date p = operacoes[i].getData();
        return p;
     }
     public char OgetTipo(int i){
        char tp = operacoes[i].getTipo();
        return tp;
     }
     public double OgetValor(int i){
        double v = operacoes[i].getValor();
        return v;
     }
     public void mediacontop(){
        int nop = operacoes[0].GetNop();
        int media = (nop/numerodecontas);
        System.err.println("A MEDIA DE OPERACOES POR CONTA E " + media );
     }
}