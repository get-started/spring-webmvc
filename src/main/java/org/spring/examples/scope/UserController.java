package org.spring.examples.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by L.x on 15-1-22.
 */
@Controller
@Scope("request")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private User user;

    @RequestMapping("/{username}")
    @ResponseBody
    public String index() {
        return user.getName();
    }
}
