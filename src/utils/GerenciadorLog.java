package utils;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GerenciadorLog
{
    private InputStream arquivo = System.in;
    
    public static void escreverNoLog(String mensagem)
    {
        
    }
    
    public static String obterDataFormatada()
    {
        Date dataAtual = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
        String dataFormatada = simpleDateFormat.format(dataAtual);
        
        return dataFormatada;
    }
}
