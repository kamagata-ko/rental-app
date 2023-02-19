package com.example.rental_app;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

// SpringBootのテストであることを指定する。
@SpringBootTest(
        // テストを実行するときには、接続先のPORT番号は、ランダムで行うように設定する
        // DatabaseのPORT番号やJAVA等のPORTとかぶる可能性を考慮
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
// TestContainerを利用するアノテーション
@Testcontainers
// テストのライフサークル設定(*あまり深く考えなくていい。(調べていくと難しいので))
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class AbstractApplicationTest {

    /* Test Container で利用するイメージの設定 */
    @Container
    protected static PostgreSQLContainer<?> database = new PostgreSQLContainer<>("postgres:15-alpine")
            .withDatabaseName("testdb")
            .withUsername("testUser")
            .withPassword("test");

    /* 通信を行うライブラリー(Test用) 継承元すべてで利用することを想定しているため、抽象クラスに定義 */
    @Autowired
    protected WebTestClient webTestClient;

    /* テスト1項目(@Testの記載をカウント数とする。)ごとに実行する前処理 */
    @AfterAll
    protected void start() {
        // TestContainer(Dockerへの接続開始)
        database.start();
    }

    /* テスト1項目(@Testの記載をカウント数とする。)ごとに実行する後処理 */
    @BeforeAll
    protected void stop() {
        // TestContainer(Dockerへの接続切断)
        database.stop();
    }


}
