package com.example.spring_boot_docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootDockerApplication {

  @RequestMapping("/")
  public String home() {
    // 호스트 명 구하기
    String hostname = System.getenv().getOrDefault("HOSTNAME", "unknown");

    // 경로 /data/javalove93/message.txt 읽어서 문자열에 저장
    try {
      message = new String(Files.readAllBytes(Paths.get("/data/javalove93/message.txt")));
    } catch (IOException e) {
      e.printStackTrace();
    }

    return "Hello Docker World from " + hostname + ", NFS message is " + message;
    // return "Hello Docker World";
    // return "Hello Docker World V2!!";
  }

  public static void main(String[] args) {
    SpringApplication.run(SpringBootDockerApplication.class, args);
  }

}
