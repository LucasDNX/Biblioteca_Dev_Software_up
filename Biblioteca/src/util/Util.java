package util;

public abstract class Util {

    private static int proximoIdUsuario = 1;
    private static int proximoIdLivro = 1;
    private static int proximoIdRelatorio = 1;
    private static int proximoIdEmprestimo = 1;

    public static int gerarIdUsuario(){
        return proximoIdUsuario++;
    }

    public static int gerarIdLivro(){
        return proximoIdLivro++;
    }

    public static int gerarIdRelatorio(){
        return proximoIdRelatorio++;
    }

    public static int gerarIdEmprestimo(){
        return proximoIdEmprestimo++;
    }
    
}
