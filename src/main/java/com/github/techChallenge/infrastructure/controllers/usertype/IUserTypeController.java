package com.github.techChallenge.infrastructure.controllers.usertype;

import com.github.techChallenge.domain.usertype.dto.UserTypeCreateInputDTO;
import com.github.techChallenge.domain.usertype.dto.UserTypeOutputDTO;
import com.github.techChallenge.domain.usertype.dto.UserTypeUpdateInputDTO;
import com.github.techChallenge.shared.ApiErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@Tag(
    name="Usuários » Tipos",
    description="API de gestão de tipos de usuário"
)
public interface IUserTypeController {
    @Operation(
        summary = "Criação de novo tipo de usuário"
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "201",
            description = "Um objeto com os dados do tipo de usuário criado",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(
                    implementation = UserTypeOutputDTO.class
                )
            )
        ),
        @ApiResponse(
            responseCode = "400",
            description = "Ocorreu um erro com os dados do tipo de usuário, durante a tentativa de criação",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = ApiErrorResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "401",
            description = "Você não tem permissão para realizar esta ação",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = ApiErrorResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "409",
            description = "Já existe um tipo de usuário cadastrado com o título informado",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = ApiErrorResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "500",
            description = "Ocorreu um erro do lado do servidor",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = ApiErrorResponse.class)
            )
        )
    })
    ResponseEntity<UserTypeOutputDTO> create(
        @Parameter(description = "Dados para criação de novo tipo de usuário")
        UserTypeCreateInputDTO dto
    );

    @Operation(
        summary = "Atualização de dados do usuário"
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "O tipo de usuário foi modificado com sucesso",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = UserTypeOutputDTO.class)
            )
        ),
        @ApiResponse(
            responseCode = "400",
            description = "Ocorreu um erro com os dados do tipo de usuário, durante a tentativa de atualização",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = ApiErrorResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "401",
            description = "Você não tem permissão para realizar esta ação",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = ApiErrorResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "O tipo de usuário que se deseja atualizar não foi encontrado",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = ApiErrorResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "409",
            description = "O título informado já pertence a outro tipo de usuário",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = ApiErrorResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "500",
            description = "Ocorreu um erro do lado do servidor",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = ApiErrorResponse.class)
            )
        )
    })
    ResponseEntity<UserTypeOutputDTO> update(
        @Parameter(description = "Dados para edição de novo usuário")
        UserTypeUpdateInputDTO dto,
        @Parameter(description = "ID do usuário a ser editado")
        int id);

    @Operation(
        summary = "Buscar por ID"
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Busca com sucesso de tipo de usuário pelo seu ID",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = UserTypeOutputDTO.class)
            )
        ),
        @ApiResponse(
            responseCode = "401",
            description = "Você não tem permissão para realizar esta ação",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = ApiErrorResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Nível de usuário não encontrado",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = ApiErrorResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "500",
            description = "Ocorreu um erro do lado do servidor",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = ApiErrorResponse.class)
            )
        )
    })
    ResponseEntity<UserTypeOutputDTO> findByID(
        @Parameter(description = "ID do tipo de usuário a ser localizado")
        int id
    );

    @Operation(
        summary = "Listar todos"
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Listar todos os tipos de usuário",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                array= @ArraySchema(schema = @Schema(implementation = UserTypeOutputDTO.class))
            )
        ),
        @ApiResponse(
            responseCode = "401",
            description = "Você não tem permissão para realizar esta ação",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = ApiErrorResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "500",
            description = "Ocorreu um erro do lado do servidor",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = ApiErrorResponse.class)
            )
        )
    })
    ResponseEntity<Page<UserTypeOutputDTO>> list(
        @Parameter(description = "Página da paginação da listagem. Valor padrão '0'.", example = "0", required = false)
        int page,
        @Parameter(description = "Quantidade de registros por página. Valor padrão '10'.", example = "10", required = false)
        int offset);

    @Operation(
        summary = "Remover tipo de usuário"
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "204",
            description = "O tipo de usuário foi removido com sucesso. A resposta não possui corpo.",
            content = @Content
        ),
        @ApiResponse(
            responseCode = "401",
            description = "Você não tem permissão para realizar esta ação",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = ApiErrorResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "O tipo de usuário que se deseja remover não foi encontrado",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = ApiErrorResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "500",
            description = "Ocorreu um erro do lado do servidor",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = ApiErrorResponse.class)
            )
        )
    })
    ResponseEntity<Void> delete(
        @Parameter(description = "ID do tipo de usuário a ser removido")
        int id);
}
