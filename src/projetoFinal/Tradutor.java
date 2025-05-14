package projetoFinal;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class Tradutor {

    private static Properties properties;
    private static Tradutor tradutor;

    private Tradutor(String idioma) {
        try {
            properties = new Properties();
            String arquivo = "documents_" + idioma + ".properties";
            InputStream traducao = this.getClass().getResourceAsStream(arquivo);

            if (traducao != null) {
                
                InputStreamReader reader = new InputStreamReader(traducao, StandardCharsets.UTF_8);
                properties.load(reader);
            } else {
                System.out.println("Arquivo não encontrado: " + arquivo);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Tradutor getInstance(String idioma) {
        if (tradutor == null) {
            tradutor = new Tradutor(idioma);
        }
        return tradutor;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
