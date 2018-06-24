package com.mysqlpostgres


import com.mysqlpostgres.foo.domain.Foo
import com.mysqlpostgres.mysql.repo.MysqlRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.boot.test.web.client.TestRestTemplate
import spock.lang.Specification

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class FooBarITSpec extends Specification {

  @Autowired
  TestRestTemplate restTemplate

  @Autowired
  MysqlRepository fooRepo

  @Autowired
  BarRepository barRepo

  def "Insert a Foo and a Bar Entity and retrieve the resulting String via GET /foobar/1"() {
    given: "A Foo and a Customer Entity"
    fooRepo.save([
      foo: "Hello"
    ] as Foo)

    barRepo.save([
      bar: "World"
    ] as Customer)

    when: "GET /mysqlpostgres/1"
    def result = restTemplate.getForObject("/mysqlpostgres/1", String.class)

    then: "The result is \"Hello World!\""
    result == "Hello World!"

    cleanup:
    fooRepo.deleteAll()
    barRepo.deleteAll()
  }
}