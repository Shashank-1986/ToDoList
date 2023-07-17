package com.example.FirstJPAProject.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;


//@RequestMapping("/tasks/")
public class TaskDto {
        @JsonProperty("name")
        public String name;
}
