package com.caro.mycash.infraestructura.controlador;

import com.caro.mycash.aplicacion.dto.DtoRegistro;
import com.caro.mycash.aplicacion.dto.DtoRespuesta;
import com.caro.mycash.dominio.puerto.RepositorioRegistro;
import com.caro.mycash.dominio.puerto.RepositorioReporte;
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

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = ApplicationMock.class)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ControladorReporteTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    RepositorioRegistro repositorioRegistro;

    @Autowired
    RepositorioReporte repositorioReporte;

    @SuppressWarnings("unchecked")
    private void crearRegistro(DtoRegistro dto) throws Exception {
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

    private void validarEliminacionDeRegistros() throws Exception {
        mocMvc.perform(get("/api/registros")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    @DisplayName("Debe generar el reporte")
    void generarTest() throws Exception {

        crearRegistro(new DtoRegistroTestDataBuilder().conCuanto(1000D).conTipo("IN").conConcepto(null).build());
        crearRegistro(new DtoRegistroTestDataBuilder().conCuanto(1000D).conTipo("IN").conConcepto(null).build());
        crearRegistro(new DtoRegistroTestDataBuilder().conCuanto(1000D).conTipo("IN").conConcepto(null).build());
        crearRegistro(new DtoRegistroTestDataBuilder().conCuanto(1000D).conTipo("EG").conConcepto("OB").build());
        crearRegistro(new DtoRegistroTestDataBuilder().conCuanto(1000D).conTipo("EG").conConcepto("OB").build());
        crearRegistro(new DtoRegistroTestDataBuilder().conCuanto(1000D).conTipo("EG").conConcepto("OT").build());
        crearRegistro(new DtoRegistroTestDataBuilder().conCuanto(1000D).conTipo("EG").conConcepto("OT").build());
        crearRegistro(new DtoRegistroTestDataBuilder().conCuanto(1000D).conTipo("EG").conConcepto("OT").build());

        mocMvc.perform(get("/api/reportes/generar")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.ingresos", is(3000D)))
                .andExpect(jsonPath("$.egresos", is(5000D)))
                .andExpect(jsonPath("$.obligatorios", is(2000D)))
                .andExpect(jsonPath("$.otros", is(3000D)));

        validarEliminacionDeRegistros();
    }

    @Test
    @DisplayName("Debe generar el reporte sin egresos")
    void generarReporteSinEgresosTest() throws Exception {

        crearRegistro(new DtoRegistroTestDataBuilder().conCuanto(1000D).conTipo("IN").conConcepto(null).build());
        crearRegistro(new DtoRegistroTestDataBuilder().conCuanto(1000D).conTipo("IN").conConcepto(null).build());
        crearRegistro(new DtoRegistroTestDataBuilder().conCuanto(1000D).conTipo("IN").conConcepto(null).build());

        mocMvc.perform(get("/api/reportes/generar")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.ingresos", is(3000D)))
                .andExpect(jsonPath("$.egresos", is(0D)))
                .andExpect(jsonPath("$.obligatorios", is(0D)))
                .andExpect(jsonPath("$.otros", is(0D)));

        validarEliminacionDeRegistros();
    }

    @Test
    @DisplayName("No debe generar el reporte sin registros")
    void generarReporteSinRegistrosTest() throws Exception {

        mocMvc.perform(get("/api/reportes/generar")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isConflict());

    }

}