    // 1- Pacote
package petstore;


    // 2 - Bibliotecas


    //3 - Classe


    import com.beust.jcommander.Strings;
    import org.testng.annotations.Test;

    import java.io.IOException;
    import java.nio.file.Files;
    import java.nio.file.Paths;

    import static io.restassured.RestAssured.given;

    public class Pet {
    // 3.1 Atributos
    String uri = "https://petstore.swagger.io/v2/pet"; // Endereço da Entidade Pet



    //3.2 Métodos e Funções
   public String lerJson (String caminhoJson) throws IOException {


       return new String (Files.readAllBytes(Paths.get(caminhoJson)));
   }

//Incluir - Create - POST

      @Test //Identificar  o metodo ou função com um teste para TesteNG

        public void incluirPet () throws IOException {
            String jsonBody = lerJson("dados/pet1.json");

            //Sitanxe Gherkin
            //Dado - Quando  - Então
             // Given - When - Then

          given () //Dado
              .contentType("application/json") //Comum em API Rest - Antigas era "Text/xml"
              .log() .all()
              .body(jsonBody)
          .when() //Quando
              .post(uri)
          .then() //Então
                  .log() .all()
                  .statusCode(200)
          ;

        }

}
