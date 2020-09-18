package org.example.service;

import com.google.common.base.Preconditions;
import org.springframework.stereotype.Service;

/**
 * @author zhout
 * @date 2020/9/16 10:25
 */
@Service
public class CheckService {

  public String testPreconditions(Integer uid) {
    Preconditions.checkNotNull(uid);
    Preconditions.checkArgument(uid > 0, "age 必须大于0");
    return "ok";
  }
}
