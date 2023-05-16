package pl.zzpj.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.zzpj.core.domain.model.userModel.User;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rent")
public class RentController {

    @GetMapping(value = "/test")
    @ResponseBody
    public String getAll() {
        return "123";
    }

}
