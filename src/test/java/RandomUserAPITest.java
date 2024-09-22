import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.assertj.core.api.Assertions.assertThat;


public class RandomUserAPITest {
    //Две позитивные проверки: отправить get запрос с парамтерами "male", "female";
    //Получить ответ со статус кодом 200 и телом, в котором значение парамтера gender = "male", "female" соответственно.
    @ParameterizedTest
    @CsvSource({"male", "female"})
    public void testPositiveRandomUserWithGender(String gender) {

        Response response = RandomUserAPITestStep.getRandomUserByGender(gender);

        assertThat(response.statusCode()).isEqualTo(200);
        assertThat(response.jsonPath().getString("results[0].gender")).isEqualTo(gender);

    }
    //Отправить запрос с пустым значением в параметре. Получить ответ со статус кодом 400
    @Test
    public void testNegativeRandomUserWithInvalidGender() {
        Response response = RandomUserAPITestStep.getRandomUserByGender("");

        assertThat(response.statusCode()).isEqualTo(400);

    }
}