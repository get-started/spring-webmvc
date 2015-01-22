package org.spring.examples.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by L.x on 15-1-22.
 */
@Component
@Scope("prototype")
@EnableAspectJAutoProxy
public class User {
    private static Integer ids = 0;
    private final Integer id;

    public User() {
        id = ids + guid();
    }

    private synchronized Integer guid() {
        return ids++;
    }

    @Autowired
    private HttpServletRequest request;

    public String getName() {
        Map<String, String> pathVariables = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        return pathVariables.get("username") + "::" + id;
    }
}
