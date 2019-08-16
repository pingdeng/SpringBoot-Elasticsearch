package cn.com.ymcd.springbootes.dto;

import lombok.Data;

/**
 * @projectName: springboot-es
 * @author: dengp
 * @date: 2019年08月13日 17:15
 * @version: 1.0
 */
@Data
public class EmployeeDTO {

    private String id;

    private Long age;

    private String first_name;

    private String last_name;

    private String about;

    private String[] interests;

}
