package com.secume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.secume.security.FullValidation;

import java.util.Set;

/**
 * Created by Hadi on 8/2/15.
 */
@RestController
public class SecurityHandler {

    @Autowired
    FullValidation fullValidation;

    @RequestMapping("/validate")
    public Set<String> validate(@RequestParam("password") String p) {
        return fullValidation.validate(p);
    }

}
