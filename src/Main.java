public class Main {
    public static void main ( String [] args ) {
        Conta minhaconta;
        minhaconta = new Conta();
        minhaconta.setDono("Davi");
        minhaconta.setNum(120906);
        minhaconta.setLim(20000);
        minhaconta.definirOp();
        Conta conta2;
        conta2 = new Conta();
        conta2.setDono("Daniel");
        conta2.setNum(20092009);
        conta2.setLim(15000);
        conta2.definirOp();
        
        // ATIVIDADE 3 
        minhaconta.sacar(2000);
        minhaconta.depositar(10000);
        minhaconta.sacar(700);
        minhaconta.sacar(1000);
        minhaconta.historico();
        //ATIVIDADE 4
        minhaconta.mediacontop();
    }
}