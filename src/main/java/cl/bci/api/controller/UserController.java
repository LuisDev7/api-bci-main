package cl.bci.api.controller;

import cl.bci.api.exception.UserException;
import cl.bci.api.model.UserModel;
import cl.bci.api.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping({"user"})
public class UserController {
    @Autowired
    private UserService userService;

    public UserController() {
    }

    @PostMapping({"/addUser"})
    @Operation(security = @SecurityRequirement(name = "bearerAuth"))
    @ResponseBody
    public ResponseEntity addUser(@RequestBody @Valid UserModel userModel, BindingResult result) {
        if (result.hasErrors()) {
            throw new UserException(HttpStatus.UNPROCESSABLE_ENTITY.value(), result);
        } else {
            return this.userService.save(userModel);
        }
    }

    @GetMapping({"/usuarios"})
    @Operation(security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity allUser() {
        return this.userService.findAllUsers();

    }

}
