package util;

import java.util.List;

public class ValidacoesUtil {
    public static void verificarTexto(String texto, String campo, List<String> erros) {
        if(texto == null || texto.isBlank())
            erros.add(campo);
    }

    public static void verificarTamanho(String texto, String campo, int tamanhomMaximo, List<String> erros) {
        if(texto != null && texto.length() > tamanhomMaximo)
            erros.add(campo + " (max. " + tamanhomMaximo + " caracteres)");
    }

    public static void verificarNumero(String texto, String campo, int valorMaximo, List<String> erros) {
        try {
            int numero = Integer.parseInt(texto);
            if(numero < 0)
                erros.add(campo + " (deve ser maior que " + 0 + ")");
            else if(numero > 0)
                erros.add(campo + " (deve ser menor que " + valorMaximo + ")");
        } catch (NumberFormatException e) {
            erros.add(campo + " (deve ser um número válido)");
        }
    }
}
