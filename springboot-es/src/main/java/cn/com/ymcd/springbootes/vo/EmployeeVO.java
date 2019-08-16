package cn.com.ymcd.springbootes.vo;

import lombok.Data;

/**
 * @projectName: springboot-es
 * @author: dengp
 * @date: 2019年08月15日 15:15
 * @version: 1.0
 *
 */
@Data
public class EmployeeVO  {

    private String id;

    private Long age;

    private String first_name;

    private String last_name;

    private String about;

    private String[] interests;

}
