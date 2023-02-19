package com.example.rental_app;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/* よく見るテストコードではこちらに@SpringBootTestや@TestContainerの記載が見られるが、
    継承元であるAbstractApplicationTestで定義しているため、記載する必要性がない。
* */
class RentalAppApplicationTests extends AbstractApplicationTest {

    @Test
    void IS_TEST_CONTROLLER_ACCEPT_SUCCESS() {
        webTestClient.get()
                .uri("/test") /* ここまでで、POSTMANで通信を行う時と同じようにURLとHTTPMETHOD(GETやPOST)をしている */
                .exchange() /* 上記のURLへリクエストを投げるものだと考えればいいです。(厳密には違いますが。。) */
                .expectStatus().isOk() /* expect〇〇 は、レスポンス情報を取得している */
                .expectBody(String.class) /* expectBody は、レスポンス時に返却されるBean(Response)クラスを指定することで情報の取得を行うことができる。 */
                .value(message -> assertEquals(message, "OK"));
                /* Returnされた文字列 を精査している。 assertEqualsは, 前後の引数が正しいかどうか判定。
                   正しくない場合は、Falseとなり、テストに失敗する。試してみるといい。
                   value()の()の中はラムダ式の書き方となっていてわかり使いが、下記のようなメソッドだとおもってくれて問題ない。

                    // actualは上記の例だと "OK"

                   boolean 〇〇 (String message, String actual){
                    return message.equals(actual);
                   }

                 */
    }

    @Test
    void IS_TEST_CONTROLLER_ACCEPT_FAILURE() {
        webTestClient.get()
                .uri("/test")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .value(message -> assertNotEquals(message, "ERROR"));
    }

}
