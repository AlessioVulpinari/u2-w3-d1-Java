package alessiovulpinari.u2_w3_d1_Java.controllers;

import alessiovulpinari.u2_w3_d1_Java.exceptions.BadRequestException;
import alessiovulpinari.u2_w3_d1_Java.payloads.EmployeeLoginDTO;
import alessiovulpinari.u2_w3_d1_Java.payloads.EmployeeLoginResponseDTO;
import alessiovulpinari.u2_w3_d1_Java.payloads.EmployeePayload;
import alessiovulpinari.u2_w3_d1_Java.payloads.EmployeePayloadResponse;
import alessiovulpinari.u2_w3_d1_Java.services.AuthService;
import alessiovulpinari.u2_w3_d1_Java.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeePayloadResponse saveEmployee(@RequestBody @Validated EmployeePayload body, BindingResult result) {
        if (result.hasErrors()) {
            throw new BadRequestException(result.getAllErrors());
        }

        return new EmployeePayloadResponse(this.employeeService.saveEmployee(body).getEmployeeId());
    }


}
