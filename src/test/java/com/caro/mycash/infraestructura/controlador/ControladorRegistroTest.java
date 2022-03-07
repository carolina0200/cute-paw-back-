package com.caro.mycash.infraestructura.controlador;

import com.caro.mycash.aplicacion.dto.DtoRegistro;
import com.caro.mycash.aplicacion.dto.DtoRespuesta;
import com.caro.mycash.dominio.puerto.RepositorioRegistro;
import com.caro.mycash.infraestructura.ApplicationMock;
import com.caro.mycash.infraestructura.testdatabuilder.DtoRegistroTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.core.Is.is;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = ApplicationMock.class)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ControladorRegistroTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    RepositorioRegistro repositorioRegistro;

    @Test
    @DisplayName("Debe crear un registro de forma exitosa ")
    void crearTest() throws Exception {
        var dto = new DtoRegistroTestDataBuilder().build();

        crear(dto);
    }

    @SuppressWarnings("unchecked")
    private void crear(DtoRegistro dto) throws Exception {
        var result = mocMvc.perform(MockMvcRequestBuilders.post("/api/registros")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andReturn();

        var jsonResult = result.getResponse().getContentAsString();
        DtoRespuesta<Integer> respuesta = objectMapper.readValue(jsonResult, DtoRespuesta.class);

        Long id = respuesta.getValor().longValue();
        Assertions.assertNotNull(id);
    }

    @Test
    @DisplayName("Debe listar los registros luego de crearlos")
    void listarTest() throws Exception {

        var dto = new DtoRegistroTestDataBuilder().build();

        crear(dto);

        mocMvc.perform(get("/api/registros")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].tipo", is(dto.getTipo())))
                .andExpect(jsonPath("$[0].cuanto", is(dto.getCuanto())));
    }
}