package com.github.techChallenge.infrastructure.controllers.usertype;

import com.github.techChallenge.application.usecases.usertype.*;
import com.github.techChallenge.application.validators.UserTypeValidator;
import com.github.techChallenge.domain.usertype.dto.UserTypeCreateInputDTO;
import com.github.techChallenge.domain.usertype.dto.UserTypeOutputDTO;
import com.github.techChallenge.domain.usertype.dto.UserTypeUpdateInputDTO;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/v1/user-type", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserTypeController implements IUserTypeController {

    private final CreateUserTypeUseCase createUserTypeUseCase;
    private final UpdateUserTypeUseCase updateUserTypeUseCase;
    private final FindUserTypeUseCase findUserTypeUseCase;
    private final ListUserTypeUseCase listUserTypeUseCase;
    private final DeleteUserTypeUseCase deleteUserTypeUseCase;
    private final UserTypeValidator userTypeValidator;

    public UserTypeController(CreateUserTypeUseCase createUserTypeUseCase,
                              UpdateUserTypeUseCase updateUserTypeUseCase,
                              FindUserTypeUseCase findUserTypeUseCase,
                              ListUserTypeUseCase listUserTypeUseCase,
                              DeleteUserTypeUseCase deleteUserTypeUseCase, UserTypeValidator userTypeValidator
    ) {
        this.createUserTypeUseCase = createUserTypeUseCase;
        this.updateUserTypeUseCase = updateUserTypeUseCase;
        this.findUserTypeUseCase = findUserTypeUseCase;
        this.listUserTypeUseCase = listUserTypeUseCase;
        this.deleteUserTypeUseCase = deleteUserTypeUseCase;
        this.userTypeValidator = userTypeValidator;
    }

    @PostMapping("/")
    @Override
    public ResponseEntity<UserTypeOutputDTO> create(
            @Valid @RequestBody UserTypeCreateInputDTO dto) {
        UserTypeOutputDTO response = this.createUserTypeUseCase.execute(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.id())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<UserTypeOutputDTO> update(
            @Valid @RequestBody UserTypeUpdateInputDTO dto,
            @PathVariable("id") int id
    ) {
        UserTypeOutputDTO response = this.updateUserTypeUseCase.execute(dto, id);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<UserTypeOutputDTO> findByID(@PathVariable("id") int id) {
        UserTypeOutputDTO dto = this.findUserTypeUseCase.execute(id);

        return ResponseEntity.ok(dto);
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<Page<UserTypeOutputDTO>> list(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "offset", defaultValue = "10") int offset) {
        Page<UserTypeOutputDTO> users = this.listUserTypeUseCase.execute(page, offset);

        return ResponseEntity.ok(users);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        this.deleteUserTypeUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

}
