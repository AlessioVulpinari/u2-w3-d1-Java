package alessiovulpinari.u2_w3_d1_Java.controllers;

import alessiovulpinari.u2_w3_d1_Java.payloads.EmployeeLoginDTO;
import alessiovulpinari.u2_w3_d1_Java.payloads.EmployeeLoginResponseDTO;
import alessiovulpinari.u2_w3_d1_Java.services.AuthService;
import alessiovulpinari.u2_w3_d1_Java.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/login")
    public EmployeeLoginResponseDTO login(@RequestBody EmployeeLoginDTO body) {
        return new EmployeeLoginResponseDTO(authService.authenticationAndTokenGeneration(body));
    }
}
