package org.example.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.example.model.TestResponse;
import org.example.service.AService;
import org.example.service.BService;
import org.example.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhout
 * @date 2020/9/3 14:54
 */
@RestController
@RequestMapping("/api")
@Api(tags = "web测试")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class Controller {

  private final AService aService;

  private final BService bService;

  private final CheckService checkService;

  @GetMapping("/knife4j")
  public TestResponse knife4j() {
    TestResponse response = new TestResponse();
    response.setCode(200);
    response.setMessage("success");
    return response;
  }

  @GetMapping("/required")
  public TestResponse testRequired() {
    TestResponse response = new TestResponse();
    response.setCode(200);
    response.setMessage(aService.a() + bService.b());
    return response;
  }

  @GetMapping("/check")
  public TestResponse testCheck(Integer uid) {
    TestResponse response = new TestResponse();
    response.setCode(200);
    response.setMessage(checkService.testPreconditions(uid));
    return response;
  }
}
