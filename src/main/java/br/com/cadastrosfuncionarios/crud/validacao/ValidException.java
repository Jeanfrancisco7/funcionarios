package br.com.cadastrosfuncionarios.crud.validacao;

public class ValidException extends RuntimeException{

    public ValidException(){super();}

    public ValidException(String menssagem){
        super(menssagem);
    }

    public ValidException (String menssagem, Throwable causa){super(menssagem, causa);}

    public ValidException ( Throwable causa){super(causa);}

    public ValidException (String menssagem, Throwable causa, boolean enableSuppression, boolean writeableStackeTrace){
        super(menssagem, causa, enableSuppression, writeableStackeTrace);
    }
}
