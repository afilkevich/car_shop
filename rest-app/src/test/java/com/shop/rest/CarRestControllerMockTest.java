package com.shop.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.model.Car;
import com.shop.model.CarDTO;
import com.shop.service.CarService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.Resource;

import java.time.LocalDate;
import java.util.Arrays;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by master on 4.5.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:rest-spring-mocktest.xml"})
public class CarRestControllerMockTest {
    private static final Logger LOGGER= LogManager.getLogger();

    @Resource
    private CarRestController carController;

    private MockMvc mockMvc;

    @Autowired
    private CarService carService;

    private static final CarDTO CAR_DTO=new CarDTO(3,"Toyota","Sedan","Lux","climat-control", LocalDate.parse("1999-07-16"),5500);

    @Before
    public void setUp() throws Exception{

        mockMvc=standaloneSetup(carController)
                .setMessageConverters(new MappingJackson2HttpMessageConverter())
                .build();
    }

    @After
    public void tearDown() throws Exception {
        verify(carService);
        reset(carService);
    }

    @Test
    public void findAllCar() throws Exception {
        LOGGER.debug("CarRestControllerMockTest:findAllCar");
        expect(carService.findAll()).andReturn(Arrays.<CarDTO>asList(CAR_DTO));
        replay(carService);

        mockMvc.perform(
                get("/cars")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

   /* @Test
    public void findCarByBrand() throws Exception {
        LOGGER.debug("CarRestControllerMockTest:findCarByBrand");
        expect(carService.findByBrand(CAR_DTO.getBrandName())).andReturn(Arrays.<CarDTO>asList(CAR_DTO));
        replay(carService);

        mockMvc.perform(
                get("/car/brand/2")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void findCarByModel() throws Exception {
        LOGGER.debug("CarRestControllerMockTest:findCarByModel");
        expect(carService.findByModel(CAR_DTO.getModelName())).andReturn(Arrays.<Car>asList(CAR));
        replay(carService);

        mockMvc.perform(
                get("/car/model/2")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void findCarById() throws Exception {
        LOGGER.debug("CarRestControllerMockTest:findCarById");
        expect(carService.findById(CAR.getId())).andReturn(CAR);
        replay(carService);

        mockMvc.perform(
                get("/car/3")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void addCar() throws Exception {
        LOGGER.debug("CarRestControllerMockTest:addCar");
        expect(carService.insert(anyObject(Car.class))).andReturn(3);
        replay(carService);

        String car=new ObjectMapper().writeValueAsString(new Car());

        mockMvc.perform(
                post("/car")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(car))
                .andDo(print()).andExpect(status().isCreated());
    }

    @Test
    public void updateCar() throws Exception {
        LOGGER.debug("CarRestControllerMockTest:updateCar");
        expect(carService.update(anyObject(Car.class))).andReturn(3);
        replay(carService);

        String car=new ObjectMapper().writeValueAsString(new Car());

        mockMvc.perform(
                put("/car")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(car))
                .andDo(print()).andExpect(status().isAccepted());
    }

    @Test
    public void deleteCar() throws Exception {
        LOGGER.debug("CarRestControllerMockTest:deleteCar");
        expect(carService.delete(CAR.getId())).andReturn(3);
        replay(carService);

        mockMvc.perform(
                delete("/car/3")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
*/
}