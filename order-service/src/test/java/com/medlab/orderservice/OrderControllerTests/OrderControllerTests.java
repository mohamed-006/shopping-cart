package com.medlab.orderservice.OrderControllerTests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;

import com.medlab.orderservice.AbstractIT;
import com.medlab.orderservice.testdata.TestDataFactory;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class OrderControllerTests extends AbstractIT {

    @Nested
    class CreateOrderTests {
        @Test
        void shouldCreateOrderSuccessfully() {
            var payload =
                    """
                        {
                                     "customer":{
                                         "name": "Mohamed Ali",
                                         "email":"mouhammedali.boussetta@gmail.com",
                                         "phone":"99999999"
                                     },
                                     "deliveryAddress":{
                                     "addressLine1": "Sfeya-sousse",
                                     "addressLine2": "khalifa karoui",
                                     "city": "Sousse",
                                     "state": "Tunisia",
                                     "zipCode": "4000",
                                     "country": "Tunisia"
                                 },
                                 "items": [
                                     {
                                         "code":"P100",
                                         "name": "Product 1",
                                         "price":25.50,
                                         "quantity":1
                                     }
                                 ]
                                 }
                            """;
            given().contentType(ContentType.JSON)
                    .body(payload)
                    .when()
                    .post("/api/orders")
                    .then()
                    .statusCode(HttpStatus.CREATED.value())
                    .body("orderNumber", notNullValue());
        }

        @Test
        void shouldReturnBadRequestWhenMandatoryDataIsMissing() {
            var payload = TestDataFactory.createOrderRequestWithInvalidCustomer();
            given().contentType(ContentType.JSON)
                    .body(payload)
                    .when()
                    .post("/api/orders")
                    .then()
                    .statusCode(HttpStatus.BAD_REQUEST.value());
        }
    }
}
