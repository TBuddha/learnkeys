package org.example.controller;

import io.swagger.annotations.Api;
import org.example.model.TestResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhout
 * @date 2020/9/3 14:54
 */
@RestController
@RequestMapping("/api")
@Api(tags = "knife4j整合")
public class Controller {

  @GetMapping("/knife4j")
  public TestResponse knife4j() {
    TestResponse response = new TestResponse();
    response.setCode(200);
    response.setMessage("success");
    return response;
  }
}
