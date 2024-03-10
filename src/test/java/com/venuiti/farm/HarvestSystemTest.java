package com.venuiti.farm;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.venuiti.farm.controller.harvest.HarvestController;
import com.venuiti.farm.controller.harvest.dto.HarvestDataDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Objects;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HarvestSystemTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private HarvestController harvestController;

    @Test
    public void testSubmitHarvestData() throws Exception {
        var harvestData = HarvestDataDTO
                .builder()
                .cropTypeId(1L)
                .actualProduct(100.0)
                .season("Spring")
                .fieldId(1L)
                .build();

        ResponseEntity<String> expectedResponse = ResponseEntity.status(HttpStatus.CREATED).body("Harvest data submitted successfully");

        when(harvestController.submit(any(HarvestDataDTO.class))).thenReturn(expectedResponse);

        mockMvc.perform(post("/harvest")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(harvestData)))
                .andExpect(status().isCreated())
                .andExpect(content().string(Objects.requireNonNull(expectedResponse.getBody())));

        verify(harvestController, times(1)).submit(any(HarvestDataDTO.class));
    }

}
